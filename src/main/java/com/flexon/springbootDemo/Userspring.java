package com.flexon.springbootDemo;

import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Userspring {
	@JsonIgnore 
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long UserId;
	
	private String FirstName;
	
	private String LastName;
	
	private String Email;
	
	private String Password;
	
	private String BirthDate;
	
	private String Gender;
	
	public Userspring() {
		
	}
	
	public Userspring(String firstName, String lastName, String email, String password, String birthDate, String gender) {
		super();
		this.FirstName = firstName;
		this.LastName = lastName;
		this.Email = email;
		this.Password = password;
		this.BirthDate = birthDate;
		this.Gender = gender;
		
	}
	
	public long getUserId() {
		return UserId;
	}
	public void setUserId(long userId) {
	this.UserId = userId;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		String emailRegex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
	            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		Pattern pat = Pattern.compile(emailRegex);
		if(pat.matcher(email).matches() && email.length()!=0 ) {
		this.Email = email;
		}else {
			System.out.println("Please Enter a valid email address");
		}
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		if(password.length()>=8) {
			int NumCount = 0;
			int SpecialCount = 0;
			for(int i=0;i<password.length();i++) {
				if(Character.isDigit(password.charAt(i))) {
					NumCount++;
				}
				if(!Character.isLetter(password.charAt(i)) && !Character.isDigit(password.charAt(i))) {
					SpecialCount++;
				}
			}
			if(Character.isUpperCase(password.charAt(0)) && NumCount > 0 && SpecialCount > 0) {
				this.Password = password;
			}
		}else {
			System.out.println("The password must be 8 characters or longer with atleast 1 number, 1 special character and the first character must be uppercase");
		}
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		int n = firstName.length();
		String str = firstName.replaceAll("[^a-zA-Z]","");
		int n1 = str.length();
		if(n==n1 && n>=2) {
		this.FirstName = firstName;
		}else {
			System.out.println("Enter a valid name Ex John,Kanak,Joey");
		}
		
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		int n = lastName.length();
		String str = lastName.replaceAll("[^a-zA-Z]","");
		int n1 = str.length();
		if(n==n1 && n>2) {
		this.LastName = lastName;
		}else {
			System.out.println("Enter a valid name Ex Sharma,Khan,Singh,Clooney");
		}
	}

  public String getBirthDate() {
	  return BirthDate;
  }
  
  public void setBirthDate(String birthDate) {
	  this.BirthDate = birthDate;
  }

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		gender = gender.toLowerCase();
		ArrayList<String> gen = new ArrayList<>();
		gen.add("male");
		gen.add("female");
		gen.add("other");
		if(gen.contains(gender)) {
			this.Gender = gender;
		}else {
			System.out.println("Enter valid gender male/female/other");
		}
	}
	@Override
	public String toString() {
		return "Userspring [UserId="+ UserId +", FirstName="+ FirstName +", LastName="+ LastName +", Email="+ Email + ", Password="+ Password +", BirthDate="+ BirthDate +", Gender="+ Gender +"]";
	}
	
	
}
