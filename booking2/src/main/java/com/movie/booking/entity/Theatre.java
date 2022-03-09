package com.movie.booking.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="theatre")
public class Theatre {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "theatre_id")
	private Integer theatreId;
	@Column(name = "theatre_name")
	private String theatreName;
	@Column(name = "location")
	private String theatreLoc;
	@Column(name ="seating_capacity")
	private Integer capacity;
	private Integer rate;
	
	
	public Integer getTheatreId() {
		return theatreId;
	}
	public void setTheatreId(Integer theatreId) {
		this.theatreId = theatreId;
	}
	public String getTheatreName() {
		return theatreName;
	}
	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}
	public String getTheatreLoc() {
		return theatreLoc;
	}
	public void setTheatreLoc(String theatreLoc) {
		this.theatreLoc = theatreLoc;
	}
	public Integer getCapacity() {
		return capacity;
	}
	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}
	public Integer getRate() {
		return rate;
	}
	public void setRate(Integer rate) {
		this.rate = rate;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(capacity, rate, theatreId, theatreLoc, theatreName);
	}

	
	
	@Override
	public String toString() {
		return "TheatreDTO [theatreId=" + theatreId + ", theatreName=" + theatreName + ", theatreloc=" + theatreLoc + ", capacity=" + capacity + "rate" +rate + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Theatre other = (Theatre) obj;
		return Objects.equals(capacity, other.capacity) && Objects.equals(rate, other.rate)
				&& Objects.equals(theatreId, other.theatreId) && Objects.equals(theatreLoc, other.theatreLoc)
				&& Objects.equals(theatreName, other.theatreName);
	}
	
	

}
