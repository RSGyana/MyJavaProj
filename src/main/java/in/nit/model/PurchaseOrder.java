package in.nit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="potab")
public class PurchaseOrder {
	@Id
	@GeneratedValue
	
	@Column(name="poid")
	private Integer pordId;
	@Column(name="pocode")
	private String pordCode;
	@Column(name="porefnum")
	private long refNum;
	@Column(name="poquacheck")
	private String quaCheck;
	@Column(name="podefstatus")
	private String defStatus;
	@Column(name="podesc")
	private String pordDesc;
	
	public PurchaseOrder() {
		super();
	}

	public PurchaseOrder(Integer pordId) {
		super();
		this.pordId = pordId;
	}

	public Integer getPordId() {
		return pordId;
	}

	public void setPordId(Integer pordId) {
		this.pordId = pordId;
	}

	public String getPordCode() {
		return pordCode;
	}

	public void setPordCode(String pordCode) {
		this.pordCode = pordCode;
	}

	public long getRefNum() {
		return refNum;
	}

	public void setRefNum(long refNum) {
		this.refNum = refNum;
	}

	public String getQuaCheck() {
		return quaCheck;
	}

	public void setQuaCheck(String quaCheck) {
		this.quaCheck = quaCheck;
	}

	public String getDefStatus() {
		return defStatus;
	}

	public void setDefStatus(String defStatus) {
		this.defStatus = defStatus;
	}

	public String getPordDesc() {
		return pordDesc;
	}

	public void setPordDesc(String pordDesc) {
		this.pordDesc = pordDesc;
	}

	@Override
	public String toString() {
		return "PurchaseOrder [pordId=" + pordId + ", pordCode=" + pordCode + ", refNum=" + refNum + ", quaCheck="
				+ quaCheck + ", defStatus=" + defStatus + ", pordDesc=" + pordDesc + "]";
	}
	

}
