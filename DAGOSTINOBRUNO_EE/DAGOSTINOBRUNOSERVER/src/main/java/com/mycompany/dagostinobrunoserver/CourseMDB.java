/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dagostinobrunoserver;

import java.util.ArrayList;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 *
 * @author snowden
 */
@MessageDriven(mappedName = "jms/javaee7/Topic", activationConfig = {
    @ActivationConfigProperty(propertyName = "acknowledge", propertyValue = "Auto-acknowledge")
})
public class CourseMDB implements MessageListener {
    @Inject
    private CourseEJB courseEJB;
    private ArrayList<Course> courses = new ArrayList<>();
    
    @Override
    public void onMessage(Message message) {
        try {
            Course course = message.getBody(Course.class);
            courses.add(course);
            courseEJB.createCourse(course);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}