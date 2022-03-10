package com.movie.theatre.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.movie.theatreDTO.TheatreDTO;



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
		
		@OneToMany(cascade = CascadeType.ALL)
		@JoinColumn(name="theatre_id")
		private List<Shows> shows;
		
		public List<Shows> getShows() {
			return shows;
		}
		public void setShows(List<Shows> shows) {
			this.shows = shows;
		}
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
		
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (this.getClass() != obj.getClass())
				return false;
			TheatreDTO other = (TheatreDTO) obj;
			if (this.getTheatreId() == null) {
				if (other.getTheatreId() != null)
					return false;
			} else if (!this.getTheatreId().equals(other.getTheatreId()))
				return false;
			return true;
		}
		
		

}

