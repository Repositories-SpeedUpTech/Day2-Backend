package com.certification.reqres.endpoitns;

public class ApiEndpontLogin {
    private static final String LOGINUSER = "users/login";

    public static String obtenerEndpoint(String endpoint){
        switch (endpoint){
            case "login":
                return ApiEndpoints.obtenerEndpoint(LOGINUSER);
            default:
                break;
        }
        return "";
    }
}
