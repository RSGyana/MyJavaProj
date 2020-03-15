package in.nit.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import in.nit.dao.IUomdao;
import in.nit.model.Uom;
@Repository
public class UomdaoImpl implements IUomdao {
	@Autowired
	private HibernateTemplate ht;

	
	public Integer saveUom(Uom u) {
		return  (Integer)ht.save(u);
		
	}

	@Override
	public List<Uom> loadallIUom() {
		List<Uom> list=ht.loadAll(Uom.class);
		return list;
	}

	@Override
	public void deleteUom(Integer id) {
   /* Uom u1=new Uom();
    u1.setUomId(id);;
     ht.delete(u1);*/
		ht.delete(new Uom(id));
	}

	@Override
	public Uom getOneUom(Integer id) {
		
		return ht.get(Uom.class,id);
	}

	@Override
	public void updateUom(Uom u) {
		ht.delete(u);
		
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<Object[]> getUomModeCount() {
		String hql="select uomType,count(uomType) "
			+ " from in.nit.model.Uom "
			+ " group by uomType ";
			return (List<Object[]>) ht.find(hql);
	}
	
	@Override
	public List<Object[]> getUomIdAndUomModel() {
		String hql="select uomId,uomModel from in.nit.model.Uom";
		List<Object[]> list=(List<Object[]>) ht.find(hql);
		return list;
	}

}
