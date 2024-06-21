package com.Final.Hospedaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface DestinoDAO extends JpaRepository<Destino, Integer>{
    
}
