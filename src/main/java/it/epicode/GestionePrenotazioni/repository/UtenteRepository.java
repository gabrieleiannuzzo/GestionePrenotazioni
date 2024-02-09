package it.epicode.GestionePrenotazioni.repository;

import it.epicode.GestionePrenotazioni.bean.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtenteRepository extends JpaRepository<Utente, Integer> {
}
