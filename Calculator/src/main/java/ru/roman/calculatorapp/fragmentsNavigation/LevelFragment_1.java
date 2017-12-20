package ru.roman.calculatorapp.fragmentsNavigation;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import ru.roman.calculatorapp.ActivityMain;
import ru.roman.calculatorapp.R;
import ru.roman.calculatorapp.adapters.ListViewAdapter;

/**
 * A simple {@link Fragment} subclass.
 */

public class LevelFragment_1 extends Fragment {

    private int position;
    private String selection;
    private final String MY_LOG = "levelFragment1";

    OnLinkItemSelectedListenerUnder mItemListenerUnder;

    public LevelFragment_1() {
        // Required empty public constructor
    }

    public interface OnLinkItemSelectedListenerUnder {
        void onItemSelectedUnder(int itemPosition, String selection);
    }

    public static LevelFragment_1 newInstance(int position, String selection) {
        LevelFragment_1 levelFragment_1 = new LevelFragment_1();
        Bundle args = new Bundle();
        args.putInt("position", position);
        args.putString("selection", selection);
        levelFragment_1.setArguments(args);
        return levelFragment_1;
    }

    private ListView listView_1;
    private ListViewAdapter listViewAdapter_1;

    // TODO: 19.04.2017 Для уровня 1
    private Integer[] mImageArrayLevel_1 = {R.drawable.ic_opti1_10, R.drawable.ic_opti1_09, R.drawable.ic_opti1_08, R.drawable.ic_opti1_07,
            R.drawable.ic_opti1_06, R.drawable.ic_opti1_05, R.drawable.ic_opti1_04, R.drawable.ic_opti1_03,
            R.drawable.ic_opti1_02};
    private String[] mItemArray_1 = {"Рыжик 1-1", "Барсик 1-2", "Мурзик 1-3",
            "Мурка 1-4", "Васька 1-5", "Томасина 1-6", "Кристина 1-7", "Пушок 1-8", "Дымка 1-9"};

    private String[] mItemArray_2 = {"Рыжик 2-1", "Барсик 2-2", "Мурзик 2-3",
            "Мурка 2-4", "Васька 2-5", "Томасина 2-6", "Кристина 2-7", "Пушок 2-8", "Дымка 2-9"};

    private String[] mItemArray_3 = {"Рыжик 3-1", "Барсик 3-2", "Мурзик 3-3",
            "Мурка 3-4", "Васька 3-5", "Томасина 3-6", "Кристина 3-7", "Пушок 3-8", "Дымка 3-9"};

    private String[] mItemArray_4 = {"Рыжик 4-1", "Барсик 4-2", "Мурзик 4-3",
            "Мурка 4-4", "Васька 4-5", "Томасина 4-6", "Кристина 4-7", "Пушок 4-8", "Дымка 4-9"};

    private String[] mItemArray_5 = {"Рыжик 5-1", "Барсик 5-2", "Мурзик 5-3",
            "Мурка 5-4", "Васька 5-5", "Томасина 5-6", "Кристина 5-7", "Пушок 5-8", "Дымка 5-9"};

    private String[] mItemArray_6 = {"Рыжик 6-1", "Барсик 6-2", "Мурзик 6-3",
            "Мурка 6-4", "Васька 6-5", "Томасина 6-6", "Кристина 6-7", "Пушок 6-8", "Дымка 6-9"};

    private String[] mItemArray_7 = {"Рыжик 7-1", "Барсик 7-2", "Мурзик 7-3",
            "Мурка 7-4", "Васька 7-5", "Томасина 7-6", "Кристина 7-7", "Пушок 7-8", "Дымка 7-9"};

    private String[] mItemArray_8 = {"Рыжик 8-1", "Барсик 8-2", "Мурзик 8-3",
            "Мурка 8-4", "Васька 8-5", "Томасина 8-6", "Кристина 8-7", "Пушок 8-8", "Дымка 8-9"};

    private String[] mItemArray_9 = {"Рыжик 9-1", "Барсик 9-2", "Мурзик 9-3",
            "Мурка 9-4", "Васька 9-5", "Томасина 9-6", "Кристина 9-7", "Пушок 9-8", "Дымка 9-9"};

    String[][] allMaterials = {mItemArray_1, mItemArray_2, mItemArray_3, mItemArray_4, mItemArray_5,
            mItemArray_6, mItemArray_7, mItemArray_8, mItemArray_9,};

    /*private String[][] itemArrayAll = {mItemArray_1,mItemArray_2,mItemArray_3,mItemArray_4,mItemArray_5,
            mItemArray_6,mItemArray_7,mItemArray_8,mItemArray_9};*/
    //private ArrayList<String> mItemArray = new ArrayList<>(size);


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        position = getArguments().getInt("position", 0);
        selection = getArguments().getString("selection", "");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Log.d(MY_LOG, "LevelFragment1: Сработал onCreateView");
        Log.d(MY_LOG, "position: "+position);
        Log.d(MY_LOG, "selection: "+selection);

        View view = inflater.inflate(R.layout.fragment_list_main, container, false);
        ((ActivityMain)getActivity()).toolbar.setTitle(selection);
        ((ActivityMain) getActivity()).fab.setVisibility(View.VISIBLE);

        listView_1 = (ListView) view.findViewById(R.id.mainListView);

        listViewAdapter_1 = new ListViewAdapter(getActivity(), allMaterials[position], mImageArrayLevel_1);

        listView_1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selection = listViewAdapter_1.getString(position);
                mItemListenerUnder.onItemSelectedUnder(position, selection);
            }

        });

        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listView_1.setAdapter(listViewAdapter_1);
        ((ActivityMain) getActivity()).setDrawerOnIcon(false);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof LevelFragment_1.OnLinkItemSelectedListenerUnder) {
            mItemListenerUnder = (LevelFragment_1.OnLinkItemSelectedListenerUnder) context;
        } else {
            throw new ClassCastException(context.toString()
                    + " must implement MyListFragment.OnItemSelectedListener");
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //((ActivityMain) getActivity()).setDrawerOnIcon(true);
        Log.d(MY_LOG, "onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //((ActivityMain)getActivity()).setDrawerOnIcon(true);
        Log.d(MY_LOG, "onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();

        mItemListenerUnder = null;
        Log.d(MY_LOG, "onDetach");
    }
}