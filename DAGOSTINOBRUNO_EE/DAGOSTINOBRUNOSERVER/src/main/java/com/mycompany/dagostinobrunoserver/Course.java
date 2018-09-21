/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dagostinobrunoserver;

import static com.mycompany.dagostinobrunoserver.Course.FIND_ALL;
import static com.mycompany.dagostinobrunoserver.Course.FIND_CFU;
import static com.mycompany.dagostinobrunoserver.Course.FIND_ID;
import static com.mycompany.dagostinobrunoserver.Course.FIND_NAME;
import static com.mycompany.dagostinobrunoserver.Course.FIND_YEAR;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author snowden
 */
@Entity
@NamedQueries({
    @NamedQuery(name = FIND_ID, query = "SELECT c.id FROM Course c"),
    @NamedQuery(name = FIND_NAME, query = "SELECT c.name FROM Course c"),
    @NamedQuery(name = FIND_CFU, query = "SELECT c.cfu FROM Course c"),
    @NamedQuery(name = FIND_YEAR, query = "SELECT c.academicYear FROM Course c"),
    @NamedQuery(name = FIND_ALL, query = "SELECT c FROM Course c")
})
public class Course implements Serializable {
    public static final String FIND_ID = "Course.findID";
    public static final String FIND_NAME = "Course.findName";
    public static final String FIND_CFU = "Course.findCFU";
    public static final String FIND_YEAR = "Course.findYear";
    public static final String FIND_ALL = "Course.findAll";
    
    @Id @GeneratedValue
    private Integer id;
    private String name;
    private String nominativo;
    private String titolare;
    private String type;
    private Integer cfu;
    private Integer hours;
    private String academicYear;    // Cambiato 'year' con 'academicYear' a causa di conflitti con SQL.

    public Course() {
    }

    public Course(String name, String nominativo, String titolare, String type, Integer cfu, Integer hours, String year) {
        this.name = name;
        this.nominativo = nominativo;
        this.titolare = titolare;
        this.type = type;
        this.cfu = cfu;
        this.hours = hours;
        this.academicYear = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNominativo() {
        return nominativo;
    }

    public void setNominativo(String nominativo) {
        this.nominativo = nominativo;
    }

    public String getTitolare() {
        return titolare;
    }

    public void setTitolare(String titolare) {
        this.titolare = titolare;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getCfu() {
        return cfu;
    }

    public void setCfu(Integer cfu) {
        this.cfu = cfu;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public String getYear() {
        return academicYear;
    }

    public void setYear(String year) {
        this.academicYear = year;
    }
}