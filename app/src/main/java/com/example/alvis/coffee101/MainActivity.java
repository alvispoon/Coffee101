package com.example.alvis.coffee101;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    //Called by PowerOver Image
    public void clickBrewing1(View v) {
        Toast.makeText(v.getContext(),
                "PourOver",
                Toast.LENGTH_SHORT).show();
        //Call Detail View to show the brewing equipment and guideline
        Intent intent = new Intent(this, Brewing1.class).putExtra(getString(R.string.brewingType), BrewingMethod.brewingType_PourOver);
        ;
        startActivity(intent);
    }

    //Called by FrenchPress Image
    public void clickBrewing2(View v) {
        Toast.makeText(v.getContext(),
                "FrenchPress",
                Toast.LENGTH_SHORT).show();
        //Call Detail View to show the brewing equipment and guideline
        Intent intent = new Intent(this, Brewing1.class).putExtra(getString(R.string.brewingType), BrewingMethod.brewingType_Press);
        ;
        startActivity(intent);
    }

    //Called by Expresso Image
    public void clickBrewing3(View v) {
        Toast.makeText(v.getContext(),
                "Expresso",
                Toast.LENGTH_SHORT).show();
        //Call Detail View to show the brewing equipment and guideline
        Intent intent = new Intent(this, Brewing1.class).putExtra(getString(R.string.brewingType), BrewingMethod.brewingType_Expresso);
        ;
        startActivity(intent);
    }

    //Called by Syphon Image
    public void clickBrewing4(View v) {
        Toast.makeText(v.getContext(),
                "Syphon",
                Toast.LENGTH_SHORT).show();
        //Call Detail View to show the brewing equipment and guideline
        Intent intent = new Intent(this, Brewing1.class).putExtra(getString(R.string.brewingType), BrewingMethod.brewingType_Syphon);
        ;
        startActivity(intent);
    }

    //Called by ice Drip Image
    public void clickBrewing5(View v) {
        Toast.makeText(v.getContext(),
                "Ice Drip",
                Toast.LENGTH_LONG).show();
        //Call Detail View to show the brewing equipment and guideline
        Intent intent = new Intent(this, Brewing1.class).putExtra(getString(R.string.brewingType), BrewingMethod.brewingType_IceDrip);
        ;
        startActivity(intent);
    }

}
