package com.Final.Hospedaje;

import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DestinoServicio implements DestinoInterface{
    @Autowired
   private DestinoDAO destinoDAO;

   public DestinoServicio() {
   }

   @Transactional
   public void guardarDestino(Destino destino) {
      this.destinoDAO.save(destino);
   }

   @Transactional
   public List<Destino> listadoDestinos() {
      return this.destinoDAO.findAll();
   }
}
