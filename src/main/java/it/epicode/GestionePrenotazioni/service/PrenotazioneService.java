package it.epicode.GestionePrenotazioni.service;

import it.epicode.GestionePrenotazioni.bean.Prenotazione;
import it.epicode.GestionePrenotazioni.repository.PrenotazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrenotazioneService {
    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    public void salvaPrenotazione(Prenotazione p){
        prenotazioneRepository.save(p);
    }

    public void aggiornaPrenotazione(Prenotazione p){
        Prenotazione prenotazione = prenotazioneRepository.findById(p.getId()).get();
        prenotazione.setDataPrenotazione(p.getDataPrenotazione());
        prenotazione.setPostazione(p.getPostazione());
        prenotazione.setUtente(p.getUtente());
        prenotazioneRepository.save(prenotazione);
    }

    public Prenotazione cercaPrenotazionePerId(int id){
        return prenotazioneRepository.findById(id).get();
    }

    public void eliminaPrenotazione(int id){
        prenotazioneRepository.deleteById(id);
    }
}
