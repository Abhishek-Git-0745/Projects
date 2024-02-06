package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.widget.ImageView;

public class SplashActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
//        Thread thread = new Thread(){
//            public void run(){
//                try{
//                    sleep(2000);
//                }
//                catch (Exception e){
//                    e.printStackTrace();
//                }
//                finally {
//                    Intent intent = new Intent(SplashActivity.this,MainActivity.class);
//                    startActivity(intent);
//                }
//            }
//        };
//        thread.start();

        // SplashActivity.java
        ImageView imageView = findViewById(R.id.imageView);

        // Load the animation resource
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator animX = ObjectAnimator.ofFloat(imageView, "translationY", 0f, 500f); // Adjust the ending X position
        animX.setDuration(1000); // Duration in milliseconds

        // You can add more animations to the set, such as rotation, alpha, etc.
        // ObjectAnimator animY = ObjectAnimator.ofFloat(imageView, "translationY", 0f, 500f);
        // ObjectAnimator scaleX = ObjectAnimator.ofFloat(imageView, "scaleX", 1f, 2f);
        // ObjectAnimator scaleY = ObjectAnimator.ofFloat(imageView, "scaleY", 1f, 2f);

        animatorSet.playTogether(animX);

        // Start the animation
        animatorSet.start();



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));

                // Finish the current SplashActivity to remove it from the back stack
                finish();
            }
        }, 2000); // Change 2000 to the desired duration in milliseconds (e.g., 2 seconds)

    }
}