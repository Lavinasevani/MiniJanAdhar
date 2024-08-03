package com.scm.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.CollectionTable;

@Entity(name = "family")
@Table(name = "family")
public class Family {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long familyId;

    @Column(name = "hofName", nullable = false)
    private String hofName;

    @Column(name = "hofdob", nullable = false)
    private String hofdob;

    @Column(name = "hofAdhar", unique = true, nullable = false)
    private String hofAdhar;

    @Column(name = "hofAddress", nullable = false)
    private String address;

    @Column(name = "hofpic", nullable = false)
    private String hofPic;

    @ElementCollection
    @CollectionTable(name = "family_members")
    @Column(name = "member")
    private List<Integer> member = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // Getters and Setters
    public Long getFamilyId() {
        return familyId;
    }

    public void setFamilyId(Long familyId) {
        this.familyId = familyId;
    }

    public String getHofName() {
        return hofName;
    }

    public void setHofName(String hofName) {
        this.hofName = hofName;
    }

    public String getHofdob() {
        return hofdob;
    }

    public void setHofdob(String hofdob) {
        this.hofdob = hofdob;
    }

    public String getHofAdhar() {
        return hofAdhar;
    }

    public void setHofAdhar(String hofAdhar) {
        this.hofAdhar = hofAdhar;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHofPic() {
        return hofPic;
    }

    public void setHofPic(String hofPic) {
        this.hofPic = hofPic;
    }

    public List<Integer> getMember() {
        return member;
    }

    public void setMember(List<Integer> member) {
        this.member = member;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
