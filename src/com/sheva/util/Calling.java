package com.sheva.util;

import java.util.Random;

public class Calling {

    public static void callTime(){

        // This method simulates a call time from 1 to 5 minutes.

        try{
            int minValue = 1000;
            int maxValue = 5000;

            int time = new Random().nextInt(minValue, maxValue);
            Thread.sleep(time);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

}
