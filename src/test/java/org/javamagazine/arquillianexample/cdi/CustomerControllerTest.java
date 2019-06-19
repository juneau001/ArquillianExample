/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.javamagazine.arquillianexample.cdi;

import javax.inject.Inject;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 * @author Juneau
 */
@RunWith(Arquillian.class)
public class CustomerControllerTest {
    
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "CustomerControllerTest.war")
                .addClass(org.javamagazine.arquillianexample.cdi.CustomerController.class)
                .addClass(org.javamagazine.arquillianexample.session.CustomerFacade.class)
                .addClass(org.javamagazine.arquillianexample.entity.Customer.class)
                .addClass(org.javamagazine.arquillianexample.session.AbstractFacade.class)
                .addAsResource("test-persistence.xml", "META-INF/persistence.xml")
                .addAsManifestResource(EmptyAsset.INSTANCE,"beans.xml")
                .addAsWebInfResource("mock-web.xml", "web.xml");
    }
    
    @Inject
    CustomerController customerController;
    
    @Test
    public void test_customer_list() {
        Assert.assertTrue(customerController.getCustomerList() != null);
    }
}