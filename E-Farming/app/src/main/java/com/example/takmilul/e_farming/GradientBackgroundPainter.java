package com.example.takmilul.e_farming;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.View;

import java.util.Random;

public class GradientBackgroundPainter {
   
   private static final int MIN = 4000;
   private static final int MAX = 5000;
   
   private final Random random;
   private final Handler handler;
   private final View target;
   private int[] drawables;
   private final Context context;
   
   public GradientBackgroundPainter(@NonNull View target) {
      
      random = new Random();
      handler = new Handler();
      context = target.getContext().getApplicationContext();
      drawables = new int[15];
      
      drawables[0] = R.drawable.gradient_1;
      drawables[1] = R.drawable.gradient_2;
      drawables[2] = R.drawable.gradient_3;
      drawables[3] = R.drawable.gradient_4;
      drawables[4] = R.drawable.gradient_5;
      drawables[5] = R.drawable.gradient_6;
      drawables[6] = R.drawable.gradient_7;
      drawables[7] = R.drawable.gradient_8;
      drawables[8] = R.drawable.gradient_9;
      drawables[9] = R.drawable.gradient_10;
      drawables[10] = R.drawable.gradient_11;
      drawables[11] = R.drawable.gradient_12;
      drawables[12] = R.drawable.gradient_13;
      drawables[13] = R.drawable.gradient_14;
      drawables[14] = R.drawable.gradient_15;
      this.target = target;
//      this.drawables = drawables;
   }
   
   private void animate(final int firstDrawable, int secondDrawable, final int duration) {
      if (secondDrawable >= drawables.length) {
         secondDrawable = 0;
      }
      final Drawable first = ContextCompat.getDrawable(context, drawables[firstDrawable]);
      final Drawable second = ContextCompat.getDrawable(context, drawables[secondDrawable]);
      
      final TransitionDrawable transitionDrawable =
            new TransitionDrawable(new Drawable[] { first, second });
      
      target.setBackgroundDrawable(transitionDrawable);
      
      transitionDrawable.setCrossFadeEnabled(false);
      
      transitionDrawable.startTransition(duration);
      
      final int localSecondDrawable = secondDrawable;
      handler.postDelayed(new Runnable() {
         @Override
         public void run() {
            animate(localSecondDrawable, localSecondDrawable + 1, randInt(MIN, MAX));
         }
      }, duration);
   }
   
   public void start() {
      final int duration = randInt(MIN, MAX);
      animate(0, 1, duration);
   }
   
   public void stop() {
      handler.removeCallbacksAndMessages(null);
   }
   
   private int randInt(int min, int max) {
      return random.nextInt((max - min) + 1) + min;
   }
}
