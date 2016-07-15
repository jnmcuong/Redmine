package com.ini.xfn.nmcuong.dao;

import java.util.List;

import com.ini.xfn.nmcuong.domain.Category;


public interface CategoryDAO {
	public List<Category> getAll();
	public Category getById(int id);
	public void save(Category category);
	public void delete(int id);
}
