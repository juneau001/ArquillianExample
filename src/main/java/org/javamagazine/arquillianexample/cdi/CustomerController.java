/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.javamagazine.arquillianexample.cdi;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import org.javamagazine.arquillianexample.entity.Customer;
import org.javamagazine.arquillianexample.session.CustomerFacade;

/**
 *
 * @author Juneau
 */
@Named
@RequestScoped
public class CustomerController {
    
    @EJB
    CustomerFacade customerFacade;
    
    private List<Customer> customerList;
    
    @PostConstruct
    public void init(){
        setCustomerList(customerFacade.findAll());
    }

    /**
     * @return the customerList
     */
    public List<Customer> getCustomerList() {
        return customerList;
    }

    /**
     * @param customerList the customerList to set
     */
    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }
    
}
