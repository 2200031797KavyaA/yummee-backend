package com.yummee.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "chef_table")
public class Chef {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false, length = 30)
    private String name;
	@Column(length = 100)
    private String bio;
    private String profileImageUrl;
    @Column(nullable = false, length = 30, unique = true)
    private String email;
    @Column(nullable = false, length = 30, unique = true)
    private String password;
    @OneToMany(mappedBy = "chef")
    @JsonIgnore
    private List<Recipe> recipes;
    private Double totalTips;
    
	@Override
	public String toString() {
		return "Chef [id=" + id + ", name=" + name + ", bio=" + bio + ", profileImageUrl=" + profileImageUrl
				+ ", email=" + email + ", password=" + password + ", recipes=" + recipes + ", totalTips=" + totalTips
				+ "]";
	}
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
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
	public String getProfileImageUrl() {
		return profileImageUrl;
	}
	public void setProfileImageUrl(String profileImageUrl) {
		this.profileImageUrl = profileImageUrl;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Recipe> getRecipes() {
		return recipes;
	}
	public void setRecipes(List<Recipe> recipes) {
		this.recipes = recipes;
	}
	public Double getTotalTips() {
		return totalTips;
	}
	public void setTotalTips(Double totalTips) {
		this.totalTips = totalTips;
	}
    
}