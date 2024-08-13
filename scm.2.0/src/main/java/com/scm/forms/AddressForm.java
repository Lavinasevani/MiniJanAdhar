package com.scm.forms;

public class AddressForm {

    private String addressLine1;
    private String addressLine2;
    private String houseNo;
    private String wardNo;
    private String block;
    private String district;
    private String city;
    private String pinCode;
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public String getHouseNo() {
		return houseNo;
	}
	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}
	public String getWardNo() {
		return wardNo;
	}
	public void setWardNo(String wardNo) {
		this.wardNo = wardNo;
	}
	public String getBlock() {
		return block;
	}
	public void setBlock(String block) {
		this.block = block;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	@Override
	public String toString() {
		return "AddressForm [addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2 + ", houseNo=" + houseNo
				+ ", wardNo=" + wardNo + ", block=" + block + ", district=" + district + ", city=" + city + ", pinCode="
				+ pinCode + "]";
	}
	public AddressForm(String addressLine1, String addressLine2, String houseNo, String wardNo, String block,
			String district, String city, String pinCode) {
		super();
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.houseNo = houseNo;
		this.wardNo = wardNo;
		this.block = block;
		this.district = district;
		this.city = city;
		this.pinCode = pinCode;
	}
	public AddressForm() {
		super();
		// TODO Auto-generated constructor stub
	}

    // Getters and Setters
    
}
