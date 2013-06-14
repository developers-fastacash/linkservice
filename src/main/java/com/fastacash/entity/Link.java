package com.fastacash.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.apache.commons.lang.RandomStringUtils;

@Entity
@Table(name = "link")
public class Link {

	private Wallet wallet_source;
	private Wallet wallet_dest;
	private Long id;

	private String secureHash;
	
	private String currency;
	private int amount;

	private State state;

	private Date createdAt;
	private Date updatedAt;
	private Date expiresAt;

	public enum State {
		PENDING, ACCEPTED, REJECTED, CANCELLED
	};

	public Link(Wallet wallet_source, Wallet wallet_dest, int amount,
			String currency) {
		this.secureHash = RandomStringUtils.randomAlphanumeric(10);
		this.amount = amount;
		this.currency = currency;
		this.wallet_source = wallet_source;
		this.wallet_dest = wallet_dest;
	}

	public Link() {

	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "wallet_source_id", nullable = false)
	public Wallet getWallet_source() {
		return wallet_source;
	}

	public void setWallet_source(Wallet wallet_source) {
		this.wallet_source = wallet_source;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "wallet_dest_id", nullable = false)
	public Wallet getWallet_dest() {
		return wallet_dest;
	}

	public void setWallet_dest(Wallet wallet_dest) {
		this.wallet_dest = wallet_dest;
	}

	@Id
	@Column(unique = true, nullable = false)
	@SequenceGenerator(name = "sequenceGenerator", sequenceName = "link_id_seq")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "sequenceGenerator")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "secure_hash", unique = true, nullable = false)
	public String getSecureHash() {
		return secureHash;
	}

	public void setSecureHash(String secureHash) {
		this.secureHash = secureHash;
	}

	@Column(name = "amount", nullable = false)
	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Column(name = "currency", nullable = false)
	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	@Column(columnDefinition = "enum('DUMMY')")
	@Enumerated(EnumType.STRING)
	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Date getExpiresAt() {
		return expiresAt;
	}

	public void setExpiresAt(Date expiresAt) {
		this.expiresAt = expiresAt;
	}
}
