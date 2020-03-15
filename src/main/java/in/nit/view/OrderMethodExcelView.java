package in.nit.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import in.nit.model.OrderMethod;
import in.nit.model.SaleOrder;

public class OrderMethodExcelView extends AbstractXlsView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		//file name (TO DOWN DIRECTLY A PDF WE ARE USING  CONTENT DEPOSISION)
				response.addHeader("Content-Disposition","attachment;filename=ordermethod.xlsx");
				Sheet s=workbook.createSheet("ORDERMETHOD");
				setHeader(s);
				//read model data
				List<OrderMethod> list=(List<OrderMethod>) model.get("list");
				setBody(s,list);
				
				
			}
			private void setHeader(Sheet s) {
				Row r=s.createRow(0);
				r.createCell(0).setCellValue("ID");
				r.createCell(1).setCellValue("MODE");
				r.createCell(1).setCellValue("CODE");
				r.createCell(2).setCellValue("METHOD");
				r.createCell(3).setCellValue("ACCEPT");
				r.createCell(4).setCellValue("DESC");
				
			}
			private void setBody(Sheet s,List<OrderMethod> list) {
				int count =1;
				for(OrderMethod st:list) {
					Row r=s.createRow(count++);
					r.createCell(0).setCellValue(st.getOrderId());
					r.createCell(1).setCellValue(st.getOrderMode());
					r.createCell(2).setCellValue(st.getOrderCode());
					r.createCell(3).setCellValue(st.getOrderMethod());
					r.createCell(4).setCellValue(st.getOrderAccept().toString());
					r.createCell(6).setCellValue(st.getDesc());
					
				}
			}

		
		
	}


