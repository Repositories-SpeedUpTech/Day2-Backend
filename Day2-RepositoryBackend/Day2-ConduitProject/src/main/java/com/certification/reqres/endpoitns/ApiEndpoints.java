package com.certification.reqres.endpoitns;

public class ApiEndpoints {
    private static final String ADDUSER = "users";
    private static final String GETUSER = "users";
    private static final String PUTUSER = "users";

    public static String obtenerEndpoint(String endpoint){
        switch (endpoint){
            case "register":
                return ApiEndpoints.ADDUSER;
            case "getUser":
                return ApiEndpoints.GETUSER;
            case "putUser":
                return ApiEndpoints.PUTUSER;
            default:
                break;
        }
        return "";
    }
}
/*Aca van las variables de  lo que vamos a conectar,
se realiza la concatenacion de las partes finales de la page
se coloca un case para cada uno y su respectivo retorno*/