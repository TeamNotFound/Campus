package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="prenotazioni")
public class Prenotazione {
	
	@EmbeddedId
	private PrenoPK pk = new PrenoPK();
	
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

	public Prenotazione(PrenoPK pk, Date dataPrenotazione) {
		super();
		this.pk = pk;
		this.dataPrenotazione = dataPrenotazione;
	}

	public Prenotazione() {
		super();
		// TODO Auto-generated constructor stub
	}



	public PrenoPK getPk() {
		return pk;
	}

	public void setPk(PrenoPK pk) {
		this.pk = pk;
	}

	public Date getDataPrenotazione() {
		return dataPrenotazione;
	}

	public void setDataPrenotazione(Date dataPrenotazione) {
		this.dataPrenotazione = dataPrenotazione;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataPrenotazione == null) ? 0 : dataPrenotazione.hashCode());
		result = prime * result + ((pk == null) ? 0 : pk.hashCode());
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
		if (dataPrenotazione == null) {
			if (other.dataPrenotazione != null)
				return false;
		} else if (!dataPrenotazione.equals(other.dataPrenotazione))
			return false;
		if (pk == null) {
			if (other.pk != null)
				return false;
		} else if (!pk.equals(other.pk))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Prenotazione [pk=" + pk + ", dataPrenotazione=" + dataPrenotazione + "]";
	}
	
	
}
