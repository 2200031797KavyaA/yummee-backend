package com.yummee.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_table")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false, length = 30)
    private String username;
	@Column(nullable = false, length = 30, unique = true)
    private String email;
	@Column(nullable = false, length = 30, unique = true)
    private String password;
	private String role;  // "USER" or "CHEF"
	@ManyToMany
	@JoinTable(
	    name = "saved_recipes",
	    joinColumns = @JoinColumn(name = "user_id"),
	    inverseJoinColumns = @JoinColumn(name = "recipe_id")
	)
	private List<Recipe> savedRecipes;

    @OneToMany(mappedBy = "user")
    private List<Playlist> playlists;
    @OneToMany(mappedBy = "sender")
    private List<Donation> donationsSent;
    @OneToMany(mappedBy = "user")
    private List<MealPlan> mealPlans;
    @OneToMany(mappedBy = "user")
    private List<Rating> ratingsGiven;
    
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password + ", role="
				+ role + ", savedRecipes=" + savedRecipes + ", playlists=" + playlists + ", donationsSent="
				+ donationsSent + ", mealPlans=" + mealPlans + ", ratingsGiven=" + ratingsGiven + "]";
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public List<Recipe> getSavedRecipes() {
		return savedRecipes;
	}
	public void setSavedRecipes(List<Recipe> savedRecipes) {
		this.savedRecipes = savedRecipes;
	}
	public List<Playlist> getPlaylists() {
		return playlists;
	}
	public void setPlaylists(List<Playlist> playlists) {
		this.playlists = playlists;
	}
	public List<Donation> getDonationsSent() {
		return donationsSent;
	}
	public void setDonationsSent(List<Donation> donationsSent) {
		this.donationsSent = donationsSent;
	}
	public List<MealPlan> getMealPlans() {
		return mealPlans;
	}
	public void setMealPlans(List<MealPlan> mealPlans) {
		this.mealPlans = mealPlans;
	}
	public List<Rating> getRatingsGiven() {
		return ratingsGiven;
	}
	public void setRatingsGiven(List<Rating> ratingsGiven) {
		this.ratingsGiven = ratingsGiven;
	}

}