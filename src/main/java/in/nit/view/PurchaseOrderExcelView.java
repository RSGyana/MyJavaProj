package in.nit.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import in.nit.model.PurchaseOrder;
import in.nit.model.SaleOrder;

public class PurchaseOrderExcelView extends AbstractXlsxView{

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {


		//file name (TO DOWN DIRECTLY A PDF WE ARE USING  CONTENT DEPOSISION)
		response.addHeader("Content-Disposition","attachment;filename=purchaseorder.xlsx");
		Sheet s=workbook.createSheet("PURCHASE ORDER");
		setHeader(s);
		//read model data
		List<PurchaseOrder> list=(List<PurchaseOrder>) model.get("list");
		setBody(s,list);


	}
	private void setHeader(Sheet s) {
		Row r=s.createRow(0);
		r.createCell(0).setCellValue("ID");
		r.createCell(1).setCellValue("CODE");
		r.createCell(2).setCellValue("REFNUM");
		r.createCell(3).setCellValue("QUALCHECK");
		r.createCell(5).setCellValue("DEFSTATUS");
		r.createCell(6).setCellValue("NOTE");

	}
	private void setBody(Sheet s,List<PurchaseOrder> list) {
		int count =1;
		for(PurchaseOrder st:list) {
			Row r=s.createRow(count++);
			r.createCell(0).setCellValue(st.getPordId());
			r.createCell(1).setCellValue(st.getPordCode());
			r.createCell(2).setCellValue(st.getRefNum());
			r.createCell(3).setCellValue(st.getQuaCheck());
			r.createCell(5).setCellValue(st.getDefStatus());
			r.createCell(6).setCellValue(st.getPordDesc());

		}




	}

}
