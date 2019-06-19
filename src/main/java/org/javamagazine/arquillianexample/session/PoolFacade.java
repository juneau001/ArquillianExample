/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.javamagazine.arquillianexample.session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.javamagazine.arquillianexample.entity.Pool;

/**
 *
 * @author Juneau
 */
@Stateless
public class PoolFacade extends AbstractFacade<Pool> {

    @PersistenceContext(unitName = "org.javamagazine_ArquillianExample_war_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PoolFacade() {
        super(Pool.class);
    }
    
}
