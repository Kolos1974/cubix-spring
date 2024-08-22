package hu.cubix.logistic.kolos.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class AddressDto {

	private long addressId;
	
	@NotBlank
	private String country;
	@NotBlank
	private String city;
	@NotBlank
	private String street;
	@NotBlank
	private String zipCode;
	@NotBlank
	private String houseNumber;
	
	private double latitude;
	private double longitude;
	
	
	public AddressDto() {
	//	super();
	}


	public AddressDto(@NotBlank String country, @NotBlank String city, @NotBlank String street,
			@NotBlank String zipCode, @NotBlank String houseNumber) {
		// super();
		this.country = country;
		this.city = city;
		this.street = street;
		this.zipCode = zipCode;
		this.houseNumber = houseNumber;
	}


	public AddressDto(@NotBlank String country, @NotBlank String city, @NotBlank String street,
			@NotBlank String zipCode, @NotBlank String houseNumber, double latitude, double longitude) {
		/*
		super();
		this.country = country;
		this.city = city;
		this.street = street;
		this.zipCode = zipCode;
		this.houseNumber = houseNumber;
		*/

		// Constructor chaining!!
		this(country, city, street, zipCode, houseNumber);
		
		this.latitude = latitude;
		this.longitude = longitude;
	}

	// A mappelés miatt szükség van az Id getter/setter-re!! 
	// Az integrációs teszt miatt is szükséges !!
	public long getAddressId() {
		return addressId;
	}

	// Erre szükség van?
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
	public String toString() {
		return "AddressDto [addressId=" + addressId + ", country=" + country + ", city=" + city + ", street=" + street
				+ ", zipCode=" + zipCode + ", houseNumber=" + houseNumber + ", latitude=" + latitude + ", longitude="
				+ longitude + "]";
	}
	
	
	
}
