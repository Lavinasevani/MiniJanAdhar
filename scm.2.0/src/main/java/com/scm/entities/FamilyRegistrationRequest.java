package com.scm.entities;

import java.util.List;

public class FamilyRegistrationRequest {

    private List<MemberInfo> members;
    private List<String> relations;
    private List<Boolean> hofStatuses;
	public List<MemberInfo> getMembers() {
		return members;
	}
	public void setMembers(List<MemberInfo> members) {
		this.members = members;
	}
	public List<String> getRelations() {
		return relations;
	}
	public void setRelations(List<String> relations) {
		this.relations = relations;
	}
	public List<Boolean> getHofStatuses() {
		return hofStatuses;
	}
	public void setHofStatuses(List<Boolean> hofStatuses) {
		this.hofStatuses = hofStatuses;
	}

    // Getters and Setters
    
}
