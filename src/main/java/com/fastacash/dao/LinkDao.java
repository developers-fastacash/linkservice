package com.fastacash.dao;

import com.fastacash.entity.Link;

public interface LinkDao {

	Long save(Link link);

	int count();

	Link getLinkBySecureHash(String secureHash);

	Link getLinkById(Long id);
}
