package org.example;

import org.example.configuration.MyConfig;
import org.example.entity.Employee;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class App {
    public static void main( String[] args ) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

        Communication communication = context.getBean("communication", Communication.class);

      //  List<Employee> allEmpls = communication.getAllEmpls();
      //  System.out.println(allEmpls);

       // Employee emplByID = communication.getEmpl(6);
       // System.out.println("emplByID = " + emplByID);

        Employee em = new Employee("Max", "Paint", "Freelancer", 777);
        em.setId(10);

        //communication.saveEmpl(em);

        communication.deleteEmpl(12);
    }
}
