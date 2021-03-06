package com.example.learndesign;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

public class Login extends AppCompatActivity {
    Button registerHere, submitBtn;
    TextView logoText, subTitle;
    ImageView logoImage;
    TextInputLayout usernameInput, passwordInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        registerHere = findViewById(R.id.register_link);

        logoText = findViewById(R.id.logo_title);
        logoImage = findViewById(R.id.logo_image);
        subTitle = findViewById(R.id.logo_slogan);
        submitBtn = findViewById(R.id.submit_button);
        usernameInput = findViewById(R.id.username);
        passwordInput = findViewById(R.id.password);
        registerHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, Register.class);
                Pair[] pairs = new Pair[7];
                pairs[0] = new Pair<View, String>(subTitle, "sub_title");
                pairs[1] = new Pair<View, String>(logoText, "logo_text");
                pairs[2] = new Pair<View, String>(logoImage, "logo_image");
                pairs[3] = new Pair<View, String>(submitBtn, "go_button");
                pairs[4] = new Pair<View, String>(usernameInput, "username");
                pairs[5] = new Pair<View, String>(passwordInput, "password");
                pairs[6] = new Pair<View, String>(registerHere, "back_url");

                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(Login.this, pairs);
                    startActivity(intent, options.toBundle());
                } else {
                    startActivity(intent);
                }
            }
        });

    }
}