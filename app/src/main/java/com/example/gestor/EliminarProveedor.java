package com.example.gestor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EliminarProveedor extends AppCompatActivity {

    Connection conexion=null;
    PreparedStatement preparedStatement=null;

    EditText Cif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_proveedor);

        Cif = (EditText) findViewById(R.id.inNumf2);
    }

    public void elp(View view){

        try {
            conexion = Connect.conecta();
            preparedStatement = conexion.prepareStatement("Delete from prov_comp where CIF_PROVEEDOR=?");
            preparedStatement.setString(1, Cif.getText().toString());
            int ok = preparedStatement.executeUpdate();
            if (ok > 0) {
                Toast.makeText(getApplicationContext(),"Dato quitado", Toast.LENGTH_SHORT).show();
                conexion.close();
            }
            else if(conexion==null) {
                Toast.makeText(getApplicationContext(),"Error eliminar, valor nulo", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(getApplicationContext(),"Error eliminar", Toast.LENGTH_SHORT).show();
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

    }

    public void canp(View view){
        finish();
    }
}
