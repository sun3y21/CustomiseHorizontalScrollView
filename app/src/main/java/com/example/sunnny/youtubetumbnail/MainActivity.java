package com.example.sunnny.youtubetumbnail;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        LinearLayout l = (LinearLayout) findViewById(R.id.dot_layout);
        final TextView textView[]=new TextView[8];
        for (int i = 0; i < 8; i++) {
            TextView t = new TextView(getApplicationContext());
            t.setText(".");
            t.setId(i + 100);
            t.setTextSize(45);
            t.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            t.setVisibility(View.VISIBLE);
            textView[i]=t;
            l.addView(t, i);
        }

        LinearLayout l1 = (LinearLayout) findViewById(R.id.image_layout);
        final ImageView imageView[]=new ImageView[8];
        final FrameLayout frameLayout[]=new FrameLayout[8];
        for (int i = 0; i < 8; i++) {
            FrameLayout frame=new FrameLayout(getApplication());
            imageView[i]=new ImageView(getApplicationContext());
            imageView[i].setImageResource(R.drawable.android);
            imageView[i].setId(1001+i);
            ImageView temp=new ImageView(getApplicationContext());
            temp.setImageResource(R.drawable.playicon);
            temp.setAdjustViewBounds(true);
            temp.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            frame.addView(imageView[i]);
            frame.addView(temp);
            frame.setId(101+i);
            frame.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getApplicationContext(),view.getId()+"",Toast.LENGTH_SHORT).show();
                }
            });
            frameLayout[i]=frame;
            l1.addView(frame,i);
        }

        final HorizontalScrollView horizontalScrollView = (HorizontalScrollView) findViewById(R.id.scroll_view);
        horizontalScrollView.setSmoothScrollingEnabled(true);

      //  horizontalScrollView.setScrollX(1500);
        if(horizontalScrollView!=null) {
            horizontalScrollView.setOnScrollChangeListener(new View.OnScrollChangeListener() {

                @Override
                public void onScrollChange(View view, int i, int i1, int i2, int i3) {
                    int k=0;
                    for(k=0;k<8;k++)
                    {
                        if(i<frameLayout[k].getX())
                            break;
                    }

                    k--;
                    for(int j=0;j<8;j++)
                    {
                        if(j==k)
                        textView[j].setTextColor(getResources().getColor(R.color.colorAccent));
                        else
                            textView[j].setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                    }
                }
            });
        }



    }






}
