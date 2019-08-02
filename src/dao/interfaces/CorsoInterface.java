package dao.interfaces;

import java.util.ArrayList;

import model.Corso;

public interface CorsoInterface extends CRUDInterface<Corso> {
	public ArrayList<Corso> getAllWithFacolta();
	public Corso getByIdWithFacolta(int id);
}
