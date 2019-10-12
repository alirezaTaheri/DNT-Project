package dnt.com.dnt.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;

import dnt.com.dnt.R;
import dnt.com.dnt.fragments.MainFragment;
import dnt.com.dnt.fragments.ProfileFragment;
import dnt.com.dnt.fragments.StockFragment;

public class StockActivity extends AbstractActivity {

    @Override
    protected Integer getContentView() {
        return R.layout.activity_stock;
    }

    @Override
    protected Integer getRootView() {
        return R.id.stock_rootlay;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        StockFragment stock_fragment = StockFragment.newInstance();
        ft.replace(getRootView(), stock_fragment);
        ft.commit();
    }
}
