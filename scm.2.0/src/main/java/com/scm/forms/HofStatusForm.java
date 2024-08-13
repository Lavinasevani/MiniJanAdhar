package com.scm.forms;

public class HofStatusForm {

    private Long memberId;
    private String relation;

    // Default constructor
    public HofStatusForm() {
    }

    // Parameterized constructor
    public HofStatusForm(Long memberId, String relation) {
        this.memberId = memberId;
        this.relation = relation;
    }

    // Getters and Setters
    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    @Override
    public String toString() {
        return "HofStatusForm [memberId=" + memberId + ", relation=" + relation + "]";
    }
}
