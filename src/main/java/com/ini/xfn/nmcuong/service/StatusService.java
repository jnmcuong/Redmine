package com.ini.xfn.nmcuong.service;

import java.util.List;


import com.ini.xfn.nmcuong.domain.Status;

public interface StatusService {
	public List<Status> getAll();
	public Status getById(int id);
}
