package it.epicode.GestionePrenotazioni.service;

import it.epicode.GestionePrenotazioni.bean.Edificio;
import it.epicode.GestionePrenotazioni.repository.EdificioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EdificioService {
    @Autowired
    private EdificioRepository edificioRepository;

    public void salvaEdificio(Edificio e){
        edificioRepository.save(e);
    }

    public void aggiornaEdificio(Edificio e){
        Edificio edificio = edificioRepository.findById(e.getId()).get();
        edificio.setNumeroMassimoOccupanti(e.getNumeroMassimoOccupanti());
        edificio.setNome(e.getNome());
        edificio.setCitta(e.getCitta());
        edificio.setIndirizzo(e.getIndirizzo());
        edificioRepository.save(edificio);
    }

    public Edificio cercaEdificioPerId(int id){
        return edificioRepository.findById(id).get();
    }

    public void eliminaEdificio(int id){
        edificioRepository.deleteById(id);
    }
}
