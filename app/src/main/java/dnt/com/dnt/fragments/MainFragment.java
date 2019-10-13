package dnt.com.dnt.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.robinhood.ticker.TickerUtils;
import com.robinhood.ticker.TickerView;

import java.util.Random;

import dnt.com.dnt.R;
import dnt.com.dnt.activities.StockActivity;
import dnt.com.dnt.utils.FaNum;
import dnt.com.dnt.utils.TypefaceUtil;


public class MainFragment extends Fragment {
    private RelativeLayout w1, w2;
    private LinearLayout watchListLayout;
    private TickerView tickerView, tickerView2;
    private Handler handler;
    private Random random;

    private String[] watchList = {"کهرام","دهدشت","فوکا","پارتا","سیستم","شاراک","فجام","کیسون"};
    private String[] watchListSub = {"گرانیت بهسرام","صنایع دهدشت","فولاد کاویان","مجتمع آرتاویل تایر","همکاران سیستم","پتروشیمی شازند","جام دارو","شرکت کیسون"};
    private String[] watchListChanges = {"0.73","1.14","2.94","3.26","2.87","1.27","0.86","2.64"};
    private int[] watchListChart = {R.drawable.green_1,R.drawable.red_1,R.drawable.green_2,R.drawable.green_3,R.drawable.red_1,R.drawable.red_2,R.drawable.red_3,R.drawable.green_4};
    private boolean[] watchListPositive = {true,false,true,true,false,false,false,true};
    public MainFragment() {
        // Required empty public constructor
    }

    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
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
        View v = inflater.inflate(R.layout.fragment_main, container, false);
        t2 = v.findViewById(R.id.t2);
        t3 = v.findViewById(R.id.t3);
        t2.setText(FaNum.convert("216,500"));
        t3.setText(FaNum.convert("17,100 تومان"));
        // Change Font For Fragment
        TypefaceUtil.setFont((ViewGroup) v);

        // start stock activities
        v.findViewById(R.id.w1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(),StockActivity.class);
                i.putExtra(StockActivity.STOCK_NAME_PARAM,"katia");
                startActivity(i);
            }
        });
        v.findViewById(R.id.w2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(),StockActivity.class);
                i.putExtra(StockActivity.STOCK_NAME_PARAM,"zagros");
                startActivity(i);
            }
        });

        w1 = v.findViewById(R.id.w1);
        w2 = v.findViewById(R.id.w2);
        tickerView = w1.findViewById(R.id.tickerView);
        tickerView2 = w2.findViewById(R.id.tickerView);
        tickerView.setCharacterLists(TickerUtils.provideNumberList());
        tickerView2.setCharacterLists(TickerUtils.provideNumberList());
        if (handler == null) {
            handler = new Handler();
            final Random random = new Random();
            handler.post(new Runnable() {
                @Override
                public void run() {
                    String a = String.valueOf(random.nextInt(5));
                    String b = String.valueOf(random.nextInt(99));
                    tickerView.setText(FaNum.convert(a + "." + b+"%"));
                    handler.postDelayed(this, random.nextInt(3000) + 3000);
                }
            });
            handler.post(new Runnable() {
                @Override
                public void run() {
                    String a = String.valueOf(random.nextInt(5));
                    String b = String.valueOf(random.nextInt(99));
                    tickerView2.setText(FaNum.convert(a + "." + b+"%"));
                    handler.postDelayed(this, random.nextInt(10000) + 4000);
                }
            });
        }
        watchListLayout = v.findViewById(R.id.watchList);
        random = new Random();
        for (int a = 0;a<watchList.length;a++){
            final View stockItem = inflater.inflate(R.layout.item_stock,null);
            ((TextView)stockItem.findViewById(R.id.symbol)).setText(watchList[a]);
            ((TextView)stockItem.findViewById(R.id.name)).setText(watchListSub[a]);
            ((TickerView)stockItem.findViewById(R.id.tickerView)).setCharacterLists(TickerUtils.provideNumberList());
            ((TickerView)stockItem.findViewById(R.id.tickerView)).setText(FaNum.convert(watchListChanges[a]+"%"));
            ((TickerView)stockItem.findViewById(R.id.tickerView)).setBackground(ContextCompat.getDrawable(getContext(), watchListPositive[a]?R.drawable.background_item_stock_positive:R.drawable.background_item_stock_negative));
            ((ImageView)stockItem.findViewById(R.id.chart)).setImageDrawable(ContextCompat.getDrawable(getContext(), watchListChart[a]));
            final int finalA = a;
            handler.post(new Runnable() {
                @Override
                public void run() {
                    String change = watchListChanges[finalA];
                    int a = Integer.parseInt(change.split("\\.")[0]);
                    int b = Integer.parseInt(change.split("\\.")[1]);
                    a = a - random.nextInt(3);
                    a = a + random.nextInt(6)+3;
                    b = random.nextInt(99);
                    ((TickerView)stockItem.findViewById(R.id.tickerView)).setText(FaNum.convert(String.valueOf(a)+"."+String.valueOf(b)+"%"));
                    handler.postDelayed(this, random.nextInt(15000) + 4000);
                }
            });
            watchListLayout.addView(stockItem);
        }


        return v;
    }



}
