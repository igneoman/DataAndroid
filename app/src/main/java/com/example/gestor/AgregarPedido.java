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
    //ResultSet resultSet=null;

    EditText Cif = (EditText) findViewById(R.id.inCif);
    EditText RSP = (EditText) findViewById(R.id.inRazS);
    EditText NumF = (EditText) findViewById(R.id.inNumf);
    EditText DesF = (EditText) findViewById(R.id.inDesf);
    EditText BasI = (EditText) findViewById(R.id.CodRespC);
    EditText IVA = (EditText) findViewById(R.id.ImSeg);
    EditText TotI = (EditText) findViewById(R.id.inTotimp);
    EditText FeF = (EditText) findViewById(R.id.inFecHom);
    EditText FeV = (EditText) findViewById(R.id.inFechv);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_pedido);
    }

    public void ape(View view){

        try {
            conexion = Connect.conecta();
            preparedStatement = conexion.prepareStatement("Insert into act_prov VALUES (?,?,?,?,?,?,?,?,?)");
            preparedStatement.setString(1, String.valueOf(Cif.getText()));
            preparedStatement.setString(2, Fix.fixdatastr(String.valueOf(RSP.getText())));
            preparedStatement.setInt(3, Fix.fixdataint(String.valueOf(NumF.getText())));//Str
            preparedStatement.setString(4, Fix.fixdatastr(String.valueOf(DesF.getText())));
            preparedStatement.setString(5, Fix.fixdatastr(String.valueOf(BasI.getText())));
            preparedStatement.setInt(6, Fix.fixdataint(String.valueOf(IVA.getText())));//Str
            preparedStatement.setInt(7, Fix.fixdataint(String.valueOf(TotI.getText())));//Str
            preparedStatement.setString(8, Fix.fixdatastr(String.valueOf(FeF.getText())));
            preparedStatement.setString(9, Fix.fixdatastr(String.valueOf(FeV.getText())));


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
