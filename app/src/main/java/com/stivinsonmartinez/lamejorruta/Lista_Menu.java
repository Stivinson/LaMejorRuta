package com.stivinsonmartinez.lamejorruta;

/**
 * Created by Stivinson on 24/11/2015.
 */
public class Lista_Menu {

    private int idImagen;
    private String opcion;

    public Lista_Menu(int idImagen, String opcion) {
        this.idImagen = idImagen;
        this.opcion = opcion;
    }

    public int getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(int idImagen) {
        this.idImagen = idImagen;
    }

    public String getOpcion() {
        return opcion;
    }

    public void setOpcion(String opcion) {
        this.opcion = opcion;
    }
}
