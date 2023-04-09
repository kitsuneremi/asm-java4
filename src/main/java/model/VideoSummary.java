package model;

import java.util.Date;
import javax.persistence.*;


@Entity
public class VideoSummary {
	@Id
    private String title;
    private Long count;
    private Date minDate;
    private Date maxDate;
    
	public VideoSummary() {
		super();
	}

	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public Long getCount() {
		return count;
	}



	public void setCount(Long count) {
		this.count = count;
	}



	public Date getMinDate() {
		return minDate;
	}



	public void setMinDate(Date minDate) {
		this.minDate = minDate;
	}



	public Date getMaxDate() {
		return maxDate;
	}



	public void setMaxDate(Date maxDate) {
		this.maxDate = maxDate;
	}



	public VideoSummary(String title, Long count, Date minDate, Date maxDate) {
		super();
		this.title = title;
		this.count = count;
		this.minDate = minDate;
		this.maxDate = maxDate;
	}

    
}
