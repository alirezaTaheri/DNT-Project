package dnt.com.dnt.activities;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;



public abstract class AbstractActivity extends AppCompatActivity {

    private boolean isContentSet = false;

    abstract @LayoutRes
    protected Integer getContentView();

    abstract @IdRes
    protected Integer getRootView();

    @Override
    public void setContentView(View view) {
        if(!isContentSet) {
            isContentSet = true;
            super.setContentView(view);
        }
    }

    @Override
    public void setContentView(int layoutResID) {
        if(!isContentSet) {
            isContentSet = true;
            super.setContentView(layoutResID);
        }
    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        if(!isContentSet) {
            isContentSet = true;
            super.setContentView(view, params);
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(!isContentSet){
            if(getContentView()!=null) setContentView(getContentView());
            else return;
        }

//        if(getRootView()!=null)
//            TypefaceUtil.setFont((ViewGroup) findViewById(getRootView()));
    }
}
