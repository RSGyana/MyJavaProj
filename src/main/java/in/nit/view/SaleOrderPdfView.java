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

import in.nit.model.SaleOrder;
import in.nit.model.ShipmentType;
import in.nit.model.WhUserType;

public class SaleOrderPdfView extends AbstractPdfView {

	@Override
	public  void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		
		//DOWNLOAD A  FILE
		response.addHeader("Content-Disposision","attachment;filename=saleorder.pdf");
		
		//CREATE ONE ELEMENT
		Paragraph p=new Paragraph("WELCOME TO SALE ORDER PAGE");
		
		//ADD ELEMENT TO DOCUMENT
		document.add(p);
		
		//READ DATA FROM MODEL
		List<SaleOrder> list=(List<SaleOrder>) model.get("list");
		
		//CREATE TABLE WITH NO OF COLUMNS
		
		PdfPTable  t=new PdfPTable(7);
		t.addCell("ID");
		t.addCell("CODE");
		t.addCell("REFNUM");
		t.addCell("STOCKMODE");
		t.addCell("STOCKSOURCE");
		t.addCell("DEFSTATUS");
		t.addCell("NOTE");
		
		//ADDING DATA TO TABLE
		for(SaleOrder st:list) {
			System.out.println(st);
			t.addCell(st.getSordId().toString());
			t.addCell(st.getOrderCode().toString());
		    t.addCell(String.valueOf(st.getRefNUm()));
			t.addCell(st.getStockMode().toString());
			t.addCell(st.getStkSource().toString());
			t.addCell(st.getDefStatus().toString());
			t.addCell(st.getSoDesc().toString());
		
		}
		//ADD TABLE TO DOCUMENT
		document.add(t);
		//PRINT DATE AND TIME
		document.add(new Paragraph(new Date().toString()));
	}

}
