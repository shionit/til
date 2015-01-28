/**
 * 
 */
package com.github.shionit.glibtrain.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.google.common.base.MoreObjects;

/**
 * Customer entity class.
 * 
 * @author shionit
 *
 */
public class Customer {

	/** 氏名 */
	private String name;

	/** 生年月日 */
	private LocalDate birthDate;

	/** 性別 */
	private Gender gender;

	/** 年収 */
	private BigDecimal salary;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the birthDate
	 */
	public LocalDate getBirthDate() {
		return birthDate;
	}

	/**
	 * @param birthDate
	 *            the birthDate to set
	 */
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	/**
	 * @return the gender
	 */
	public Gender getGender() {
		return gender;
	}

	/**
	 * @param gender
	 *            the gender to set
	 */
	public void setGender(Gender gender) {
		this.gender = gender;
	}

	/**
	 * @return the salary
	 */
	public BigDecimal getSalary() {
		return salary;
	}

	/**
	 * @param salary
	 *            the salary to set
	 */
	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	/**
	 * @inheritDoc
	 */
	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
				.add("name", name)
				.add("birthDate", birthDate)
				.add("gender", gender)
				.add("salary", salary)
				.toString();
	}
}
