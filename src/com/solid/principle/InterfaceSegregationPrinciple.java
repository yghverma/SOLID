package com.solid.principle;

// These program might not execute it is just example

// Clients should not be forced to depend on interfaces they do not use.
// An interface should only have the methods that are relevant to the specific implementing class.
// Suppose if you enter a restaurant and you are pure vegetarian. The waiter in that restaurant gave you the menu card which includes vegetarian items, non-vegetarian items, drinks, and sweets. 
public class InterfaceSegregationPrinciple {
}

// without ISP
//Here, the Developer class is forced to implement the eat() method even though it's not relevant, violating ISP.
interface Worker {
    void work();
    void eat();
}

class Developer implements Worker {
    @Override
    public void work() {
        System.out.println("Developer is working.");
    }

    @Override
    public void eat() { // Irrelevant for a Developer class
        throw new UnsupportedOperationException("Developer doesn't need this method.");
    }
}

// with ISP
//Now, the Developer class implements only what it needs (Workable), while OfficeStaff uses both Workable and Eatable, adhering to ISP.
interface Workable {
    void work();
}

interface Eatable {
    void eat();
}

class Developer1 implements Workable {
    @Override
    public void work() {
        System.out.println("Developer is working.");
    }
}

class OfficeStaff implements Workable, Eatable {
    @Override
    public void work() {
        System.out.println("Office staff is working.");
    }

    @Override
    public void eat() {
        System.out.println("Office staff is eating.");
    }
}
