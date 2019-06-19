/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.javamagazine.arquillianexample.session;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.javamagazine.arquillianexample.cdi.CustomerController;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 * @author Juneau
 */
@RunWith(Arquillian.class)
public class CustomerFacadeTest {
    
    @EJB
    private CustomerFacade customerFacade;
    
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "CustomerFacadeTest.war")
                .addClass(CustomerController.class)
                .addClass(CustomerFacade.class)
                .addClass(org.javamagazine.arquillianexample.session.AbstractFacade.class)
                .addClass(org.javamagazine.arquillianexample.entity.Customer.class)
                .addAsResource("test-persistence.xml", "META-INF/persistence.xml")
                .addAsManifestResource(EmptyAsset.INSTANCE,"beans.xml");
    }
    
    
    @Test
    public void test_customer_list() {
        Assert.assertTrue(customerFacade.findAllCustomers()!= null);
    }
}