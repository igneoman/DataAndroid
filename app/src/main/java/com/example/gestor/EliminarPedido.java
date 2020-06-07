package com.example.gestor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EliminarPedido extends AppCompatActivity {

    Connection conexion=null;
    PreparedStatement preparedStatement=null;

    EditText NumF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_pedido);
        NumF = (EditText) findViewById(R.id.inNumf2);
    }

    public void ElP(View view){

        try {
            conexion = Connect.conecta();
            preparedStatement = conexion.prepareStatement("Delete from act_prov where NUM_FACTURA=?");
            preparedStatement.setString(1, String.valueOf(NumF.getText()));
            int ok = preparedStatement.executeUpdate();
            if (ok > 0) {
                Toast.makeText(getApplicationContext(),"Dato eliminado", Toast.LENGTH_SHORT).show();
                conexion.close();
            }
            else {
                if(TextUtils.isEmpty(NumF.getText().toString())) {
                    Toast.makeText(getApplicationContext(),"Error, valor nulo", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(),"Error, valor inexistente", Toast.LENGTH_SHORT).show();
                }

            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

    }

    public void canp(View view){
        finish();
    }

}
