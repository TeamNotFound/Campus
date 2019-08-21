package model;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table (name="professori")
public class Professore extends Utente{
	@Column()
	private boolean rettore;
	
	@OneToMany(mappedBy = "professore")
	private Set<ProfessoriCorsi> professoriCorsi;
	
	@OneToMany(mappedBy="professore")
	private Set<DataAppello> appelli;
	
	
	
	public Professore() {
		super();
		rettore=false;
	}
	
	
	
}
