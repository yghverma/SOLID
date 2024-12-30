package com.solid.principle;

// These program might not execute it is just example

// child objects must adhere to the behavior and expectations defined by their parent class.
// A parent class reference can hold an object of a child class without altering the expected behavior.
// Eg - LSP says: Anywhere you can use a parent class (Payment), you should also be able to use any of its child classes (CreditCardPayment, PayPalPayment, etc.) without breaking the program.
// One of the classic examples of this principle is a rectangle having four sides. A rectangle’s height can be any value and width can be any value. A square is a rectangle with equal width and height. So we can say that we can extend the properties of the rectangle class into square class. 
public class LiskovSubstitutionPrinciple {
}

// without LSP
class PaymentWithoutLSP {
    void processPayment(double amount) {
        System.out.println("Processing payment of $" + amount);
    }
}

class CreditCardPaymentWithoutLSP extends PaymentWithoutLSP {
    @Override
    void processPayment(double amount) {
        System.out.println("Processing credit card payment of $" + amount);
    }
}
//Here, BankTransferPayment breaks the substitution principle because it does not behave as expected from a Payment.
class BankTransferPaymentWithouLSP extends PaymentWithoutLSP {
    @Override
    void processPayment(double amount) {
        throw new UnsupportedOperationException("Bank transfers are not supported yet!");
    }
}

// Main program
 class MainWithoutLSP {
    public static void main(String[] args) {
	PaymentWithoutLSP payment = new BankTransferPaymentWithouLSP();
        payment.processPayment(100.0); // Throws exception: Violates LSP
    }
}
 
 
 
 
// With LSP
 
//Define a common interface
interface PaymentLSP {
  void processPayment(double amount);
}

//Implement payment methods
class CreditCardPaymentLSP implements PaymentLSP {
  @Override
  public void processPayment(double amount) {
      System.out.println("Processing credit card payment of $" + amount);
  }
}

class PayPalPayment implements PaymentLSP {
  @Override
  public void processPayment(double amount) {
      System.out.println("Processing PayPal payment of $" + amount);
  }
}

//Add a new type that doesn't break behavior
class BankTransferPaymentLSP implements PaymentLSP {
  @Override
  public void processPayment(double amount) {
      System.out.println("Processing bank transfer payment of $" + amount);
  }
}

//Main program
class MainLSP {
  public static void mainlsp(String[] args) {
      PaymentLSP payment1 = new CreditCardPaymentLSP();
      payment1.processPayment(150.0); // Works as expected

      PaymentLSP payment2 = new BankTransferPaymentLSP();
      payment2.processPayment(200.0); // Works as expected

      PaymentLSP payment3 = new PayPalPayment();
      payment3.processPayment(300.0); // Works as expected
  }
}

