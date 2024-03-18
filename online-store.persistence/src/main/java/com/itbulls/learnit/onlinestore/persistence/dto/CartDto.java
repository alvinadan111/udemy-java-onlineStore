package com.itbulls.learnit.onlinestore.persistence.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity(name = "cart")
public class CartDto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "fk_cart_user")
	private UserDto userDto;


	@ManyToMany
	@JoinTable(name="cart_product",
	   joinColumns=@JoinColumn(name="cart_id"),
	   inverseJoinColumns=@JoinColumn(name="product_id"))
	private List<ProductDto> productDtos;



	public UserDto getUserDto() {
		return userDto;
	}
	public void setUserDto(UserDto userDto) {
		this.userDto = userDto;
	}
	public List<ProductDto> getProductDtos() {
		return productDtos;
	}
	public void setProductDtos(List<ProductDto> productDtos) {
		this.productDtos = productDtos;
	}




}
