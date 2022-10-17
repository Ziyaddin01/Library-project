package az.developia.library.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Student {
  
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	@NotEmpty(message="Bosh goymaq olmaz!")
	@Size(min=2,message="Minimum 2 simvol lazimdir!")
	@Size(max=20,message="Maksimum 20 simvol olmalidir!")
	private String name;
	
	@NotEmpty(message="Bosh qoymaq olmaz!")
	@Size(min=2,message="Minimum 2 simvol lazimdir!")
	@Size(max=20,message="Maksimum 20 simvol olmalidir!")
	private String surname;
	
	@NotEmpty(message="Bosh qoymaq olmaz!")
	@Size(min=2,message="Minimum 2 simvol lazimdir!")
	@Size(max=200,message="Maksimum 200 simvol olmalidir!")
	private String address;
	
	@NotNull(message="Bosh qoymaq olmaz!")
	private String phone;
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
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
