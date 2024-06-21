package com.Final.Hospedaje;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="huesped")
public class Huesped {
    @Id
    private int id;
    private String nombre;
    private String ciudadania;
    private String email;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Destino destino;
 
    public Destino getDestino() {
       return this.destino;
    }
 
    public void setDestino(Destino destino) {
       this.destino = destino;
    }

    public Huesped(){

    }


    // Getter and Setter for id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter and Setter for nombre
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Getter and Setter for ciudadania
    public String getCiudadania() {
        return ciudadania;
    }

    public void setCiudadania(String ciudadania) {
        this.ciudadania = ciudadania;
    }

    // Getter and Setter for email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String toString() {
        return "Huesped [id=" + this.id + ", nombre=" + this.nombre + ", ciudadania=" + this.ciudadania +", email=" + this.email + "]";
     }

}
