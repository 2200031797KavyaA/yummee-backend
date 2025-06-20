package com.yummee.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "mealplan_table")
public class MealPlan {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 30, nullable = false)
	private String name;
	@ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @ManyToMany
    @JoinTable(
        name = "mealplan_recipe_table",
        joinColumns = @JoinColumn(name = "mealplan_id"),
        inverseJoinColumns = @JoinColumn(name = "recipe_id")
    )
    private List<Recipe> recipes;
    private LocalDate createdAt;
    
	@Override
	public String toString() {
		return "MealPlan [id=" + id + ", name=" + name + ", user=" + user + ", recipes=" + recipes + ", createdAt="
				+ createdAt + "]";
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<Recipe> getRecipes() {
		return recipes;
	}
	public void setRecipes(List<Recipe> recipes) {
		this.recipes = recipes;
	}
	public LocalDate getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}
    
}