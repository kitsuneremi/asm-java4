package model;

import java.util.Date;
import javax.persistence.*;

@Entity
public class Userfav {
	@Id
	private String id;
	private String fullname;
	private String email;
	private Date favDate;
	
	public Userfav() {
		super();
	}
	public Userfav(String id, String fullname, String email, Date favDate) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.email = email;
		this.favDate = favDate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getFavDate() {
		return favDate;
	}
	public void setFavDate(Date favDate) {
		this.favDate = favDate;
	}
	
	
}
