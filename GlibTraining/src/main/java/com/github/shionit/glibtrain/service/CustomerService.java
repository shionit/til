/**
 * 
 */
package com.github.shionit.glibtrain.service;

import java.util.Arrays;
import java.util.List;

import com.github.shionit.glibtrain.model.Customer;

/**
 * Service layer logic class of Customer.
 * @author shionit
 *
 */
public class CustomerService {

	/**
	 * @param customers Target customers
	 * @param topN number of filtered top N salary
	 * @return
	 */
	public List<Customer> filterTopSalary(List<Customer> customers, int topN) {
		Customer[] results = customers.stream()
				.sorted((x, y) -> y.getSalary().compareTo(x.getSalary()))
				.limit(topN).toArray(x -> new Customer[x]);
		return Arrays.asList(results);
				
	}
}
