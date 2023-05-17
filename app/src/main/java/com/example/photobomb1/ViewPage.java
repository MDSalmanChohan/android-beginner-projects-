package com.example.photobomb1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.example.photobomb1.Adapter.ViewPagerAdapter;
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator;
//import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator;

public class ViewPage extends AppCompatActivity {

    WormDotsIndicator wormDotsIndicator;
    AppCompatButton next,skipBtn;
    ViewPager viewPage;
    ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_page);
//        getSupportActionBar().hide();
  //      getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);


        wormDotsIndicator=findViewById(R.id.wormDotsIndicator);
        next=findViewById(R.id.next);
        skipBtn=findViewById(R.id.skipBtn);
        viewPage=findViewById(R.id.viewPage);


        viewPagerAdapter =new ViewPagerAdapter(this);
        viewPage.setAdapter(viewPagerAdapter);
        wormDotsIndicator.attachTo(viewPage);
        skipBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ViewPage.this,LoginActivity.class));
            }
        });
        viewPage.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position==2){
                    next.setText("Get Started");
                }else {
                    next.setText("Next");
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (viewPage.getCurrentItem()+1< viewPage.getAdapter().getCount()){
                    viewPage.setCurrentItem(viewPage.getCurrentItem()+1);
                }else {
                    startActivity(new Intent(ViewPage.this,LoginActivity.class));
                }
            }
        });
    }
}