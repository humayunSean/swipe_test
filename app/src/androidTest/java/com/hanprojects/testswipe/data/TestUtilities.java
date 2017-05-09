package com.hanprojects.testswipe.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.DrawableWrapper;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;

import com.hanprojects.testswipe.R;

import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import static com.hanprojects.testswipe.DetailActivity.DetailFragment.getBitmapAsByteArray;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

/**
 * Created by humayun on 4/25/2017.
 */

public class TestUtilities {
    static final String TEST_LOCATION = "99705";
    static final long TEST_DATE = 1419033600L;  // December 20th, 2014

    static void validateCursor(String error, Cursor valueCursor, ContentValues expectedValues) {
        assertTrue("Empty cursor returned. " + error, valueCursor.moveToFirst());
        validateCurrentRecord(error, valueCursor, expectedValues);
        valueCursor.close();
    }

    static void validateCurrentRecord(String error, Cursor valueCursor, ContentValues expectedValues) {
        Set<Map.Entry<String, Object>> valueSet = expectedValues.valueSet();
        int a = 0;
        for (Map.Entry<String, Object> entry : valueSet) {

            String columnName = entry.getKey();
            int idx = valueCursor.getColumnIndex(columnName)  ;
            assertFalse("Column '" + columnName + "' not found. " + error, idx == -1);
            String expectedValue = entry.getValue().toString();
            String val = valueCursor.getString(idx);
            assertEquals("Value '" + entry.getValue().toString() +
                    "' did not match the expected value '" +
                    expectedValue+"' '"+ valueCursor.getColumnName(idx)+ columnName +"'. " + error, expectedValue, val);
            a++;
        }
    }

    /*
        Students: Use this to create some default weather values for your database tests.
     */
//    static ContentValues createWeatherValues(long locationRowId) {
//        ContentValues weatherValues = new ContentValues();
//        weatherValues.put(WeatherContract.WeatherEntry.COLUMN_LOC_KEY, locationRowId);
//        weatherValues.put(WeatherContract.WeatherEntry.COLUMN_DATE, TEST_DATE);
//        weatherValues.put(WeatherContract.WeatherEntry.COLUMN_DEGREES, 1.1);
//        weatherValues.put(WeatherContract.WeatherEntry.COLUMN_HUMIDITY, 1.2);
//        weatherValues.put(WeatherContract.WeatherEntry.COLUMN_PRESSURE, 1.3);
//        weatherValues.put(WeatherContract.WeatherEntry.COLUMN_MAX_TEMP, 75);
//        weatherValues.put(WeatherContract.WeatherEntry.COLUMN_MIN_TEMP, 65);
//        weatherValues.put(WeatherContract.WeatherEntry.COLUMN_SHORT_DESC, "Asteroids");
//        weatherValues.put(WeatherContract.WeatherEntry.COLUMN_WIND_SPEED, 5.5);
//        weatherValues.put(WeatherContract.WeatherEntry.COLUMN_WEATHER_ID, 321);
//
//        return weatherValues;
//    }

    /*
        Students: You can uncomment this helper function once you have finished creating the
        LocationEntry part of the WeatherContract.
     */
    private static String getDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        Date date = new Date();
        return dateFormat.format(date);
    }

    static ContentValues createCategoryValues(Context mContext) {

//        ByteArrayOutputStream baos = new ByteArrayOutputStream();
//        Bitmap bitmap = ((BitmapDrawable)getResources().getDrawable(R.drawable.mybutton)).getBitmap();
//        bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
//        byte[] photo = baos.toByteArray();
        // Create a new map of values, where column names are the keys

        Bitmap icon = BitmapFactory.decodeResource(mContext.getResources(),
                R.mipmap.ic_launcher);
        byte[] data1 = getBitmapAsByteArray(icon);

        ContentValues testValues = new ContentValues();
        testValues.put(MillStoreContracts.CategoryEntry.COLUMN_ITEM_NAME, "Category");
        testValues.put(MillStoreContracts.CategoryEntry.COLUMN_DESCRIPTION,  "A category value");
        testValues.put(MillStoreContracts.CategoryEntry.COLUMN_SHORT_DESCRIPTION, "A category");
        testValues.put(MillStoreContracts.CategoryEntry.COLUMN_ACTIVE, 1);
        testValues.put(MillStoreContracts.CategoryEntry.COLUMN_CREATED,  getDateTime());
        testValues.put(MillStoreContracts.CategoryEntry.COLUMN_UPDATED, getDateTime());
        testValues.put(MillStoreContracts.CategoryEntry.COLUMN_CREATED_BY, "Humayun");

        testValues.put(MillStoreContracts.CategoryEntry.COLUMN_UPDATED_BY, "Humayun");
        testValues.put(MillStoreContracts.CategoryEntry.COLUMN_PARENT_CATEGORY, "Humayun");
        testValues.put(MillStoreContracts.CategoryEntry.COLUMN_IMAGE, data1);
        return testValues;
    }

    /*
        Students: You can uncomment this function once you have finished creating the
        LocationEntry part of the WeatherContract as well as the WeatherDbHelper.
     */
//    static long insertNorthPoleLocationValues(Context context) {
//        // insert our test records into the database
//        WeatherDbHelper dbHelper = new WeatherDbHelper(context);
//        SQLiteDatabase db = dbHelper.getWritableDatabase();
//        ContentValues testValues = TestUtilities.createNorthPoleLocationValues();
//
//        long locationRowId;
//        locationRowId = db.insert(WeatherContract.LocationEntry.TABLE_NAME, null, testValues);
//
//        // Verify we got a row back.
//        assertTrue("Error: Failure to insert North Pole Location Values", locationRowId != -1);
//
//        return locationRowId;
//    }

    /*
        Students: The functions we provide inside of TestProvider use this utility class to test
        the ContentObserver callbacks using the PollingCheck class that we grabbed from the Android
        CTS tests.
        Note that this only tests that the onChange function is called; it does not test that the
        correct Uri is returned.
     */
    static class TestContentObserver extends ContentObserver {
        final HandlerThread mHT;
        boolean mContentChanged;

        static TestContentObserver getTestContentObserver() {
            HandlerThread ht = new HandlerThread("ContentObserverThread");
            ht.start();
            return new TestContentObserver(ht);
        }

        private TestContentObserver(HandlerThread ht) {
            super(new Handler(ht.getLooper()));
            mHT = ht;
        }

        // On earlier versions of Android, this onChange method is called
        @Override
        public void onChange(boolean selfChange) {
            onChange(selfChange, null);
        }

        @Override
        public void onChange(boolean selfChange, Uri uri) {
            mContentChanged = true;
        }

        public void waitForNotificationOrFail() {
            // Note: The PollingCheck class is taken from the Android CTS (Compatibility Test Suite).
            // It's useful to look at the Android CTS source for ideas on how to test your Android
            // applications.  The reason that PollingCheck works is that, by default, the JUnit
            // testing framework is not running on the main Android application thread.
//            new PollingCheck(5000) {
//                @Override
//                protected boolean check() {
//                    return mContentChanged;
//                }
//            }.run();
            mHT.quit();
        }
    }

    static TestContentObserver getTestContentObserver() {
        return TestContentObserver.getTestContentObserver();
    }
}
