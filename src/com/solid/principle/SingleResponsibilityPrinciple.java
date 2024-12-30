package com.solid.principle;

// SOLID Principle - The SOLID principles are five design principles in object-oriented programming aimed 
// at creating more maintainable, scalable, and robust software systems.


// These program might not execute it is just example

// Class should have a single reason to change
// It should have one responsibility or focus
//Separation of Concerns: Each class has a single, well-defined responsibility.

// Imagine a baker who is responsible for baking bread. The baker’s role is to focus on the task of baking bread, ensuring that the bread is of high quality, properly baked, and meets the bakery’s standards.
public class SingleResponsibilityPrinciple {
}

// Eg. Different class for PayRollService and saving data to Db which will focus on just one thing
class Employee {
    private String name;
    private String salary;
    // Getters and Setters
}

// Pay Roll Service
class PayRollService {
    public void calculatePay(Employee e ) {
	System.out.println("For Calcultion we have different class");
    }
}

// Persist employee data
class EmployeeRepository {
    void saveToDatabase(Employee employee) {
	System.out.println("Saving employee to database...");
    }
}