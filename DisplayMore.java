package com.example.wearableapplication;

import android.content.Intent;
import android.graphics.Color;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GridLabelRenderer;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by hanaa on 6/22/16.
 */
public class DisplayMore extends AppCompatActivity {



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();

        setContentView(R.layout.activity_more);

        // generate dates
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Calendar calendar = Calendar.getInstance();
        Date d1 = calendar.getTime();
        //String d1 = dateFormat.format(calendar.getTime());
        calendar.add(calendar.DATE, -1);
        Date d2 = calendar.getTime();
        //String d2 = dateFormat.format(calendar.getTime());
        calendar.add(calendar.DATE, -1);
        Date d3 = calendar.getTime();
        //String d3 = dateFormat.format(calendar.getTime());
        calendar.add(calendar.DATE, -1);
        //String d4 = dateFormat.format(calendar.getTime());
        Date d4 = calendar.getTime();
        calendar.add(calendar.DATE, -1);
        //String d5 = dateFormat.format(calendar.getTime());
        Date d5 = calendar.getTime();
        calendar.add(calendar.DATE, -1);
        //String d6 = dateFormat.format(calendar.getTime());
        Date d6 = calendar.getTime();
        calendar.add(calendar.DATE, -1);
        //String d7 = dateFormat.format(calendar.getTime());
        Date d7 = calendar.getTime();

//        InputData2 inputData2 = new InputData2(this);
//        inputData2.open();
//
//        String message1 = inputData2.getMovement(d1);
//        Log.i("TAG", "numberval" + message1);
//        String message2 = inputData2.getMovement(d2);
//        String message3 = inputData2.getMovement(d3);
//        String message4 = inputData2.getMovement(d4);
//        String message5 = inputData2.getMovement(d5);
//        String message6 = inputData2.getMovement(d6);
//        String message7 = inputData2.getMovement(d7);
//
//        inputData2.close();

        String message1 = intent.getStringExtra(MainActivity.mssg);
        String message2 = intent.getStringExtra(MainActivity.mssg2);
        String message3 = intent.getStringExtra(MainActivity.mssg3);
        String message4 = intent.getStringExtra(MainActivity.mssg4);
        String message5 = intent.getStringExtra(MainActivity.mssg5);
        String message6 = intent.getStringExtra(MainActivity.mssg6);
        String message7 = intent.getStringExtra(MainActivity.mssg7);

        // generate dates
//        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd");
//        Calendar calendar = Calendar.getInstance();
//        String d1 = dateFormat.format(calendar.getTime());
//        calendar.add(calendar.DATE, -1);
//        String d2 = dateFormat.format(calendar.getTime());
//        calendar.add(calendar.DATE, -1);
//        String d3 = dateFormat.format(calendar.getTime());
//        calendar.add(calendar.DATE, -1);
//        String d4 = dateFormat.format(calendar.getTime());
//        calendar.add(calendar.DATE, -1);
//        String d5 = dateFormat.format(calendar.getTime());
//        calendar.add(calendar.DATE, -1);
//        String d6 = dateFormat.format(calendar.getTime());
//        calendar.add(calendar.DATE, -1);
//        String d7 = dateFormat.format(calendar.getTime());

        GraphView graph = (GraphView) findViewById(R.id.graph);
        BarGraphSeries<DataPoint> series = new BarGraphSeries<>(new DataPoint[]{
                //new DataPoint(0, 0),
                new DataPoint(1, Integer.parseInt(message1)),
                new DataPoint(2, Integer.parseInt(message2)),
                new DataPoint(3, Integer.parseInt(message3)),
                new DataPoint(4, Integer.parseInt(message4)),
                new DataPoint(5, Integer.parseInt(message5)),
                new DataPoint(6, Integer.parseInt(message6)),
                new DataPoint(7, Integer.parseInt(message7))
        });

