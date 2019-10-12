package dnt.com.dnt.activities;

import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;

import dnt.com.dnt.R;
import dnt.com.dnt.fragments.StockFragment;

public class StockActivity extends AbstractActivity {

    public static final String STOCK_NAME_PARAM = "stock_name";

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

        Intent i = getIntent();
        String stockName = i.getStringExtra(STOCK_NAME_PARAM);

        if(stockName==null) {
            finish();
            return;
        }

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        StockFragment stock_fragment = StockFragment.newInstance();
        ft.replace(getRootView(), stock_fragment);
        ft.commit();
    }
}
