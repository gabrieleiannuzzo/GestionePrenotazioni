package it.epicode.GestionePrenotazioni.service;

import it.epicode.GestionePrenotazioni.bean.Utente;
import it.epicode.GestionePrenotazioni.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtenteService {
    @Autowired
    private UtenteRepository utenteRepository;

    public void salvaUtente(Utente u){
        utenteRepository.save(u);
    }

    public void aggiornaUtente(Utente u){
        Utente utente = utenteRepository.findById(u.getId()).get();
        utente.setNome(u.getNome());
        utente.setCognome(u.getCognome());
        utente.setUsername(u.getUsername());
        utente.setEmail(u.getEmail());
        utenteRepository.save(utente);
    }

    public Utente cercaUtentePerId(int id){
        return utenteRepository.findById(id).get();
    }

    public void eliminaUtente(int id){
        utenteRepository.deleteById(id);
    }
}
