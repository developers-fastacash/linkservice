package com.fastacash.dao;

import com.fastacash.entity.Link;

public interface LinkDao {

	void save(Link link);
	
	void update(Link link);

	Long count();

	Link getLinkBySecureHash(String secureHash);

	Link getLinkById(Long id);
}
