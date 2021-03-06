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

import in.nit.model.ShipmentType;

public class ShipmentTypePdfView extends AbstractPdfView {

	@Override
	public  void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		
		//DOWNLOAD A  FILE
		response.addHeader("Content-Disposision","attachment;filename=shipment.pdf");
		
		//CREATE ONE ELEMENT
		Paragraph p=new Paragraph("WELCOME TO SHIPMENT TYPE PAGE");
		
		//ADD ELEMENT TO DOCUMENT
		document.add(p);
		
		//READ DATA FROM MODEL
		List<ShipmentType> list=(List<ShipmentType>) model.get("list");
		
		//CREATE TABLE WITH NO OF COLUMNS
		
		PdfPTable  t=new PdfPTable(6);
		t.addCell("ID");
		t.addCell("MODE");
		t.addCell("CODE");
		t.addCell("ENABLE");
		t.addCell("GRADE");
		t.addCell("NOTE");
		
		//ADDING DATA TO TABLE
		for(ShipmentType st:list) {
			t.addCell(st.getShipId().toString());
			t.addCell(st.getShipMode().toString());
			t.addCell(st.getShipCode().toString());
			t.addCell(st.getEnbShip().toString());
			t.addCell(st.getShipGrade().toString());
			t.addCell(st.getShipDesc().toString());
		
		}
		//ADD TABLE TO DOCUMENT
		document.add(t);
		//PRINT DATE AND TIME
		document.add(new Paragraph(new Date().toString()));
	}

}
