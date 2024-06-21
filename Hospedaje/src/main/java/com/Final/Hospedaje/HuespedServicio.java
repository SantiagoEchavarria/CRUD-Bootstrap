package com.Final.Hospedaje;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HuespedServicio implements HuespedInterface{
    @Autowired
   private HuespedDAO huespedDAO;
   

   public HuespedServicio() {
   }

   @Transactional
   public void guardarHuesped(Huesped huesped) {
      this.huespedDAO.save(huesped);
   }

   @Transactional
   public List<Huesped> listadoHuesped() {
      return this.huespedDAO.findAll();
   }
}
