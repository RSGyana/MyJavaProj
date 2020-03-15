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


import in.nit.model.WhUserType;

public class WhUserTypePdfView extends AbstractPdfView {

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
				List<WhUserType> list=(List<WhUserType>) model.get("list");
				
				//CREATE TABLE WITH NO OF COLUMNS
				
				PdfPTable  t=new PdfPTable(7);
				t.addCell("ID");
				t.addCell("USERTYPE");
				t.addCell("USERCODE");
				t.addCell("USERFOR");
				t.addCell("USEREMAIL");
				t.addCell("USERCONTACT");
				t.addCell("USERIDTYPE");
				t.addCell("OTHERID");
				t.addCell("IDNUMBER");
				
				//ADDING DATA TO TABLE
				for(WhUserType st:list) {
					System.out.println(st);
					t.addCell(st.getUserId().toString());
					t.addCell(st.getUserType().toString());
					t.addCell(st.getUserCode().toString());
				    
					t.addCell(st.getUserFor().toString());
					t.addCell(st.getUserEmail().toString());
					t.addCell(st.getUserContact().toString());
					t.addCell(st.getUserIdType().toString());
					t.addCell(st.getUserOtherId().toString());
					t.addCell(String.valueOf(st.getUserIdNum()));
				
				}
				//ADD TABLE TO DOCUMENT
				document.add(t);
				//PRINT DATE AND TIME
				document.add(new Paragraph(new Date().toString()));

		
		
		
		
	}

}
