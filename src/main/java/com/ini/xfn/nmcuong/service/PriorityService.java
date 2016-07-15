package com.ini.xfn.nmcuong.service;

import java.util.List;

import com.ini.xfn.nmcuong.domain.Priority;

public interface PriorityService {
	public List<Priority> getAll();
	public Priority getById(int id);
}
