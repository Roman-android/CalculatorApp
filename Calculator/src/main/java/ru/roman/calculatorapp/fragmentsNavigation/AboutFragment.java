package ru.roman.calculatorapp.fragmentsNavigation;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import ru.roman.calculatorapp.ActivityMain;
import ru.roman.calculatorapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AboutFragment extends Fragment {


    public AboutFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //((ActivityMain) getActivity()).setDrawerOnIcon(true);
        ((ActivityMain) getActivity()).getSupportActionBar().setHomeButtonEnabled(true);
        ((ActivityMain) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((ActivityMain) getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(true);
        return inflater.inflate(R.layout.fragment_about, container, false);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Toast.makeText(getActivity(), "onAttach", Toast.LENGTH_SHORT).show();

    }
}
