package com.scm.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "test_address_test")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "family_id")
    private Long familyId;

    @Column(name = "address_line_1")
    private String addressLine1;

    @Column(name = "address_line_2")
    private String addressLine2;

    @Column(name = "house_no")
    private String houseNo;

    @Column(name = "ward_no")
    private String wardNo;

    @Column(name = "block")
    private String block;

    @Column(name = "district")
    private String district;

    @Column(name = "city")
    private String city;

    @Column(name = "pin_code")
    private String pinCode;
    // Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getFamilyId() {
		return familyId;
	}

	public void setFamilyId(Long familyId) {
		this.familyId = familyId;
	}

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

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address(Long id, Long familyId, String addressLine1, String addressLine2, String houseNo, String wardNo,
			String block, String district, String city, String pinCode) {
		super();
		this.id = id;
		this.familyId = familyId;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.houseNo = houseNo;
		this.wardNo = wardNo;
		this.block = block;
		this.district = district;
		this.city = city;
		this.pinCode = pinCode;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", familyId=" + familyId + ", addressLine1=" + addressLine1 + ", addressLine2="
				+ addressLine2 + ", houseNo=" + houseNo + ", wardNo=" + wardNo + ", block=" + block + ", district="
				+ district + ", city=" + city + ", pinCode=" + pinCode + "]";
	}

   
    
}
