package com.web.domain;


import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Rental")
@Getter
@Setter
public class Rental {

	 	@Id
	 	@Column(nullable = false)
	 	private Long rental_no;
	 	
	 	@Column(nullable = false)
	 	private Long car_no;
	 	
	 	@Column(nullable = false)
	    private String id;
	 	
	 	@Column(nullable = false)
	 	private int rentalPeriod;
	 	
	 	@Column(nullable = false)
	 	private int totalCost;
	 	
	 	@Column(name = "start_date", columnDefinition = "DATE", nullable = false)
	 	private LocalDate startDate;
	 	
	 	@Column(nullable = false)
	    private int startTime;
	 	
	 	@Column(name = "end_date", columnDefinition = "DATE", nullable = false)
	    private LocalDate endDate;
	 	
	 	@Column(nullable = false)
	    private int endTime;
	 	
	 	@ManyToOne
	    @JoinColumn(name = "car_no", insertable = false, updatable = false)
	    private Car car;
	    
	    public Rental() {
	        super();
	    }

	    public Rental(Long rental_no, Long car_no, String id, int totalCost, int rentalPeriod, LocalDate startDate, int startTime, LocalDate endDate, int endTime) {
	    	this.rental_no = rental_no;
	        this.car_no = car_no;
	        this.id = id;
	        this.totalCost = totalCost;
	        this.rentalPeriod = rentalPeriod;
	        this.startDate = startDate;
	        this.startTime = startTime;
	        this.endDate = endDate;
	        this.endTime = endTime;
	    }

}