package com.example.takmilul.e_farming.Activity;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.takmilul.e_farming.Adapter.ViewPagerAdapter;
import com.example.takmilul.e_farming.Fragment.TodaysVaccineListFragment;
import com.example.takmilul.e_farming.GradientBackgroundPainter;
import com.example.takmilul.e_farming.R;

public class TypeOfCropsActivity extends AppCompatActivity {
   
   Toolbar toolbar;
   TabLayout tabLayout;
   ViewPager viewPager;
   GradientBackgroundPainter gradientBackgroundPainter;
   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_type_of_crops);
      
      toolbar = (Toolbar) findViewById(R.id.typeOfCropsToolbar);
      tabLayout = (TabLayout) findViewById(R.id.typeOfCropsTabs);
      viewPager = (ViewPager) findViewById(R.id.typeOfCropsViewpager);
      
      setSupportActionBar(toolbar);
      toolbar.setTitleTextColor(getResources().getColor(R.color.white_70_transparent));
   
      CoordinatorLayout backgroundImage = (CoordinatorLayout) findViewById(R.id.activity_type_of_crops);
      gradientBackgroundPainter = new GradientBackgroundPainter(backgroundImage);
      gradientBackgroundPainter.start();
      
      /*final Drawable upArrow = ContextCompat.getDrawable(this, R.drawable.abc_ic_ab_back_mtrl_am_alpha);
      upArrow.setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);
      getSupportActionBar().setHomeAsUpIndicator(upArrow);*/
   
      setupViewPager(viewPager);
   
      tabLayout.post(new Runnable() {
         @Override
         public void run() {
            tabLayout.setupWithViewPager(viewPager);
         }
      });
   }
   
   private void setupViewPager(ViewPager viewPager) {
      ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
      adapter.addFragment(new TodaysVaccineListFragment(), getString(R.string.rice));
      adapter.addFragment(new TodaysVaccineListFragment(), getString(R.string.jute));
      adapter.addFragment(new TodaysVaccineListFragment(), getString(R.string.wheat));
      adapter.addFragment(new TodaysVaccineListFragment(), getString(R.string.sugarCane));
      viewPager.setAdapter(adapter);
   }
}
