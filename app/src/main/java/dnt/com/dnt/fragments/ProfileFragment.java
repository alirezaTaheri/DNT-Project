package dnt.com.dnt.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import dnt.com.dnt.R;
import dnt.com.dnt.utils.FaNum;
import dnt.com.dnt.utils.TypefaceUtil;


public class ProfileFragment extends Fragment {
    public ProfileFragment() {
        // Required empty public constructor
    }

    public static ProfileFragment newInstance() {
        ProfileFragment fragment = new ProfileFragment();
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
        View v = inflater.inflate(R.layout.fragment_profile, container, false);
        t2 = v.findViewById(R.id.t2);
        t3 = v.findViewById(R.id.t3);
        t2.setText(FaNum.convert("216,500"));
        t3.setText(FaNum.convert("17,100 تومان"));
        // Change Font For Fragment
        TypefaceUtil.setFont((ViewGroup) v);

        return v;
    }

}
