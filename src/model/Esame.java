package model;

import javax.persistence.*;

@Entity
@Table ( name = "esame")
public class Esame {
	
@Id
@GeneratedValue (strategy = GenerationType.IDENTITY)
private int id;

@ManyToOne
@JoinColumn (name="corso_id")
private Corso corso;

@ManyToOne
@JoinColumn (name="facolta_id")
private Facolta facolta;

@ManyToOne 
@JoinColumn (name = "studente_id")
private Studente studente;

@ManyToOne 
@JoinColumn (name = "professore_id")
private Professore professore;

@Column(name ="voto_esame")
private int votoEsame;

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

public Studente getStudente() {
	return studente;
}

public void setStudente(Studente studente) {
	this.studente = studente;
}

public Professore getProfessore() {
	return professore;
}

public void setProfessore(Professore professore) {
	this.professore = professore;
}

public int getVotoEsame() {
	return votoEsame;
}

public void setVotoEsame(int votoEsame) {
	this.votoEsame = votoEsame;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((corso == null) ? 0 : corso.hashCode());
	result = prime * result + ((facolta == null) ? 0 : facolta.hashCode());
	result = prime * result + id;
	result = prime * result + ((professore == null) ? 0 : professore.hashCode());
	result = prime * result + ((studente == null) ? 0 : studente.hashCode());
	result = prime * result + votoEsame;
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
	Esame other = (Esame) obj;
	if (corso == null) {
		if (other.corso != null)
			return false;
	} else if (!corso.equals(other.corso))
		return false;
	if (facolta == null) {
		if (other.facolta != null)
			return false;
	} else if (!facolta.equals(other.facolta))
		return false;
	if (id != other.id)
		return false;
	if (professore == null) {
		if (other.professore != null)
			return false;
	} else if (!professore.equals(other.professore))
		return false;
	if (studente == null) {
		if (other.studente != null)
			return false;
	} else if (!studente.equals(other.studente))
		return false;
	if (votoEsame != other.votoEsame)
		return false;
	return true;
}

@Override
public String toString() {
	return "Esame [id=" + id + ", corso=" + corso + ", facolta=" + facolta + ", studente=" + studente + ", professore="
			+ professore + ", votoEsame=" + votoEsame + "]";
}

public Esame(int id, Corso corso, Facolta facolta, Studente studente, Professore professore, int votoEsame) {
	super();
	this.id = id;
	this.corso = corso;
	this.facolta = facolta;
	this.studente = studente;
	this.professore = professore;
	this.votoEsame = votoEsame;
}

public Esame() {
	super();
}

}
