package model;

import java.util.Set;
import java.util.TreeSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="corsi")
public class Corso {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column
	private String corso;
	
	@OneToMany(mappedBy="corso", fetch=FetchType.EAGER)
	private Set<Prenotazione> prenotazioni;
	
	@ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(
        name = "corsi_facolta", 
        joinColumns = { @JoinColumn(name = "facolta_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "corso_id") }
    )
	private Set<Facolta> facolta;
	
	

	public Corso() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Set<Prenotazione> getPrenotazioni() {
		return prenotazioni;
	}

	public void setPrenotazioni(Set<Prenotazione> prenotazioni) {
		this.prenotazioni = prenotazioni;
	}

	public Set<Facolta> getFacolta() {
		return facolta;
	}

	public void setFacolta(Set<Facolta> facolta) {
		this.facolta = facolta;
	}

	public String getCorso() {
		return corso;
	}

	public void setCorso(String corso) {
		this.corso = corso;
	}
	
	public void addFacolta(Facolta f){
		facolta.add(f);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((corso == null) ? 0 : corso.hashCode());
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
		Corso other = (Corso) obj;
		if (corso == null) {
			if (other.corso != null)
				return false;
		} else if (!corso.equals(other.corso))
			return false;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Corso [id=" + id + ", prenotazioni=" + prenotazioni + ", facolta=" + facolta + "]";
	}
	
	
}
