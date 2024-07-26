package com.rabiayigit.runnablehandler;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Runnable runnable;
    Handler handler;
    Button button;
    int number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        textView=findViewById(R.id.textView);
        button=findViewById(R.id.button);
        number=0;

    }

    public void start(View view){

        handler= new Handler();

        runnable=new Runnable() {
            @Override
            public void run() {
                textView.setText("Time: "+number);
                number++;
                textView.setText("Time "+ number);
                handler.postDelayed(runnable,1000);

            }
        };
        handler.post(runnable);
        button.setEnabled(false);
    }

    public void stop(View view){
        button.setEnabled(true);
        handler.removeCallbacks(runnable);
        number=0;
        textView.setText("Time: "+number);

    }
}