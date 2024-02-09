package it.epicode.GestionePrenotazioni.bean;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(
        name = "prenotazioni",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"id_utente", "data_prenotazione"}),
                @UniqueConstraint(columnNames = {"id_postazione", "data_prenotazione"})
        }
)
@Data
public class Prenotazione {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenza_prenotazioni")
    @SequenceGenerator(name = "sequenza_prenotazioni", initialValue = 1, allocationSize = 1)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_postazione", nullable = false)
    private Postazione postazione;

    @ManyToOne
    @JoinColumn(name = "id_utente", nullable = false)
    private Utente utente;

    @Column(name = "data_prenotazione")
    private LocalDate dataPrenotazione;
}
