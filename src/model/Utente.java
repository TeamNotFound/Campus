package model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Utente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String nome;
	
	@Column
	private String cognome;
	
	@Column
	private Date dataNascita;
	
	@Column
	private String luogoNascita;
	
	@Column
	private String codiceFiscale;
	
    @Column
    private boolean uomo;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    private Account account;
    
    
    
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public Date getDataNascita() {
		return dataNascita;
	}
	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}
	public String getLuogoNascita() {
		return luogoNascita;
	}
	public void setLuogoNascita(String luogoNascita) {
		this.luogoNascita = luogoNascita;
	}
	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}
	public boolean isUomo() {
		return uomo;
	}
	public void setUomo(boolean uomo) {
		this.uomo = uomo;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codiceFiscale == null) ? 0 : codiceFiscale.hashCode());
		result = prime * result + ((cognome == null) ? 0 : cognome.hashCode());
		result = prime * result + ((dataNascita == null) ? 0 : dataNascita.hashCode());
		result = prime * result + id;
		result = prime * result + ((luogoNascita == null) ? 0 : luogoNascita.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + (uomo ? 1231 : 1237);
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
		Utente other = (Utente) obj;
		if (codiceFiscale == null) {
			if (other.codiceFiscale != null)
				return false;
		} else if (!codiceFiscale.equals(other.codiceFiscale))
			return false;
		if (cognome == null) {
			if (other.cognome != null)
				return false;
		} else if (!cognome.equals(other.cognome))
			return false;
		if (dataNascita == null) {
			if (other.dataNascita != null)
				return false;
		} else if (!dataNascita.equals(other.dataNascita))
			return false;
		if (id != other.id)
			return false;
		if (luogoNascita == null) {
			if (other.luogoNascita != null)
				return false;
		} else if (!luogoNascita.equals(other.luogoNascita))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (uomo != other.uomo)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Utente [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", dataNascita=" + dataNascita
				+ ", luogoNascita=" + luogoNascita + ", codiceFiscale=" + codiceFiscale + ", uomo=" + uomo + "]";
	}
	public Utente(int id, String nome, String cognome, Date dataNascita, String luogoNascita, String codiceFiscale,
			boolean uomo) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
		this.luogoNascita = luogoNascita;
		this.codiceFiscale = codiceFiscale;
		this.uomo = uomo;
	}
	public Utente() {
		super();
	}
    
    
	
	
	
	
	
	
	
	
	

}
