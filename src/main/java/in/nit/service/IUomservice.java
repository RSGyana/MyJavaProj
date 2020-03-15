package in.nit.service;

import java.util.List;

import in.nit.model.Uom;

public interface IUomservice {
	
	Integer saveUom(Uom u);
	List<Uom> loadallIUom();
	void deleteUom(Integer id);
	Uom getOneUom(Integer id);
	void updateUom(Uom u);
	List<Object[]> getUomModeCount();
	List<Object[]> getUomIdAndUomModel();

}
