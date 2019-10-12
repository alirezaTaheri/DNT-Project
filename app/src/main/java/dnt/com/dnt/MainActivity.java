package dnt.com.dnt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.widget.RelativeLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.robinhood.ticker.TickerUtils;
import com.robinhood.ticker.TickerView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    BottomNavigationView bottomNavigationView;
    MainFragment mainFragment;
    ProfileFragment profileFragment;
    BrowseFragment browseFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
                        ft.replace(R.id.parentLayout, browseFragment);
                        ft.commit();
                        return true;
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
        browseFragment = BrowseFragment.newInstance();
        ft.add(R.id.parentLayout, mainFragment);
        ft.commit();
    }

}
