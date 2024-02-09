package it.epicode.GestionePrenotazioni.repository;

import it.epicode.GestionePrenotazioni.bean.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Integer> {
}
