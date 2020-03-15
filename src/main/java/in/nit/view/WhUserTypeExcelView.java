package in.nit.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import in.nit.model.SaleOrder;
import in.nit.model.WhUserType;

public class WhUserTypeExcelView extends AbstractXlsView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		
		
		//file name (TO DOWN DIRECTLY A PDF WE ARE USING  CONTENT DEPOSISION)
				response.addHeader("Content-Disposition","attachment;filename=user.xlsx");
				Sheet s=workbook.createSheet("USER");
				setHeader(s);
				//read model data
				List<WhUserType> list=(List<WhUserType>) model.get("list");
				setBody(s,list);
				
				
			}
			private void setHeader(Sheet s) {
				Row r=s.createRow(0);
				r.createCell(0).setCellValue("ID");
				r.createCell(1).setCellValue("USERTYPE");
				r.createCell(2).setCellValue("USERCODE");
				r.createCell(3).setCellValue("USERFOR");
				r.createCell(4).setCellValue("USEREMAIL");
				r.createCell(5).setCellValue("USERCONTACT");
				r.createCell(6).setCellValue("USERIDTYPE");
				r.createCell(6).setCellValue("OTHERID");
				r.createCell(6).setCellValue("IDNUMBER");
				
			}
			private void setBody(Sheet s,List<WhUserType> list) {
				int count =1;
				for(WhUserType st:list) {
					Row r=s.createRow(count++);
					r.createCell(0).setCellValue(st.getUserId());
					r.createCell(0).setCellValue(st.getUserType());
					r.createCell(1).setCellValue(st.getUserCode());
					r.createCell(2).setCellValue(st.getUserFor());
					r.createCell(3).setCellValue(st.getUserEmail());
					r.createCell(4).setCellValue(st.getUserContact());
					r.createCell(5).setCellValue(st.getUserIdType());
					r.createCell(6).setCellValue(st.getUserOtherId());
					r.createCell(6).setCellValue(st.getUserIdNum());
					
				}
			}
				

		
		
		
	

}
