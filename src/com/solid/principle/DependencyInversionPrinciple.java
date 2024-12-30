package com.solid.principle;

//These program might not execute it is just example

// High-level modules should not depend on low-level modules. Both should depend on abstractions (e.g., interfaces).
// Abstractions should not depend on details. Details should depend on abstractions.




// LSP is about correct inheritance, ensuring that derived classes can be used in place of base classes without altering expected behavior.
// DIP is about decoupling between high-level and low-level modules by introducing abstractions, which makes your code more flexible and maintainable.
// In a software development team, developers depend on an abstract version control system (e.g., Git) to manage and track changes to the codebase. They don’t depend on specific details of how Git works internally. 
public class DependencyInversionPrinciple {
}

// without DIP
//PaymentProcessor is tightly coupled to CreditCardPayment. If we need to add another payment method like PayPal, we would have to modify PaymentProcessor.
class CreditCardPaymentWithoutDIP {
    public void processPayment(double amount) {
        System.out.println("Processing Credit Card payment of $" + amount);
    }
}

class PaymentProcessorWithoutDIP {
    private CreditCardPaymentWithoutDIP creditCardPayment;

    public PaymentProcessorWithoutDIP() {
        this.creditCardPayment = new CreditCardPaymentWithoutDIP(); // Tightly coupled to CreditCardPayment
    }

    public void process(double amount) {
        creditCardPayment.processPayment(amount);
    }
}

class MainWithoutDIP {
    public static void main(String[] args) {
	PaymentProcessorWithoutDIP paymentProcessor = new PaymentProcessorWithoutDIP();
        paymentProcessor.process(100.0);
    }
}



// With DIP
interface PaymentMethod {
    void processPayment(double amount);
}


class CreditCardPaymentWithDIP implements PaymentMethod {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing Credit Card payment of $" + amount);
    }
}

class PayPalPaymentWithDIP implements PaymentMethod {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing PayPal payment of $" + amount);
    }
}

class PaymentProcessorWithDIP {
    private PaymentMethod paymentMethod;

    // Now PaymentProcessor depends on the abstraction (PaymentMethod), not a concrete class
    public PaymentProcessorWithDIP(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void process(double amount) {
        paymentMethod.processPayment(amount);
    }
}

 class MainWithDIP {
    public static void main(String[] args) {
        PaymentMethod creditCard = new CreditCardPaymentWithDIP();
        PaymentProcessorWithDIP paymentProcessor = new PaymentProcessorWithDIP(creditCard);
        paymentProcessor.process(100.0);

        PaymentMethod paypal = new PayPalPaymentWithDIP();
        PaymentProcessorWithDIP paymentProcessor2 = new PaymentProcessorWithDIP(paypal);
        paymentProcessor2.process(150.0);
    }
}
