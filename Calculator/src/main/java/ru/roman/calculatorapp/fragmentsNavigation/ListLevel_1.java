package ru.roman.calculatorapp.fragmentsNavigation;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import ru.roman.calculatorapp.MainActivity;
import ru.roman.calculatorapp.R;
import ru.roman.calculatorapp.adapters.ListViewAdapter;

/**
 * A simple {@link Fragment} subclass.
 */

public class ListLevel_1 extends Fragment {

    private final String MY_LOG = "levelFragment1";
    OnLinkItemSelectedListenerUnder mItemListenerUnder;
    private int position;
    private String selection;
    private ListView listView_1;
    private ListViewAdapter listViewAdapter_1;
    // TODO: 19.04.2017 Для уровня 1
    private Integer[] mItemArrayLevel_1 = {R.drawable.item_1_1, R.drawable.item_1_2, R.drawable.item_1_3, R.drawable.item_1_4,
            R.drawable.ic_opti1_06, R.drawable.item_1_6, R.drawable.ic_opti1_04, R.drawable.ic_opti1_03, R.drawable.ic_opti1_02};
    private Integer[] mItemArrayLevel_2 = {R.drawable.item_2_1, R.drawable.item_2_2, R.drawable.item_2_3, R.drawable.item_2_4,
            R.drawable.item_2_5, R.drawable.item_2_6, R.drawable.ic_opti1_04, R.drawable.ic_opti1_03, R.drawable.ic_opti1_02};
    private Integer[][] allArrayItems = {mItemArrayLevel_1, mItemArrayLevel_2};


    private String[] mItemArray_1 = {"Трафареты из алюминия 1-1", "Трафареты из магнитоалюминия 1-item_2", "Трафареты из магнитопластика 1-item_3",
            "Трафареты из нержавейки 1-item_4", "Трафареты из оцинковки 1-item_5", "Трафареты из пластика ПЭТ 1-item_6", "Трафареты из пленки ORACAL 1-item_7"};
    private String[] mItemArray_2 = {"Буквы деревянные item_2-1", "Буквы из композита item_2-item_2", "Буквы из оргстекла item_2-item_3",
            "Буквы из ПВХ item_2-item_4", "Буквы из ПЕНОПЛАСТА item_2-item_5"};
    private String[] mItemArray_3 = {"Рыжик item_3-1", "Барсик item_3-item_2", "Мурзик item_3-item_3",
            "Мурка item_3-item_4", "Васька item_3-item_5", "Томасина item_3-item_6", "Кристина item_3-item_7", "Пушок item_3-item_8", "Дымка item_3-item_9"};
    private String[] mItemArray_4 = {"Рыжик item_4-1", "Барсик item_4-item_2", "Мурзик item_4-item_3",
            "Мурка item_4-item_4", "Васька item_4-item_5", "Томасина item_4-item_6", "Кристина item_4-item_7", "Пушок item_4-item_8", "Дымка item_4-item_9"};
    private String[] mItemArray_5 = {"Рыжик item_5-1", "Барсик item_5-item_2", "Мурзик item_5-item_3",
            "Мурка item_5-item_4", "Васька item_5-item_5", "Томасина item_5-item_6", "Кристина item_5-item_7", "Пушок item_5-item_8", "Дымка item_5-item_9"};
    private String[] mItemArray_6 = {"Рыжик item_6-1", "Барсик item_6-item_2", "Мурзик item_6-item_3",
            "Мурка item_6-item_4", "Васька item_6-item_5", "Томасина item_6-item_6", "Кристина item_6-item_7", "Пушок item_6-item_8", "Дымка item_6-item_9"};
    private String[] mItemArray_7 = {"Рыжик item_7-1", "Барсик item_7-item_2", "Мурзик item_7-item_3",
            "Мурка item_7-item_4", "Васька item_7-item_5", "Томасина item_7-item_6", "Кристина item_7-item_7", "Пушок item_7-item_8", "Дымка item_7-item_9"};
    private String[] mItemArray_8 = {"Рыжик item_8-1", "Барсик item_8-item_2", "Мурзик item_8-item_3",
            "Мурка item_8-item_4", "Васька item_8-item_5", "Томасина item_8-item_6", "Кристина item_8-item_7", "Пушок item_8-item_8", "Дымка item_8-item_9"};
    private String[] mItemArray_9 = {"Рыжик item_9-1", "Барсик item_9-item_2", "Мурзик item_9-item_3",
            "Мурка item_9-item_4", "Васька item_9-item_5", "Томасина item_9-item_6", "Кристина item_9-item_7", "Пушок item_9-item_8", "Дымка item_9-item_9"};
    String[][] allMaterials = {mItemArray_1, mItemArray_2, mItemArray_3, mItemArray_4, mItemArray_5,
            mItemArray_6, mItemArray_7, mItemArray_8, mItemArray_9,};

    public ListLevel_1() {
        // Required empty public constructor
    }

    public static ListLevel_1 newInstance(int position, String selection) {
        ListLevel_1 listLevel_1 = new ListLevel_1();
        Bundle args = new Bundle();
        args.putInt("position", position);
        args.putString("selection", selection);
        listLevel_1.setArguments(args);
        return listLevel_1;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        position = getArguments().getInt("position", 0);
        selection = getArguments().getString("selection", "");
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Log.d(MY_LOG, "LevelFragment1: Сработал onCreateView");
        Log.d(MY_LOG, "position: "+position);
        Log.d(MY_LOG, "selection: "+selection);

        View view = inflater.inflate(R.layout.fragment_list_main, container, false);
        if (getActivity() != null) {
            ((MainActivity) getActivity()).toolbar.setTitle(selection);
            ((MainActivity) getActivity()).fab.setVisibility(View.GONE);
        }


        listView_1 = (ListView) view.findViewById(R.id.mainListView);

        listViewAdapter_1 = new ListViewAdapter(getActivity(), allMaterials[position], allArrayItems[position]);

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
        if (getActivity() != null) {
            ((MainActivity) getActivity()).setDrawerOnIcon(false);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof ListLevel_1.OnLinkItemSelectedListenerUnder) {
            mItemListenerUnder = (ListLevel_1.OnLinkItemSelectedListenerUnder) context;
        } else {
            throw new ClassCastException(context.toString()
                    + " must implement MyListFragment.OnItemSelectedListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();

        mItemListenerUnder = null;
        Log.d(MY_LOG, "onDetach");
    }

    public interface OnLinkItemSelectedListenerUnder {
        void onItemSelectedUnder(int itemPosition, String selection);
    }
}
