package com.example.mohamed.crachlytics;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.crashlytics.android.Crashlytics;
import com.google.firebase.crash.FirebaseCrash;

import io.fabric.sdk.android.Fabric;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_main);
    }

    public void Crach(View view) {


    }

    public void crashFabric(View view) {
        throw new RuntimeException("This is a crash");
    }

    public void CrachFireBase(View view) {
        try{
            int v=5/0;
            Toast.makeText(this, ""+v, Toast.LENGTH_SHORT).show();

        }catch (Exception ex) {
            FirebaseCrash.report(ex);
        }
    }
}
