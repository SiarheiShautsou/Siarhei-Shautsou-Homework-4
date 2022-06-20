package com.sheva.domain;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;

public class Customer implements Runnable {

    public static final int DEFAULT_ID_NUMBER = 100000;

    public static final int DEFAULT_ORDER_NUMBER = 100000;

    BlockingQueue<String> customersQueue = null;

    String signal = null;

    private String customerName;

    private String customerSurname;

    private int idNumber;

    private int orderNumber;

    private String productName;


    public Customer() {
        this.customerName = "Sam";
        this.customerSurname = "Jackson";
        this.idNumber = DEFAULT_ID_NUMBER;
        this.orderNumber = DEFAULT_ORDER_NUMBER;
        this.productName = "TV";
    }

    public Customer(String customerName, String customerSurname, int idNumber, int orderNumber, String productName,
                    BlockingQueue<String> customersQueue) {
        this.customerName = customerName;
        this.customerSurname = customerSurname;
        this.idNumber = idNumber;
        this.orderNumber = orderNumber;
        this.productName = productName;
        this.customersQueue = customersQueue;
    }

    public Customer(BlockingQueue<String> customersQueue, String poison) {
        this.customersQueue = customersQueue;
        signal = poison;
    }


    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerSurname() {
        return customerSurname;
    }

    public void setCustomerSurname(String customerSurname) {
        this.customerSurname = customerSurname;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return idNumber == customer.idNumber && orderNumber == customer.orderNumber && Objects.equals(customerName, customer.customerName) && Objects.equals(customerSurname, customer.customerSurname) && Objects.equals(productName, customer.productName) && Objects.equals(customersQueue, customer.customersQueue) && Objects.equals(signal, customer.signal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerName, customerSurname, idNumber, orderNumber, productName, customersQueue, signal);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerName='" + customerName + '\'' +
                ", customerSurname='" + customerSurname + '\'' +
                ", idNumber=" + idNumber +
                ", orderNumber=" + orderNumber +
                ", productName='" + productName + '\'' +
                '}';
    }

    @Override
    public void run() {

        try {

            this.customersQueue.put(Objects.requireNonNullElseGet(signal, () -> "Customer " + this.customerName + " " +
                    this.customerSurname + " ID " + this.idNumber + " has order number " + this.orderNumber + " " + this.productName));

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
