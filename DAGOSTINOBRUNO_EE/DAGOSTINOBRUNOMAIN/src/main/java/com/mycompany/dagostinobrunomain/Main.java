/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dagostinobrunomain;

import com.mycompany.dagostinobrunoserver.Course;
import com.mycompany.dagostinobrunoserver.CourseEJBRemote;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author snowden
 */
public class Main {
    public static void main(String[] args) throws NamingException {
        Context ctx = new InitialContext();
        CourseEJBRemote courseEJB = (CourseEJBRemote) ctx.lookup("java:global/DAGOSTINOBRUNOSERVER-1.0-SNAPSHOT/CourseEJB!com.mycompany.dagostinobrunoserver.CourseEJBRemote");
        
        // Per ragioni sia di sicurezza che per evitare errori, si potrebbe
        // formattare/controllare la stringa.
        List<Course> courses = courseEJB.getAllCoursesbyType("Cloud Computing");
        for (Course c : courses) {
            System.out.println(c.getNominativo());
        }
        
        courses = courseEJB.getFondamentale();
        for (Course c : courses) {
            System.out.println(c.getNominativo());
        }
    }
}