package com.quimplex.q_shopdrc.EmailLoginRegister;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.quimplex.q_shopdrc.MainActivity;
import com.quimplex.q_shopdrc.R;

public class EmailLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_login);
        //
        /////////////Cacher au /start/ la status Action bar ou bar superieure////////
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //////////status bar hide end/ ////////////////// mettre  android:fitsSystemWindows="true" dans activity//
        //////////status bar hide end/ ////////////////// mettre  android:fitsSystemWindows="true" dans activity//
    }

    public void redirectRegister(View view) {
        Intent intent=new Intent(EmailLoginActivity.this,EmailRegisterActivity.class);
        startActivity(intent);
        Animatoo.animateSwipeLeft(this);
        finish();
    }
    public void backToMainPage(View view) {
        Intent intent=new Intent(EmailLoginActivity.this,MainActivity.class);
        startActivity(intent);
        Animatoo.animateSlideRight(this);
        finish();
    }
}
