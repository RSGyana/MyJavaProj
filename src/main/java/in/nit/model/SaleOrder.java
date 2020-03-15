package in.nit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sotab")
public class SaleOrder {
	@Id
	@GeneratedValue
	@Column(name="soid")
	private Integer sordId;
	@Column(name="socode")
	private String orderCode;
	@Column(name="sorefnum")
	private long refNUm;
	@Column(name="sostkmode")
	private String stockMode;
	@Column(name="sostksource")
	private String stkSource;
	@Column(name="sodefstatus")
	private String defStatus;
	@Column(name="sodesc")
	private String soDesc;
	
	public SaleOrder() {
		super();
	}

	
	public SaleOrder(Integer sordId) {
		super();
		this.sordId = sordId;
	}

	public Integer getSordId() {
		return sordId;
	}

	public void setSordId(Integer sordId) {
		this.sordId = sordId;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public long getRefNUm() {
		return refNUm;
	}

	public void setRefNUm(long refNUm) {
		this.refNUm = refNUm;
	}

	public String getStockMode() {
		return stockMode;
	}



	public void setStockMode(String stockMode) {
		this.stockMode = stockMode;
	}


	public String getStkSource() {
		return stkSource;
	}

	public void setStkSource(String stkSource) {
		this.stkSource = stkSource;
	}

	public String getDefStatus() {
		return defStatus;
	}

	public void setDefStatus(String defStatus) {
		this.defStatus = defStatus;
	}

	public String getSoDesc() {
		return soDesc;
	}

	public void setSoDesc(String soDesc) {
		this.soDesc = soDesc;
	}


	@Override
	public String toString() {
		return "SaleOrder [sordId=" + sordId + ", orderCode=" + orderCode + ", refNUm=" + refNUm + ", StockMode="
				+ stockMode + ", stkSource=" + stkSource + ", defStatus=" + defStatus + ", soDesc=" + soDesc + "]";
	}

	
	
	
}
