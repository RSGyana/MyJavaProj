package in.nit.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import in.nit.model.Part;

public class PartExcelView extends AbstractXlsView{

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		
		//file name (TO DOWN DIRECTLY A PDF WE ARE USING  CONTENT DEPOSISION)
				response.addHeader("Content-Disposition","attachment;filename=part.xlsx");
				Sheet s=workbook.createSheet("PART");
				setHeader(s);
				//read model data
				List<Part> list=(List<Part>) model.get("list");
				setBody(s,list);
				
				
			}
			private void setHeader(Sheet s) {
				Row r=s.createRow(0);
				r.createCell(0).setCellValue("ID");
				r.createCell(1).setCellValue("CODE");
				r.createCell(2).setCellValue("WIDTH");
				r.createCell(3).setCellValue("LENGTH");
				r.createCell(4).setCellValue("HEIGHT");
				r.createCell(5).setCellValue("BASECOST");
				r.createCell(6).setCellValue("BASECURRENCY");
				r.createCell(7).setCellValue("MODEL");
				r.createCell(8).setCellValue("ORDERMETHOD");
				r.createCell(9).setCellValue("NOTE");
				
			}
			private void setBody(Sheet s,List<Part> list) {
				int count =1;
				for(Part st:list) {
					Row r=s.createRow(count++);
					r.createCell(0).setCellValue(st.getPartId());
					r.createCell(1).setCellValue(st.getPartCode());
					r.createCell(2).setCellValue(st.getWidth());
					r.createCell(3).setCellValue(st.getLength());
					r.createCell(4).setCellValue(st.getHeight());
					r.createCell(5).setCellValue(st.getBaseCost());
					r.createCell(6).setCellValue(st.getBaseCurrency());
					r.createCell(7).setCellValue(st.getUomOb().getUomModel());
					r.createCell(8).setCellValue(st.getOmOb().getOrderCode());
					r.createCell(9).setCellValue(st.getPartDesc());
					
				}
			}

		
	

}
