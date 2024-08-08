package com.scm.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "bsdc_Info") // Correct table name
public class MemberInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String fName;
    private String mName;
    private String dob; // Format: dd-MM-yyyy
    private String gender;
    private String mAdhar;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getmAdhar() {
        return mAdhar;
    }

    public void setmAdhar(String mAdhar) {
        this.mAdhar = mAdhar;
    }

    @Override
    public String toString() {
        return "MemberInfo [id=" + id + ", name=" + name + ", fName=" + fName + ", mName=" + mName + ", dob=" + dob
                + ", gender=" + gender + ", mAdhar=" + mAdhar + "]";
    }
}
