package com.ini.xfn.nmcuong.dao;

import java.util.List;

import com.ini.xfn.nmcuong.domain.History;

public interface HistoryDAO {
	public List<History> getAll();
	public History getById(int id);
	public void save(History history);
	public void delete(int id);
}
