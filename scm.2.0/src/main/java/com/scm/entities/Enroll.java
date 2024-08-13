package com.scm.entities;
import jakarta.persistence.*;

@Entity
@Table(name = "enroll")
public class Enroll {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long enrollId;

    private Long memberId;
    private String relationWithHof;
    private String hofStatus;

    // Getters and Setters
	public Long getEnrollId() {
		return enrollId;
	}
	public void setEnrollId(Long enrollId) {
		this.enrollId = enrollId;
	}
	public Long getMemberId() {
		return memberId;
	}
	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}
	public String getRelationWithHof() {
		return relationWithHof;
	}
	public void setRelationWithHof(String relationWithHof) {
		this.relationWithHof = relationWithHof;
	}
	public String getHofStatus() {
		return hofStatus;
	}
	public void setHofStatus(String hofStatus) {
		this.hofStatus = hofStatus;
	}
	@Override
	public String toString() {
		return "Enroll [enrollId=" + enrollId + ", memberId=" + memberId + ", relationWithHof=" + relationWithHof
				+ ", hofStatus=" + hofStatus + "]";
	}
	public Enroll() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Enroll(Long enrollId, Long memberId, String relationWithHof, String hofStatus) {
		super();
		this.enrollId = enrollId;
		this.memberId = memberId;
		this.relationWithHof = relationWithHof;
		this.hofStatus = hofStatus;
	}

    
}
