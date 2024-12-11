package za.hp.cwengandudula;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;

public class Splash extends AppCompatActivity {
    private int progressStatus = 0;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ProgressBar progressBar = findViewById(R.id.progressBar);


        new Thread(new Runnable() {
            @Override
            public void run() {
                while (progressStatus < 100) {
                    progressStatus += 2;
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            progressBar.setProgress(progressStatus);
                        }
                    });
                    try {
                        Thread.sleep(50); // Delay to simulate load time
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // Once loading is complete, launch MainActivity
                Intent intent = new Intent(Splash.this, MainActivity.class);
                startActivity(intent);
            }
        }).start();
    }


}