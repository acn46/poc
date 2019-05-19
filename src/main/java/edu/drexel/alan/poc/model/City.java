package edu.drexel.alan.poc.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity(name="City")
@Table(name="City")
@NamedQuery(name="City.findAll", query="SELECT ci FROM City ci")
public class City implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="city_id")
	private int cityId;
	
	@Column(name="city")
	private String City;
	
	@Column(name="country_id")
	private int countryId;
	
	@Column(name="last_update")
	private Date lastUpdate;

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	@Override
	public String toString() {
		return "City [cityId=" + cityId + ", City=" + City + ", countryId=" + countryId + ", lastUpdate=" + lastUpdate
				+ "]";
	}

}
