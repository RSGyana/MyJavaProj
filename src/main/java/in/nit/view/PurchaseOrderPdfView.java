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

import in.nit.model.PurchaseOrder;
import in.nit.model.SaleOrder;

public class PurchaseOrderPdfView extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		//DOWNLOAD A  FILE
				response.addHeader("Content-Disposision","attachment;filename=purchaseorder.pdf");
				
				//CREATE ONE ELEMENT
				Paragraph p=new Paragraph("WELCOME TO SALE ORDER PAGE");
				
				//ADD ELEMENT TO DOCUMENT
				document.add(p);
				
				//READ DATA FROM MODEL
				List<PurchaseOrder> list=(List<PurchaseOrder>) model.get("list");
				
				//CREATE TABLE WITH NO OF COLUMNS
				
				PdfPTable  t=new PdfPTable(7);
				t.addCell("ID");
				t.addCell("CODE");
				t.addCell("REFNUM");
				t.addCell("QUALCHECK");
				t.addCell("DEFSTATUS");
				t.addCell("NOTE");
				
				//ADDING DATA TO TABLE
				for(PurchaseOrder st:list) {
					System.out.println(st);
					t.addCell(st.getPordId().toString());
					t.addCell(st.getPordCode().toString());
				  
					t.addCell(String.valueOf(st.getRefNum()));
					t.addCell(st.getQuaCheck().toString());
					t.addCell(st.getDefStatus().toString());
					t.addCell(st.getPordDesc().toString());
				
				}
				//ADD TABLE TO DOCUMENT
				document.add(t);
				//PRINT DATE AND TIME
				document.add(new Paragraph(new Date().toString()));
			}

		
	

}
