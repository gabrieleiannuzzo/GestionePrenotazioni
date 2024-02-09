package it.epicode.GestionePrenotazioni.service;

import it.epicode.GestionePrenotazioni.bean.Utente;
import it.epicode.GestionePrenotazioni.repository.UtenteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtenteService {
    @Autowired
    private UtenteRepository utenteRepository;

    private Logger logger;

    public UtenteService(){
        logger = LoggerFactory.getLogger("progetto");
    }

    public void salvaUtente(Utente u){
        try {
            utenteRepository.save(u);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    public void aggiornaUtente(Utente u){
        try {
            Utente utente = utenteRepository.findById(u.getId()).get();
            utente.setNome(u.getNome());
            utente.setCognome(u.getCognome());
            utente.setUsername(u.getUsername());
            utente.setEmail(u.getEmail());
            utenteRepository.save(utente);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    public Utente cercaUtentePerId(int id){
        Utente u = null;

        try {
            u = utenteRepository.findById(id).get();
        } catch (Exception e) {
            logger.error("Non è stato trovato nulla");
        }

        return u;
    }

    public void eliminaUtente(int id){
        try {
            utenteRepository.deleteById(id);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }
}
