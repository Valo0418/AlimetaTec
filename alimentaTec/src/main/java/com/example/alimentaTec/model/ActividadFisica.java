package com.example.alimentaTec.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ActividadFisica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_actividad;
    private String nombre_actividad;
    private String duracion;
    private float calorias_quemadas;
    private String intensidad;

    public int getId_actividad(){return id_actividad;}
    public void setId_actividad(int id_actividad){this.id_actividad = id_actividad;}

    public String getNombre_actividad(){return nombre_actividad;}
    public void setNombre_Actividad(String nombre_actividad){this.nombre_actividad = nombre_actividad;}
    
    public String getDuracion(){return duracion;}
    public void setDuracion(String duracion){this.duracion = duracion;}

    public float getCalorias_quemadas(){return calorias_quemadas;}
    public void setCalorias_quemadas(float calorias_quemadas){this.calorias_quemadas = calorias_quemadas;}

    public String getIntensidad(){return intensidad;}
    public void setIntensidad(String intensidad){this.intensidad = intensidad;}

    @Override
    public String toString(){
        return id_actividad + " :: " + nombre_actividad + " :: " + duracion + " :: " + calorias_quemadas + " :: " + intensidad;
    }
}
