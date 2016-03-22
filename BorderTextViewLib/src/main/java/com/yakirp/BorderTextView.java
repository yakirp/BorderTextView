package com.yakirp;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;



/**
 * Created by yakirp on 3/21/2016.
 */
public class BorderTextView extends LinearLayout {
    public static final String FONT = "fonts/Roboto-Light.ttf";
    private final String text;
    private final int color;
    private LinearLayout border;
    private String textSize;
    private LayoutInflater inflater;

    public TextView getTextView() {
        return textView;
    }

    public void setTextView(TextView textView) {
        this.textView = textView;
    }

    private TextView textView;
    private String padding = "10dp";

    public BorderTextView(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.BorderTextView1);
        text = a.getString(R.styleable.BorderTextView1_android_text);
        textSize = a.getString(R.styleable.BorderTextView1_android_textSize);
        padding = a.getString(R.styleable.BorderTextView1_textPadding);
        color = a.getColor(R.styleable.BorderTextView1_android_textColor, Color.BLACK);
        //Don't forget this
        a.recycle();
        initControl(context, attrs);

    }

    @Override
    public void setOnClickListener(OnClickListener l) {

        getTextView().setOnClickListener(l);


    }

    @Override
    public void setOnLongClickListener(OnLongClickListener l) {
        getTextView().setOnLongClickListener(l);
    }

    public void setText(String text) {
        getTextView().setText(text);
    }

    public void setColor(int color) {
        setBorderColor(color);
        getTextView().setTextColor(color);
    }

    public void setColor(String color) {
        setBorderColor(Color.parseColor(color));
        getTextView().setTextColor(Color.parseColor(color));
    }

    /**
     * Load component XML layout
     */
    private void initControl(Context context, AttributeSet attrs) {

        inflater = (LayoutInflater)
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View g = inflater.inflate(R.layout.border_text_view, this);
        border = (LinearLayout) g.findViewById(R.id.border);

        setBorderColor(color);
        int pa = castPaddingValue(context);
        initialTextView(context, pa);


    }

    private void initialTextView(Context context, int pa) {
        if (textSize == null || textSize.equals("")) {
            textSize = "12sp";
        }

        setTextView((TextView) findViewById(R.id.border_text_view));
        getTextView().setText(text.toUpperCase());
        getTextView().setPadding(10, 8, 10, 8);
        Typeface tf3 = Typeface.createFromAsset(context.getAssets(), FONT);
        getTextView().setTypeface(tf3);
        getTextView().setTextColor(color);

        getTextView().setTextSize(TypedValue.COMPLEX_UNIT_SP, Float.parseFloat(textSize.replace("sp", "")));


    }

    private int castPaddingValue(Context context) {
        if (padding == null || padding.equals("")) {
            padding = "7dp";
        }
        return (int) DimensionConverter.stringToDimension(padding, context.getResources().getDisplayMetrics());
    }

    private void setBorderColor(int newColor) {
        GradientDrawable gd = (GradientDrawable) border.getBackground().getCurrent();
        gd.setStroke(2, newColor, 0, 0);
    }

}
