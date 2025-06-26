package com.yummee.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "recipe_table")
public class Recipe {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false, length = 50)
	private String title;
	@Column(length = 1000)
	private String description;
	private String cuisine;
	@ElementCollection
	private List<String> ingredients;
	@ElementCollection
	private List<String> instructions;
	private String imageUrl;
    private String language;
    private Integer cookTimeMinutes;
    private Double ratingAverage;
    private Integer ratingCount;
    @ManyToOne
    @JoinColumn(name = "chef_id", nullable = false)
    private Chef chef;   // Many-to-one
    @ManyToMany
    @JoinTable(
        name = "recipe_tag_table",
        joinColumns = @JoinColumn(name = "recipe_id"),
        inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private List<Tag> tags;
    @ManyToMany(mappedBy = "recipes")
    private List<Playlist> playlists;
    
	@Override
	public String toString() {
		return "Recipe [id=" + id + ", title=" + title + ", description=" + description + ", cuisine=" + cuisine
				+ ", ingredients=" + ingredients + ", instructions=" + instructions + ", imageUrl=" + imageUrl
				+ ", language=" + language + ", cookTimeMinutes=" + cookTimeMinutes + ", ratingAverage=" + ratingAverage
				+ ", ratingCount=" + ratingCount + ", chef=" + chef + ", tags=" + tags + ", playlists=" + playlists
				+ "]";
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCuisine() {
		return cuisine;
	}
	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}
	public List<String> getIngredients() {
		return ingredients;
	}
	public void setIngredients(List<String> ingredients) {
		this.ingredients = ingredients;
	}
	public List<String> getInstructions() {
		return instructions;
	}
	public void setInstructions(List<String> instructions) {
		this.instructions = instructions;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public Integer getCookTimeMinutes() {
		return cookTimeMinutes;
	}
	public void setCookTimeMinutes(Integer cookTimeMinutes) {
		this.cookTimeMinutes = cookTimeMinutes;
	}
	public Double getRatingAverage() {
		return ratingAverage;
	}
	public void setRatingAverage(Double ratingAverage) {
		this.ratingAverage = ratingAverage;
	}
	public Integer getRatingCount() {
		return ratingCount;
	}
	public void setRatingCount(Integer ratingCount) {
		this.ratingCount = ratingCount;
	}
	public Chef getChef() {
		return chef;
	}
	public void setChef(Chef chef) {
		this.chef = chef;
	}
	public List<Tag> getTags() {
		return tags;
	}
	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}
	public List<Playlist> getPlaylists() {
		return playlists;
	}
	public void setPlaylists(List<Playlist> playlists) {
		this.playlists = playlists;
	}
    
}