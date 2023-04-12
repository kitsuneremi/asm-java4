package model;

import java.util.Date;
import javax.persistence.*;

@Entity
public class Sender {
	@Id
	private String id;
	private String senderName;
	private String senderMail;
	private String receivemail;
	private Date sendDate;
	
	public Sender() {
		super();
	}
	public Sender(String senderName, String senderMail, String receivemail, Date sendDate) {
		super();
		this.senderName = senderName;
		this.senderMail = senderMail;
		this.receivemail = receivemail;
		this.sendDate = sendDate;
	}
	public String getSenderName() {
		return senderName;
	}
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	public String getSenderMail() {
		return senderMail;
	}
	public void setSenderMail(String senderMail) {
		this.senderMail = senderMail;
	}
	public String getReceivemail() {
		return receivemail;
	}
	public void setReceivemail(String receivemail) {
		this.receivemail = receivemail;
	}
	public Date getSendDate() {
		return sendDate;
	}
	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}
	
	
}
