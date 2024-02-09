package it.epicode.GestionePrenotazioni.service;

import it.epicode.GestionePrenotazioni.bean.Postazione;
import it.epicode.GestionePrenotazioni.bean.Tipo;
import it.epicode.GestionePrenotazioni.repository.PostazioneRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostazioneService {
    @Autowired
    private PostazioneRepository postazioneRepository;

    private Logger logger;

    public PostazioneService(){
        logger = LoggerFactory.getLogger("progetto");
    }

    public void salvaPostazione(Postazione p){
        try {
            postazioneRepository.save(p);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    public void aggiornaPostazione(Postazione p){
        try {
            Postazione postazione = postazioneRepository.findById(p.getId()).get();
            postazione.setDescrizione(p.getDescrizione());
            postazione.setTipo(p.getTipo());
            postazione.setEdificio(p.getEdificio());
            postazioneRepository.save(p);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    public Postazione cercaPostazionePerId(int id){
        Postazione p = null;

        try {
            p = postazioneRepository.findById(id).get();
        } catch (Exception e) {
            logger.error("Non è stato trovato nulla");
        }

        return p;
    }

    public List<Postazione> cercaPostazionePerTipoECitta(Tipo tipo, String citta){
        return postazioneRepository.findByTipoAndCitta(tipo, citta);
    }

    public void eliminaPostazione(int id){
        try {
            postazioneRepository.deleteById(id);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }
}
