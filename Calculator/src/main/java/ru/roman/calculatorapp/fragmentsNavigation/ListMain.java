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
import ru.roman.calculatorapp.utils.NumbersToListViews;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListMain extends Fragment {


    private final String MY_LOG = "myListMain";
    // TODO: 15.04.2017 Объявляем переменные для View элементов
    private ListView listView_1;
    private ListViewAdapter listViewAdapter;
    private OnLinkItemSelectedListenerMain mItemListenerMain;


    NumbersToListViews numToList;
    private String[] mItemArray = {"ИЗГОТОВЛЕНИЕ ТРАФАРЕТОВ 1", "ОБЪЕМНЫЕ БУКВЫ 2", "Мурзик 3", "Мурка 4", "Васька 5", "Томасина 6", "Кристина 7", "Пушок 8", "Дымка 9"};


    public ListMain() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(MY_LOG,"ListMain: Сработал onCreateView");

        ((MainActivity) getActivity()).setDrawerOnIcon(true);

        View view = inflater.inflate(R.layout.fragment_list_main, container, false);
        ((MainActivity) getActivity()).toolbar.setTitle(R.string.app_name);
        ((MainActivity)getActivity()).fab.setVisibility(View.GONE);

        numToList = new NumbersToListViews();
        listView_1 = (ListView) view.findViewById(R.id.mainListView);

        listViewAdapter = new ListViewAdapter(getActivity(), numToList.getNumItems(mItemArray), mItemArray);

        listView_1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selection = listViewAdapter.getString(position);
                mItemListenerMain.OnItemSelectedMain(position, selection);
                // TODO: 08.02.2018 открываем список по мере заполнения данными, когда все готово условие убрать!
            }
        });


        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        listView_1.setAdapter(listViewAdapter);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof OnLinkItemSelectedListenerMain) {
            mItemListenerMain = (OnLinkItemSelectedListenerMain) context;
        } else {
            throw new ClassCastException(context.toString()
                    + " must implement MyListFragment.OnItemSelectedListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();

        mItemListenerMain = null;
    }

    public interface OnLinkItemSelectedListenerMain {
        void OnItemSelectedMain(int num, String selection);
    }

}
