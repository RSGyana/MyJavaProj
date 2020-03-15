package in.nit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usertab")
public class WhUserType {
	@Id
	@GeneratedValue
	@Column(name="uuid")
	private Integer userId;
	@Column(name="uucode")
	private String userCode;
	@Column(name="uufor")
	private String userFor;
	@Column(name="uuemail")
	private String  userEmail;
	@Column(name="uucontact")
	private String userContact;
	@Column(name="uuidtype")
	private String userIdType;
	@Column(name="uuotherid")
	private String userOtherId;
	@Column(name="uuidnum")
	private long userIdNum;
	@Column(name="uutype")
	private String userType;

	public WhUserType() {
		super();
	}

	public WhUserType(Integer userId) {
		super();
		this.userId = userId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getUserFor() {
		return userFor;
	}

	public void setUserFor(String userFor) {
		this.userFor = userFor;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserContact() {
		return userContact;
	}

	public void setUserContact(String userContact) {
		this.userContact = userContact;
	}

	public String getUserIdType() {
		return userIdType;
	}

	public void setUserIdType(String userIdType) {
		this.userIdType = userIdType;
	}

	public String getUserOtherId() {
		return userOtherId;
	}

	public void setUserOtherId(String userOtherId) {
		this.userOtherId = userOtherId;
	}

	public long getUserIdNum() {
		return userIdNum;
	}

	public void setUserIdNum(long userIdNum) {
		this.userIdNum = userIdNum;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userCode=" + userCode + ", userFor=" + userFor + ", userEmail=" + userEmail
				+ ", userContact=" + userContact + ", userIdType=" + userIdType + ", userOtherId=" + userOtherId
				+ ", userIdNum=" + userIdNum + ", userType=" + userType + "]";
	}

	




}
