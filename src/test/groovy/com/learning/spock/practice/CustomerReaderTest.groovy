package com.learning.spock.practice;

import javax.persistence.EntityManager;
import spock.lang.Specification;
import org.junit.Test

public class CustomerReaderTest extends Specification{

	public void "customer full name is formed from first name and last name"() {
		
		given: "a customer with example name values"
		Customer sampleCustomer = new Customer()
		sampleCustomer.setFirstName("Susan")
		sampleCustomer.setLastName("Ivanova")

		and: "an entity manager that always returns tis customer"
		EntityManager entityManager = Stub(EntityManager.class)
		entityManager.find(Customer.class,1L) >> sampleCustomer

		and: "a customer reader which is the class under test"
		CustomerReader customerReader = new CustomerReader()
		customerReader.setEntityManager(entityManager)

		when: "we ask for the full name of the customer"
		String fullName = customerReader.findFullName(1L)

		then: "we get both the first and the last name"
		fullName == "Susan Ivanova"
	}
	
	def "Should get an index out of bounds when removing a non-existent item"() {
		given:
			def list = [1, 2, 3, 4]
	  
		when:
			list.remove(20)
	 
		then:
			thrown(IndexOutOfBoundsException)
			list.size() == 4
	}
	
	def "numbers to the power of two"(int a, int b, int c) {
		expect:
			Math.pow(a, b) == c
	   
		where:
			a | b | c
			1 | 2 | 1
			2 | 2 | 4
			3 | 2 | 9
		}
}