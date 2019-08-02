package model;

import java.util.Set;
import java.util.TreeSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="facolta")
public class Facolta {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column
	private String facolta;
	
	@OneToMany(mappedBy="facolta", fetch=FetchType.EAGER)
	private Set<Studente> studenti;
	
	@ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(
        name = "corsi_facolta", 
        joinColumns = { @JoinColumn(name = "corso_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "facolta_id") }
    )
	private Set<Corso> corsi;

	public Facolta(int id, String facolta, Set<Studente> studenti) {
		super();
		this.id = id;
		this.facolta = facolta;
		this.studenti = studenti;
	}

	public Facolta() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFacolta() {
		return facolta;
	}

	public void setFacolta(String facolta) {
		this.facolta = facolta;
	}

	public Set<Studente> getStudenti() {
		return studenti;
	}

	public void setStudenti(Set<Studente> studenti) {
		this.studenti = studenti;
	}

	public Set<Corso> getCorsi() {
		return corsi;
	}

	public void setCorsi(Set<Corso> corsi) {
		this.corsi = corsi;
	}
	
	public void addStudente(Studente s){
		if(s.getFacolta() == null){
			s.setFacolta(this);
		}
		studenti.add(s);
	}
	
	public void addCorso(Corso c){
		corsi.add(c);
	}

	@Override
	public String toString() {
		return "Facolta [id=" + id + ", facolta=" + facolta + ", studenti=" + studenti + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		Facolta other = (Facolta) obj;
		if (facolta == null) {
			if (other.facolta != null)
				return false;
		} else if (!facolta.equals(other.facolta))
			return false;
		if (id != other.id)
			return false;
		return true;
	}
}
