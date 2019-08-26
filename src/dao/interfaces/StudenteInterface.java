package dao.interfaces;

import model.Studente;

public interface StudenteInterface extends CRUDInterface<Studente> {
public Studente getByIdWithPrenotazioni(int id);
}
