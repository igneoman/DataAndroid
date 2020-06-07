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
import java.sql.SQLIntegrityConstraintViolationException;

public class AgregarProveedor extends AppCompatActivity {

    Connection conexion=null;
    PreparedStatement preparedStatement=null;

    EditText Cif;
    EditText RegN;
    EditText CRC;
    EditText ImS;
    EditText FeH;
    EditText RSP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_proveedor);

        Cif=(EditText) findViewById(R.id.inCif);
        RegN=(EditText) findViewById(R.id.inNumf);
        CRC=(EditText) findViewById(R.id.CodRespC);
        ImS=(EditText) findViewById(R.id.ImSeg);
        FeH=(EditText) findViewById(R.id.inFecHom);
        RSP=(EditText) findViewById(R.id.inRazS);

    }

    public void AgPro(View view){

        if(TextUtils.isEmpty(Cif.getText().toString())) {
            Toast.makeText(getApplicationContext(),"Datos insuficientes", Toast.LENGTH_SHORT).show();
        }
        else {

            try {
                conexion = Connect.conecta();
                preparedStatement = conexion.prepareStatement("Insert into prov_comp VALUES (?,?,?,?,?,?)");
                preparedStatement.setString(1, Fix.fixdatastr(String.valueOf(Cif.getText())));
                preparedStatement.setString(3, Fix.fixdatastr(String.valueOf(RegN.getText())));
                preparedStatement.setString(4, Fix.fixdatastr(String.valueOf(CRC.getText())));
                preparedStatement.setString(5, Fix.fixdatastr(String.valueOf(ImS.getText())));
                preparedStatement.setString(6, Fix.fixdatastr(String.valueOf(FeH.getText())));
                preparedStatement.setString(2, Fix.fixdatastr(String.valueOf(RSP.getText())));

                int ok = preparedStatement.executeUpdate();
                if (ok > 0) {
                    Toast.makeText(getApplicationContext(),"Dato agregado", Toast.LENGTH_SHORT).show();
                    conexion.close();
                }
                else if(conexion==null) {
                    Toast.makeText(getApplicationContext(),"Error agregar, valor nulo", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(),"Error agregar", Toast.LENGTH_SHORT).show();
                }
            } catch(SQLIntegrityConstraintViolationException e0) {
                Toast.makeText(getApplicationContext(),"Valor duplicado", Toast.LENGTH_SHORT).show();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }

    }

    public void canp(View view){
        finish();
    }
}
