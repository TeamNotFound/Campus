package dao.interfaces;

import java.util.List;

import model.DataAppello;


public interface DataAppelloInterfaces extends CRUDInterface<DataAppello>{

	List<DataAppello> getByFacoltaAndCorso(int idFacolta, int idCorso);

}
