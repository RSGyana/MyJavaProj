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

import in.nit.model.OrderMethod;
import in.nit.model.PurchaseOrder;

public class OrderMethodPdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//DOWNLOAD A  FILE
				response.addHeader("Content-Disposision","attachment;filename=ordermethod.pdf");
				
				//CREATE ONE ELEMENT
				Paragraph p=new Paragraph("WELCOME TO  ORDER METHOD PAGE");
				
				//ADD ELEMENT TO DOCUMENT
				document.add(p);
				
				//READ DATA FROM MODEL
				List<OrderMethod> list=(List<OrderMethod>) model.get("list");
				
				//CREATE TABLE WITH NO OF COLUMNS
				
				PdfPTable  t=new PdfPTable(6);
				t.addCell("ID");
				t.addCell("MODE");
				t.addCell("CODE");
				t.addCell("METHOD");
				t.addCell("ACCEPT");
				t.addCell("DESC ");
				
				//ADDING DATA TO TABLE
				for(OrderMethod st:list) {
					System.out.println(st);
					t.addCell(st.getOrderId().toString());
					t.addCell(st.getOrderMode().toString());
					t.addCell(st.getOrderCode().toString());
					t.addCell(st.getOrderMethod().toString());
					t.addCell(st.getOrderAccept().toString());
					t.addCell(st.getDesc().toString());
				
				}
				//ADD TABLE TO DOCUMENT
				document.add(t);
				//PRINT DATE AND TIME
				document.add(new Paragraph(new Date().toString()));
			}

		
		

}
