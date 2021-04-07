package com.dsp.theTipTop.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class User {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	
	@NotNull
	private String email;
	
	private String facebookId;
	
	private String password;
	
	@NotNull @Temporal(TemporalType.TIMESTAMP)
	private Date birthDate;
	
	@NotNull
	private boolean canEmailMe;
	
	
	@OneToOne @JoinColumn(name = "lot_id")
	private Lot wonTheBigPrize;
	
	
	private boolean isHadHisGift;


	public User(@NotNull String email, String facebookId, String password, @NotNull Date birthDate,
			@NotNull boolean canEmailMe, Lot wonTheBigPrize, boolean isHadHisGift) {
		super();
		this.email = email;
		this.facebookId = facebookId;
		this.password = password;
		this.birthDate = birthDate;
		this.canEmailMe = canEmailMe;
		this.wonTheBigPrize = wonTheBigPrize;
		this.isHadHisGift = isHadHisGift;
	}


	
	
	
	
}
