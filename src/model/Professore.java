package model;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table (name="professori")
public class Professore extends Utente{
	@Column()
	private boolean rettore;
	
	@Column(name="titoli_di_studio")
	private String titoliDiStudio;
	
	@OneToMany(mappedBy = "professore")
	private Set<ProfessoriCorsi> professoriCorsi;
	
	@OneToMany(mappedBy="professore")
	private Set<DataAppello> appelli;
	
	public String getTitoliDiStudio() {
		return titoliDiStudio;
	}

	public void setTitoliDiStudio(String titoliDiStudio) {
		this.titoliDiStudio = titoliDiStudio;
	}

	public boolean isRettore() {
		return rettore;
	}

	public void setRettore(boolean rettore) {
		this.rettore = rettore;
	}

	public Set<ProfessoriCorsi> getProfessoriCorsi() {
		return professoriCorsi;
	}

	public void setProfessoriCorsi(Set<ProfessoriCorsi> professoriCorsi) {
		this.professoriCorsi = professoriCorsi;
	}

	public Set<DataAppello> getAppelli() {
		return appelli;
	}

	public void setAppelli(Set<DataAppello> appelli) {
		this.appelli = appelli;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (rettore ? 1231 : 1237);
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
		Professore other = (Professore) obj;
		if (rettore != other.rettore)
			return false;
		if (titoliDiStudio == null) {
			if (other.titoliDiStudio != null)
				return false;
		} else if (!titoliDiStudio.equals(other.titoliDiStudio))
			return false;
		return true;
	}

	public Professore() {
		super();
		rettore=false;
	}

	@Override
	public String toString() {
		return super.toString() + "Professore [rettore=" + rettore + ", titoliDiStudio=" + titoliDiStudio + "]";
	}
	
	
}
