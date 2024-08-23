package esoft.order.model;

import esoft.com.model.Address;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Order {
    private final Date date;
    private final Address billingAddress;
    private final Address shippingAddress;
    private final CCTransaction ccTransaction;
    private final Customer customer;
    private OrderState status; // Atributo mutável
    private final double subtotal;
    private final double tax;
    private final double total;
    private final List<OrderLine> lines;

    // Construtor
    public Order(Date date, Address billingAddress, Address shippingAddress, CCTransaction ccTransaction,
                 Customer customer, OrderState status, double subtotal, double tax, double total,
                 List<OrderLine> lines) {
        // Validações
        validateNotNull(date, "Date");
        validateNotNull(billingAddress, "Billing Address");
        validateNotNull(shippingAddress, "Shipping Address");
        validateNotNull(ccTransaction, "Credit Card Transaction");
        validateNotNull(customer, "Customer");
        validatePositive(subtotal, "Subtotal");
        validatePositive(tax, "Tax");
        validatePositive(total, "Total");
        validateNotEmpty(lines, "Order Lines");

        this.date = new Date(date.getTime()); // Imutabilidade
        this.billingAddress = billingAddress;
        this.shippingAddress = shippingAddress;
        this.ccTransaction = ccTransaction;
        this.customer = customer;
        this.status = status;  // Inicialmente definida
        this.subtotal = subtotal;
        this.tax = tax;
        this.total = total;
        this.lines = Collections.unmodifiableList(lines); // Lista imutável
    }

    // Métodos de Validação
    private void validateNotNull(Object obj, String fieldName) {
        if (obj == null) {
            throw new IllegalArgumentException(fieldName + " cannot be null");
        }
    }

    private void validatePositive(double value, String fieldName) {
        if (value < 0) {
            throw new IllegalArgumentException(fieldName + " must be positive");
        }
    }

    private void validateNotEmpty(List<?> list, String fieldName) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException(fieldName + " cannot be null or empty");
        }
    }

    // Getters
    public Date getDate() {
        return new Date(date.getTime()); // Retorna uma cópia para preservar a imutabilidade
    }

    public Address getBillingAddress() {
        return billingAddress;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public CCTransaction getCcTransaction() {
        return ccTransaction;
    }

    public Customer getCustomer() {
        return customer;
    }

    public OrderState getStatus() {
        return status;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public double getTax() {
        return tax;
    }

    public double getTotal() {
        return total;
    }

    public List<OrderLine> getLines() {
        return lines;
    }

    // Método para atualizar o status, o único campo mutável
    public void updateStatus(OrderState newStatus) {
        this.status = newStatus;
    }
}
