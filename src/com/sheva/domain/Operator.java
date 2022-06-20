package com.sheva.domain;

import com.sheva.util.Calling;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;

public class Operator implements Runnable {

    public static final int DEFAULT_OPERATOR_NUMBER = 1;

    BlockingQueue<String> customersQueue = null;

    String signal = null;

    private String operatorName;

    private int operatorNumber;

    public Operator() {
        this.operatorName = "Jane";
        this.operatorNumber = DEFAULT_OPERATOR_NUMBER;
    }

    public Operator(BlockingQueue<String> customersQueue, String signal, String operatorName, int operatorNumber) {
        this.customersQueue = customersQueue;
        this.signal = signal;
        this.operatorName = operatorName;
        this.operatorNumber = operatorNumber;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public int getOperatorNumber() {
        return operatorNumber;
    }

    public void setOperatorNumber(int operatorNumber) {
        this.operatorNumber = operatorNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operator operator = (Operator) o;
        return operatorNumber == operator.operatorNumber && Objects.equals(customersQueue, operator.customersQueue)
                && Objects.equals(signal, operator.signal) && Objects.equals(operatorName, operator.operatorName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customersQueue, signal, operatorName, operatorNumber);
    }

    @Override
    public String toString() {
        return "Operator{" +
                "customersQueue=" + customersQueue +
                ", signal='" + signal + '\'' +
                ", operatorName='" + operatorName + '\'' +
                ", operatorNumber=" + operatorNumber +
                '}';
    }

    @Override
    public void run() {

        try {
            while (true) {
                String customerInfo = this.customersQueue.take();
                if (customerInfo.equals(signal)) {
                    System.out.println("Operator " + this.operatorNumber + " " + this.operatorName + " fished work");
                    return;
                }
                Calling.callTime();
                conversation(customerInfo);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void conversation(String s) {

        String result = s + " is talking with " + this.operatorName + " operator number "
                + this.operatorNumber;
        System.out.println(result);

        //Generation delivery time from 8:00 to 20:00 o'clock
        int time = (int) (Math.random() * 12 + 8);
        System.out.println("Order will deliver today at " + time + " o'clock.");

    }

}
