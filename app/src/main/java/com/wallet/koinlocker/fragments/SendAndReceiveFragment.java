package com.wallet.koinlocker.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wallet.koinlocker.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SendAndReceiveFragment extends Fragment {


    public SendAndReceiveFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_send_and_receive, container, false);
    }

}
