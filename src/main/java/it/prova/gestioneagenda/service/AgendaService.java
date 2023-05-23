package it.prova.gestioneagenda.service;

import java.util.List;

import it.prova.gestioneagenda.model.Agenda;

public interface AgendaService {
	
	List<Agenda> listAllElements(boolean eager);

	Agenda caricaSingoloElemento(Long id);

	Agenda caricaSingoloElementoEager(Long id);

	Agenda aggiorna(Agenda agendaInstance);

	Agenda inserisciNuovo(Agenda agendaInstance);

	void rimuovi(Long idToRemove);

	List<Agenda> findByExample(Agenda example);

	List<Agenda> findByDescrizione(String descrizione);
	
	List<Agenda> agendeByUtente();
	
	void firstInstert();
	
}
