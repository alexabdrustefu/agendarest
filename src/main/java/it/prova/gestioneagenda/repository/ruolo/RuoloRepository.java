package it.prova.gestioneagenda.repository.ruolo;

import org.springframework.data.repository.CrudRepository;

import it.prova.gestioneagenda.model.Ruolo;


public interface RuoloRepository extends CrudRepository<Ruolo, Long> {
	Ruolo findByDescrizioneAndCodice(String descrizione, String codice);
}
