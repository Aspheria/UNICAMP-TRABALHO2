package esoft.order.model;

import esoft.abs.model.Product;
import esoft.abs.model.Item;
import esoft.com.model.Address;
import esoft.com.model.Country;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Criação do país
        Country usa = new Country(
            1,              // id
            "USA",          // name
            "USD",          // currency (moeda)
            1.0             // exchange (taxa de câmbio)
        );

        // Criação dos endereços de faturamento e entrega usando o construtor correto de Address
        Address billingAddress = new Address(
            1,                   // id
            "123 Main St",       // street1
            "456 Elm St",        // street2
            "New York",          // city
            "NY",                // state
            "10001",             // zip
            usa,                 // country
            "40.7128° N",        // latitude
            "74.0060° W",        // longitude
            "12A"                // buildingNumber
        );

        Address shippingAddress = new Address(
            2,                   // id
            "789 Oak St",        // street1
            "101 Pine St",       // street2
            "Los Angeles",       // city
            "CA",                // state
            "90001",             // zip
            usa,                 // country
            "34.0522° N",        // latitude
            "118.2437° W",       // longitude
            "34B"                // buildingNumber
        );

        // Criação de um cliente
        Customer customer = new Customer(
            1,                  // ID
            "jdoe",             // Username
            "password123",      // Password
            "John",             // First name
            "Doe",              // Last name
            "555-1234",         // Phone number
            "jdoe@example.com", // Email address
            new Date(),         // Account creation date
            new Date(),         // Last visit date
            new Date(),         // Login date
            new Date(),         // Expiration date
            0.10,               // Discount
            100.00,             // Balance
            150.00,             // Year-to-date payment
            new Date(1990-1900, 0, 1), // Birthdate
            "Additional Info",  // Additional data
            billingAddress      // Address
        );

        // Criação de uma transação com cartão de crédito usando o enum CreditCard
        CreditCard creditCardType = CreditCard.VISA;  // Escolha o tipo de cartão (VISA, MASTERCARD, etc.)
        CCTransaction ccTransaction = new CCTransaction(creditCardType, 0, "Purchase", null, null, 0, null, usa);

        // Criação do item (Product)
        Item item = new Item(0, null); // Supondo que Item tenha um construtor adequado
        Product product = new SimpleProduct(1, 50.00, item, 100, 1);

        // Criação das linhas de pedido usando a classe OrderLine
        List<OrderLine> orderLines = new ArrayList<>();
        OrderLine orderLine = new OrderLine(product, 2); // Exemplo com quantidade 2
        orderLines.add(orderLine);

        // Criação da ordem
        Order order = new Order(
            new Date(),          // Date
            billingAddress,      // Billing Address
            shippingAddress,     // Shipping Address
            ccTransaction,       // Credit Card Transaction
            customer,            // Customer
            OrderState.NEW,      // Estado inicial da ordem
            200.00,              // Subtotal
            10.00,               // Taxa
            210.00,              // Total
            orderLines           // Order Lines
        );

        // Atualizando o status da ordem
        order.updateStatus(OrderState.PAID_OUT);

        // Exibir detalhes da ordem
        System.out.println("Order created for customer: " + customer.getFname() + " " + customer.getLname());
        System.out.println("Order status: " + order.getStatus().getInfo());
    }
}
