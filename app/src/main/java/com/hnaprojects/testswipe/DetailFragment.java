package com.hnaprojects.testswipe;

/**
 * Created by humayun on 5/21/2017.
 */

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.hnaprojects.testswipe.data.MillStoreContracts;
import com.hnaprojects.testswipe.data.MillStoreDB;
import com.squareup.picasso.Picasso;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.Executor;

import static android.app.Activity.RESULT_OK;

public class DetailFragment extends Fragment {

    public static final String ABC = DetailFragment.class.getSimpleName();
    private static int PICK_IMAGE = 1;

//    private StorageReference storage;

    String returnedResult = null;
    Bitmap yourSelectedImage;
    byte[] aaa = null;
    String picturePath;
    Context aContext;
    final byte[][] aa = new byte[1][1];


    public DetailFragment(){}





    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        aContext = getActivity().getApplicationContext();




//        storage = FirebaseStorage.getInstance().getReference();
//        try {
//            File localFile = File.createTempFile("images", "jpg");
//            storage.getFile(localFile).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
//                @Override
//                public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
//
//                }
//            }).addOnFailureListener(new OnFailureListener() {
//                @Override
//                public void onFailure(@NonNull Exception e) {
//
//                }
//            });
//        } catch (IOException e) {
//            e.printStackTrace();
//        }



//        Intent getIntent = new Intent(Intent.ACTION_GET_CONTENT);
//        getIntent.setType("image/*");
//
//        Intent pickIntent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//        pickIntent.setType("image/*");
//
//        Intent chooserIntent = Intent.createChooser(getIntent, "Select Image");
//        chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, new Intent[] {pickIntent});
//
//        startActivityForResult(chooserIntent, PICK_IMAGE);


        Log.v(ABC+"----->","4");
    }

    @Override
    public void onStart() {
        super.onStart();



    }

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

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


//        if (requestCode == PICK_IMAGE && resultCode == RESULT_OK && data != null && data.getData() != null) {
//
//  //          String[] filePathColumn = { MediaStore.Images.Media.DATA };
//  //          filePathColumn.Uri.parse( data.getData().toString());
//            Uri uri = data.getData();
//            String[] filePathColumn = {MediaStore.Images.Media.DATA};
//            Cursor cursor = aContext.getContentResolver().query(uri,filePathColumn,null,null,null);
//
//            assert cursor != null;
//            cursor.moveToFirst();
//
//            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
//            picturePath = cursor.getString(columnIndex);
//            cursor.close();
//            Bitmap bm = BitmapFactory.decodeFile(picturePath);
//            Log.i("Hii...", "After Cursor..");
//            byte[] aa = getBitmapAsByteArray(bm);
//            Log.i(ABC+"----->1"," 1 " + aa);
////                try {
////                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
////                    // Log.d(TAG, String.valueOf(bitmap));
////                } catch (IOException e) {
////                    e.printStackTrace();
////                }
//        }
    }


//        @Override
//        public void onActivityResult(int requestCode, int resultCode, Intent data) {
//            super.onActivityResult(requestCode, resultCode, data);
//
//            Log.v(ABC+"----->1"," 11 " + returnedResult);
//            if (requestCode == PICK_IMAGE) {
//                if (resultCode == RESULT_OK) {
//                    returnedResult = data.getData().toString();
//                    Log.v(ABC+"----->1"," 1 " + returnedResult);
//                }
//            }
//        }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.detail_fragment,container,false);


//            File sourceimage = new File("C:\\Users\\humayun\\Downloads\\Webp.net-resizeimage-min.png");
//            Bitmap  yourSelectedImage = BitmapFactory.decodeFile("C:/Users/humayun/Downloads/Webp.net-resizeimage-min.png");

        Context mContext = getContext();
        MillStoreDB dbHelper = new MillStoreDB(mContext);
        SQLiteDatabase stmt = dbHelper.getWritableDatabase();

//            Intent intent1 = new Intent();
//            intent1.setType("image/*");
//            intent1.setAction(Intent.ACTION_GET_CONTENT);
//            startActivityForResult(Intent.createChooser(intent1, "Select Picture"), PICK_IMAGE);


        /*to get file from mobile internal storage*/

        Uri uri = Uri.parse("content://media/external/images/media/57078").buildUpon().build();
        String[] filePathColumn = {MediaStore.Images.Media.DATA};
        Cursor cursor = aContext.getContentResolver().query(uri,filePathColumn,null,null,null);

        assert cursor != null;
        cursor.moveToFirst();

        int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
        picturePath = cursor.getString(columnIndex);
        cursor.close();
        Bitmap bm = BitmapFactory.decodeFile(picturePath);
        Log.i("Hii...", "After Cursor..");
        byte[] a1 = getBitmapAsByteArray(bm);




        FirebaseStorage storage1 = FirebaseStorage.getInstance();
        StorageReference gsReference = storage1.getReferenceFromUrl("gs://testswipe-a0927.appspot.com/Image1.png");

        try {

            File storagePath = new File(Environment.getExternalStorageDirectory(), "storage/sdcard0/DCIM/Camera/");
// Create direcorty if not exists
            if(!storagePath.exists()) {
                storagePath.mkdirs();
            }

            final File myFile = new File(storagePath,"image12.png");

            File localFile = File.createTempFile("images", "png");
            gsReference.getFile(myFile).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                    Log.i("Huma---->",taskSnapshot.toString());
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override

                public void onFailure(@NonNull Exception e) {
                    Log.i("Huma---->1","Failure");
                }
            });
            Log.i("localFile=--->", myFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }


