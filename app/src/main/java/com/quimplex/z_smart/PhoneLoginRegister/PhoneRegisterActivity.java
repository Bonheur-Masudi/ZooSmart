package com.quimplex.q_shopdrc.PhoneLoginRegister;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.quimplex.q_shopdrc.EmailLoginRegister.EmailLoginActivity;
import com.quimplex.q_shopdrc.EmailLoginRegister.EmailRegisterActivity;
import com.quimplex.q_shopdrc.MainActivity;
import com.quimplex.q_shopdrc.R;

public class PhoneRegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_register);
        //
        /////////////Cacher au /start/ la status Action bar ou bar superieure////////
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //////////status bar hide end/ ////////////////// mettre  android:fitsSystemWindows="true" dans activity//
        // mettre  android:fitsSystemWindows="true" dans activity//
    }

    public void allerLogin(View view) {
        Intent intent=new Intent(PhoneRegisterActivity.this, PhoneLoginActivity.class);
        startActivity(intent);
        Animatoo.animateSlideUp(this);
        finish();
    }
    public void backToMainPage(View view) {
        Intent intent=new Intent(PhoneRegisterActivity.this, MainActivity.class);
        startActivity(intent);
        Animatoo.animateSlideRight(this);
        finish();
    }
}
