package com.Demo.RestApi.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="TBL_PRODUCTS")
public class Product {

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PRODSEQ")
	@SequenceGenerator(sequenceName="products_seq",allocationSize=1, name="PRODSEQ")
	private Long id;
	
	@Column(name="CATEGORY")
	private String category;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="STOCK")
	private Integer stock;
	
	@Column(name="PRICE")
	private Double price;
	
}
