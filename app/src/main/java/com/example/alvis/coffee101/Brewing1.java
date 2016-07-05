package com.example.alvis.coffee101;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class Brewing1 extends AppCompatActivity {

    //Define required listview variables and adaptors
    private ListView equipmentListView;
    private ArrayAdapter<String> listAdapter;

    private ListView stepbystepListView;
    private ArrayAdapter<String> stepbystepListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brewing1);

        //Get the parameter from previous activity to identify the brewing type
        Intent intent = getIntent();
        int brewingType = 0;
        if (intent != null && intent.hasExtra("brewingType")) {
            brewingType = intent.getIntExtra("brewingType", 0);
        }

        //initialize all required variable
        String[] equpmentArray = null;
        String[] stepbystepArray = null;
        String brewingTitle = null;
        int brewingImg = 1;

        //Extract all required equipment/image and stepbystep guide and store into variable
        switch (brewingType) {
            case BrewingMethod.brewingType_PourOver:
                equpmentArray = getResources().getStringArray(R.array.brewing1_Equipment);
                stepbystepArray = getResources().getStringArray(R.array.brewing1_stepbystep);
                brewingTitle = getResources().getString(R.string.brewing1);
                brewingImg = R.drawable.brewing1;
                break;
            case BrewingMethod.brewingType_Press:
                equpmentArray = getResources().getStringArray(R.array.brewing2_Equipment);
                stepbystepArray = getResources().getStringArray(R.array.brewing2_stepbystep);
                brewingTitle = getResources().getString(R.string.brewing2);
                brewingImg = R.drawable.brewing2;
                break;
            case BrewingMethod.brewingType_Expresso:
                equpmentArray = getResources().getStringArray(R.array.brewing3_Equipment);
                stepbystepArray = getResources().getStringArray(R.array.brewing3_stepbystep);
                brewingTitle = getResources().getString(R.string.brewing3);
                brewingImg = R.drawable.brewing3;
                break;
            case BrewingMethod.brewingType_Syphon:
                equpmentArray = getResources().getStringArray(R.array.brewing4_Equipment);
                stepbystepArray = getResources().getStringArray(R.array.brewing4_stepbystep);
                brewingTitle = getResources().getString(R.string.brewing4);
                brewingImg = R.drawable.brewing4;
                break;
            case BrewingMethod.brewingType_IceDrip:
                equpmentArray = getResources().getStringArray(R.array.brewing5_Equipment);
                stepbystepArray = getResources().getStringArray(R.array.brewing5_stepbystep);
                brewingTitle = getResources().getString(R.string.brewing5);
                brewingImg = R.drawable.brewing5;
                break;
        }

        //Set Brewing Title
        TextView titleTV = (TextView) findViewById(R.id.title);
        titleTV.setText(brewingTitle);

        //Set Brewing Image
        ImageView typeIV = (ImageView) findViewById(R.id.brewingimg);
        typeIV.setImageResource(brewingImg);

        //Setup ListView to show required equipment
        equipmentListView = (ListView) findViewById(R.id.equipment);
        ArrayList<String> equipmentList = new ArrayList<String>();
        if (equpmentArray != null) {
            equipmentList.addAll(Arrays.asList(equpmentArray));
        }
        listAdapter = new ArrayAdapter<String>(this, R.layout.list_item_equipment, equipmentList);
        equipmentListView.setAdapter(listAdapter);

        //Setup ListView to show step by step guideline
        stepbystepListView = (ListView) findViewById(R.id.stepbystep);
        ArrayList<String> stepbystepList = new ArrayList<String>();
        if (stepbystepArray != null) {
            stepbystepList.addAll(Arrays.asList(stepbystepArray));
        }
        stepbystepListAdapter = new ArrayAdapter<String>(this, R.layout.list_item_step, stepbystepList);
        stepbystepListView.setAdapter(stepbystepListAdapter);


        //Setup the header in two listview
        LayoutInflater inflater = getLayoutInflater();
        ViewGroup equipmentheader = (ViewGroup) inflater.inflate(R.layout.list_header_equipment, equipmentListView,
                false);
        equipmentListView.addHeaderView(equipmentheader, null, false);

        ViewGroup stepbystepheader = (ViewGroup) inflater.inflate(R.layout.list_header_stepbystep, stepbystepListView,
                false);
        stepbystepListView.addHeaderView(stepbystepheader, null, false);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_brewing1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