//        final long ONE_MEGABYTE = 128 * 128;
//        gsReference.getBytes(ONE_MEGABYTE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
//            @Override
//            public void onSuccess(byte[] bytes) {
//                aa[0] = bytes;
//            }
//        }).addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull Exception e) {
//
//            }
//        });
//
//        Log.i("HHHHHH--->",aa[0].toString());


   //     yourSelectedImage = BitmapFactory.decodeFile("content://media/external/images/media/57078");
        yourSelectedImage = BitmapFactory.decodeFile("storage/sdcard0/WhatsApp/Media/WhatsApp Images/IMG-20170220-WA0009.jpg");
        Bitmap icon = BitmapFactory.decodeResource(mContext.getResources(),
                R.mipmap.image1);
 //       byte[] data1 = getBitmapAsByteArray(yourSelectedImage);


        Log.v(ABC+"----->","6 ");
        ContentValues testValues = new ContentValues();
        testValues.put(MillStoreContracts.CategoryEntry.COLUMN_ACTIVE, 1);
        testValues.put(MillStoreContracts.CategoryEntry.COLUMN_CREATED,  getDateTime());
        testValues.put(MillStoreContracts.CategoryEntry.COLUMN_CREATED_BY, "Humayun");
        testValues.put(MillStoreContracts.CategoryEntry.COLUMN_DESCRIPTION,  "A category value");
        testValues.put(MillStoreContracts.CategoryEntry.COLUMN_ITEM_NAME, "Category");
        testValues.put(MillStoreContracts.CategoryEntry.COLUMN_PARENT_CATEGORY, "Humayun");
        testValues.put(MillStoreContracts.CategoryEntry.COLUMN_SHORT_DESCRIPTION, "A category");
        testValues.put(MillStoreContracts.CategoryEntry.COLUMN_FULLFILLMENT_GROUP,"Humayun");
        testValues.put(MillStoreContracts.CategoryEntry.COLUMN_TAB_CATEGORY,"Humayun");
        testValues.put(MillStoreContracts.CategoryEntry.COLUMN_UPDATED, getDateTime());
        testValues.put(MillStoreContracts.CategoryEntry.COLUMN_UPDATED_BY, "Humayun");
        testValues.put(MillStoreContracts.CategoryEntry.COLUMN_IMAGE, aa[0]);
        testValues.put(MillStoreContracts.CategoryEntry.COLUMN_ICON, "aaaa");

        stmt.delete(MillStoreContracts.CategoryEntry.TABLE_NAME, null, null);

        long locationRowId;
        locationRowId = stmt.insert(MillStoreContracts.CategoryEntry.TABLE_NAME, null, testValues);

        Log.i("ABC", Long.toString(locationRowId));
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
        if(rs1.moveToNext())
        {
            image = rs1.getBlob(12);
            Log.i("Humayun ---> 222",image.toString());
            bitmap = BitmapFactory.decodeByteArray(image, 0, image.length);
            String one = rs1.getString(0) +"' '"+ rs1.getColumnName(0);
            String script = rs1.getString(1) +"' '"+ rs1.getColumnName(1);
            String call =  rs1.getString(2) +"' '"+ rs1.getColumnName(2);
            String price =  rs1.getString(3) +"' '"+ rs1.getColumnName(3);
            String stoploss =  rs1.getString(4) +"' '"+ rs1.getColumnName(4);
            String target =  rs1.getString(5) +"' '"+ rs1.getColumnName(5);
            String ltp =  rs1.getString(6) +"' '"+ rs1.getColumnName(6);
            String exit =  rs1.getString(7) +"' '"+ rs1.getColumnName(7);
            String eight = rs1.getString(8) +"' '"+ rs1.getColumnName(8);
            String nine = rs1.getString(9) +"' '"+ rs1.getColumnName(9);
            String ten = rs1.getString(10) +"' '"+ rs1.getColumnName(10) +"' '"+ rs1.getString(11) +"' '"+ rs1.getColumnName(11);
            sb.append(script).append(";").append(one).append(";").append(call).append(";").append(price).append(";").append(stoploss).append(";").append(target).append(";").append(ltp).append(";").append(exit).append(";").append(eight).append(";").append(nine).append(";").append(ten).append("_");
        }

 //       Uri ur1 = Uri.parse("https://firebasestorage.googleapis.com/v0/b/testswipe-a0927.appspot.com/o/Image1.png?alt=media&token=ebac79df-1ad3-4722-b6cd-bd4d94fbf3a7").buildUpon().build();


        rs1.close();
        stmt.close();




        Log.v(ABC+"----->","5");
        Intent intent = getActivity().getIntent();
        if(intent != null && intent.hasExtra(Intent.EXTRA_TEXT)){
            String millExtra = intent.getStringExtra(Intent.EXTRA_TEXT);
            ((TextView) rootView.findViewById(R.id.detail_text)).setText(sb);//millExtra
            ((ImageView) rootView.findViewById(R.id.imageView)).setImageBitmap(bitmap);

            Log.v(ABC+"----->","7");
//            ImageView imageView = ((ImageView) rootView.findViewById(R.id.imageView));
//            Picasso.with(getActivity()).load(ur1).into(imgg);

//                ImageView imageView = ((ImageView) rootView.findViewById(R.id.imageView)).setImageBitmap(bitmap);
//            Picasso.with(getActivity()).load(ur1).into(imageView);
        }
        return rootView;
    }


}
