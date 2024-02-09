package it.epicode.GestionePrenotazioni.bean;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "edifici")
@Data
public class Edificio {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenza_edifici")
    @SequenceGenerator(name = "sequenza_edifici", initialValue = 1, allocationSize = 1)
    private int id;

    private String nome;

    private String indirizzo;

    private String citta;

    /* Ho inserito il numero massimo degli occupanti in un edificio assumendo che la postazione sia occupata da una
    sola persona. Se un edificio può avere più postazioni possiamo inserire un metodo che controlla che non vengano
    prenotate troppe postazioni in un giorno, altrimenti non possiamo imporre un limite giornaliero assumendo che
    la proprietà numeroMassimoOccupanti faccia parte della classe Postazione */
    private int numeroMassimoOccupanti;

    @OneToMany(mappedBy = "edificio", fetch = FetchType.EAGER)
    private List<Postazione> postazioni;

    @Override
    public String toString() {
        return "Edificio{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", indirizzo='" + indirizzo + '\'' +
                ", citta='" + citta + '\'' +
                ", numeroMassimoOccupanti=" + numeroMassimoOccupanti +
                '}';
    }
}
