package hu.cubix.logistic.kolos.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

@Entity
public class Address {

	
	@Id
	@GeneratedValue
	private long addressId;	
	
	@Size(min=2, max = 2)
	private String country;
	
	private String city;
	private String street;
	private String zipCode;
	private String houseNumber;
	private double latitude;
	private double longitude;
	
	
	public Address() {
	//	super();
	}


	public Address(@Size(min = 2, max = 2) String country, String city, String street, String zipCode,
			String houseNumber, double latitude, double longitude) {
		// super();
		this.country = country;
		this.city = city;
		this.street = street;
		this.zipCode = zipCode;
		this.houseNumber = houseNumber;
		this.latitude = latitude;
		this.longitude = longitude;
	}


	public long getAddressId() {
		return addressId;
	}


	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getStreet() {
		return street;
	}


	public void setStreet(String street) {
		this.street = street;
	}


	public String getZipCode() {
		return zipCode;
	}


	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}


	public String getHouseNumber() {
		return houseNumber;
	}


	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}


	public double getLatitude() {
		return latitude;
	}


	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}


	public double getLongitude() {
		return longitude;
	}


	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}


	@Override
	public int hashCode() {
		return Objects.hash(addressId);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		return addressId == other.addressId;
	}


	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", country=" + country + ", city=" + city + ", street=" + street
				+ ", zipCode=" + zipCode + ", houseNumber=" + houseNumber + ", latitude=" + latitude + ", longitude="
				+ longitude + "]";
	}
	
	
	
	
}
