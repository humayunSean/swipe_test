package com.hanprojects.testswipe.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by humayun on 3/7/2017.
 */

public class MillStoreDB extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    static  final String DATABASE_NAME = "millstore.db";

    public MillStoreDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        final String SQL_CREATE_MILLSTORE_CATEGORY_TABLE = "CREATE TABLE " + MillStoreContracts.CategoryEntry.TABLE_NAME + " (" +
                MillStoreContracts.CategoryEntry._ID + " INTEGER PRIMARY KEY," +
                MillStoreContracts.CategoryEntry.COLUMN_ITEM_NAME + " TEXT NOT NULL, " +
                MillStoreContracts.CategoryEntry.COLUMN_DESCRIPTION + " TEXT NOT NULL, " +
                MillStoreContracts.CategoryEntry.COLUMN_SHORT_DESCRIPTION + " TEXT NOT NULL, " +
                MillStoreContracts.CategoryEntry.COLUMN_ACTIVE + " INTEGER NOT NULL, " +
                MillStoreContracts.CategoryEntry.COLUMN_CREATED + " INTEGER NOT NULL, " +
                MillStoreContracts.CategoryEntry.COLUMN_UPDATED + " INTEGER NOT NULL, " +
                MillStoreContracts.CategoryEntry.COLUMN_CREATED_BY + " TEXT NOT NULL, " +
                MillStoreContracts.CategoryEntry.COLUMN_UPDATED_BY + " TEXT NOT NULL, " +
                MillStoreContracts.CategoryEntry.COLUMN_PARENT_CATEGORY + " TEXT NOT NULL, " +
                MillStoreContracts.CategoryEntry.COLUMN_TAB_CATEGORY + " TEXT NOT NULL, " +
                MillStoreContracts.CategoryEntry.COLUMN_FULLFILLMENT_GROUP  + " TEXT NOT NULL, " +
                MillStoreContracts.CategoryEntry.COLUMN_IMAGE + " BLOB NOT NULL, " +
                MillStoreContracts.CategoryEntry.COLUMN_ICON + " BLOB NOT NULL " +
                " );";

        final String SQL_CREATE_MILLSTORE_LOCATION_TABLE = "CREATE TABLE " + MillStoreContracts.LocationEntry.TABLE_NAME + " (" +
                MillStoreContracts.LocationEntry._ID + " INTEGER PRIMARY KEY," +
                MillStoreContracts.LocationEntry.COLUMN_CITY + " TEXT NOT NULL, " +
                MillStoreContracts.LocationEntry.COLUMN_DISTRICT + " TEXT NOT NULL, " +
                MillStoreContracts.LocationEntry.COLUMN_STATE + " TEXT NOT NULL, " +
                MillStoreContracts.LocationEntry.COLUMN_COUNTRY + " TEXT NOT NULL, " +
                MillStoreContracts.CategoryEntry.COLUMN_CREATED_BY + " TEXT NOT NULL, " +
                MillStoreContracts.LocationEntry.COLUMN_UPDATED_BY + " TEXT NOT NULL, " +
            
                MillStoreContracts.LocationEntry.COLUMN_ACTIVE + " INTEGER NOT NULL, " +
                MillStoreContracts.LocationEntry.COLUMN_CREATED + " INTEGER NOT NULL, " +
                MillStoreContracts.LocationEntry.COLUMN_UPDATED + " INTEGER NOT NULL, " +
               
                MillStoreContracts.LocationEntry.COLUMN_STREET + " TEXT NOT NULL, " +
                MillStoreContracts.LocationEntry.COLUMN_ADDRESS1 + " TEXT NOT NULL, " +
                MillStoreContracts.LocationEntry.COLUMN_ADDRESS2  + " TEXT NOT NULL, " +
                MillStoreContracts.LocationEntry.COLUMN_ZIP_CODE + " TEXT NOT NULL " +
                " );";
        
        final String SQL_CREATE_MILLSTORE_TABLE = "CREATE TABLE " + MillStoreContracts.ItemEntry.TABLE_NAME + " (" +
                // Why AutoIncrement here, and not above?
                // Unique keys will be auto-generated in either case.  But for weather
                // forecasting, it's reasonable to assume the user will want information
                // for a certain date and all dates *following*, so the forecast data
                // should be sorted accordingly.
                MillStoreContracts.ItemEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +

                
                MillStoreContracts.ItemEntry.COLUMN_ITEM_NAME + " TEXT NOT NULL, " +
                MillStoreContracts.ItemEntry.COLUMN_DESCRIPTION + " TEXT NOT NULL, " +
                MillStoreContracts.ItemEntry.COLUMN_SHORT_DESCRIPTION + " TEXT NOT NULL, " +
                MillStoreContracts.ItemEntry.COLUMN_CREATED_BY + " TEXT NOT NULL, " +
                MillStoreContracts.ItemEntry.COLUMN_VENDOR + " TEXT NOT NULL, " +
                MillStoreContracts.ItemEntry.COLUMN_FULLFILLMENT_GROUP + " TEXT NOT NULL, " +
                MillStoreContracts.ItemEntry.COLUMN_UPDATED_BY + " TEXT NOT NULL, " +
//               MillStoreContracts.ItemEntry.COLUMN_CART + " TEXT NOT NULL, " +
//               MillStoreContracts.ItemEntry.COLUMN_SHOW_QUANTITY + " INTEGER NOT NULL, " +
//               MillStoreContracts.ItemEntry.COLUMN_QUANTITY + " INTEGER NOT NULL, " +

                MillStoreContracts.ItemEntry.COLUMN_ACTIVE + " INTEGER NOT NULL, " +
                MillStoreContracts.ItemEntry.COLUMN_AVAILABILTY + " INTEGER NOT NULL, " +
                MillStoreContracts.ItemEntry.COLUMN_CREATED + " INTEGER NOT NULL, " +
                MillStoreContracts.ItemEntry.COLUMN_UPDATED + " INTEGER NOT NULL, " +

                MillStoreContracts.ItemEntry.COLUMN_ICON + " BLOB NOT NULL, " +
                MillStoreContracts.ItemEntry.COLUMN_IMAGE + " BLOB NOT NULL, " +
                MillStoreContracts.ItemEntry.COLUMN_COST + " REAL NOT NULL," +
            
                // the ID of the category entry associated with this weather data
                MillStoreContracts.ItemEntry.COLUMN_CATEGORY + " INTEGER NOT NULL," +

                " FOREIGN KEY (" + MillStoreContracts.ItemEntry.COLUMN_CATEGORY + ") REFERENCES " +
                MillStoreContracts.CategoryEntry.TABLE_NAME + " (" + MillStoreContracts.CategoryEntry._ID + ")); ";

        db.execSQL(SQL_CREATE_MILLSTORE_CATEGORY_TABLE);
        db.execSQL(SQL_CREATE_MILLSTORE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + MillStoreContracts.CategoryEntry.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + MillStoreContracts.ItemEntry.TABLE_NAME);
        onCreate(db);
    }
}
