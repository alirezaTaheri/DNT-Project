package dnt.com.dnt.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.robinhood.ticker.TickerUtils;
import com.robinhood.ticker.TickerView;

import java.util.Random;

import dnt.com.dnt.R;
import dnt.com.dnt.utils.TypefaceUtil;


public class MainFragment extends Fragment {
    RelativeLayout w1;
    TickerView tickerView;
    Handler handler;

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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_main, container, false);

        // Change Font For Fragment
        TypefaceUtil.setFont((ViewGroup) v);

        handler = new Handler();
        w1 = v.findViewById(R.id.w1);
        tickerView = w1.findViewById(R.id.tickerView);
        tickerView.setCharacterLists(TickerUtils.provideNumberList());
        handler.post(new Runnable() {
            @Override
            public void run() {
                Random random = new Random();
                String a = String.valueOf(random.nextInt(999));
                String b = String.valueOf(random.nextInt(99));
                tickerView.setText(a+"."+b);
                handler.postDelayed(this, random.nextInt(3000)+3000);
            }
        });
        return v;
    }

}
