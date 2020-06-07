package com.example.gestor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Connect {

    /*Por ahora en local, pero cuando pueda usarÃ©
    https://www.freemysqlhosting.net/ o https://www.freesqldatabase.com/ o https://www.db4free.net/*/
    //En Local
    //10.0.2.2 es para acceder al localhost demi PC
	private static String url = "jdbc:mysql://10.0.2.2:3306/empresadb";
	private static String user = "root";
	private static String pass = "";
    //En remoto acceder con usuario y contraseña aquí:
    //https://www.db4free.net/phpMyAdmin/index.php
    /*private static String url = "jdbc:mysql://db4free.net:3306/empresadb9";
    private static String user = "tester12309";
    private static String pass = "Testear123";*/

    public static Connection conecta(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion;
            conexion = DriverManager.getConnection(url,user,pass);
            return conexion;
        }catch(SQLException e){
            System.out.println("Error sql: "+e.getMessage());
        }catch (Exception e){
            System.out.println("Error: "+e.getMessage());
        }
        return null;
    }

}