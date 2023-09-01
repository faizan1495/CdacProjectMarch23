package com.project.demo.entities;


import org.springframework.data.jpa.domain.support.AuditingEntityListener;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Product")
@NoArgsConstructor
@Getter
@Setter
//@EntityListeners(AuditingEntityListener.class)
public class Product {
	@Id
	private long Id;
	
	private String Title;
	
	private String Cat;
	
	private int Price;
	
    private String Img;
	
}
