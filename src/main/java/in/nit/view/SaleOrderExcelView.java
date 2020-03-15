package in.nit.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import in.nit.model.SaleOrder;


public class SaleOrderExcelView extends AbstractXlsxView {


	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		//file name (TO DOWN DIRECTLY A PDF WE ARE USING  CONTENT DEPOSISION)
		response.addHeader("Content-Disposition","attachment;filename=saleorder.xlsx");
		Sheet s=workbook.createSheet("SALEORDER");
		setHeader(s);
		//read model data
		List<SaleOrder> list=(List<SaleOrder>) model.get("list");
		setBody(s,list);
		
		
	}
	private void setHeader(Sheet s) {
		Row r=s.createRow(0);
		r.createCell(0).setCellValue("ID");
		r.createCell(1).setCellValue("CODE");
		r.createCell(2).setCellValue("REFNUM");
		r.createCell(3).setCellValue("STOCKMODE");
		r.createCell(4).setCellValue("STOCKSOURCE");
		r.createCell(5).setCellValue("DEFSTATUS");
		r.createCell(6).setCellValue("NOTE");
		
	}
	private void setBody(Sheet s,List<SaleOrder> list) {
		int count =1;
		for(SaleOrder st:list) {
			Row r=s.createRow(count++);
			r.createCell(0).setCellValue(st.getSordId());
			r.createCell(1).setCellValue(st.getOrderCode());
			r.createCell(2).setCellValue(st.getRefNUm());
			r.createCell(3).setCellValue(st.getStockMode());
			r.createCell(4).setCellValue(st.getStkSource());
			r.createCell(5).setCellValue(st.getDefStatus());
			r.createCell(6).setCellValue(st.getSoDesc());
			
		}
	}
		
		
	}


