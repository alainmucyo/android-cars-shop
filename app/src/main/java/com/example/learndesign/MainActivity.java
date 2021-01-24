package com.example.learndesign;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Animation topAnim, bottomAnim;
    TextView logoText, logoSlogan;
    ImageView logoImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final int SPLASH_SCREEN_DURATION = 3000;

        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);

        logoText = findViewById(R.id.logo_text);
        logoSlogan = findViewById(R.id.logo_slogan);
        logoImage = findViewById(R.id.logo_image);

        logoImage.setAnimation(topAnim);
        logoText.setAnimation(bottomAnim);
        logoSlogan.setAnimation(bottomAnim);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, Login.class);
                Pair[] pairs = new Pair[2];
                pairs[0] = new Pair<View, String>(logoImage, "logo_image");
                pairs[1] = new Pair<View, String>(logoText, "logo_text");
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, pairs);
                    startActivity(intent, options.toBundle());
                } else {
                    startActivity(intent);
                }
            }
        }, SPLASH_SCREEN_DURATION);
    }
}