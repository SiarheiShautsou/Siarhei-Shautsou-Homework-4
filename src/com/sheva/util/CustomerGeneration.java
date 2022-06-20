package com.sheva.util;

import com.sheva.domain.Customer;

import java.util.concurrent.BlockingQueue;

import static com.sheva.util.InfoGeneration.generatorID;
import static com.sheva.util.InfoGeneration.nameGenerator;
import static com.sheva.util.InfoGeneration.orderNameGenerator;
import static com.sheva.util.InfoGeneration.orderNumberGenerator;
import static com.sheva.util.InfoGeneration.surnameGenerator;

public class CustomerGeneration {

    public static void customerCallGenerator(BlockingQueue<String> queue, int count) {

        for (int i = 0; i < count; i++) {
            Thread customer = new Thread(new Customer(nameGenerator(), surnameGenerator(), generatorID(), orderNumberGenerator(),
                    orderNameGenerator(), queue));
            customer.start();
        }

    }

}
