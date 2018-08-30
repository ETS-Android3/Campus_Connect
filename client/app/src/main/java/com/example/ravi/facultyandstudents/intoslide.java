package com.example.ravi.facultyandstudents;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class intoslide extends AppCompatActivity {
    private ViewPager msliderViewPager;
    private LinearLayout mLayout;
    private slideradapter SliderAdapter ;
    private TextView[] mdots;
    private Button back;
    private Button next;
    private  int mcurrentPage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.introactivity);
        msliderViewPager=(ViewPager)findViewById(R.id.pager);
        mLayout=findViewById(R.id.layout);
        back=findViewById(R.id.back);
        next=findViewById(R.id.next);

        msliderViewPager.setAdapter(SliderAdapter);
        addsDotIndicator(0);
        msliderViewPager.addOnPageChangeListener(viewListener);

        next.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                msliderViewPager.setCurrentItem(mcurrentPage+1);
            }
        });
        back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                msliderViewPager.setCurrentItem(mcurrentPage-1);
            }
        });

    }

    private void addsDotIndicator(int position) {
        int No_of_slides=3;
        mdots=new TextView[No_of_slides];
        for(int i=0;i<No_of_slides;i++)
        {
            mdots[i]=new TextView(this);
            mdots[i].setText(Html.fromHtml("&#8226;"));
            mdots[i].setTextSize(35);
            mdots[i].setTextColor(getResources().getColor(R.color.color_transparent_white));
            mLayout.addView(mdots[i]);
        }
        if(mdots.length>0){
            mdots[position].setTextColor(getResources().getColor(R.color.color_white));
        }


    }

    ViewPager.OnPageChangeListener viewListener=new ViewPager.OnPageChangeListener(){
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addsDotIndicator(position);
            mcurrentPage=position;
            if(mcurrentPage==0){
                back.setEnabled(false );
                next.setEnabled(true);
                back.setVisibility(View.INVISIBLE);
                next.setText("NEXT");
            }
            else if(mcurrentPage==mdots.length-1){
                back.setEnabled(true );
                next.setEnabled(true);
                back.setVisibility(View.VISIBLE);
                next.setText("START");
                back.setText("BACK");
                //////////////start the ctualactivity
            }
            else{
                back.setEnabled(true );
                next.setEnabled(true);
                back.setVisibility(View.VISIBLE);
                back.setText("BACK");
                next.setText("NEXT");
            }

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}
