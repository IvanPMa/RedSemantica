package com.example.redsemanticapoblacional;

public class datosModelo {
    private String edad,sexo,puesto,antiguedad;
    //private int imgSujeto;

    public datosModelo() {
    }

    public datosModelo(String edad, String sexo, String puesto, String antiguedad) {
        this.edad = edad;
        this.sexo = sexo;
        this.puesto = puesto;
        this.antiguedad = antiguedad;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(String antiguedad) {
        this.antiguedad = antiguedad;
    }

    //public int getImgSujeto() {
        //return imgSujeto;
   // }

    //public void setImgSujeto(int imgSujeto) {
       // this.imgSujeto = imgSujeto;
   // }
}
