package it.epicode.GestionePrenotazioni.service;

import it.epicode.GestionePrenotazioni.bean.Postazione;
import it.epicode.GestionePrenotazioni.bean.Tipo;
import it.epicode.GestionePrenotazioni.repository.PostazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostazioneService {
    @Autowired
    private PostazioneRepository postazioneRepository;

    public void salvaPostazione(Postazione p){
        postazioneRepository.save(p);
    }

    public void aggiornaPostazione(Postazione p){
        Postazione postazione = postazioneRepository.findById(p.getId()).get();
        postazione.setDescrizione(p.getDescrizione());
        postazione.setTipo(p.getTipo());
        postazione.setEdificio(p.getEdificio());
        postazioneRepository.save(p);
    }

    public Postazione cercaPostazionePerId(int id){
        return postazioneRepository.findById(id).get();
    }

    public List<Postazione> cercaPostazionePerTipoECitta(Tipo tipo, String citta){
        return postazioneRepository.findByTipoAndCitta(tipo, citta);
    }

    public void eliminaPostazione(int id){
        postazioneRepository.deleteById(id);
    }
}
