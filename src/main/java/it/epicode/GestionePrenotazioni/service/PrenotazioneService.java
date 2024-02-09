package it.epicode.GestionePrenotazioni.service;

import it.epicode.GestionePrenotazioni.bean.Prenotazione;
import it.epicode.GestionePrenotazioni.repository.PrenotazioneRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrenotazioneService {
    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    private Logger logger;

    public PrenotazioneService(){
        logger = LoggerFactory.getLogger("progetto");
    }

    public void salvaPrenotazione(Prenotazione p){
        try {
            prenotazioneRepository.save(p);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    public void aggiornaPrenotazione(Prenotazione p){
        try {
            Prenotazione prenotazione = prenotazioneRepository.findById(p.getId()).get();
            prenotazione.setDataPrenotazione(p.getDataPrenotazione());
            prenotazione.setPostazione(p.getPostazione());
            prenotazione.setUtente(p.getUtente());
            prenotazioneRepository.save(prenotazione);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    public Prenotazione cercaPrenotazionePerId(int id){
        return prenotazioneRepository.findById(id).get();
    }

    public void eliminaPrenotazione(int id){
        try {
            prenotazioneRepository.deleteById(id);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }
}
