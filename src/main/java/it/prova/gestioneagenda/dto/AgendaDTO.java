package it.prova.gestioneagenda.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import it.prova.gestioneagenda.model.Agenda;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AgendaDTO {
	
	private Long id;
	
	@NotBlank(message = "{descrizione.notblank}")
	private String descrizione;
	
	@NotNull(message = "{dataOraInizio.notnull}")
	private LocalDateTime dataOraInizio;
	
	@NotNull(message = "{dataOraFine.notnull}")
	private LocalDateTime dataOraFine;
	
	@JsonIgnoreProperties(value = { "agende" })
	private UtenteDTO utente;
	
	public AgendaDTO () {}

	public AgendaDTO(Long id,String descrizione,LocalDateTime dataOraInizio, LocalDateTime dataOraFine,UtenteDTO utente) {
		super();
		this.id = id;
		this.descrizione = descrizione;
		this.dataOraInizio = dataOraInizio;
		this.dataOraFine = dataOraFine;
		this.utente = utente;
	}
	
	public AgendaDTO(Long id, String descrizione, LocalDateTime dataOraInizio,LocalDateTime dataOraFine) {
		super();
		this.id = id;
		this.descrizione = descrizione;
		this.dataOraInizio = dataOraInizio;
		this.dataOraFine = dataOraFine;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public LocalDateTime getDataOraInizio() {
		return dataOraInizio;
	}

	public void setDataOraInizio(LocalDateTime dataOraInizio) {
		this.dataOraInizio = dataOraInizio;
	}

	public LocalDateTime getDataOraFine() {
		return dataOraFine;
	}

	public void setDataOraFine(LocalDateTime dataOraFine) {
		this.dataOraFine = dataOraFine;
	}

	public UtenteDTO getUtente() {
		return utente;
	}

	public void setUtente(UtenteDTO utente) {
		this.utente = utente;
	}
	
	public Agenda buildAgendaModel() {
		Agenda result = new Agenda(this.id, this.descrizione, this.dataOraInizio, this.dataOraFine);
		if (this.utente != null)
			result.setUtente(this.utente.buildUtenteModel(false));

		return result;
	}
	
	public static AgendaDTO buildAgendaDTOFromModel(Agenda agendaModel, boolean includeUtente) {
		AgendaDTO result = new AgendaDTO(agendaModel.getId(), agendaModel.getDescrizione(), agendaModel.getDataOraInizio(),
				agendaModel.getDataOraFine());

		if (includeUtente)
			result.setUtente(UtenteDTO.buildUtenteDTOFromModel(agendaModel.getUtente()));

		return result;
	}
	
	public static List<AgendaDTO> createAgendaDTOListFromModelList(List<Agenda> modelListInput, boolean includeUtente) {
		return modelListInput.stream().map(agendaEntity -> {
			return AgendaDTO.buildAgendaDTOFromModel(agendaEntity, includeUtente);
		}).collect(Collectors.toList());
	}
	
	public static Set<AgendaDTO> createAgendaDTOSetFromModelSet(Set<Agenda> modelListInput, boolean includeUtente) {
		return modelListInput.stream().map(agendaEntity -> {
			return AgendaDTO.buildAgendaDTOFromModel(agendaEntity, includeUtente);
		}).collect(Collectors.toSet());
	}
	
	

}
