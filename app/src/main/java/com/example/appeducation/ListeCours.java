package com.example.appeducation;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appeducation.ui.home.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.List;

public class ListeCours extends AppCompatActivity {
    ListView listeView;
    String nTitle[]={"Chiffre" , "Animaux" , "lettre","vegetable"};
    String nDescription[]={"Chiffre Description" , "animaux Description" , "Lettre Decsription" , "Vegetable description"};
    int images[] ={R.drawable.chiffre,R.drawable.animaux1,R.drawable.lettres,R.drawable.vegetable};

    BottomNavigationView bottomNavigationView ;
    HomeFragment homeFragment = new HomeFragment();
    Settings settings = new Settings();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_cours);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        getSupportFragmentManager().beginTransaction().replace(R.id.container,homeFragment).commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected( MenuItem item) {
                switch(item.getItemId()){
                    case R.id.home:  getSupportFragmentManager().beginTransaction().replace(R.id.container,homeFragment).commit();
                     return true;
                    case R.id.settings: getSupportFragmentManager().beginTransaction().replace(R.id.container,settings).commit();
                    return true;

                }

                return false;
            }
        });

        listeView = findViewById(R.id.listView);
        MyAdapter adapter =new MyAdapter(this, nTitle , nDescription,images);
        listeView.setAdapter(adapter);

        listeView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    Toast.makeText(ListeCours.this, "Chiffre Description", Toast.LENGTH_SHORT).show();
                }
                if(position==0){
                    Toast.makeText(ListeCours.this, "Animaux Description", Toast.LENGTH_SHORT).show();
                }
                if(position==0){
                    Toast.makeText(ListeCours.this, "Lettre Description", Toast.LENGTH_SHORT).show();
                }
                if(position==0){
                    Toast.makeText(ListeCours.this, "Vegetable Description", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    class MyAdapter extends ArrayAdapter<String>{
        Context context ;
        String rTitle[];
        String rDescription[];
        int rImg[];
        MyAdapter(Context c , String title[] , String description[] , int img[]){

            super(c,R.layout.row , R.id.textView1 , title);
            this.context=c;
            this.rTitle=title;
            this.rDescription=description;
            this.rImg=img;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater=(LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row,parent,false);
            ImageView images = row.findViewById(R.id.image);
            TextView myTitle = row.findViewById(R.id.textView1);
            TextView myDescription = row.findViewById(R.id.textView2);

            images.setImageResource(rImg[position]);
            myTitle.setText(rTitle[position]);
            myDescription.setText(rDescription[position]);

            return row;
        }
    }
}