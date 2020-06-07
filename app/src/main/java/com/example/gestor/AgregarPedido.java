package com.example.gestor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

public class AgregarPedido extends AppCompatActivity {

    Connection conexion=null;
    PreparedStatement preparedStatement=null;

    EditText Cif;
    EditText RSP;
    EditText NumF;
    EditText DesF;
    EditText BasI;
    EditText IVA;
    EditText TotI;
    EditText FeF;
    EditText FeV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_pedido);
        Cif = (EditText) findViewById(R.id.inCif);
        RSP = (EditText) findViewById(R.id.inRazS);
        NumF = (EditText) findViewById(R.id.inNumf);
        DesF = (EditText) findViewById(R.id.inDesf);
        BasI = (EditText) findViewById(R.id.CodRespC);
        IVA = (EditText) findViewById(R.id.ImSeg);
        TotI = (EditText) findViewById(R.id.inTotimp);
        FeF = (EditText) findViewById(R.id.inFecHom);
        FeV = (EditText) findViewById(R.id.inFechv);
    }

    public void ape(View view){

       try {
           conexion = Connect.conecta();
           if (conexion != null) {
               preparedStatement = conexion.prepareStatement("Insert into act_prov VALUES (?,?,?,?,?,?,?,?,?)");

               preparedStatement.setString(1, Cif.getText().toString());
               preparedStatement.setString(2, Fix.fixdatastr(RSP.getText().toString()));
               preparedStatement.setInt(3, Fix.fixdataint(NumF.getText().toString()));//Str
               preparedStatement.setString(4, Fix.fixdatastr(DesF.getText().toString()));
               preparedStatement.setString(5, Fix.fixdatastr(BasI.getText().toString()));
               preparedStatement.setInt(6, Fix.fixdataint(IVA.getText().toString()));//Str
               preparedStatement.setInt(7, Fix.fixdataint(TotI.getText().toString()));//Str
               preparedStatement.setString(8, Fix.fixdatastr(FeF.getText().toString()));
               preparedStatement.setString(9, Fix.fixdatastr(FeV.getText().toString()));
           }

            int ok = preparedStatement.executeUpdate();
            if (ok > 0) {
                Toast.makeText(getApplicationContext(),"Dato añadido", Toast.LENGTH_SHORT).show();
                conexion.close();
            }
            else {
                Toast.makeText(getApplicationContext(),"Error", Toast.LENGTH_SHORT).show();
            }

        } catch(SQLIntegrityConstraintViolationException e0) {
            Toast.makeText(getApplicationContext(),"Valor duplicado o proveedor inexistente", Toast.LENGTH_SHORT).show();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

    }

    public void canp(View view){
        finish();
    }
}
