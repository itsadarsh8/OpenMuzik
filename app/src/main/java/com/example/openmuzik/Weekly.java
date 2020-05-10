package com.example.openmuzik;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Weekly extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_list);

        final ArrayList<AlbumDetail> albumList = new ArrayList<>();


        albumList.add(new AlbumDetail("Artist1", "Music 1", R.drawable.weekly,R.raw.number_two));
        albumList.add(new AlbumDetail("Artist2", "Music 2", R.drawable.weekly,R.raw.number_two));
        albumList.add(new AlbumDetail("Artist3", "Music 3", R.drawable.weekly,R.raw.number_two));
        albumList.add(new AlbumDetail("Artist4", "Music 4", R.drawable.weekly,R.raw.number_two));
        albumList.add(new AlbumDetail("Artist5", "Music 5", R.drawable.weekly,R.raw.number_two));
        albumList.add(new AlbumDetail("Artist6", "Music 6", R.drawable.weekly,R.raw.number_two));
        albumList.add(new AlbumDetail("Artist7", "Music 7", R.drawable.weekly,R.raw.number_two));
        albumList.add(new AlbumDetail("Artist8", "Music 8", R.drawable.weekly,R.raw.number_two));
        albumList.add(new AlbumDetail("Artist9", "Music 9", R.drawable.weekly,R.raw.number_two));
        albumList.add(new AlbumDetail("Artist10", "Music 10", R.drawable.weekly,R.raw.number_two));
        albumList.add(new AlbumDetail("Artist11", "Music 11", R.drawable.weekly,R.raw.number_two));
        albumList.add(new AlbumDetail("Artist12", "Music 12", R.drawable.weekly,R.raw.number_two));

        AlbumAdapter albumAdapter = new AlbumAdapter(this, albumList,R.color.weeklyColor);

        ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(albumAdapter);



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AlbumDetail albumDetail=albumList.get(position);
                mediaPlayer=MediaPlayer.create(Weekly
                        .this,albumDetail.getAudioId());
                mediaPlayer.start();



                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener(){
                    @Override
                    public void onCompletion(MediaPlayer mp){
                        mediaPlayer.release();

                        Log.i("exit","done");
                    }
                });
            }
        });


    }
}
