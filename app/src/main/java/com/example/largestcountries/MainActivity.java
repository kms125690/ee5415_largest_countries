package com.example.largestcountries;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;

    private ListAdapter mListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = (ListView) findViewById(R.id.listview);
//        final String[] countries = {"Russia", "Canada", "United States", "China", "Brazil", "Australia", "India", "Argentina", "Kazahkstan", "Algeria"};
        final String[] countries = getResources().getStringArray(R.array.countries_array);
        final String[] areas = getResources().getStringArray(R.array.areas_array);
        final int[] flags = {R.drawable.russia, R.drawable.canada,
                             R.drawable.usa, R.drawable.china,
                             R.drawable.brazil, R.drawable.australia,
                             R.drawable.india, R.drawable.argentina,
                             R.drawable.kazakhstan, R.drawable.algeria};

//        ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, countries);
        mListAdapter = new ListAdapter(MainActivity.this, countries, areas, flags);
        mListView.setAdapter(mListAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), countries[i] + " " + areas[i], Toast.LENGTH_LONG).show();
            }
        });
    }

}