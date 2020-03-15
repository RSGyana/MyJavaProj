package in.nit.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import in.nit.model.Uom;
import in.nit.model.WhUserType;

public class UomPdfView  extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		//DOWNLOAD A  FILE
		response.addHeader("Content-Disposision","attachment;filename=user.pdf");
		
		//CREATE ONE ELEMENT
		Paragraph p=new Paragraph("WELCOME TO USER PAGE");
		
		//ADD ELEMENT TO DOCUMENT
		document.add(p);
		
		//READ DATA FROM MODEL
		List<Uom> list=(List<Uom>) model.get("list");
		
		//CREATE TABLE WITH NO OF COLUMNS
		
		PdfPTable  t=new PdfPTable(4);
		t.addCell("ID");
		t.addCell("TYPE");
		t.addCell("MODEL");
		t.addCell("DESC");
		
		//ADDING DATA TO TABLE
		for(Uom st:list) {
			System.out.println(st);
			t.addCell(st.getUomId().toString());
			t.addCell(st.getUomType().toString());
			t.addCell(st.getUomModel().toString());
		    
			t.addCell(st.getDesc().toString());
		
		}
		//ADD TABLE TO DOCUMENT
		document.add(t);
		//PRINT DATE AND TIME
		document.add(new Paragraph(new Date().toString()));





}

		
	

}
