package com.scm.entities;



import jakarta.persistence.*;

@Entity
@Table(name = "test_family")
public class TestFamily {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "hof_status")
    private String hofStatus;

    @Column(name = "member_name")
    private String memberName;

    @Column(name = "member_age")
    private Integer memberAge;

    @Column(name = "member_gender")
    private String memberGender;

    @Column(name = "relation_with_hof")
    private String relationWithHof;

    @Column(name = "family_id")
    private Long familyId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHofStatus() {
		return hofStatus;
	}

	public void setHofStatus(String hofStatus) {
		this.hofStatus = hofStatus;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public Integer getMemberAge() {
		return memberAge;
	}

	public void setMemberAge(Integer memberAge) {
		this.memberAge = memberAge;
	}

	public String getMemberGender() {
		return memberGender;
	}

	public void setMemberGender(String memberGender) {
		this.memberGender = memberGender;
	}

	public String getRelationWithHof() {
		return relationWithHof;
	}

	public void setRelationWithHof(String relationWithHof) {
		this.relationWithHof = relationWithHof;
	}

	public Long getFamilyId() {
		return familyId;
	}

	public void setFamilyId(Long familyId) {
		this.familyId = familyId;
	}

    
}
