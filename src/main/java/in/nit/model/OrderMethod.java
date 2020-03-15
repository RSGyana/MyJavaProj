package in.nit.model;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

@Entity
@Table(name="ordertab")
public class OrderMethod {
	@Id
	@GeneratedValue(generator = "oidgen")
	
	@Column(name="oid")
	private Integer orderId;
	@Column(name="omode")
	private String orderMode;
	@Column(name="ocode")
	private String orderCode;
	@Column(name="omethod")
	 private String orderMethod;
	//order Accept var is check box var ,so we should take collection type var,bcoz may we select multiple values
	@ElementCollection(fetch=FetchType.EAGER )
	@CollectionTable(name="omaccepttab",joinColumns=@JoinColumn(name="omid"))
	@OrderColumn(name="pos")
	@Column(name="oaccept")
	 private List<String> orderAccept;
	@Column(name="odesc")
	 private String desc;
	 
	 //default  const
	public OrderMethod() {
		super();
	}
	
	//one param const
	public OrderMethod(Integer orderId) {
		super();
		this.orderId = orderId;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getOrderMode() {
		return orderMode;
	}

	public void setOrderMode(String orderMode) {
		this.orderMode = orderMode;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public String getOrderMethod() {
		return orderMethod;
	}

	public void setOrderMethod(String orderMethod) {
		this.orderMethod = orderMethod;
	}

	public List<String> getOrderAccept() {
		return orderAccept;
	}

	public void setOrderAccept(List<String> orderAccept) {
		this.orderAccept = orderAccept;
	}

	public String getDesc() {
		return desc;
	}

	@Override
	public String toString() {
		return "OrderMethod [orderId=" + orderId + ", orderMode=" + orderMode + ", orderCode=" + orderCode
				+ ", orderMethod=" + orderMethod + ", orderAccept=" + orderAccept + ", desc=" + desc + "]";
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	 
	
	
	

}
