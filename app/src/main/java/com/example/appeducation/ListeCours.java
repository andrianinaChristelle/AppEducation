package com.example.appeducation;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.appeducation.ui.home.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.List;

public class ListeCours extends AppCompatActivity {
    ListView listeView;
    String nTitle[]={"Chiffre" , "Animaux" , "lettre","vegetable"};
    String nDescription[]={"Chiffre Description" , "animaux Description" , "Lettre Decsription" , "Vegetable description"};
    int images[] ={R.drawable.chiffre,R.drawable.animaux1,R.drawable.lettres,R.drawable.vegetable};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_cours);



        listeView = findViewById(R.id.listView);
        MyAdapter adapter =new MyAdapter(this, nTitle , nDescription,images);
        listeView.setAdapter(adapter);

        VideoView videoView = findViewById(R.id.video_view);
        String videoPath = "android.resource://"+ getPackageName() + "/" + R.raw.video;
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);
        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);




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