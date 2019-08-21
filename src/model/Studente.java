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
	
	
	
	
}
