package com.sheva.util;

import com.sheva.domain.Customer;
import com.sheva.domain.Operator;

import java.util.concurrent.BlockingQueue;

public class CallCenterProcesses {

    public static void operatorsStartWork(BlockingQueue<String> queue, int count, String signal) {

        for (int i = 0; i < count; i++) {

            int operatorNumber = i + 1;
            Thread operator = new Thread(new Operator(queue, signal, InfoGeneration.nameGenerator(), operatorNumber));
            operator.start();
            System.out.println("Operator number " + operatorNumber + " started working");
        }

    }

    public static void theEndOfWorkingDay(BlockingQueue<String> queue, int count, String signal) {

        for (int i = 0; i < count; i++) {

            Thread signalThread = new Thread(new Customer(queue, signal));
            signalThread.start();
        }
    }
}
