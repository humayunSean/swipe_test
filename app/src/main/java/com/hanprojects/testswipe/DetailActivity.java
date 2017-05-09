package com.hanprojects.testswipe;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hanprojects.testswipe.data.MillStoreContracts;
import com.hanprojects.testswipe.data.MillStoreDB;

import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by humayun on 2/18/2017.
 */

public class DetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar1);
//        setSupportActionBar(toolbar);
        getSupportFragmentManager().beginTransaction().add(R.id.container,new DetailFragment()).commit();
    }

    public static class DetailFragment extends Fragment{

        public DetailFragment(){}

        private static String getDateTime() {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
            Date date = new Date();
            return dateFormat.format(date);
        }

        public static byte[] getBitmapAsByteArray(Bitmap bitmap) {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 0, outputStream);
            return outputStream.toByteArray();
        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

            View rootView = inflater.inflate(R.layout.detail_fragment,container,false);

            Context mContext = getActivity().getApplicationContext();
            MillStoreDB dbHelper = new MillStoreDB(mContext);
            SQLiteDatabase stmt = dbHelper.getWritableDatabase();

            Bitmap icon = BitmapFactory.decodeResource(mContext.getResources(),
                    R.mipmap.ic_launcher);
            byte[] data1 = getBitmapAsByteArray(icon);

            ContentValues testValues = new ContentValues();
            testValues.put(MillStoreContracts.CategoryEntry.COLUMN_ACTIVE, true);
            testValues.put(MillStoreContracts.CategoryEntry.COLUMN_CREATED,  getDateTime());
            testValues.put(MillStoreContracts.CategoryEntry.COLUMN_CREATED_BY, "Humayun");
            testValues.put(MillStoreContracts.CategoryEntry.COLUMN_DESCRIPTION,  "A category value");
            testValues.put(MillStoreContracts.CategoryEntry.COLUMN_ITEM_NAME, "Category");
            testValues.put(MillStoreContracts.CategoryEntry.COLUMN_PARENT_CATEGORY, "Humayun");
            testValues.put(MillStoreContracts.CategoryEntry.COLUMN_SHORT_DESCRIPTION, "A category");

            testValues.put(MillStoreContracts.CategoryEntry.COLUMN_UPDATED, getDateTime());
            testValues.put(MillStoreContracts.CategoryEntry.COLUMN_UPDATED_BY, "Humayun");
            testValues.put(MillStoreContracts.CategoryEntry.COLUMN_IMAGE, data1);

            stmt.delete(MillStoreContracts.CategoryEntry.TABLE_NAME, null, null);

            long locationRowId;
            locationRowId = stmt.insert(MillStoreContracts.CategoryEntry.TABLE_NAME, null, testValues);

            Cursor rs1 = stmt.query(
            MillStoreContracts.CategoryEntry.TABLE_NAME,  // Table to Query
            null, // all columns
            null, // Columns for the "where" clause
            null, // Values for the "where" clause
            null, // columns to group by
            null, // columns to filter by row groups
            null // sort order
            );

            StringBuilder sb = new StringBuilder();
            byte[] image = null;
            Bitmap bitmap = null;
            while (rs1.moveToNext())
            {
                image = rs1.getBlob(10);
                bitmap = BitmapFactory.decodeByteArray(image, 0, image.length);
                String script = rs1.getString(1) +"' '"+ rs1.getColumnName(1);
                String call =  rs1.getString(2) +"' '"+ rs1.getColumnName(2);
                String price =  rs1.getString(3) +"' '"+ rs1.getColumnName(3);
                String stoploss =  rs1.getString(4) +"' '"+ rs1.getColumnName(4);
                String target =  rs1.getString(5) +"' '"+ rs1.getColumnName(5);
                String ltp =  rs1.getString(6) +"' '"+ rs1.getColumnName(6);
                String exit =  rs1.getString(7) +"' '"+ rs1.getColumnName(7);
                String eight = rs1.getString(8) +"' '"+ rs1.getColumnName(8);
                String nine = rs1.getString(9) +"' '"+ rs1.getColumnName(9);
                String ten = rs1.getString(9) +"' '"+ rs1.getColumnName(9);
                sb.append(script).append(";").append(call).append(";").append(price).append(";").append(stoploss).append(";").append(target).append(";").append(ltp).append(";").append(exit).append(";").append(eight).append(";").append(nine).append(";").append(ten).append("_");
            }


            rs1.close();
            stmt.close();
            Intent intent = getActivity().getIntent();
            if(intent != null && intent.hasExtra(Intent.EXTRA_TEXT)){
                String millExtra = intent.getStringExtra(Intent.EXTRA_TEXT);
                ((TextView) rootView.findViewById(R.id.detail_text)).setText(sb);//millExtra
                ((ImageView) rootView.findViewById(R.id.imageView)).setImageBitmap(bitmap);
            }
            return rootView;
        }
    }
}
