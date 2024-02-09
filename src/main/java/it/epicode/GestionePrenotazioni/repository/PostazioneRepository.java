package it.epicode.GestionePrenotazioni.repository;

import it.epicode.GestionePrenotazioni.bean.Postazione;
import it.epicode.GestionePrenotazioni.bean.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostazioneRepository extends JpaRepository<Postazione, Integer> {
    // utilizzo una query JPQL perchè non posso accedere direttamente a città da postazione, ma solo da postazione.edificio
    @Query("SELECT p FROM Postazione p WHERE p.tipo = :tipo AND p.edificio.citta = :citta")
    public List<Postazione> findByTipoAndCitta(Tipo tipo, String citta);
}
