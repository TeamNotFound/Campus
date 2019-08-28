package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import model.Prenotazione.Id;

@Entity
@Table(name="prenotazioni")
public class Prenotazione {
	
	@Embeddable
	class Id implements Serializable{
	@Column(name="data_appello_id")
	private int data_appello_id;
	@Column(name="studente_id")
	private int studente_id;
	
	
	public int getData_appello_id() {
		return data_appello_id;
	}

	public void setData_appello_id(int data_appello_id) {
		this.data_appello_id = data_appello_id;
	}

	public int getStudente_id() {
		return studente_id;
	}

	public void setStudente_id(int studente_id) {
		this.studente_id = studente_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + getEnclosingInstance().hashCode();
		result = prime * result + data_appello_id;
		result = prime * result + studente_id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Id other = (Id) obj;
		if (!getEnclosingInstance().equals(other.getEnclosingInstance()))
			return false;
		if (data_appello_id != other.data_appello_id)
			return false;
		if (studente_id != other.studente_id)
			return false;
		return true;
	}

	private Prenotazione getEnclosingInstance() {
		return Prenotazione.this;
	}

	public Id(int data_appello_id, int studente_id) {
		super();
		this.data_appello_id = data_appello_id;
		this.studente_id = studente_id;

	}

	public Id() {
		super();
	}
	}
	@EmbeddedId
	private Id id;
	
	@Column(name="data_prenotazione")
	private Date dataPrenotazione;
	
	@ManyToOne
	@MapsId("studente_id")
	@JoinColumn(name = "studente_id")
	private Studente studente;
	
	@ManyToOne
	@MapsId("data_appello_id")
	@JoinColumn(name = "data_appello_id")
	private DataAppello dataAppello;

	public Id getId() {
		return id;
	}

	public void setId(Id id) {
		this.id = id;
	}

	public Date getDataPrenotazione() {
		return dataPrenotazione;
	}

	public void setDataPrenotazione(Date dataPrenotazione) {
		this.dataPrenotazione = dataPrenotazione;
	}

	public Studente getStudente() {
		return studente;
	}

	public void setStudente(Studente studente) {
		this.studente = studente;
	}

	public DataAppello getDataAppello() {
		return dataAppello;
	}

	public void setDataAppello(DataAppello dataAppello) {
		this.dataAppello = dataAppello;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataAppello == null) ? 0 : dataAppello.hashCode());
		result = prime * result + ((dataPrenotazione == null) ? 0 : dataPrenotazione.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((studente == null) ? 0 : studente.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Prenotazione other = (Prenotazione) obj;
		if (dataAppello == null) {
			if (other.dataAppello != null)
				return false;
		} else if (!dataAppello.equals(other.dataAppello))
			return false;
		if (dataPrenotazione == null) {
			if (other.dataPrenotazione != null)
				return false;
		} else if (!dataPrenotazione.equals(other.dataPrenotazione))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (studente == null) {
			if (other.studente != null)
				return false;
		} else if (!studente.equals(other.studente))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Prenotazione [id=" + id + ", dataPrenotazione=" + dataPrenotazione + ", studente=" + studente
				+ ", dataAppello=" + dataAppello + "]";
	}

	public Prenotazione(Id id, Date dataPrenotazione, Studente studente, DataAppello dataAppello) {
		super();
		this.id = id;
		this.dataPrenotazione = dataPrenotazione;
		this.studente = studente;
		this.dataAppello = dataAppello;
	}

	public Prenotazione() {
		super();
	}

	
	}
	
	
