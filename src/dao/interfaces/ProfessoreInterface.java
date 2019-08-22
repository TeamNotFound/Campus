package dao.interfaces;

import java.util.ArrayList;

import model.Professore;

public interface ProfessoreInterface extends CRUDInterface<Professore>  {
	public void inserimento(Professore p);
	public Professore getById(int id);
	public ArrayList<Professore> getAll();
	public void update(Professore element);
	public void remove(Professore element);
}
