package com.example.gestor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivitySec extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_sec);
    }


    public void ap(){
        Intent intent = new Intent(MainActivitySec.this,AgregarProveedor.class);
        startActivity(intent);
    }

    public void qp(){
        Intent intent2 = new Intent(MainActivitySec.this,EliminarProveedor.class);
        startActivity(intent2);
    }

    public void canp(){
        finish();
    }

    public void salir(){
        finishAffinity();
    }
}
