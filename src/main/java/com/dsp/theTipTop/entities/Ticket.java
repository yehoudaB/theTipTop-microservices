package com.dsp.theTipTop.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {

	@Id 
	private Long ticketId;
	
	@NotNull
	private String name;
	
	
	@ManyToOne @JoinColumn(name = "lot_id") 
	private Lot lot;
	  
	@ManyToOne @JoinColumn(name = "user_id") 
	private User user;
	 

	@NotNull
	private boolean isHadTheGift;


	
}
