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

/**
 * VO/DTO for address
 * @author AlanN
 *
 */

@Entity(name="Address")
@Table(name="address")
@NamedQuery(name="Address.findAll", query="SELECT a FROM Address a")
public class Address implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="address_id")
	private int id;
	
	@Column(name="address")
	private String address;
	
	@Column(name="address2")
	private String address2;
	
	@Column(name="district")
	private String district;
	
	@Column(name="city_id")
	private int cityId;
	
	@Column(name="postal_code")
	private String postalCode;
	
	@Column(name="phone")
	private String phone;
	
	@Column(name="location")
	private String location;
	
	@Column(name="last_update")
	private Date lastUpdate;

	public Address() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", address=" + address + ", address2=" + address2 + ", district=" + district
				+ ", cityId=" + cityId + ", postalCode=" + postalCode + ", phone=" + phone + ", location=" + location
				+ ", lastUpdate=" + lastUpdate + "]";
	}
	
	
}

