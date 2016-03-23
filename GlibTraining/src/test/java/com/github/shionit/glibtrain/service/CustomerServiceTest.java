package com.github.shionit.glibtrain.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.junit.Test;

import com.github.shionit.glibtrain.model.Customer;
import com.github.shionit.glibtrain.model.Gender;
import com.google.common.collect.Lists;
import static com.google.common.truth.Truth.*;

public class CustomerServiceTest {

	private CustomerService target = new CustomerService();
	
	@Test
	public final void testFilterTopSalary() {
		List<Customer> customers = Lists.newArrayList();
		Customer c1 = new Customer();
		c1.setName("tanaka.hira");
		c1.setGender(Gender.MAN);
		c1.setSalary(BigDecimal.valueOf(1000000L));
		c1.setBirthDate(LocalDate.of(1980, 5, 22));
		customers.add(c1);

		Customer c2 = new Customer();
		c2.setName("yamaguchi.kacho");
		c2.setGender(Gender.WOMAN);
		c2.setSalary(BigDecimal.valueOf(3000000L));
		c2.setBirthDate(LocalDate.of(1977, 4, 19));
		customers.add(c2);
		
		Customer c3 = new Customer();
		c3.setName("yamaguchi.bucho");
		c3.setGender(Gender.OTHERS);
		c3.setSalary(BigDecimal.valueOf(5000000L));
		c3.setBirthDate(LocalDate.of(1974, 11, 28));
		customers.add(c3);
		
		assertThat(target.filterTopSalary(customers, 2)).containsExactly(c3, c2).inOrder();;
}

}
