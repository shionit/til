/**
 * 
 */
package com.github.shionit.glibtrain.model;

import java.util.Date;

/**
 * Customer entity class.
 * @author shionit
 *
 */
public class Customer {

	/** 氏名 */
	private String name;
	
	/** 生年月日 */
	private Date birthDate;
	
	/** 性別 */
	private Gender gender;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the birthDate
	 */
	public Date getBirthDate() {
		return birthDate;
	}

	/**
	 * @param birthDate the birthDate to set
	 */
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	/**
	 * @return the gender
	 */
	public Gender getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(Gender gender) {
		this.gender = gender;
	}
}
