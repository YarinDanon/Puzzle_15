package com.yarin.puzzle15;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {

    private Button btnStartGame;
    private Switch swtMusic;
    private Intent gameActiviti;
    private MediaPlayer mp;
    private SharedPreferences sp;
    private boolean musicOn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Start game Button
        gameActiviti = new Intent(this,GameActivity.class);
        btnStartGame = (Button) findViewById(R.id.btnStartGameID);
        btnStartGame.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                gameActiviti.putExtra("musicOn",musicOn);
                startActivity(gameActiviti);
            }
        });

        //  == Music Switch ==
        mp = MediaPlayer.create(this,R.raw.music);
        mp.setLooping(true);
        swtMusic = (Switch) findViewById(R.id.swtMusicID);
        // read music preferences from memory
        sp = getSharedPreferences("musicPref",MODE_PRIVATE);
        musicOn = sp.getBoolean("musicOn",false);
        swtMusic.setChecked(musicOn);
        final SharedPreferences.Editor editor = sp.edit();
        // listener to music switch
        swtMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(swtMusic.isChecked()) {
                    mp.start();
                    editor.putBoolean("musicOn",true);
                    musicOn = true;
                }
                else {
                    mp.pause();
                    editor.putBoolean("musicOn",false);
                    musicOn = false;
                }
                editor.commit();
            }
        });


    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        mp.stop();
    }
    @Override
    public void onPause(){
        super.onPause();
        Log.d("paumain","pause");
        mp.pause();
    }
    @Override
    public void onResume(){
        super.onResume();
        Log.d("resume","resume");
        if(musicOn)
            mp.start();
    }

    // Action Bar
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        super.onCreateOptionsMenu(menu);
        MenuItem menuAbout = menu.add("About");
        MenuItem menuExit = menu.add("Exit");

        menuAbout.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener()
        {
            @Override
            public boolean onMenuItemClick(MenuItem item)
            {
                showAboutDialog();
                return true;
            }
        });

        menuExit.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener()
        {
            @Override
            public boolean onMenuItemClick(MenuItem item)
            {
                showExitDialog();
                return true;
            }
        });
        return true;
    }

    private void showAboutDialog()
    {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("About the game");
        alertDialog.setMessage(getString(R.string.about));
        alertDialog.show();
        //Toast.makeText(this, "ABOUT", Toast.LENGTH_SHORT).show();
    }

    private void showExitDialog()
    {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setIcon(R.drawable.ic_exit);
        alertDialog.setTitle("Exit game");
        alertDialog.setMessage("Do you really want to exit?");
        alertDialog.setCancelable(false);
        alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                finish();  // destroy this activity
            }
        });
        alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {

            }
        });
        alertDialog.show();
    }
}
