package com.quimplex.q_shopdrc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.quimplex.q_shopdrc.Adapters.PresentationAdaptater;
import com.quimplex.q_shopdrc.EmailLoginRegister.EmailLoginActivity;
import com.quimplex.q_shopdrc.EmailLoginRegister.EmailRegisterActivity;
import com.quimplex.q_shopdrc.Models.PresentationModel;
import com.quimplex.q_shopdrc.PhoneLoginRegister.PhoneLoginActivity;
import com.quimplex.q_shopdrc.UpdateApp.AppUpdateChecker;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<PresentationModel> presentationModelList;
    private PresentationAdaptater presentationAdaptater;
    private LinearLayout phonebtn;
    private LinearLayout emailbtn;
    private Button skip;
    //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Test de mise à jour de l'appli
        try {
            AppUpdateChecker appUpdateChecker=new AppUpdateChecker(this);
            appUpdateChecker.checkForUpdate(false);
        }catch (Exception e){
            e.printStackTrace();
        }

        //
        /////////////Cacher au /start/ la status Action bar ou bar superieure////////
       getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //////////status bar hide end/ ////////////////// mettre  android:fitsSystemWindows="true" dans activity//
        //
        emailbtn=(LinearLayout)findViewById(R.id.lineaire2);
        phonebtn=(LinearLayout)findViewById(R.id.lineaire1);
        skip=(Button)findViewById(R.id.buttonSkip);
        recyclerView=(RecyclerView)findViewById(R.id.recyclerView);
        //
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        //
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setKeepScreenOn(true);
        recyclerView.setHasFixedSize(true);
        //
        presentationModelList=new ArrayList<>();
        presentationModelList.add(new PresentationModel(R.mipmap.image_gorille));
        presentationModelList.add(new PresentationModel(R.mipmap.image_incognito));
        presentationModelList.add(new PresentationModel(R.mipmap.image_leopard));
        presentationModelList.add(new PresentationModel(R.mipmap.image_lion));
        presentationModelList.add(new PresentationModel(R.mipmap.image_ntaba));
        presentationModelList.add(new PresentationModel(R.mipmap.image_paon));
        //
        presentationAdaptater=new PresentationAdaptater(presentationModelList,this);
        recyclerView.setAdapter(presentationAdaptater);
        presentationAdaptater.notifyDataSetChanged();

        ////appel à la methode autoscroll///
        autoScroll();
        //////end call///////////
        /// ouverture de l'activité mail ////
        emailbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(MainActivity.this, EmailLoginActivity.class);
                    startActivity(intent);
                    Animatoo.animateSlideDown(MainActivity.this);
                }
            });
        //// fin ouverture ////
        /// ouverture de l'activité phone ////
        phonebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, PhoneLoginActivity.class);
                startActivity(intent);
                Animatoo.animateSlideDown(MainActivity.this);
            }
        });
        //// fin ouverture ////
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, AccueilActivity.class);
                startActivity(intent);
                Animatoo.animateSwipeLeft(MainActivity.this);
            }
        });
        //// fin ouverture ////
    }

    //auto scroll des images ///
    public void autoScroll(){
        final int speedScroll=2;
        final Handler handler=new Handler();
        final Runnable runnable=new Runnable() {
           int count=0;
            @Override
            public void run() {
                if(count==presentationAdaptater.getItemCount())
                    count=0;
                if(count<presentationAdaptater.getItemCount()){
                    recyclerView.smoothScrollToPosition(++count);
                    handler.postDelayed(this,speedScroll);

                }
            }
        };
        handler.postDelayed(runnable,speedScroll);
    }

}
