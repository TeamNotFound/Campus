package model;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="studenti")
public class Studente extends Utente {
	
	@ManyToOne
	@JoinColumn(name = "facolta_id")
	private Facolta facolta;
	
	@OneToMany(mappedBy = "studente")
	private Set<Prenotazione> prenotazioni;
	
	@Column(name="titoli_di_studio")
	private String titoliDiStudio;

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

	public String getTitoliDiStudio() {
		return titoliDiStudio;
	}
	

	public void setTitoliDiStudio(String titoliDiStudio) {
		this.titoliDiStudio = titoliDiStudio;
	}

	public Studente() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((titoliDiStudio == null) ? 0 : titoliDiStudio.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Studente other = (Studente) obj;
		if (titoliDiStudio == null) {
			if (other.titoliDiStudio != null)
				return false;
		} else if (!titoliDiStudio.equals(other.titoliDiStudio))
			return false;
		return true;
	}
}
