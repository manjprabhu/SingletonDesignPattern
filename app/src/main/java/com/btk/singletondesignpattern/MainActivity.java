package com.btk.singletondesignpattern;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createThread();
            }
        });
    }

    private void createThread() {
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                Account account = Account.getInstance();
                Log.v(TAG,"=== Thread one:"+account.hashCode());
            }
        });

        threadOne.start();


        Thread threadTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                Account account = Account.getInstance();
                Log.v(TAG,"=== Thread two:"+account.hashCode());
            }
        });

        threadTwo.start();
    }
}
