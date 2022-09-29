package com.certification.reqres.models;

public class AutenticacionModels {
    private static final String MAIN_ROUTE= "src/test/resources/templates/";
    public static final String CREATE_USER = MAIN_ROUTE + "registro.json";
    public static final String LOGIN_USER = MAIN_ROUTE + "logueo.json";
    public static final String GET_USER = MAIN_ROUTE;
}

/*aca va lo que esta en los templates*/
// entonces primero definimos lo que tenemos en la carpeta de
// templates, En crear cliente lo que hago es usar la ruta principal de la carpeta
// y le concateno la direccion del json que vamos a usar
