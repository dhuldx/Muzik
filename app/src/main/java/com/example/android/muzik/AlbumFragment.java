package com.example.android.muzik;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.miwok.R;


public class AlbumFragment extends Fragment{

    public AlbumFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
                TextView play = (TextView) getActivity().findViewById(R.id.play);
        if (play != null) {
            play.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent albumIntent = new Intent(getActivity(), ListenActivity.class);
                    startActivity(albumIntent);

                }
            });
        }
// Inflate the layout for this fragment
            return inflater.inflate(R.layout.fragment_album, container, false);


        }
}

