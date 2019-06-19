/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.javamagazine.arquillianexample.cdi;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.inject.Inject;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 * @author Juneau
 */
@RunWith(Arquillian.class)
public class PoolControllerTest {
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class, "PoolControllerTest.jar")
                .addClass(org.javamagazine.arquillianexample.cdi.PoolController.class)
                .addClass(org.javamagazine.arquillianexample.entity.Pool.class)
                .addClass(org.javamagazine.arquillianexample.session.PoolFacade.class)
                .addClass(org.javamagazine.arquillianexample.session.AbstractFacade.class)
                .addAsResource("test-persistence.xml", "META-INF/persistence.xml")
                .addAsManifestResource(EmptyAsset.INSTANCE,"beans.xml");
    }
    
    @Inject
    PoolController poolController;
    
    @Test
    public void pool_list_populated() {
        Assert.assertEquals(2, poolController.getPoolList().size());
    }
}
