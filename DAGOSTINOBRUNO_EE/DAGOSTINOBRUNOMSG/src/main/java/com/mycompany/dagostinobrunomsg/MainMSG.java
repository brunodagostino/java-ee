/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dagostinobrunomsg;

import com.mycompany.dagostinobrunoserver.Course;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author snowden
 */
public class MainMSG {
    public static void main(String[] args) throws NamingException {
        Course course = new Course("Security", "Python", "Bruno", "Fondamentale", 12, 80, "Secondo");
        
        Context jndiContext = new InitialContext();
        ConnectionFactory connectionFactory = (ConnectionFactory) jndiContext.lookup("jms/javaee7/ConnectionFactory");
        Destination topic = (Destination) jndiContext.lookup("jms/javaee7/Topic");
        
        try (JMSContext jmsContext = connectionFactory.createContext()) {
            jmsContext.createProducer().send(topic, course);
        }
    }
}