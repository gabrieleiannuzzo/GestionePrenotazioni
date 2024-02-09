package it.epicode.GestionePrenotazioni.service;

import it.epicode.GestionePrenotazioni.bean.Edificio;
import it.epicode.GestionePrenotazioni.repository.EdificioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EdificioService {
    @Autowired
    private EdificioRepository edificioRepository;

    private Logger logger;

    public EdificioService(){
        logger = LoggerFactory.getLogger("progetto");
    }

    public void salvaEdificio(Edificio e){
        try {
            edificioRepository.save(e);
        } catch (Exception exception) {
            logger.error(exception.getMessage());
        }
    }

    public void aggiornaEdificio(Edificio e){
        try {
            Edificio edificio = edificioRepository.findById(e.getId()).get();
            edificio.setNumeroMassimoOccupanti(e.getNumeroMassimoOccupanti());
            edificio.setNome(e.getNome());
            edificio.setCitta(e.getCitta());
            edificio.setIndirizzo(e.getIndirizzo());
            edificioRepository.save(edificio);
        } catch (Exception exception) {
            logger.error(exception.getMessage());
        }
    }

    public Edificio cercaEdificioPerId(int id){
        Edificio e = null;

        try {
            e = edificioRepository.findById(id).get();
        } catch (Exception ex) {
            logger.error("Non è stato trovato nulla");
        }

        return e;
    }

    public void eliminaEdificio(int id){
        try {
            edificioRepository.deleteById(id);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }
}