        int max1 = Math.max(Integer.parseInt(message1), Integer.parseInt(message2));
        int max2 = Math.max(Integer.parseInt(message3), Integer.parseInt(message4));
        int max3 = Math.max(max1, max2);
        int max4 = Math.max(max3, Integer.parseInt(message7));

        graph.addSeries(series);

        //graph customizing
        graph.setTitle("Movements");
        graph.setTitleColor(Color.parseColor("#009688"));
        graph.setTitleTextSize(80);
        // horizontal axis
        graph.getGridLabelRenderer().setNumHorizontalLabels(7);
        graph.getGridLabelRenderer().setHorizontalAxisTitle("Days");
        graph.getGridLabelRenderer().setHorizontalAxisTitleColor(Color.parseColor("#ffab91"));
        graph.getGridLabelRenderer().setHorizontalAxisTitleTextSize(60);
        graph.getViewport().setMinX(0.0);
        // vertical axis
        graph.getViewport().setMinY(0.0);
        int maxValue = max4;
        int interval;
        // maxValue can be less than or greater than any #, just chose 10 and 50 for now
        if (maxValue <= 10) {
            interval = 1; // interval of 1 between values on y axis
        } else if (maxValue <= 50) {
            interval = 10;
        } else {
            interval = 20;
        }
        // top value of graph must be multiplier of interval
        int maxLabel = maxValue + 1;
        while (maxLabel % interval != 0) {
            maxLabel++;
        }
        //setting manual bounds
        graph.getViewport().setYAxisBoundsManual(true);
        graph.getViewport().setMaxY(maxLabel);
        graph.getGridLabelRenderer().setNumVerticalLabels(maxLabel / interval + 1);

        //series customizing
        series.setSpacing(10);
        series.setColor(Color.parseColor("#b2dfdb"));
        series.setDrawValuesOnTop(true);
        series.setValuesOnTopColor(Color.parseColor("#ffab91"));
        series.setValuesOnTopSize(48);
//        series.setValueDependentColor(new ValueDependentColor<DataPoint>() {
//            @Override
//            public int get(DataPoint data) {
//                return Color.rgb((int) data.getX()*255/25, (int) data.getY()*64/20, 139);
//            }
//        });

        // grid line settings
        graph.getGridLabelRenderer().setGridStyle(GridLabelRenderer.GridStyle.NONE);
        graph.getGridLabelRenderer().setGridStyle(GridLabelRenderer.GridStyle.HORIZONTAL);
        graph.getGridLabelRenderer().setGridStyle(GridLabelRenderer.GridStyle.VERTICAL);


//        String message1 = intent.getStringExtra(MainActivity.mssg);
//        String message2 = intent.getStringExtra(MainActivity.mssg2);
//        String message3 = intent.getStringExtra(MainActivity.mssg3);
//        String message4 = intent.getStringExtra(MainActivity.mssg4);
//        String message5 = intent.getStringExtra(MainActivity.mssg5);
//        String message6 = intent.getStringExtra(MainActivity.mssg6);
//        String message7 = intent.getStringExtra(MainActivity.mssg7);

//        // generate dates
//        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd");
//        Calendar calendar = Calendar.getInstance();
//        String d1 = dateFormat.format(calendar.getTime());
//        calendar.add(calendar.DATE, -1);
//        String d2 = dateFormat.format(calendar.getTime());
//        calendar.add(calendar.DATE, -1);
//        String d3 = dateFormat.format(calendar.getTime());
//        calendar.add(calendar.DATE, -1);
//        String d4 = dateFormat.format(calendar.getTime());
//        calendar.add(calendar.DATE, -1);
//        String d5 = dateFormat.format(calendar.getTime());
//        calendar.add(calendar.DATE, -1);
//        String d6 = dateFormat.format(calendar.getTime());
//        calendar.add(calendar.DATE, -1);
//        String d7 = dateFormat.format(calendar.getTime());


    }
}

