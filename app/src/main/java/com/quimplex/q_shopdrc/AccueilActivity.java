package com.quimplex.q_shopdrc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.quimplex.q_shopdrc.Fragments.Menu1Fragment;
import com.quimplex.q_shopdrc.Fragments.Menu2Fragment;
import com.quimplex.q_shopdrc.Fragments.Menu3Fragment;
import com.quimplex.q_shopdrc.Fragments.Menu4Fragment;

public class AccueilActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);
        //
        /////////////Cacher au /start/ la status Action bar ou bar superieure////////
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        //////////status bar hide end/ //////////////////
        //
        frameLayout=(FrameLayout)findViewById(R.id.frameLayout);
        bottomNavigationView=(BottomNavigationView)findViewById(R.id.bottomNavigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navigation);

        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new Menu1Fragment()).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navigation=
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                    Fragment fragmentSelectionner=null;
                    switch (item.getItemId()){
                        case R.id.accueil:
                            fragmentSelectionner=new Menu1Fragment();
                             break;

                        case R.id.visite:
                           fragmentSelectionner=new Menu2Fragment();
                            break;

                        case R.id.communaute:
                            fragmentSelectionner=new Menu3Fragment();
                            break;

                        case R.id.inviter:
                            fragmentSelectionner=new Menu4Fragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,fragmentSelectionner).commit();
                    return true;
                }
            };
}
