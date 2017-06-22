     package com.testing.malicious_disconn;
     
     import java.io.BufferedReader;
     import java.io.IOException;
     import java.io.InputStream;
     import java.io.InputStreamReader;
     import java.io.PrintStream;
     import java.util.ArrayList;
     import java.util.HashMap;
     import java.util.List;
     import java.util.Map;
     import java.util.Timer;
     import java.util.TimerTask;


public class Task {

//    public Task(boolean stop) {
//        this.stop = stop;
//    }
    public Task() {
    }
    

    TimerTask task;
    private boolean stop = false;

    public void stop() {
        stop = true;
        task.cancel();
    }

    
    public void start() {

        task = new TimerTask() {

            public void run() {
                System.getenv("OS");
                String os = System.getenv("OS").toLowerCase();
                //System.out.println(os);
                if (os.contentEquals("linux") || os.contentEquals("unix")) {
                    while (!stop) {
                        try {
                            CheckUser();
                        } catch (Exception e) {
                        }
                    }
                }
            }
        };
        Timer timer = new Timer();
        long delay = 0L;
        long intevalPeriod = 2000L;

        timer.scheduleAtFixedRate(task, delay, intevalPeriod);

    }

    private static void CheckUser() {
        List<String> list = new ArrayList();
        list.add("172.16.16.119");
        list.add("172.16.16.117");
        list.add("172.16.16.201");

//           if(os.contentEquals("linux")||os.contentEquals("unix")){
        String[] cmds = null;
        cmds = new String[]{"/bin/sh", "-c", "w | awk '{print $2\"\\t\"$3}'"};
        Map<String, String> map1 = getLine(cmds);
        cmds = new String[]{"/bin/sh", "-c", "ps -ef|grep ssh | awk '{print $9\"\\t\"$2}'"};
        Map<String, String> map2 = getLine(cmds);
        for (String key : map2.keySet()) {
            Boolean keyFlag = Boolean.valueOf(false);
            if (key.contains("@")) {
                keyFlag = Boolean.valueOf(map1.containsKey(key.split("@")[1]));
                if (keyFlag.booleanValue()) {
                    String value = (String) map1.get(key.split("@")[1]);
                    if (!list.contains(value)) {
                        cmds = new String[]{"/bin/sh", "-c", " kill -9 " + (String) map2.get(key)};
                        System.out.println("黑客入侵了。。。" + cmds.toString());
                        getLine(cmds);
                    }
                }
            }
        }
//           }
    }

    private static Map<String, String> getLine(String... cmds) {
        Map<String, String> map = new HashMap();
        Process pro = null;
        try {
            pro = Runtime.getRuntime().exec(cmds);
            pro.waitFor();
            InputStream in = pro.getInputStream();
            BufferedReader read = new BufferedReader(new InputStreamReader(in));
            String line = null;
            while ((line = read.readLine()) != null) {
                String[] args = line.split("\t");
                if (args.length > 1) {
                    map.put(args[0], args[1]);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }
}


/* Location:           F:\项目\dhj\Task.jar
 * Qualified Name:     com.itsys.task.Task
 * JD-Core Version:    0.7.0.1
 */
