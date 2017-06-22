package com.testing.malicious_disconn;

import java.util.Timer;
import java.util.TimerTask;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;


public class Activator implements BundleActivator {

    //private boolean stop = false;
    Task tk=new Task();

    public void start(BundleContext context) throws Exception {
        System.out.println("Bundle started");
        tk.start();

//        stop = false;
//
////          Timer timer = new Timer();
/////* 19 */     long delay = 0L;
/////* 20 */     long intevalPeriod = 2000L;
/////*    */     
/////* 22 */     timer.scheduleAtFixedRate(task, delay, intevalPeriod);
////        new Thread (new Runnable()
////      {
//        TimerTask task = new TimerTask() {
//            public void run() {
//
//                while (!stop) {
//                    try {
//
//                       // Task.CheckUser();
//                    } catch (Exception e) {
//                    }
//                }
//
//            }
//        };
//        Timer timer = new Timer();
//        long delay = 0L;
//        long intevalPeriod = 2000L;
//
//        timer.scheduleAtFixedRate(task, delay, intevalPeriod);
////      }).start();
    }

    public void stop(BundleContext context) throws Exception {
        System.out.println("Bundle stopped");
        //stop = true;
        tk.stop();
    }
}
