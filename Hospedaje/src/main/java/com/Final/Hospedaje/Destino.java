package com.Final.Hospedaje;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "destino")
public class Destino {
    @Id
   public int id;
   public String nombre;
   public String pais;

   @OneToMany(
      mappedBy = "destino",
      fetch = FetchType.LAZY,
      cascade = {CascadeType.ALL}
   )
   List<Huesped> huesped;

   public Destino() {
      huesped = new ArrayList<>();
   }

   public List<Huesped> getHuesped() {
      return this.huesped;
   }

   public void setHuesped (List<Huesped> huesped) {
      this.huesped = huesped;
   }

   public int getId() {
      return this.id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getNombre() {
      return this.nombre;
   }

   public void setNombre(String nombre) {
      this.nombre = nombre;
   }

   public String getPais() {
      return this.pais;
   }

   public void setPais(String pais) {
      this.pais = pais;
   }

   public String toString() {
      return this.nombre ;
   }
}
