/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

/**
 *
 * @author 9alej
 */
public class Usuario {
    private String nombre, dni, estudios, rol;
    
    public Usuario (String nombre, String dni, String estudios, boolean admin){
        this.nombre=nombre;
        this.dni=dni;
        this.estudios=estudios;
        if(admin) rol = "administrador";
        else rol = "usuario";
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEstudios() {
        return estudios;
    }

    public void setEstudios(String estudios) {
        this.estudios = estudios;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(boolean admin) {
        if(admin) rol = "administrador";
        else rol = "usuario";
    }    
}
