package com.ecart.dao;

import java.util.List;

import com.ecart.model.Category;

public interface CategoryDAO {


	public boolean addCategory(Category category);
	public Category getCategory(int categoryId);
	public boolean deleteCategory(Category category);
	public boolean updateCategory(Category category);
	public List<Category> getCategories();
}
