package com.ini.xfn.nmcuong.dao;

import java.util.List;

import com.ini.xfn.nmcuong.domain.Language;


public interface LanguageDAO {
	public List<Language> getAll();
	public Language getById(int id);
	public void save(Language language);
	public void delete(int id);
}
