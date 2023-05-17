package com.example.photobomb1.BottomFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.photobomb1.R;
import com.google.android.material.textfield.TextInputEditText;

public class CreateGroupFragment extends Fragment {

    TextInputEditText startGroup,edtGroupexpiry,edtUserAccess;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_create_group, container, false);

        startGroup=view.findViewById(R.id.edtGroupstart);
        edtGroupexpiry=view.findViewById(R.id.edtGroupexpiry);
        edtUserAccess=view.findViewById(R.id.edtUserAccess);


        startGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return view;
    }
}