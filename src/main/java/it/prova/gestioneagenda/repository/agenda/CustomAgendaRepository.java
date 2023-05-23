package it.prova.gestioneagenda.repository.agenda;

import java.util.List;

import it.prova.gestioneagenda.model.Agenda;


public interface CustomAgendaRepository {
	List<Agenda> findByExample(Agenda example);

}
