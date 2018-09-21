/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dagostinobrunoserver;

import java.util.List;
import java.util.logging.Logger;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author snowden
 */
// Interfaccia per il web service.
@WebService(endpointInterface = "com.mycompany.dagostinobrunoserver.ListCourses")
@Stateless
@LocalBean
public class CourseEJB implements CourseEJBRemote, ListCourses {
    @Inject
    private EntityManager em;
    @Inject
    private Logger logger;
    private int count = 1;  // Si potrebbe costruire una struttura dati in modo
                            // da poter portare il conto anche per altri metodi
                            // e in maniera più efficace ma soprattuto elegante.
    
    @Override
    @Loggable
    public List<Course> getAllCoursesbyType(String name) {  // Non ho cambiato il nome, ma fa quello che deve fare.
        logger.info("Chiamata " + count + " del metodo getAllCoursesbyType()");
        count++;
        
        // Query creata a runtime in modo da accettare input dal client.
        TypedQuery<Course> query = em.createQuery("SELECT c FROM Course c WHERE c.name = '" + name + "'", Course.class);
        
        return query.getResultList();
    }
    
    @Override
    public List<Course> getFondamentale() { // Interfaccia CourseEJBRemote.
        
        // Per ragioni di efficienza si poteva scrivere la query nella classe Course (Entity).
        TypedQuery<Course> query = em.createQuery("SELECT c FROM Course c WHERE c.type = 'Fondamentale'", Course.class);
        
        return query.getResultList();
    }
    
    @Override
    public List<Course> getAllCoursesbyName(String name) {  // Interfaccia ListCourses (WS).
        TypedQuery<Course> query = em.createQuery("SELECT c FROM Course c WHERE c.name = '" + name + "'", Course.class);
        
        return query.getResultList();
    }
    
    public Course createCourse(Course course) { // Metodo utilizzato dal bean singleton.
        em.persist(course);
        
        return course;
    }
    
    public Course updateCourse(Course course) {
        return em.merge(course);
    }
    
    public void deleteCourse(Course course) {   // Metodo utilizzato dal bean singleton.
        em.remove(em.merge(course));
    }
}