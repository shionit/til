package com.github.shionit.glibtrain.model;

import static com.google.common.truth.Truth.assertThat;

import java.util.Date;

import org.junit.Test;

public class CustomerTest {

	private Customer cust = new Customer();

	@Test
	public final void testGetName() {
		cust.setName("taro");
		assertThat(cust.getName()).isEqualTo("taro");
	}

	@Test
	public final void testSetName() {
		cust.setName("taro");
		assertThat(cust.getName()).isEqualTo("jiro");
	}

	@Test
	public final void testGetBirthDate() {
		assertThat(cust.getBirthDate()).isNull();
		cust.setBirthDate(new Date());
		assertThat(cust.getBirthDate()).isNotNull();
	}

	@Test
	public final void testSetBirthDate() {
	}

	@Test
	public final void testGetGender() {
	}

	@Test
	public final void testSetGender() {
	}

}
