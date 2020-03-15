package in.nit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="parttab")
public class Part {
@Id
@GeneratedValue
@Column(name="pid")
private Integer partId;
@Column(name="pcode")
private String partCode;
@Column(name="pwidth")
private String width;
@Column(name="plength")
private String length;
@Column(name="pheight")
private String height;

@Column(name="pbasecost")
private double baseCost;
@Column(name="pbasecurrency")
private String baseCurrency;

@ManyToOne   //module integreation part(p) with uom(c)
@JoinColumn(name="uomIdFk")
private Uom uomOb;
           //module integreation part(p) with ordermethod(c)
@ManyToOne
@JoinColumn(name="orderIdFk")
private OrderMethod omOb;



@Column(name="pdesc")
private String partDesc;

public Part() {
	super();
}

public Part(Integer partId) {
	super();
	this.partId = partId;
}

public Integer getPartId() {
	return partId;
}

public void setPartId(Integer partId) {
	this.partId = partId;
}

public String getPartCode() {
	return partCode;
}

public void setPartCode(String partCode) {
	this.partCode = partCode;
}

public String getWidth() {
	return width;
}

public void setWidth(String width) {
	this.width = width;
}

public String getLength() {
	return length;
}

public void setLength(String length) {
	this.length = length;
}

public String getHeight() {
	return height;
}

public void setHeight(String height) {
	this.height = height;
}

public double getBaseCost() {
	return baseCost;
}

public void setBaseCost(double baseCost) {
	this.baseCost = baseCost;
}

public String getBaseCurrency() {
	return baseCurrency;
}

public void setBaseCurrency(String baseCurrency) {
	this.baseCurrency = baseCurrency;
}

public Uom getUomOb() {
	return uomOb;
}

public void setUomOb(Uom uomOb) {
	this.uomOb = uomOb;
}

public OrderMethod getOmOb() {
	return omOb;
}

public void setOmOb(OrderMethod omOb) {
	this.omOb = omOb;
}

public String getPartDesc() {
	return partDesc;
}

public void setPartDesc(String partDesc) {
	this.partDesc = partDesc;
}

@Override
public String toString() {
	return "Part [partId=" + partId + ", partCode=" + partCode + ", width=" + width + ", length=" + length + ", height="
			+ height + ", baseCost=" + baseCost + ", baseCurrency=" + baseCurrency + ", uomOb=" + uomOb + ", omOb="
			+ omOb + ", partDesc=" + partDesc + "]";
}



}
