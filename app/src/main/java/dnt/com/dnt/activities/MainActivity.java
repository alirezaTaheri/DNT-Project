package dnt.com.dnt.activities;

import android.os.Bundle;

import dnt.com.dnt.R;

public class MainActivity extends AbstractActivity {

    @Override
    protected Integer getContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected Integer getRootView() {
        return R.id.main_rootlay;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // * No need to setContentView()

    }
}
