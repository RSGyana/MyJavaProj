package in.nit.service;

import java.util.List;

import in.nit.model.Part;

public interface IPartservice {
	
	Integer savePart(Part ob);
	List<Part> getAllPart();
	  void deletePart(Integer id);
	  void updatePart(Part ob);
	  Part getOnePart(Integer id);

}
