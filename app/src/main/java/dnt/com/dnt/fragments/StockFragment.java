package dnt.com.dnt.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.fragment.app.Fragment;

import java.util.Arrays;

import dnt.com.dnt.R;
import dnt.com.dnt.utils.TypefaceUtil;


public class StockFragment extends Fragment {

    public static final String STOCK_NAME_PARAM = "stock_name";
    public static final String DEFAULT_STOCK_NAME = "stock_name";
    public static final String[] SUPPORTED_STOCKS = {"katia","zagros"};

    public StockFragment() {
        // Required empty public constructor
    }

    public static StockFragment newInstance() {
        return newInstance(DEFAULT_STOCK_NAME);
    }
    public static StockFragment newInstance(String stock_name) {
        StockFragment fragment = new StockFragment();
        if(Arrays.binarySearch(SUPPORTED_STOCKS,stock_name)==-1)
            stock_name = DEFAULT_STOCK_NAME ;

        Bundle b = new Bundle();
        b.putString(STOCK_NAME_PARAM,stock_name);

        fragment.setArguments(b);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        String stockName = getArguments()==null?DEFAULT_STOCK_NAME:getArguments().getString(STOCK_NAME_PARAM,DEFAULT_STOCK_NAME);
        @LayoutRes int layout;
        switch (stockName){
            case "katia":{
                layout = R.layout.fragment_stock_katia;
                break;
            }
            case "zagros":{
                layout = R.layout.fragment_stock_zagros;
                break;
            }
            default:{
                layout = R.layout.fragment_stock_katia;
            }
        }
        View v = inflater.inflate(layout, container, false);

        // Change Font For Fragment
        TypefaceUtil.setFont((ViewGroup) v);



        return v;
    }

    private void setGrowth(boolean posetive){

    }


}
