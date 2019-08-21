package model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class PrenoPK implements Serializable {

	
	private static final long serialVersionUID = 1L;
	protected int studente_id;
	protected int data_appello_id;
	
	public PrenoPK(int studente_id, int data_appello_id) {
		super();
		this.studente_id = studente_id;
		this.data_appello_id = data_appello_id;
	}

	public PrenoPK() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getStudente_id() {
		return studente_id;
	}

	public void setStudente_id(int studente_id) {
		this.studente_id = studente_id;
	}

	

	public int getData_appello_id() {
		return data_appello_id;
	}

	public void setData_appello_id(int data_appello_id) {
		this.data_appello_id = data_appello_id;
	}

	@Override
	public String toString() {
		return "PrenoPK [studente_id=" + studente_id + ", data_appello_id=" + data_appello_id + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + data_appello_id;
		result = prime * result + studente_id;
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
		PrenoPK other = (PrenoPK) obj;
		if (data_appello_id != other.data_appello_id)
			return false;
		if (studente_id != other.studente_id)
			return false;
		return true;
	}
	
	
}
