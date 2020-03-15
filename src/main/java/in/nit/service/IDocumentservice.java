package in.nit.service;

import java.util.List;

import in.nit.model.Document;

public interface IDocumentservice {
	Integer saveDocument(Document doc);
	public List<Object[]>getFileIdAndNames();
	public Document getOneDocument(Integer id);


}
