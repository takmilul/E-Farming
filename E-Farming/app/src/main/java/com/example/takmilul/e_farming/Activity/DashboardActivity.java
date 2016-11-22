package com.example.takmilul.e_farming.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.takmilul.e_farming.GradientBackgroundPainter;
import com.example.takmilul.e_farming.R;

public class DashboardActivity extends AppCompatActivity implements OnClickListener {
   
   Button typeOfCrops;
   GradientBackgroundPainter gradientBackgroundPainter;
   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_dashboard);
      
      typeOfCrops = (Button) findViewById(R.id.typeOfCropsButton);
      Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
      setSupportActionBar(toolbar);
      toolbar.setTitleTextColor(getResources().getColor(R.color.white_70_transparent));
      
      LinearLayout backgroundImage = (LinearLayout) findViewById(R.id.activity_dashboard);
      gradientBackgroundPainter = new GradientBackgroundPainter(backgroundImage);
      gradientBackgroundPainter.start();
      
      typeOfCrops.setOnClickListener(this);
   }
   
   @Override
   public void onClick(View view) {
      Intent intent = new Intent(DashboardActivity.this, TypeOfCropsActivity.class);
      startActivity(intent);
   }
}
