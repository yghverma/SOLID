package com.solid.principle;

//These program might not execute it is just example

// Software entities (Class, Modules, function) should be open for extension and closed for modification
// OPen for extension - The behavior of a class can be extended or modified without altering its existing code.
// Closed for Modification: Once a class is written and tested, it should not be modified directly to avoid introducing bugs.
//  Imagine you have a class called PaymentProcessor that processes payments for an online store. Initially, the PaymentProcessor class only supports processing payments using credit cards. However, you want to extend its functionality to also support processing payments using PayPal.
public class OpenClosedPrinciple {

}
// Without OCP. so next time you add the new payment method you will have to alter the below code
class PaymentProcessor {
    public void processPayment(String type) {
        if (type.equals("CreditCard")) {
            System.out.println("Processing credit card payment...");
        } else if (type.equals("UPI")) {
            System.out.println("Processing UPI payment...");
        }
    }
}


// With OCP - OCP can be achieve by Abstraction and Polymorphism
// Abstraction either by abstact class or interface will define the behavior 
// Polymorphism - method implemented can have different implementation
//Abstract class or Interface
interface Payment {
 void process();
}

//Implementations
class CreditCardPayment implements Payment {
 public void process() {
     System.out.println("Processing credit card payment...");
 }
}

class UPIPayment implements Payment {
 public void process() {
     System.out.println("Processing UPI payment...");
 }
}

//Usage

class PaymentProcessorOCP {
    public void processPayment(Payment payment) { // Polymorphism: Accepts any Payment type
        payment.process(); // Calls the appropriate process() method
    }
}


//Main
class Main {
 public static void main(String[] args) {
     PaymentProcessorOCP processor = new PaymentProcessorOCP();
     Payment creditCard = new CreditCardPayment();
     Payment upi = new UPIPayment();
     
     processor.processPayment(creditCard);
     processor.processPayment(upi);
 }
}

