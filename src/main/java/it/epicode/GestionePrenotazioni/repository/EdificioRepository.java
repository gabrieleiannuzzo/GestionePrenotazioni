package it.epicode.GestionePrenotazioni.repository;

import it.epicode.GestionePrenotazioni.bean.Edificio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EdificioRepository extends JpaRepository<Edificio, Integer> {
}
