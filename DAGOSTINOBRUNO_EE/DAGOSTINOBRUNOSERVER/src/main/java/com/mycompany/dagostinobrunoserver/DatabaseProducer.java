/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dagostinobrunoserver;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author snowden
 */
public class DatabaseProducer {
    @Produces @PersistenceContext(unitName = "EsamePU")
    private EntityManager em;
}