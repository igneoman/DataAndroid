package com.example.gestor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ap(View view){
        Intent intent = new Intent(MainActivity.this,AgregarPedido.class);

        /*Bundle b = new Bundle();
        b.putString("Usuario",userst);*/

        //intent.putExtras();

        startActivity(intent);
    }

    public void qp(){
        Intent intent2 = new Intent(MainActivity.this,EliminarPedido.class);
        startActivity(intent2);
    }

    public void pro(){
        Intent gespro = new Intent(MainActivity.this,MainActivitySec.class);
        startActivity(gespro);
    }


    public void salir(){
        finish();
    }
}
