package com.isep.cooking.entities;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Tool implements Serializable {

	@Id
	@Column(name = "ID")
	private String id;

	private String name;

	@ManyToMany(cascade = CascadeType.MERGE, mappedBy = "tools")
	private List<CookingUser> users;

	@ManyToMany(cascade = CascadeType.MERGE, mappedBy = "tools")
	private List<Recipe> recipes;

	public Tool() {
		this.id = UUID.randomUUID().toString();
	}

	public Tool(String name, List<CookingUser> users, List<Recipe> recipes) {
		this.id = UUID.randomUUID().toString();
		this.name = name;
		this.users = users;
		this.recipes = recipes;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<CookingUser> getUsers() {
		return users;
	}

	public void setUsers(List<CookingUser> users) {
		this.users = users;
	}

	public List<Recipe> getRecipes() {
		return recipes;
	}

	public void setRecipes(List<Recipe> recipes) {
		this.recipes = recipes;
	}

	public boolean generateId() {
		if (this.id == null) {
			this.id = UUID.randomUUID().toString();
			return true;
		}
		return false;
	}

	public void addUser(CookingUser c) {
		this.users.add(c);
	}

	public void addRecipe(Recipe r) {
		this.recipes.add(r);
	}

}
