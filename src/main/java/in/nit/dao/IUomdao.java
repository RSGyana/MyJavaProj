package in.nit.dao;

import java.util.List;

import in.nit.model.Uom;

public interface IUomdao {
	
	Integer saveUom(Uom u);
	List<Uom> loadallIUom();
	void deleteUom(Integer id);
	Uom getOneUom(Integer id);
	void updateUom(Uom u);
	List<Object[]> getUomModeCount();
	List<Object[]> getUomIdAndUomModel();
	


}
