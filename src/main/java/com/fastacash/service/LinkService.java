package com.fastacash.service;

import com.fastacash.entity.Link;

public interface LinkService {
	 
	public Link create(int amount, String currency, Long sourceWalletId, Long destWalletId);
	public boolean accept(String secureHash);

}