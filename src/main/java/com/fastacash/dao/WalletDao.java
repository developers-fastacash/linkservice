package com.fastacash.dao;

import com.fastacash.entity.Wallet;

public interface WalletDao {

	void save(Wallet wallet);

	Long count();
	
	Wallet getWalletById(Long id);
}
