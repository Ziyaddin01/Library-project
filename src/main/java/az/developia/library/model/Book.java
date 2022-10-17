package az.developia.library.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
 
@Entity
public class Book {
   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@NotEmpty(message="Bos qoymaq olmaz!")
	@Size(min=2,message="Minimum 2 simvol yazilmalidir!")
	@Size(max=40,message="Maksimum 40 simvol olmalidir!")
	private String name;
	@Min(value = 0,message="Minimum 0 yazmaq olar")
	@Max(value = 10000,message="Maksimum 10000 yazmaq olar")
	@NotNull(message="Bos qoymaq olmaz!")
	private Double price;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	
}
