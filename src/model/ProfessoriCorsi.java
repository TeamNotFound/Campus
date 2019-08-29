package model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="professori_corsi")
public class ProfessoriCorsi {
	@Embeddable
	private static class Id implements Serializable{
		private static final long serialVersionUID = 1L;


		private int professore_id;

		private int corso_id;

		private int facolta_id;

		public Id() {
			super();
		}

		public Id(int professore_id, int corso_id, int facolta_id) {
			super();
			this.professore_id = professore_id;
			this.corso_id = corso_id;
			this.facolta_id = facolta_id;
		}


		public int getProfessore_id() {
			return professore_id;
		}

		public void setProfessore_id(int professore_id) {
			this.professore_id = professore_id;
		}

		public int getCorso_id() {
			return corso_id;
		}

		public void setCorso_id(int corso_id) {
			this.corso_id = corso_id;
		}

		public int getFacolta_id() {
			return facolta_id;
		}

		public void setFacolta_id(int facolta_id) {
			this.facolta_id = facolta_id;
		}



		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + corso_id;
			result = prime * result + facolta_id;
			result = prime * result + professore_id;
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
			Id other = (Id) obj;
			if (corso_id != other.corso_id)
				return false;
			if (facolta_id != other.facolta_id)
				return false;
			if (professore_id != other.professore_id)
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Id [professore_id=" + professore_id + ", corso_id=" + corso_id + ", facolta_id=" + facolta_id + "]";
		}


	}
	@EmbeddedId
	private Id id = new Id();

	@ManyToOne
	@MapsId("professore_id")
	@JoinColumn(name = "professore_id")
	private Professore professore;

	@ManyToOne
	@MapsId("corso_id")
	@JoinColumn(name = "corso_id")
	private Corso corso;

	@ManyToOne
	@MapsId("facolta_id")
	@JoinColumn(name = "facolta_id")
	private Facolta facolta;

	public Id getId() {
		return id;
	}

	public void setId(Id id) {
		this.id = id;
	}

	public Professore getProfessore() {
		return professore;
	}

	public void setProfessore(Professore professore) {
		this.professore = professore;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((corso == null) ? 0 : corso.hashCode());
		result = prime * result + ((facolta == null) ? 0 : facolta.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((professore == null) ? 0 : professore.hashCode());
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
		ProfessoriCorsi other = (ProfessoriCorsi) obj;
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (professore == null) {
			if (other.professore != null)
				return false;
		} else if (!professore.equals(other.professore))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ProfessoriCorsi [id=" + id + ", professore=" + professore + ", corso=" + corso + ", facolta=" + facolta
				+ "]";
	}

	public ProfessoriCorsi(Id id, Professore professore, Corso corso, Facolta facolta) {
		super();
		this.id = id;
		this.professore = professore;
		this.corso = corso;
		this.facolta = facolta;
	}

	public ProfessoriCorsi() {
		super();
		// TODO Auto-generated constructor stub
	}


}
