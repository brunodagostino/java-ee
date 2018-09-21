/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dagostinobrunoserver;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

/**
 *
 * @author snowden
 */
@Singleton
@Startup
@DataSourceDefinition(
    className = "org.apache.derby.jdbc.ClientDataSource",
    name = "java:global/jdbc/EsameDS",
    user = "app",
    password = "app",
    databaseName = "EsameDB",
    properties = {"connectionAttributes=;create=true"}
)
public class DatabasePopulator {
    @Inject
    private CourseEJB courseEJB;
    private Course course1;
    private Course course2;
    private Course course3;
    private Course course4;
    
    @PostConstruct
    private void populateDB() {
        course1 = new Course("Cloud Computing", "Programmazione Concorrente Parallela e su Cloud", "Scarano", "Fondamentale", 9, 72, "Primo");
        course2 = new Course("Cloud Computing", "Reti Geografiche", "Malandrino", "Fondamentale", 9, 72, "Primo");
        course3 = new Course("Cloud Computing", "Architetture Distribuite per il Cloud", "Negro", "Fondamentale", 9, 72, "Secondo");
        course4 = new Course("Internet of Things", "Serverless Computing for IoT", "Scarano", "Caratterizzante", 9, 45, "Secondo");
        
        courseEJB.createCourse(course1);
        courseEJB.createCourse(course2);
        courseEJB.createCourse(course3);
        courseEJB.createCourse(course4);
    }
    
    @PreDestroy
    private void clearDB() {
        courseEJB.deleteCourse(course1);
        courseEJB.deleteCourse(course2);
        courseEJB.deleteCourse(course3);
        courseEJB.deleteCourse(course4);
    }
}