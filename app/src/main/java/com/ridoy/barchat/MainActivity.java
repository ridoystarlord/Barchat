package com.ridoy.barchat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    BarChart barChart;
    ArrayList<BarEntry> barEntryArrayList;
    ArrayList<BarchatItems> barchatItemsArrayList;
    ArrayList<String> labelname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        barChart=findViewById(R.id.barchat);
        barchatItemsArrayList=new ArrayList<>();
        barEntryArrayList=new ArrayList<>();
        labelname=new ArrayList<>();

        barchatItemsArrayList.add(new BarchatItems("Semester1", (float) 4.0));
        barchatItemsArrayList.add(new BarchatItems("Semester2", (float) 3.92));
        barchatItemsArrayList.add(new BarchatItems("Semester3", (float) 3.50));
        barchatItemsArrayList.add(new BarchatItems("Semester4", (float) 4.00));
        barchatItemsArrayList.add(new BarchatItems("Semester5", (float) 3.75));

        barEntryArrayList.clear();
        labelname.clear();

        for (int i=0;i<barchatItemsArrayList.size();i++){
            String semesterName=barchatItemsArrayList.get(i).getSemesterName();
            double semesterCGPA=barchatItemsArrayList.get(i).getSemesterCGPA();
            barEntryArrayList.add(new BarEntry(i, (float) semesterCGPA));
            labelname.add(semesterName);
        }

        BarDataSet barDataSet=new BarDataSet(barEntryArrayList,"Semester");
        barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        Description description=new Description();
        description.setText("Result");
        barChart.setDescription(description);

        BarData barData=new BarData(barDataSet);
        barChart.setData(barData);

        XAxis xAxis=barChart.getXAxis();
        xAxis.setValueFormatter(new IndexAxisValueFormatter(labelname));
        xAxis.setPosition(XAxis.XAxisPosition.TOP);
        xAxis.setDrawGridLines(false);
        xAxis.setDrawAxisLine(false);
        xAxis.setGranularity(1f);
        xAxis.setLabelCount(labelname.size());
        xAxis.setLabelRotationAngle(0);
        barChart.animateY(1000);
        barChart.invalidate();
    }
}