package model;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table (name="data_appello")
public class DataAppello {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn (name="corso_id")
	private Corso corso;
	
	@ManyToOne
	@JoinColumn (name="facolta_id")
	private Facolta facolta;
	
	@ManyToOne
	@JoinColumn(name="professore_id")
	private Professore professore;
	
	@OneToMany (mappedBy="dataAppello")
	private Set <Prenotazione> prenotazioni;
	
	@Column (name="dataAppello")
	private Date dataAppello;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Corso getCorso() {
		return corso;
	}

	public void setCorso(Corso corso) {
		this.corso = corso;
	}

	public Facolta getFacolta() {
		return facolta;
	}

	public void setFacolta(Facolta facolta) {
		this.facolta = facolta;
	}

	public Set<Prenotazione> getPrenotazioni() {
		return prenotazioni;
	}

	public void setPrenotazioni(Set<Prenotazione> prenotazioni) {
		this.prenotazioni = prenotazioni;
	}

	
	
	public Date getDataAppello() {
		return dataAppello;
	}

	public void setDataAppello(Date dataAppello) {
		this.dataAppello = dataAppello;
	}
	
	public Professore getProfessore() {
		return professore;
	}

	public void setProfessore(Professore professore) {
		this.professore = professore;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((corso == null) ? 0 : corso.hashCode());
		result = prime * result + ((dataAppello == null) ? 0 : dataAppello.hashCode());
		result = prime * result + ((facolta == null) ? 0 : facolta.hashCode());
		result = prime * result + id;
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
		DataAppello other = (DataAppello) obj;
		if (corso == null) {
			if (other.corso != null)
				return false;
		} else if (!corso.equals(other.corso))
			return false;
		if (dataAppello == null) {
			if (other.dataAppello != null)
				return false;
		} else if (!dataAppello.equals(other.dataAppello))
			return false;
		if (facolta == null) {
			if (other.facolta != null)
				return false;
		} else if (!facolta.equals(other.facolta))
			return false;
		if (id != other.id)
			return false;
		return true;
	}

	public DataAppello(int id, Corso corso, Facolta facolta, Set<Prenotazione> prenotazioni) {
		super();
		this.id = id;
		this.corso = corso;
		this.facolta = facolta;
		this.prenotazioni = prenotazioni;
	}

	public DataAppello() {
		super();
	}

	@Override
	public String toString() {
		return "DataAppello [id=" + id + ", corso=" + corso + ", facolta=" + facolta + ", professore=" + professore
				+ ", prenotazioni=" + prenotazioni + ", dataAppello=" + dataAppello + "]";
	}
	
	
}
