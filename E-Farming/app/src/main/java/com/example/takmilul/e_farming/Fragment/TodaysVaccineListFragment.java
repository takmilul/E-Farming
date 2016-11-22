package com.example.takmilul.e_farming.Fragment;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TodaysVaccineListFragment extends Fragment {

   String personID;
   SharedPreferences preferences;
   ListView vaccineLVToday;
   String formattedDate;
   boolean hasTodaysVaccine;
   boolean hasCompletedVaccine;
   boolean hasUpcomingVaccine;

   @Nullable
   @Override
   public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      //Toast.makeText(getActivity(), "OnCreateView() called", Toast.LENGTH_SHORT).show();
//      return inflater.inflate(R.layout.todays_vaccine_list_fragment, container, false);
      return null;
   }

   @Override
   public void onActivityCreated(@Nullable Bundle savedInstanceState) {
      super.onActivityCreated(savedInstanceState);
      //Toast.makeText(getActivity(), "OnActivityCreated() called", Toast.LENGTH_SHORT).show();
      preferences = getActivity().getSharedPreferences("person_id", 0);
      personID = preferences.getString("person_id", "");
      Calendar c = Calendar.getInstance();
      SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
      formattedDate = df.format(c.getTime());

   }

   @Override
   public void onStart() {
      super.onStart();
      //Toast.makeText(getActivity(), "OnStart() called", Toast.LENGTH_SHORT).show();
   }

   @Override
   public void onResume() {
      super.onResume();
      //showVaccineToday();
      //Toast.makeText(getActivity(), "OnResume() called", Toast.LENGTH_SHORT).show();
   }

   
}


