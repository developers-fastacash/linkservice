package com.fastacash.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="wallet")
public class Wallet {

	
	private Long id;

	public Wallet() {
		
	}
	

	@Id
	@Column(unique = true, nullable = false)
	@SequenceGenerator(name = "sequenceGenerator", sequenceName = "wallet_id_seq")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "sequenceGenerator")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
