package dnt.com.dnt.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import androidx.annotation.LayoutRes;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;

import java.util.Arrays;

import dnt.com.dnt.R;
import dnt.com.dnt.utils.FaNum;
import dnt.com.dnt.utils.TypefaceUtil;


public class StockFragment extends Fragment {

    public static final String STOCK_NAME_PARAM = "stock_name";
    public static final String DEFAULT_STOCK_NAME = "stock_name";
    public static final String[] SUPPORTED_STOCKS = {"katia","zagros"};

    public StockFragment() {
        // Required empty public constructor
    }

//    public static StockFragment newInstance() {
//        return newInstance(DEFAULT_STOCK_NAME);
//    }
    public static StockFragment newInstance(String stock_name) {
        StockFragment fragment = new StockFragment();
//        if(Arrays.binarySearch(SUPPORTED_STOCKS,stock_name)==-1)
//            stock_name = DEFAULT_STOCK_NAME ;

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

    TextView t2, t3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.e(">>>>>>>>>>", "katia: " + getArguments());

        String stockName = getArguments()==null?DEFAULT_STOCK_NAME:getArguments().getString(STOCK_NAME_PARAM,DEFAULT_STOCK_NAME);
        Log.e(">>>>>>>>>>", ">?>?>>?>?>: " + stockName);
        @LayoutRes int layout;
        switch (stockName){
            case "katia":{
                Log.e(">>>>>>>>>>", "katia: " + stockName);
                layout = R.layout.fragment_stock_katia;
                break;
            }
            case "zagros":{
                Log.e(">>>>>>>>>>", "zagros: " + stockName);
                layout = R.layout.fragment_stock_zagros;
                break;
            }
            default:{
                layout = R.layout.fragment_stock_zagros;
            }
        }
        View v = inflater.inflate(layout, container, false);
        t2 = v.findViewById(R.id.f_stock_tv_const_value);
        t3 = v.findViewById(R.id.t3);

        // Change Font For Fragment
        TypefaceUtil.setFont((ViewGroup) v);
        switch (stockName){
            case "katia":{
                t2.setText(FaNum.convert("13,691"));
                t3.setText(FaNum.convert("231 ریال"));
                Glide.with(getContext()).load(R.drawable.katia_statics).into((AppCompatImageView)v.findViewById(R.id.f_stock_img_statics));
                Glide.with(getContext()).load(R.drawable.katia_statics2).into((AppCompatImageView)v.findViewById(R.id.f_stock_img_statics2));
                Glide.with(getContext()).load(R.drawable.katia_news).into((AppCompatImageView)v.findViewById(R.id.f_stock_img_news));
                Glide.with(getContext()).load(R.drawable.katia_tahlil).into((AppCompatImageView)v.findViewById(R.id.f_stock_img_analysis));
                Glide.with(getContext()).load(R.drawable.katia_tahlil1).into((AppCompatImageView)v.findViewById(R.id.f_stock_img_tahlile1));
                Glide.with(getContext()).load(R.drawable.katia_tahlil2).into((AppCompatImageView)v.findViewById(R.id.f_stock_img_tahlile2));
                Glide.with(getContext()).load(R.drawable.katia_portfo1).into((AppCompatImageView)v.findViewById(R.id.x));
                Glide.with(getContext()).load(R.drawable.katia_portfo2).into((AppCompatImageView)v.findViewById(R.id.y));
                Glide.with(getContext()).load(R.drawable.katia_portfo3).into((AppCompatImageView)v.findViewById(R.id.z));
                Glide.with(getContext()).load(R.drawable.katia_portfo4).into((AppCompatImageView)v.findViewById(R.id.xx));
                Glide.with(getContext()).load(R.drawable.katia_portfo5).into((AppCompatImageView)v.findViewById(R.id.yy));
                Glide.with(getContext()).load(R.drawable.katia_about).into((AppCompatImageView)v.findViewById(R.id.f_stock_img_about));

                break;
            }
            case "zagros":{
                t2.setText(FaNum.convert("7,691"));
                t3.setText(FaNum.convert("151 ریال"));
                Glide.with(getContext()).load(R.drawable.zagros_statics).into((AppCompatImageView)v.findViewById(R.id.f_stock_img_statics));
                Glide.with(getContext()).load(R.drawable.katia_statics2).into((AppCompatImageView)v.findViewById(R.id.f_stock_img_statics2));
                Glide.with(getContext()).load(R.drawable.zagros_news).into((AppCompatImageView)v.findViewById(R.id.f_stock_img_news));
                Glide.with(getContext()).load(R.drawable.katia_tahlil).into((AppCompatImageView)v.findViewById(R.id.f_stock_img_analysis));
                Glide.with(getContext()).load(R.drawable.katia_tahlil1).into((AppCompatImageView)v.findViewById(R.id.f_stock_img_tahlile1));
                Glide.with(getContext()).load(R.drawable.katia_tahlil2).into((AppCompatImageView)v.findViewById(R.id.f_stock_img_tahlile2));
                Glide.with(getContext()).load(R.drawable.katia_portfo1).into((AppCompatImageView)v.findViewById(R.id.x));
                Glide.with(getContext()).load(R.drawable.katia_portfo2).into((AppCompatImageView)v.findViewById(R.id.y));
                Glide.with(getContext()).load(R.drawable.katia_portfo3).into((AppCompatImageView)v.findViewById(R.id.z));
                Glide.with(getContext()).load(R.drawable.katia_portfo4).into((AppCompatImageView)v.findViewById(R.id.xx));
                Glide.with(getContext()).load(R.drawable.katia_portfo5).into((AppCompatImageView)v.findViewById(R.id.yy));
                Glide.with(getContext()).load(R.drawable.zagros_about).into((AppCompatImageView)v.findViewById(R.id.f_stock_img_about));
                break;
            }
            default:{
//                layout = R.layout.fragment_stock_katia;
            }
        }


        return v;
    }

    private void setGrowth(boolean posetive){

    }


}
