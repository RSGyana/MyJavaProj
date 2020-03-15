package in.nit.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="uomtab")
@Entity
public class Uom {
	@Id
	@GeneratedValue
	@Column(name="umid")
	private Integer uomId;
	@Column(name="utype")
	private String uomType;
	@Column(name="umodel")
	private String uomModel;
	@Column(name="udesc")
	private String desc;
	public Uom() {
		super();
	}
	
	public Uom(Integer uomId) {
		super();
		this.uomId = uomId;
	}

	public Integer getUomId() {
		return uomId;
	}
	public void setUomId(Integer uomId) {
		this.uomId = uomId;
	}
	public String getUomType() {
		return uomType;
	}
	public void setUomType(String uomType) {
		this.uomType = uomType;
	}
	public String getUomModel() {
		return uomModel;
	}
	public void setUomModel(String uomModel) {
		this.uomModel = uomModel;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	@Override
	public String toString() {
		return "Uom [uomId=" + uomId + ", uomType=" + uomType + ", uomModel=" + uomModel + ", desc=" + desc + "]";
	}
	
	

}
