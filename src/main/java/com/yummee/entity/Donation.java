package com.yummee.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "donation_table")
public class Donation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User sender;
	@ManyToOne
	@JoinColumn(name = "chef_id", nullable = false)
	private Chef recipient;
	private Double amount;
	private LocalDateTime timestamp;
	@Column(length = 50)
	private String message;
	
	@Override
	public String toString() {
		return "Donation [id=" + id + ", sender=" + sender + ", recipient=" + recipient + ", amount=" + amount
				+ ", timestamp=" + timestamp + ", message=" + message + "]";
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public User getSender() {
		return sender;
	}
	public void setSender(User sender) {
		this.sender = sender;
	}
	public Chef getRecipient() {
		return recipient;
	}
	public void setRecipient(Chef recipient) {
		this.recipient = recipient;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}