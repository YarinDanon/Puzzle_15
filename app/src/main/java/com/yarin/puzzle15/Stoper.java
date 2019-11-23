package com.yarin.puzzle15;

import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import android.widget.TextView;

public class Stoper {

    private boolean timeRun;
    private long time;
    private String display;

    Stoper (final TextView txvTime){

        timeRun = true;
        time = 0;
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    SystemClock.sleep(1000);
                    if(timeRun)
                        time ++;
                    String ss, mm;
                    long sec = time % 60;
                    long min = time / 60;
                    if (sec > 9)
                        ss = "" + sec;
                    else
                        ss = "0" + sec;
                    if (min > 9)
                        mm = "" + min;
                    else
                        mm = "0" + min;
                    display = mm + ':' + ss;

                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        @Override
                        public void run() {
                            txvTime.setText("Time: " + display);
                        }
                    });
                }
            }
        }).start();
    }

    public void start(){
        timeRun = true;
    }

    public void pause(){
        timeRun = false;

    }
    public void reset(){
       time = 0;
    }

}
