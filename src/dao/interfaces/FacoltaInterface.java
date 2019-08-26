package dao.interfaces;

import java.util.ArrayList;

import model.Facolta;

public interface FacoltaInterface extends CRUDInterface<Facolta> {
	public ArrayList<Facolta> getAllWithCorsi();
	public Facolta getByIdWithCorsi(int id);
	public Facolta getByIdWithCorsiAndCattedre(int id);
}
