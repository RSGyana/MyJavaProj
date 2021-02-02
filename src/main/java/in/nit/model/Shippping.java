package in.nit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="shippingtab")
public class Shippping {
	@Id
	@GeneratedValue
	@Column(name="sid")
	private Integer shippId;
	@Column(name="scode")
	private String shippCode;
	@Column(name="srefnum")
	private Integer refNum;
	@Column(name="crefnum")
	private Integer courierRefNum;
	@Column(name="dtls")
	private String contDtls;
	@Column(name="ocode")
	private String saleOrderCode;
	@Column(name="snote")
	private String note;
	@Column(name="billadrs")
	private String billToAdrs;
	@Column(name="shipadrs")
	private String shipToAdrss;
	
	public Shippping() {
		super();
		
	}


	public Shippping(Integer shippId) {
		super();
		shippId = shippId;
		
	}

	public Integer getShippId() {
		return shippId;
	}

	public void setShippId(Integer shippId) {
		shippId = shippId;
	}

	public String getShippCode() {
		return shippCode;
	}

	public void setShippCode(String shippCode) {
		shippCode = shippCode;
	}

	public Integer getRefNum() {
		return refNum;
	}

	public void setRefNum(Integer refNum) {
		this.refNum = refNum;
	}

	public String getContDtls() {
		return contDtls;
	}

	public void setContDtls(String contDtls) {
		this.contDtls = contDtls;
	}

	public String getSaleOrderCode() {
		return saleOrderCode;
	}

	public void setSaleOrderCode(String saleOrderCode) {
		saleOrderCode = saleOrderCode;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getBillToAdrs() {
		return billToAdrs;
	}

	public void setBillToAdrs(String billToAdrs) {
		this.billToAdrs = billToAdrs;
	}

	public String getShipToAdrss() {
		return shipToAdrss;
	}

	public void setShipToAdrss(String shipToAdrss) {
		shipToAdrss = shipToAdrss;
	}


	public Integer getCourierRefNum() {
		return courierRefNum;
	}


	public void setCourierRefNum(Integer courierRefNum) {
		this.courierRefNum = courierRefNum;
	}


	@Override
	public String toString() {
		return "Shippping [ShippId=" + shippId + ", ShippCode=" + shippCode + ", refNum=" + refNum + ", courierRefNum="
				+ courierRefNum + ", contDtls=" + contDtls + ", SaleOrderCode=" + saleOrderCode + ", note=" + note
				+ ", billToAdrs=" + billToAdrs + ", ShipToAdrss=" + shipToAdrss + "]";
	}
	
	}

