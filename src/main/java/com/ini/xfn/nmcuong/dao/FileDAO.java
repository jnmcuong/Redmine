package com.ini.xfn.nmcuong.dao;

import java.util.List;

import com.ini.xfn.nmcuong.domain.File;


public interface FileDAO {
	public List<File> getAll();
	public File getById(int id);
	public void save(File file);
	public void delete(int id);
}
