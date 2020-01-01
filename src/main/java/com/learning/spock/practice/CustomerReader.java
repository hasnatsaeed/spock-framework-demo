package com.learning.spock.practice;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class CustomerReader {
  
  @PersistenceContext
  private EntityManager entityManager;
  
  public String findFullName(Long customerID){
    Customer customer = entityManager.find(Customer.class, customerID);
    return customer.getFirstName() +" "+customer.getLastName();
  }

public EntityManager getEntityManager() {
	return entityManager;
}

public void setEntityManager(EntityManager entityManager) {
	this.entityManager = entityManager;
}
  
  

}