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

import in.nit.model.Part;
import in.nit.model.SaleOrder;

public class PartPdfView extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
	
		
		
		//DOWNLOAD A  FILE
				response.addHeader("Content-Disposision","attachment;filename=part.pdf");
				
				//CREATE ONE ELEMENT
				Paragraph p=new Paragraph("WELCOME TO part PAGE");
				
				//ADD ELEMENT TO DOCUMENT
				document.add(p);
				
				//READ DATA FROM MODEL
				List<Part> list=(List<Part>) model.get("list");
				
				//CREATE TABLE WITH NO OF COLUMNS
				
				PdfPTable  t=new PdfPTable(11);
				t.addCell("ID");
				t.addCell("CODE");
				t.addCell("WIDTH");
				t.addCell("LENGTH");
				t.addCell("HEIGHT");
				t.addCell("BASECOST");
				t.addCell("BASECURRENCY");
				t.addCell("MODEL");
				t.addCell("ORDERMETHOD");
				t.addCell("NOTE");
				
				//ADDING DATA TO TABLE
				for(Part st:list) {
					System.out.println(st);
					t.addCell(st.getPartId().toString());
					t.addCell(st.getPartCode().toString());
				    t.addCell(st.getWidth().toString());
					t.addCell(st.getLength().toString());
					t.addCell(st.getHeight().toString());
					t.addCell(String.valueOf(st.getBaseCost()));
					t.addCell(st.getBaseCurrency().toString());
					t.addCell(st.getUomOb().getUomModel());						
					t.addCell(st.getOmOb().getOrderCode());						
					t.addCell(st.getPartDesc().toString());
				
				}
				//ADD TABLE TO DOCUMENT
				document.add(t);
				//PRINT DATE AND TIME
				document.add(new Paragraph(new Date().toString()));
			}

		
	
}
