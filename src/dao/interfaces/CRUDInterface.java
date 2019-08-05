package dao.interfaces;

import java.util.ArrayList;

public interface CRUDInterface<T> {
	public void inserimento(T element);
	public T getById(int id);
	public ArrayList<T> getAll();
	public void update(T element);
	public void remove(T element);
}
