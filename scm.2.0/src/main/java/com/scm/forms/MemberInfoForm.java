package com.scm.forms;

import com.scm.entities.MemberInfo;

public class MemberInfoForm {

    private String name;
    private String fName;
    private String mName;
    private String dob; // Format: dd-MM-yyyy
    private String gender;
    private String mAdhar;

    // Getters and Setters
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

    // Constructors
    public MemberInfoForm() {
        super();
    }

    public MemberInfoForm(String name, String fName, String mName, String dob, String gender, String mAdhar) {
        super();
        this.name = name;
        this.fName = fName;
        this.mName = mName;
        this.dob = dob;
        this.gender = gender;
        this.mAdhar = mAdhar;
    }

    @Override
    public String toString() {
        return "MemberInfoForm [name=" + name + ", fName=" + fName + ", mName=" + mName + ", dob=" + dob + ", gender="
                + gender + ", mAdhar=" + mAdhar + "]";
    }

    public MemberInfo getMemberInfo() {
        MemberInfo memberInfo = new MemberInfo();
        memberInfo.setName(this.name);
        memberInfo.setfName(this.fName);
        memberInfo.setmName(this.mName);
        memberInfo.setDob(this.dob);
        memberInfo.setGender(this.gender);
        memberInfo.setmAdhar(this.mAdhar);
        return memberInfo;
    }
}
