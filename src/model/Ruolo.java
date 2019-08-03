package model;

import java.util.ArrayList;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="ruoli")
public class Ruolo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column
	private String ruolo;
	
	@OneToMany(mappedBy = "ruolo")
	private Set<Utente> iscritti;
	
	public Ruolo(int id, String ruolo) {
		super();
		this.id = id;
		this.ruolo = ruolo;
	}

	public Ruolo() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRuolo() {
		return ruolo;
	}

	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}

	public Set<Utente> getIscritti() {
		return iscritti;
	}

	public void setIscritti(Set<Utente> iscritti) {
		this.iscritti = iscritti;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((ruolo == null) ? 0 : ruolo.hashCode());
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
		Ruolo other = (Ruolo) obj;
		if (id != other.id)
			return false;
		if (ruolo == null) {
			if (other.ruolo != null)
				return false;
		} else if (!ruolo.equals(other.ruolo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Ruolo [id=" + id + ", ruolo=" + ruolo + "]";
	}
}
