package com.ini.xfn.nmcuong.dao;


import java.util.List;

import com.ini.xfn.nmcuong.domain.Member;
import com.ini.xfn.nmcuong.domain.Priority;

public interface PriorityDAO {
	public List<Priority> getAll();
	public Priority getById(int id);
	public void save(Priority priority);
	public void delete(int id);
}
