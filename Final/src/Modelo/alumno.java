/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author LN710Q
 */
public class alumno {
      private int id;
    private int carnet;
    private String nombre;
    private String apellidos;
    private String universidad;
    private int edad;
    private boolean estado;

    public alumno() {
    }

  

    public alumno(int id, int carnet, String nombre, String apellidos, String universidad, int edad, boolean estado) {
        this.id = id;
        this.carnet = carnet;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.universidad = universidad;
        this.edad = edad;
        this.estado = estado;
    }

    public alumno(int carnet, String nombre, String apellidos, String universidad, int edad, boolean estado) {
        this.carnet = carnet;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.universidad = universidad;
        this.edad = edad;
        this.estado = estado;
    }

    public String getUniversidad() {
        return universidad;
    }

    public void setUniversidad(String universidad) {
        this.universidad = universidad;
    }


    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCarnet() {
        return carnet;
    }

    public void setCarnet(int carnet) {
        this.carnet = carnet;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "alumno{" + "id=" + id + ", carnet=" + carnet + ", nombre=" + nombre + ", apellidos=" + apellidos + ", edad=" + edad + ", estado=" + estado + '}';
    }
    
}
