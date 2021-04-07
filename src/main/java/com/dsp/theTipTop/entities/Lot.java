package com.dsp.theTipTop.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Lot {

	@Id
	private Long lotId;
	
	@NotNull
	private String name;
	
	@Column(columnDefinition = "TEXT")
	private String description;
	
	private double price;
}
