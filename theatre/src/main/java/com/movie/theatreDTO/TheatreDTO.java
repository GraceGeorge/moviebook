package com.movie.theatreDTO;

public class TheatreDTO {
	private Integer theatreId;
	private String theatreName;
	private String theatreLoc;
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

		return 31;
	}

	
	
	@Override
	public String toString() {
		return "TheatreDTO [theatreId=" + theatreId + ", theatreName=" + theatreName + ", theatreloc=" + theatreLoc + ", capacity=" + capacity + "rate" +rate + "]";
	}
	
	

}
