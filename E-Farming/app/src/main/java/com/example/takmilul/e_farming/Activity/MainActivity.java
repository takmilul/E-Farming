package com.example.takmilul.e_farming.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.takmilul.e_farming.GradientBackgroundPainter;
import com.example.takmilul.e_farming.R;

public class MainActivity extends AppCompatActivity implements OnClickListener {
   
   ProgressBar progressBar;
   EditText nameEditText;
   TextView saveButton;
   GradientBackgroundPainter gradientBackgroundPainter;
   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);
   
      Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
      setSupportActionBar(toolbar);
      toolbar.setTitleTextColor(getResources().getColor(R.color.white_70_transparent));
      /*toolbar.setNavigationIcon(R.drawable.back_button1);
      toolbar.setNavigationOnClickListener(new OnClickListener() {
         @Override
         public void onClick(View v) {
            onBackPressed();
         }
      });*/
   
      LinearLayout backgroundImage = (LinearLayout) findViewById(R.id.activity_main);
      gradientBackgroundPainter = new GradientBackgroundPainter(backgroundImage);
      gradientBackgroundPainter.start();
      
      progressBar = (ProgressBar) findViewById(R.id.progressBar);
      progressBar.setVisibility(View.GONE);
      nameEditText = (EditText) findViewById(R.id.nameET);
      saveButton = (TextView) findViewById(R.id.saveButton);
      saveButton.setOnClickListener(this);
   }
   
   @Override
   public void onClick(View view) {
      Intent intent = new Intent(MainActivity.this, DashboardActivity.class);
      startActivity(intent);
   }
}
