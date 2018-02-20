package ru.roman.calculatorapp.fragmentsNavigation;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import ru.roman.calculatorapp.MainActivity;
import ru.roman.calculatorapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AboutFragment extends Fragment {


    public AboutFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_about, container, false);

        if (getActivity() != null) {
            ((MainActivity) getActivity()).setDrawerOnIcon(false);
            ((MainActivity) getActivity()).toolbar.setTitle(R.string.about);
        }

        return view;
    }

}
