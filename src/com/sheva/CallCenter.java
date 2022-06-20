package com.sheva;

import com.sheva.util.CallCenterProcesses;
import com.sheva.util.CustomerGeneration;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class CallCenter {
    public static void main(String[] args) {

        System.out.println("Call center started working.");

        /* Call center's queue is created.
         * @callCenterQueueCapacity is a max number customers in one day.
         * */
        int callCenterQueueCapacity = 100;
        BlockingQueue<String> customersQueue = new ArrayBlockingQueue<>(callCenterQueueCapacity);

        /* Customers start calling.
         * @customersNumber is a number of customers callings.
         * */
        int customersNumber = 30;
        CustomerGeneration.customerCallGenerator(customersQueue, customersNumber);

        /* Operators start working.
         * @operatorsNumber is a number of operators in the call center.
         * */
        int operatorsNumber = 4;
        String endSignal = "Working day finishes at 6 o'clock";
        CallCenterProcesses.operatorsStartWork(customersQueue, operatorsNumber, endSignal);
        CallCenterProcesses.theEndOfWorkingDay(customersQueue, operatorsNumber, endSignal);


    }

}
