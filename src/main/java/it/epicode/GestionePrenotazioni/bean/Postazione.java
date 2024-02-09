package it.epicode.GestionePrenotazioni.bean;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "postazioni")
@Data
public class Postazione {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenza_postazioni")
    @SequenceGenerator(name = "sequenza_postazioni", initialValue = 1, allocationSize = 1)
    private int id;

    private String descrizione;

    @Enumerated(EnumType.STRING)
    private Tipo tipo;

    @ManyToOne()
    @JoinColumn(name = "id_edificio", nullable = false)
    private Edificio edificio;

    @OneToMany(mappedBy = "postazione", fetch = FetchType.EAGER)
    private List<Prenotazione> prenotazioni;

    @Override
    public String toString() {
        return "Postazione{" +
                "id=" + id +
                ", descrizione='" + descrizione + '\'' +
                ", tipo=" + tipo +
                ", edificio=" + edificio +
                '}';
    }
}
