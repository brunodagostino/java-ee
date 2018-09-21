/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dagostinobrunows;

import java.util.List;

/**
 *
 * @author snowden
 */
public class MainWS {
    public static void main(String[] args) {
        CourseEJBService service = new CourseEJBService();
        ListCourses port = service.getCourseEJBPort();
        
        List<Course> courses = port.getAllCoursesbyName("Cloud Computing");
        for (Course c : courses) {
            System.out.println(c.getNominativo());
        }
    }
}