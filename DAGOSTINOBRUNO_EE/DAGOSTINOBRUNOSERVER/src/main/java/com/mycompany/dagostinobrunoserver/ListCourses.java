/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dagostinobrunoserver;

import java.util.List;
import javax.jws.WebService;

/**
 *
 * @author snowden
 */
@WebService
public interface ListCourses {
    public List<Course> getAllCoursesbyName(String name);
}