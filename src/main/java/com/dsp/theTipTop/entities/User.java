package com.dsp.theTipTop.entities;

import java.util.Date;

import javax.persistence.CascadeType;
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

import org.hibernate.validator.constraints.UniqueElements;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull @Column(unique = true)
	private String email;
	
	private String firstName;

	private String lastName;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date birthDate;
	
	private boolean canEmailMe;
	
	
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval=true) @JoinColumn(name = "big_lot_id")
	private Lot wonTheBigLot;
	
	
	private boolean isHadHisGift;
	
}
