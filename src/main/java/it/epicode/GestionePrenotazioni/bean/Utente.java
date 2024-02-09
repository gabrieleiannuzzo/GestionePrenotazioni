package it.epicode.GestionePrenotazioni.bean;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "utenti")
@Data
public class Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenza_utenti")
    @SequenceGenerator(name = "sequenza_utenti", initialValue = 1, allocationSize = 1)
    private int id;

    private String username;

    private String nome;

    private String cognome;

    private String email;

    @OneToMany(mappedBy = "utente", fetch = FetchType.EAGER)
    private List<Prenotazione> prenotazioni;
}
