package com.example.android.muzik;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.android.miwok.R;


public class PlaylistFragment extends Fragment {

    public PlaylistFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View viewRoot = inflater.inflate(R.layout.fragment_playlist, container, false);

        Button play = (Button) viewRoot.findViewById(R.id.play);
        if (play != null) {
            play.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent playlistIntent = new Intent(getActivity(), ListenActivity.class);
                    startActivity(playlistIntent);
                }
            });
        }
        return viewRoot;
    }
}
