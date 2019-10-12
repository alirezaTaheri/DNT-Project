package dnt.com.dnt.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import dnt.com.dnt.R;
import dnt.com.dnt.fragments.MainFragment;
import dnt.com.dnt.fragments.ProfileFragment;

public class MainActivity extends AbstractActivity {


    BottomNavigationView bottomNavigationView;
    MainFragment mainFragment;
    ProfileFragment profileFragment;

    @Override
    protected Integer getContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected Integer getRootView() {
        return R.id.parentLayout;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // No Need to setContentView()

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.action_invest);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                switch (menuItem.getItemId()){
                    case R.id.action_invest:
                        ft.replace(R.id.parentLayout, mainFragment);
                        ft.commit();
                        return true;
                    case R.id.action_browse:
                        return false;
                    case R.id.action_profile:
                        ft.replace(R.id.parentLayout, profileFragment);
                        ft.commit();
                        return true;
                }
                return false;
            }
        });

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        mainFragment = MainFragment.newInstance();
        profileFragment = ProfileFragment.newInstance();
        ft.add(R.id.parentLayout, mainFragment);
        ft.commit();
    }

}
