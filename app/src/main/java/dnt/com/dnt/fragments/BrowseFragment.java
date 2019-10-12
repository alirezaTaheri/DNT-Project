package dnt.com.dnt.fragments;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import dnt.com.dnt.R;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class BrowseFragment extends Fragment {

    HorizontalScrollView categoriesScrollView;
    LinearLayout categoriesRow1, categoriesRow2, categoriesRow3, popularLayout;
    private String[] favorites = {"های‌وب", "ذوب‌آهن", "ایران ترانسفو","بیمه آسیا", "موتوژن", "ایران تایر", "پتروشیمی‌جم", "گروه مپنا"};
//    private String[] favorites = {"های‌وب", "ذوب‌آهن", "ایران ترانسفو","بیمه آسیا", "موتوژن", "ایران تایر", "جم", "رمپنا"};
    private String[] favoritesPrices = {"7,850", "2,400", "19,110","4,650", "10,120", "7,616", "5,200", "3,960"};
    private String[] favoritesChanges = {"1.08", "0.13", "3.91","2.13", "1.97", "4.12", "0.65", "0.35"};
    private String[] categories = {"صدسهام محبوب","تکنولوژی","بیشترین کاهش قیمت","سهام های تازه وارد","نفت و گاز","بازار پایه فرابورس","محصولات کاغذی","خودرو","محصولات دارویی","سیمان، آهک و گچ","فلزات اساسی","قند و شکر"};
    private String[] categoriesCount = {"100","7","20","27","25","56","32","12","17","26","12","19"};
    public BrowseFragment() {
        // Required empty public constructor
    }

    public static BrowseFragment newInstance() {
        BrowseFragment fragment = new BrowseFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
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
        View v = inflater.inflate(R.layout.fragment_browse, container, false);
        categoriesScrollView = v.findViewById(R.id.categoriesScrollView);
        categoriesRow1 = v.findViewById(R.id.categoriesRow1);
        categoriesRow2 = v.findViewById(R.id.categoriesRow2);
        categoriesRow3 = v.findViewById(R.id.categoriesRow3);
        for (int a = 0; a<categories.length;a++){
            View categoryItem = inflater.inflate(R.layout.item_category,null);
            ((TextView)categoryItem.findViewById(R.id.name)).setText(categories[a]);
            ((TextView)categoryItem.findViewById(R.id.badge)).setText(categoriesCount[a]);
            CardView.LayoutParams lp = new CardView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            lp.topMargin = 10;
            lp.leftMargin = 10;
            lp.bottomMargin = 10;
            categoryItem.setLayoutParams(lp);
            if (a%3 == 0)
                categoriesRow1.addView(categoryItem);
            else if (a%3 == 1)
                categoriesRow2.addView(categoryItem);
            else categoriesRow3.addView(categoryItem);
        }
        popularLayout = v.findViewById(R.id.popularLayout);
        for (int a = 0;a<favorites.length;a++){
            View item = inflater.inflate(R.layout.item_browse_fragment_popular,null);
            ((TextView)item.findViewById(R.id.name)).setText(favorites[a]);
            ((TextView)item.findViewById(R.id.price)).setText(favoritesPrices[a]);
            ((TextView)item.findViewById(R.id.change)).setText(favoritesChanges[a]);
            if (a%3 == 2) {
                ((TextView) item.findViewById(R.id.price)).setTextColor(getContext().getColor(R.color.red));
                ((TextView) item.findViewById(R.id.change)).setTextColor(getContext().getColor(R.color.red));
            }
            CardView.LayoutParams lp = new CardView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            lp.topMargin = 10;
            lp.leftMargin = 15;
            lp.rightMargin = 15;
            lp.bottomMargin = 10;
            item.setLayoutParams(lp);
            popularLayout.addView(item);
        }
        return v;
    }

}
