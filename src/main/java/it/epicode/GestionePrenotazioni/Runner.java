package it.epicode.GestionePrenotazioni;

import it.epicode.GestionePrenotazioni.bean.*;
import it.epicode.GestionePrenotazioni.service.EdificioService;
import it.epicode.GestionePrenotazioni.service.PostazioneService;
import it.epicode.GestionePrenotazioni.service.PrenotazioneService;
import it.epicode.GestionePrenotazioni.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class Runner implements CommandLineRunner {
    @Autowired
    private EdificioService edificioService;

    @Autowired
    private PostazioneService postazioneService;

    @Autowired
    private PrenotazioneService prenotazioneService;

    @Autowired
    private UtenteService utenteService;

    @Override
    public void run(String... args) throws Exception {
        //Edificio e = edificioService.cercaEdificioPerId(1);
        //Postazione po1 = postazioneService.cercaPostazionePerId(1);
        //Utente u = utenteService.cercaUtentePerId(1);
        //Prenotazione pr1 = prenotazioneService.cercaPrenotazionePerId(1);

        Edificio e1 = new Edificio();
        e1.setCitta("Torino");
        e1.setIndirizzo("Via Via Via");
        e1.setNome("Quarto edificio");
        e1.setNumeroMassimoOccupanti(10);

        //edificioService.salvaEdificio(e1);

//        Postazione po2 = new Postazione();
//        po2.setEdificio(e);
//        po2.setTipo(Tipo.PRIVATO);
//        po2.setDescrizione("Quinta postazione");

        //postazioneService.salvaPostazione(po2);

        Utente u2 = new Utente();
        u2.setEmail("g.i@it");
        u2.setNome("Gabriele");
        u2.setCognome("Iannuzzo");
        u2.setUsername("gabbo");

        //utenteService.salvaUtente(u2);

//        Prenotazione pr2 = new Prenotazione();
//        pr2.setPostazione(po1);
//        pr2.setUtente(u);
//        pr2.setDataPrenotazione(LocalDate.now().plusDays(2));

        //prenotazioneService.salvaPrenotazione(pr2);

        //prenotazioneService.eliminaPrenotazione(1);
        //utenteService.eliminaUtente(3);
        //utenteService.eliminaUtente(4);
        //edificioService.eliminaEdificio(3);
        //edificioService.eliminaEdificio(4);

        //System.out.println(postazioneService.cercaPostazionePerTipoECitta(Tipo.PRIVATO, "Roma"));
    }
}
