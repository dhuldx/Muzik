package com.example.android.muzik;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.miwok.R;

import java.util.concurrent.TimeUnit;

    public class SongsFragment extends Fragment{
        private Button b1,b2,b3,b4;
        private ImageView iv;
        private MediaPlayer mediaPlayer;
        private double startTime = 0;
        private double finalTime = 0;
        private Handler myHandler = new Handler();;
        private int forwardTime = 5000;
        private int backwardTime = 5000;
        private SeekBar seekbar;
        private TextView tx1,tx2,tx3;

        public static int oneTimeOnly = 0;
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState)  {
            View rootView = inflater.inflate(R.layout.fragment_songs, container, false);




            b1 = (Button) getView().findViewById(R.id.button);
            b2 = (Button) getView().findViewById(R.id.button2);
            b3=(Button)getView().findViewById(R.id.button3);
            b4=(Button)getView().findViewById(R.id.button4);
            iv=(ImageView)getView().findViewById(R.id.imageView);

            tx1=(TextView)getView().findViewById(R.id.textView2);
            tx2=(TextView)getView().findViewById(R.id.textView3);
            tx3=(TextView)getView().findViewById(R.id.textView4);
            tx3.setText("song.mp3");

            mediaPlayer = MediaPlayer.create(getActivity(), R.raw.song);
            seekbar=(SeekBar)getView().findViewById(R.id.seekBar);
            seekbar.setClickable(false);
            b2.setEnabled(false);

            b3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getActivity().getApplicationContext(), "Playing sound",Toast.LENGTH_SHORT).show();
                    mediaPlayer.start();

                    finalTime = mediaPlayer.getDuration();
                    startTime = mediaPlayer.getCurrentPosition();

                    if (oneTimeOnly == 0) {
                        seekbar.setMax((int) finalTime);
                        oneTimeOnly = 1;
                    }
                    tx2.setText(String.format("%d min, %d sec",
                            TimeUnit.MILLISECONDS.toMinutes((long) finalTime),
                            TimeUnit.MILLISECONDS.toSeconds((long) finalTime) -
                                    TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long) finalTime)))
                    );

                    tx1.setText(String.format("%d min, %d sec",
                            TimeUnit.MILLISECONDS.toMinutes((long) startTime),
                            TimeUnit.MILLISECONDS.toSeconds((long) startTime) -
                                    TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long) startTime)))
                    );

                    seekbar.setProgress((int)startTime);
                    myHandler.postDelayed(UpdateSongTime,100);
                    b2.setEnabled(true);
                    b3.setEnabled(false);
                }
            });

            b2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getActivity().getApplicationContext(), "Pausing sound",Toast.LENGTH_SHORT).show();
                    mediaPlayer.pause();
                    b2.setEnabled(false);
                    b3.setEnabled(true);
                }
            });

            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int temp = (int)startTime;

                    if((temp+forwardTime)<=finalTime){
                        startTime = startTime + forwardTime;
                        mediaPlayer.seekTo((int) startTime);
                        Toast.makeText(getActivity().getApplicationContext(),"You have Jumped forward 5 seconds",Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(getActivity().getApplicationContext(),"Cannot jump forward 5 seconds",Toast.LENGTH_SHORT).show();
                    }
                }
            });

            b4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int temp = (int)startTime;

                    if((temp-backwardTime)>0){
                        startTime = startTime - backwardTime;
                        mediaPlayer.seekTo((int) startTime);
                        Toast.makeText(getActivity().getApplicationContext(),"You have Jumped backward 5 seconds",Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(getActivity().getApplicationContext(),"Cannot jump backward 5 seconds",Toast.LENGTH_SHORT).show();
                    }
                }
            });
            return rootView;
        }

        private Runnable UpdateSongTime = new Runnable() {
            public void run() {
                startTime = mediaPlayer.getCurrentPosition();
                tx1.setText(String.format("%d min, %d sec",

                        TimeUnit.MILLISECONDS.toMinutes((long) startTime),
                        TimeUnit.MILLISECONDS.toSeconds((long) startTime) -
                                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.
                                        toMinutes((long) startTime)))
                );
                seekbar.setProgress((int)startTime);
                myHandler.postDelayed(this, 100);
            }
        };

        /*@Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getActivity().getMenuInflater().inflate(R.menu.menu_main, menu);
            return true;
        }*/

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

