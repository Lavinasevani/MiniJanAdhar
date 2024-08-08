package com.scm.forms;

import com.scm.entities.MemberProfession;

public class MemberProfessionForm {

    private String education;
    private String occupation;
    private String resident;
    private String religion;
    private String category;
    private String mobileNumber;

    // Getters and Setters
    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getResident() {
        return resident;
    }

    public void setResident(String resident) {
        this.resident = resident;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    // Constructors
    public MemberProfessionForm() {
        super();
    }

    public MemberProfessionForm(String education, String occupation, String resident, String religion, String category, String mobileNumber) {
        super();
        this.education = education;
        this.occupation = occupation;
        this.resident = resident;
        this.religion = religion;
        this.category = category;
        this.mobileNumber = mobileNumber;
    }

    @Override
    public String toString() {
        return "MemberProfessionForm [education=" + education + ", occupation=" + occupation + ", resident=" + resident
                + ", religion=" + religion + ", category=" + category + ", mobileNumber=" + mobileNumber + "]";
    }

    public MemberProfession getMemberProfession() {
        MemberProfession memberProfession = new MemberProfession();
        memberProfession.setEducation(this.education);
        memberProfession.setOccupation(this.occupation);
        memberProfession.setResident(this.resident);
        memberProfession.setReligion(this.religion);
        memberProfession.setCategory(this.category);
        memberProfession.setMobileNumber(this.mobileNumber);
        return memberProfession;
    }
}
