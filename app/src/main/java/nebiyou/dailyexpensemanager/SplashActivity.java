package nebiyou.dailyexpensemanager;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

      @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        final Context context = this;
        Thread timerThread = new Thread(){
            public void run(){
                try{
                    sleep(3000);
                }
                catch(InterruptedException e){
                    e.printStackTrace();
                }
                finally{
                    finish();
                    Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
            }
        };
        timerThread.start();
    }
}
