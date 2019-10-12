package dnt.com.dnt.utils;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.TypefaceSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.StringRes;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class TypefaceUtil {

    /**
     * Using reflection to override default typeface
     * NOTICE: DO NOT FORGET TO SET TYPEFACE FOR APP THEME AS DEFAULT TYPEFACE WHICH WILL BE OVERRIDDEN
     *
     * @param context                    to work with assets
     * @param defaultFontNameToOverride  for example "monospace"
     * @param customFontFileNameInAssets file name of the font from assets
     */

    public final static String DEFAULT_FONT_NAME = "iransans_light_web.ttf";
    public final static String ALTERNATIVE_FONT_NAME = "iransans_light_web.ttf";
//    private final static String EN_FONT_NAME = "B Nazanin.ttf";
    public static void overrideFont(Context context, String defaultFontNameToOverride, String customFontFileNameInAssets) {

        final Typeface customFontTypeface = Typeface.createFromAsset(context.getAssets(), customFontFileNameInAssets);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Map<String, Typeface> newMap = new HashMap<String, Typeface>();
            newMap.put("serif", customFontTypeface);
            try {
                final Field staticField = Typeface.class
                        .getDeclaredField("sSystemFontMap");
                staticField.setAccessible(true);
                staticField.set(null, newMap);
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        } else {
            try {
                final Field defaultFontTypefaceField = Typeface.class.getDeclaredField(defaultFontNameToOverride);
                defaultFontTypefaceField.setAccessible(true);
                defaultFontTypefaceField.set(null, customFontTypeface);
            } catch (Exception e) {
                //Log.e(TypefaceUtil.class.getSimpleName(), "Can not set custom font " + customFontFileNameInAssets + " instead of " + defaultFontNameToOverride);
            }
        }
    }
    public static Typeface getTypeFace(Context context,String fontnameInFonts){
        try {
            return Typeface.createFromAsset(context.getAssets(), "fonts/"+fontnameInFonts);
        }
        catch (Exception e){
            return null;
        }

    }
    public static void setFont(ViewGroup parent, Typeface font) {
        for (int i = parent.getChildCount() - 1; i >= 0; i--) {
            final View child = parent.getChildAt(i);
            if (child instanceof ViewGroup) {
                setFont((ViewGroup) child, font);
            } else if (child instanceof TextView) {
                ((TextView) child).setTypeface(font);
//                ((TextView) child).setTextSize(TypedValue.COMPLEX_UNIT_SP,((TextView) child).getTextSize());
            }
        }
    }

    public static void setFont(ViewGroup parent, String fontNameInFonts) {
        setFont(parent,getTypeFace(parent.getContext(),fontNameInFonts));
    }
    public static void setFont(ViewGroup parent) {
//        if(Locale.getDefault().equals(new Locale("fa")))
            setFont(parent,getTypeFace(parent.getContext(),DEFAULT_FONT_NAME));

    }
    public static void setSingleFont(TextView textView, Typeface font) {
        textView.setTypeface(font);
    }
    public static void setSingleFont(TextView textView,String font_name) {
        setSingleFont(textView,getTypeFace(textView.getContext(),font_name));
    }

    public static void setMenuItemFont(Context context,MenuItem menuItem, String font_name){
        menuItem.setTitle(getSpannableText(context,menuItem.getTitle(),font_name));
    }
    public static void setMenuItemFont(Context context,MenuItem menuItem){
        setMenuItemFont(context,menuItem,DEFAULT_FONT_NAME);
    }
    public static void setMenuFont(Context context,Menu menu,String font_name){
        for(int i=0;i<menu.size();i++) setMenuItemFont(context,menu.getItem(i),font_name);
    }
    public static void setMenuFont(Context context,Menu menu){
        setMenuFont(context,menu,DEFAULT_FONT_NAME);
    }
    public static CharSequence getSpannableText(Context context,CharSequence text,String font_name){
        Typeface font = getTypeFace(context,font_name);
        SpannableString mNewTitle = new SpannableString(text);
        mNewTitle.setSpan(new MyTypefaceSpan("" , font), 0 , mNewTitle.length(),  Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        return mNewTitle;
    }
    public static CharSequence getSpannableText(Context context, @StringRes int res, String font_name){
        return getSpannableText(context,context.getString(res),font_name);
    }
    public static CharSequence getSpannableText(Context context,CharSequence text){
        return getSpannableText(context,text,DEFAULT_FONT_NAME);
    }
    public static CharSequence getSpannableText(Context context,@StringRes int res){
        return getSpannableText(context,res,DEFAULT_FONT_NAME);
    }

}

class MyTypefaceSpan extends TypefaceSpan {

    private final Typeface newType;

    public MyTypefaceSpan(String family, Typeface type) {
        super(family);
        newType = type;
    }

    @Override
    public void updateDrawState(TextPaint ds) {
        applyCustomTypeFace(ds, newType);
    }

    @Override
    public void updateMeasureState(TextPaint paint) {
        applyCustomTypeFace(paint, newType);
    }

    private static void applyCustomTypeFace(Paint paint, Typeface tf) {
        int oldStyle;
        Typeface old = paint.getTypeface();
        if (old == null) {
            oldStyle = 0;
        } else {
            oldStyle = old.getStyle();
        }

        int fake = oldStyle & ~tf.getStyle();
        if ((fake & Typeface.BOLD) != 0) {
            paint.setFakeBoldText(true);
        }

        if ((fake & Typeface.ITALIC) != 0) {
            paint.setTextSkewX(-0.25f);
        }

        paint.setTypeface(tf);
    }
}