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

public class ListLevel_1 extends Fragment {

    private final String MY_LOG = "levelFragment1";

    NumbersToListViews numToList;
    OnLinkItemSelectedListenerUnder mItemListenerUnder;

    private int position;
    private String selection;
    private ListView listView_1;
    private ListViewAdapter listViewAdapter_1;

    private String[] mItemArray_1 = {"Из алюминия", "Из магнитоалюминия", "Из магнитопластика",
            "Из нержавейки", "Из оцинковки", "Из пластика", "Из пленки ORACAL","Для пескоструйки","Из фанеры","Гигантские трафареты"};
    private String[] mItemArray_2 = {"Из дерева", "Из композита", "Из фанеры","Из оргстекла", "Из ПВХ", "Из пенопласта","Золотые, серебрянные","Из нержавейки"};
    private String[] mItemArray_3 = {"Магнитные цветные", "Из оцинковки", "Их ПВХ", "Из нержавейки","Из фанеры", "Из цветного акрила", "Из прозрачного оргстекла", "Из композита","Золотой пластик","Серебряный пластик"};
    private String[] mItemArray_4 = {"Металлические", "Из фанеры","Из ПВХ", "Из дерева"};
    private String[] mItemArray_5 = {"Прозрачное", "Ударопрочное","Затемненное. Черное", "Матовое Опал", "Цветное", "Зеркальное","Молочное"};
    private String[] mItemArray_6 = {"Полка прямоугольная", "Столик", "Ящик. короб", "Рамка", "Подставка. Поднос", "Наличник","Медальница","Мишень","Герб"};
    private String[] mItemArray_7 = {"Из ПВХ", "Из МДФ", "Из фанеры", "Из дерева", "из металла"};
    private String[] mItemArray_8 = {"Из пластика", "Из металла"};
    private String[] mItemArray_9 = {"На оргстекле", "На обычном стекле", "На фанере", "На мдф", "На золотом зеркальном пластике", "На серебряном зеркальном пластике", "На золотом матовом пластике", "На серебряном матовом пластике", "На цветном пластике"};
    private String[] mItemArray_10 = {"Из оргстекла", "Из ПВХ", "Из фанеры", "Из мдф", "На золотом зеркальном пластике", "На серебряном зеркальном пластике", "На золотом матовом пластике", "На серебряном матовом пластике", "На цветном пластике","Из зеркальной нержавейки", "Из аллюминия","Из металла","Из композита"};
    private String[] mItemArray_11 = {"Наклейки полноцвет", "Наклейки из ORACAL", "Трафареты из ORACAL", "Трафареты для пескоструйки"};
    String[][] allMaterials = {mItemArray_1, mItemArray_2, mItemArray_3, mItemArray_4, mItemArray_5,
            mItemArray_6, mItemArray_7, mItemArray_8, mItemArray_9, mItemArray_10,mItemArray_11};

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

        numToList = new NumbersToListViews();
        listViewAdapter_1 = new ListViewAdapter(getActivity(), numToList.getNumItems(allMaterials[position]), allMaterials[position]);

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
