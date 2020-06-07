package com.example.gestor;

public class Fix {

    //En el caso de "" dará 0 en valores numéricos
    public static int fixdataint(String fixing) {
        if(fixing.equals("")) {
            return 0;
        }
        else
        {
            return Integer.parseInt(fixing);
        }
    }

    //En el caso de "" dará null en valores de cadena
    public static String fixdatastr(String fixing) {
        if(fixing.equals("")) {
            return null;
        }
        else
        {
            return fixing;
        }
    }

}
