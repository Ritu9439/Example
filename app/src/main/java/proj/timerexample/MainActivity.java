package proj.timerexample;

import android.media.Image;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageButton;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    long mLastStopTime;
    Chronometer simpleChronometer;
    TextView breaktime,recordtime;
    ImageButton startbtn,pausebtn;
    Button stopbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         simpleChronometer = (Chronometer) findViewById(R.id.simpleChronometer); // initiate a chronometer
        breaktime = (TextView) findViewById(R.id.breaktime);
        startbtn = (ImageButton) findViewById(R.id.startbtn);
        pausebtn = (ImageButton) findViewById(R.id.pausebtn);
        stopbtn = (Button) findViewById(R.id.stopbtn);
        recordtime = (TextView) findViewById(R.id.recordtime);

pausebtn.setClickable(false);


        startbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    chronoStart();
                    startbtn.setVisibility(View.GONE);
                    pausebtn.setVisibility(View.VISIBLE);
                    pausebtn.setClickable(true);


            }
        });
        pausebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* simpleChronometer.stop();
                long minutes=((SystemClock.elapsedRealtime()-simpleChronometer.getBase())/1000)/60;
                long seconds=((SystemClock.elapsedRealtime()-simpleChronometer.getBase())/1000)%60;
                Log.d("currentTime=",+minutes+":"+seconds);
                //arg0.setText(currentTime);
                //elapsedTime=elapsedTime+1000;

                Log.d("elapsedTime=", String.valueOf(+SystemClock.elapsedRealtime()+1000));*/
               chronoPause();
                startbtn.setVisibility(View.VISIBLE);
                pausebtn.setVisibility(View.GONE);
                pausebtn.setClickable(false);
            }
        });



      //  simpleChronometer.start(); // start a chronometer
    }
public void clickStart(View view){



  /*  chronoStart();*/
}
    public void clickPause(View view) {
        //restart
        chronoPause();
    }


    public void clickStop(View view){

        long minutes=((SystemClock.elapsedRealtime()-simpleChronometer.getBase())/1000)/60;
        long seconds=((SystemClock.elapsedRealtime()-simpleChronometer.getBase())/1000)%60;
        Log.d("currentTime=",+minutes+":"+seconds);

        recordtime.setText(simpleChronometer.getText());
        Log.d("elapsedTime=", String.valueOf(+SystemClock.elapsedRealtime()+1000));
        simpleChronometer.setBase(SystemClock.elapsedRealtime());


    }

    private void chronoPause()
    {
        simpleChronometer.stop();

        mLastStopTime = SystemClock.elapsedRealtime();
    }private void chronoStart()
    {
        // on first start
        if ( mLastStopTime == 0 )
            simpleChronometer.setBase( SystemClock.elapsedRealtime() );
            // on resume after pause
        else
        {
            long intervalOnPause = (SystemClock.elapsedRealtime() - mLastStopTime);

            int minutes = (int) ((intervalOnPause / 1000) / 60);
            int seconds = (int) ((intervalOnPause / 1000) % 60);

            Log.d("pause duration",""+minutes+" :"+seconds);
            breaktime.setText(":"+minutes+"mm:"+seconds+"ss");
            simpleChronometer.setBase( simpleChronometer.getBase() + intervalOnPause );
        }

        simpleChronometer.start();
    }
}
