package com.example.admin.healthtracker;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;
import java.util.List;


public class PHTActivity extends AppCompatActivity {

    LineChart lineChart;

    ArrayList<String> xAxes = new ArrayList<>();
    ArrayList<Entry> yAxes = new ArrayList<>();
    ArrayList<ILineDataSet> lineDataSets = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pht);

        button = (Button)findViewById(R.id.BMIResultButtonId);
        button.setOnClickListener(new View.OnClickListener()
                                  {
                                      public void onClick(View view) {

                                          lineChart = (LineChart)findViewById(R.id.bloodPressureMontlyChart);

                                          xAxes.add("Monday");
                                          xAxes.add("Tuesday");
                                          xAxes.add("Wednesday");
                                          xAxes.add("Thursday");
                                          xAxes.add("Friday");

                                          yAxes.add(new Entry(10,0));
                                          yAxes.add(new Entry(50,1));
                                          yAxes.add(new Entry(40,2));
                                          yAxes.add(new Entry(60,3));
                                          yAxes.add(new Entry(20,4));

                                          String[] xaxes = new String[xAxes.size()];

                                          for(int i=0;i<xAxes.size();i++)
                                          {
                                              xaxes[i] = xAxes.get(i).toString();
                                          }

                                          LineDataSet lineDataSet = new LineDataSet(yAxes,"values");
                                          lineDataSet.setDrawCircles(true);
                                          lineDataSet.setColor(Color.BLUE);

                                          lineDataSets.add(lineDataSet);

                                          lineChart.setData(new LineData(xaxes,lineDataSets));

                                          lineChart.setVisibleXRangeMaximum(65f);
                                          lineChart.setTouchEnabled(true);
                                          lineChart.setDragEnabled(true);

                                      }
                                  };




        /*
        double monthlyBloodPressure [] = {3.0,4.5,5.6,6.7};
        lineChart = (LineChart)findViewById(R.id.bloodPressureMontlyChart);


        private List<ILineDataSet> getLineDataValues()
        {
           ArrayList<ILineDataSet> lineDataSets = null;
           ArrayList<Entry> entryArrayList = new ArrayList<>();

          for(int i = 0;i<monthlyBloodPressure.length;i++)
          {
              entryArrayList.add(new Entry(monthlyBloodPressure[i],i));
          }
          LineDataSet lineDataSet = new LineDataSet(entryArrayList,"bloodPressureMonthly");
          lineDataSets = new ArrayList<>();

          lineDataSets.add(lineDataSet);

        }
        private List<Integer> getMonthValues()
        {
            ArrayList<Integer> month = new ArrayList<>();
            for(int i = 1;i<=30;i++)
            {
                month.add(i);
            }
        }

        lineData = new LineData (getMonthValues(), getLineDataValues());
        lineChart.setData(lineData);*/
    }
}
