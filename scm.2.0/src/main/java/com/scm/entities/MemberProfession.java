package com.scm.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "final_Prof")
public class MemberProfession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String education;
    private String occupation;
    private String resident;
    private String religion;
    private String category;
    private String mobileNumber;

    @OneToOne
    @JoinColumn(name = "member_id")
    private MemberInfo memberInfo;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public MemberInfo getMemberInfo() {
        return memberInfo;
    }

    public void setMemberInfo(MemberInfo memberInfo) {
        this.memberInfo = memberInfo;
    }

    @Override
    public String toString() {
        return "MemberProfession [id=" + id + ", education=" + education + ", occupation=" + occupation + ", resident="
                + resident + ", religion=" + religion + ", category=" + category + ", mobileNumber=" + mobileNumber
                + "]";
    }
}
