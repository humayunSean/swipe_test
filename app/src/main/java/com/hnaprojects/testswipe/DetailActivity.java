package com.hnaprojects.testswipe;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.concurrent.Executor;

import static com.hnaprojects.testswipe.R.id.container;

/**
 * Created by humayun on 2/18/2017.
 */

public class DetailActivity extends AppCompatActivity {

    private static int PICK_IMAGE = 1;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar1);
//        setSupportActionBar(toolbar);
        getSupportFragmentManager().beginTransaction().add(container,new DetailFragment()).commit();


    }

    @Override
    protected void onStart() {
        super.onStart();

    }


}
