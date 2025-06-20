package com.yummee.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tag_table")
public class Tag {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 30)
	private String name;  //"Vegan", "Budget", "Dinner"
	@ManyToMany(mappedBy = "tags")
    private List<Recipe> recipes;
    
	@Override
	public String toString() {
		return "Tag [id=" + id + ", name=" + name + ", recipes=" + recipes + "]";
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
	public List<Recipe> getRecipes() {
		return recipes;
	}
	public void setRecipes(List<Recipe> recipes) {
		this.recipes = recipes;
	}
}