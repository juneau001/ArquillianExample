/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.javamagazine.arquillianexample.cdi;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import org.javamagazine.arquillianexample.entity.Pool;
import org.javamagazine.arquillianexample.session.PoolFacade;

/**
 *
 * @author Juneau
 */
@Named
@RequestScoped
public class PoolController {
    @EJB
    PoolFacade poolFacade;
    
    private List<Pool> poolList;
    
    private Pool current;
    
    @PostConstruct
    public void init(){
        poolList = new ArrayList();
        
        Pool pool = new Pool();
        pool.setId(1);
        pool.setGallons(new Double(25000));
        pool.setLength(new Double(32));
        pool.setWidth(new Double(16));
        pool.setShape("RECTANGLE");
        
        poolList.add(pool);
        
        pool = new Pool();
        pool.setId(2);
        pool.setGallons(new Double(15000));
        pool.setRadius(new Double(24));
        pool.setShape("CIRCLE");
        
        poolList.add(pool);
    }
    
    public void create(){
        
    }
    
    public Pool getCurrent(){
        if(current == null){
            current = new Pool();
        }
        return current;
    }
    
    public void setPool(Pool current){
        this.current = current;
    }

    /**
     * @return the PoolList
     */
    public List<Pool> getPoolList() {
        return poolList;
    }

    /**
     * @param poolList the poolList to set
     */
    public void setPoolList(List<Pool> poolList) {
        this.poolList = poolList;
    }
}
