package com.dsp.theTipTop.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Ticket {

	@Id 
	@GeneratedValue
	private Long ticketId;
	
	@NotNull
	private String name;
	
	
	@ManyToOne @JoinColumn(name = "lot_id") 
	private Lot lot;
	  
	@ManyToOne @JoinColumn(name = "user_id") 
	private User user;
	 

	@NotNull
	private boolean isHadTheGift;


	public Ticket(@NotNull String name, Lot lot, User user, @NotNull boolean isHadTheGift) {
		super();
		this.name = name;
		this.lot = lot;
		this.user = user;
		this.isHadTheGift = isHadTheGift;
	}


	
}
