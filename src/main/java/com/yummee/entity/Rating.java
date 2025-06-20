package com.yummee.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "rating_table")
public class Rating {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
	private User user;
	@ManyToOne
    @JoinColumn(name = "recipe_id", nullable = false)
	private Recipe recipe;
	private Integer stars ;  // 1 to 5
	@Column(length = 50)
	private String comment;
	private LocalDateTime ratedAt;

	@Override
	public String toString() {
		return "Rating [id=" + id + ", user=" + user + ", recipe=" + recipe + ", stars=" + stars + ", comment="
				+ comment + ", ratedAt=" + ratedAt + "]";
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Recipe getRecipe() {
		return recipe;
	}
	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}
	public Integer getStars() {
		return stars;
	}
	public void setStars(Integer stars) {
		this.stars = stars;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public LocalDateTime getRatedAt() {
		return ratedAt;
	}
	public void setRatedAt(LocalDateTime ratedAt) {
		this.ratedAt = ratedAt;
	}
	
}