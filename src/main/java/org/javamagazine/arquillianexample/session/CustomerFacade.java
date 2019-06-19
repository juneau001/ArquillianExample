/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.javamagazine.arquillianexample.session;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.javamagazine.arquillianexample.entity.Customer;

/**
 *
 * @author Juneau
 */
@Stateless
public class CustomerFacade extends AbstractFacade<Customer> {

    @PersistenceContext(unitName = "org.javamagazine_ArquillianExample_war_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    /**
     * Set the entity manager for testing purposes
     * @param em 
     */
    public void setEntityManager(EntityManager em){
        this.em = em;
    }

    public CustomerFacade() {
        super(Customer.class);
    }
    
    public List findAllCustomers(){
        return em.createQuery("select object(o) from Customer o")
                .getResultList();
    }
    
}
