package ru.roman.calculatorapp;


import android.Manifest;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.lypeer.fcpermission.FcPermissions;
import com.lypeer.fcpermission.impl.FcPermissionsCallbacks;

import java.util.List;

import ru.roman.calculatorapp.adapters.ViewPagerAdapter;
import ru.roman.calculatorapp.utils.CalculationFormula;
import ru.roman.calculatorapp.utils.RecourcesToViewPager;
import ru.roman.calculatorapp.utils.SendSMS;


/**
 * A simple {@link Fragment} subclass.
 */
public class ViewPagerWorkFragment extends Fragment implements Button.OnClickListener, TextWatcher,FcPermissionsCallbacks {

    private final String MY_LOG = "myFilterPageWork";
    BottomSheetBehavior behavior;
    String valueLength, valueWidth, valueNumList, valueSpinnerSq;
    Spinner spinnerMeters, spinnerSquare;
    // TODO: 30.01.2018 Импорт классов
    ViewPagerAdapter viewPagerAdapter;
    RecourcesToViewPager recourcesToViewPager;
    CalculationFormula calculationFormula;
    private View bottomSheet;
    private TextView bottomSheetPick;
    private FloatingActionButton fab;
    private String textSms;
    private Button btnCalcMeters, btnCalcSquare;
    private View calcByMeters, calcBySquare;
    // TODO: 22.07.2017 объявляем переменные для calc_by_meters и calc_by_square
    private EditText countOfMeters, countOfIncut;
    private EditText mNumLength, mNumWidth, mNumLists;
    private TextView result_cost_by_meters, result_cost_by_square;
    private String valueMeters, valueIncut, valueSpinnerMetr;
    // TODO: 15.08.2017 Получаем номера выбранных позиций в ListMain и ListLevel_1 и текст выбранной позиции в ListLevel_1
    private int position_from_listMain;
    private int position_from_levelFragment_1;
    private String selection;
    private int[] imgShow;
    private String [] descrText;

    public ViewPagerWorkFragment() {
        // Required empty public constructor
    }

    public static ViewPagerWorkFragment newInstance(int positionLevel_1, int positionLevel_2,String selection) {
        ViewPagerWorkFragment viewPagerWorkFragment = new ViewPagerWorkFragment();
        Bundle args = new Bundle();
        args.putInt("position_from_listMain", positionLevel_1);
        args.putInt("position_from_levelFragment_1", positionLevel_2);
        args.putString("selection",selection);
        viewPagerWorkFragment.setArguments(args);

        return viewPagerWorkFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        position_from_listMain = getArguments().getInt("position_from_listMain", 0);
        position_from_levelFragment_1 = getArguments().getInt("position_from_levelFragment_1", 0);
        selection = getArguments().getString("selection","");

        // TODO: 23.01.2018 Получаем текст и картинки для класса ViewPager в зависимости от выбранного пункта
        recourcesToViewPager = new RecourcesToViewPager(getContext(), position_from_listMain,position_from_levelFragment_1);
        imgShow = recourcesToViewPager.chooseImgArray();
        descrText = recourcesToViewPager.chooseTextArray();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_view_pager_work, container, false);
        if (((MainActivity) getActivity()) != null) {
            ((MainActivity) getActivity()).toolbar.setTitle(selection);
        }

        Log.d(MY_LOG, "ViewPagerWork: Сработал onCreateView");
        Log.d(MY_LOG, "position_from_listMain: "+position_from_listMain);
        Log.d(MY_LOG, "position_from_levelFragment_1: "+position_from_levelFragment_1);
        Log.d(MY_LOG, "selection: "+selection);

        // TODO: 22.07.2017 подключаем viewPagerAdapter
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        viewPagerAdapter = new ViewPagerAdapter(getContext(), imgShow, descrText);
        viewPager.setAdapter(viewPagerAdapter);


        // TODO: 30.01.2018 Инициализируем класс CalculationFormula
        calculationFormula = new CalculationFormula(position_from_listMain,position_from_levelFragment_1);

        // TODO: 25.09.2017 Отправка СМС
        fab = (FloatingActionButton) view.findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (result_cost_by_meters.getText() != "Заполните все поля" && result_cost_by_meters.length() > 0 && calcByMeters.getVisibility() == View.VISIBLE) {
                    textSms = "Pogonnii metr: Metrov: " + valueMeters + " Vrezok: " + valueIncut + " Tolshina: " + valueSpinnerMetr +
                            " Stoimost: " + calculationFormula.roundMetr();
                    Toast.makeText(getActivity(), textSms, Toast.LENGTH_SHORT).show();
                    requestSMSPermission();
                } else if (result_cost_by_square.getText() != "Заполните все поля" && result_cost_by_square.length() > 0 && calcBySquare.getVisibility() == View.VISIBLE) {
                    textSms = "Raschet po ploshadi: Dlina: " + valueLength + " Shirina: " + valueWidth +
                            " Kolichestvo: " + valueNumList + " Tolshina: " + valueSpinnerSq + " Stoimost " + calculationFormula.roundSquare();
                    Toast.makeText(getActivity(), textSms, Toast.LENGTH_SHORT).show();
                } else {
                    Log.d(MY_LOG, "Заполните все поля");
                    Toast.makeText(getActivity(), "Заполните все поля! Сообщение с заказом не отправлено!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        bottomSheetPick = (TextView) view.findViewById(R.id.bottom_sheet_pick);
        bottomSheet = view.findViewById(R.id.bottom_sheet);

        btnCalcMeters = (Button) view.findViewById(R.id.but_calc_meters);
        btnCalcSquare = (Button) view.findViewById(R.id.but_calc_square);
        btnCalcMeters.setEnabled(false);

        // TODO: 29.06.2017 инициализируем переменные для calcByMeters
        countOfMeters = (EditText) view.findViewById(R.id.num_of_count_meters);
        countOfMeters.addTextChangedListener(this);

        countOfIncut = (EditText) view.findViewById(R.id.num_count_of_incut);
        countOfIncut.addTextChangedListener(this);

        spinnerMeters = (Spinner) view.findViewById(R.id.spinnerMeters);
        ArrayAdapter<String> arrayAdapterMeters = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, recourcesToViewPager.chooseSpinnerArray());
        spinnerMeters.setAdapter(arrayAdapterMeters);

        result_cost_by_meters = (TextView) view.findViewById(R.id.cost_by_meters);

        // TODO: 22.07.2017 инициализируем переменные для calcBySquare
        mNumLength = (EditText) view.findViewById(R.id.num_of_length);
        mNumLength.addTextChangedListener(this);

        mNumWidth = (EditText) view.findViewById(R.id.num_of_width);
        mNumWidth.addTextChangedListener(this);

        mNumLists = (EditText) view.findViewById(R.id.num_of_lists);
        mNumLists.addTextChangedListener(this);

        spinnerSquare = (Spinner) view.findViewById(R.id.spinnerSquare);
        spinnerSquare.setAdapter(arrayAdapterMeters);

        result_cost_by_square = (TextView) view.findViewById(R.id.cost_by_square);

        calcByMeters = view.findViewById(R.id.calcByMeters);
        calcBySquare = view.findViewById(R.id.calcBySquare);

        btnCalcMeters.setOnClickListener(this);
        btnCalcSquare.setOnClickListener(this);

        behavior = BottomSheetBehavior.from(bottomSheet);
        behavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {

                switch (behavior.getState()) {
                    case 3:
                        //если bottomSheet==STATE_EXPANDED
                        bottomSheetPick.setText("Потяните вниз, чтоб свернуть");
                        break;
                    case 4:
                        //если bottomSheet==STATE_COLLAPSED
                        bottomSheetPick.setText("Потяните вверх, чтоб рассчитать стоимость");
                        break;
                }

            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });

        spinnerMeters.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                valueSpinnerMetr = spinnerMeters.getSelectedItem().toString();
                Toast.makeText(getActivity(), valueSpinnerMetr, Toast.LENGTH_SHORT).show();
                calculationFormula.countCost(countOfMeters,countOfIncut, spinnerMeters, result_cost_by_meters);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinnerSquare.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                valueSpinnerSq = spinnerSquare.getSelectedItem().toString();
                Toast.makeText(getActivity(), valueSpinnerSq, Toast.LENGTH_SHORT).show();
                calculationFormula.countCost(mNumLength,mNumWidth,mNumLists,spinnerSquare,result_cost_by_square);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (getActivity() != null) {
            ((MainActivity) getActivity()).setDrawerOnIcon(false);
        }
    }

    // TODO: 29.06.2017 обрабатываем нажатия на кнопки "Расчет по п.м." и "Расчет по площади"
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.but_calc_meters:
                Log.d(MY_LOG, "calc_meters");
                btnCalcMeters.setEnabled(false);
                btnCalcSquare.setEnabled(true);
                if (calcBySquare.getVisibility() == View.VISIBLE) {
                    calcBySquare.setVisibility(View.GONE);
                }

                if (calcByMeters.getVisibility() == View.GONE) {
                    calcByMeters.setVisibility(View.VISIBLE);
                }

                break;
            case R.id.but_calc_square:
                Log.d(MY_LOG, "calc_square");
                btnCalcSquare.setEnabled(false);
                btnCalcMeters.setEnabled(true);
                if (calcBySquare.getVisibility() == View.GONE) {
                    calcBySquare.setVisibility(View.VISIBLE);
                }

                if (calcByMeters.getVisibility() == View.VISIBLE) {
                    calcByMeters.setVisibility(View.GONE);
                }

                break;
        }
    }

    // TODO: 29.06.2017  метод (функция) для подсчета стоимости при вводе цифр в полях
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        //Log.d(MY_LOG,"beforeTextChange");
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

        if (calcByMeters.getVisibility() == View.VISIBLE) {
            valueMeters = countOfMeters.getText().toString();
            valueIncut = countOfIncut.getText().toString();
            valueSpinnerMetr = spinnerMeters.getSelectedItem().toString();
            calculationFormula.countCost(countOfMeters,countOfIncut, spinnerMeters, result_cost_by_meters);
        }

        if (calcBySquare.getVisibility() == View.VISIBLE) {
            valueLength = mNumLength.getText().toString();
            valueWidth = mNumWidth.getText().toString();
            valueNumList = mNumLists.getText().toString();
            valueSpinnerSq = spinnerSquare.getSelectedItem().toString();
            calculationFormula.countCost(mNumLength,mNumWidth,mNumLists,spinnerSquare,result_cost_by_square);
        }
    }

    @Override
    public void afterTextChanged(Editable s) {

    }

    // TODO: 25.09.2017 Работаем с разрешениями Android item_6.0 и выше

    private void requestSMSPermission () {
        FcPermissions.requestPermissions(this,"Требуется разрешение отправить СМС", FcPermissions.REQ_PER_CODE,Manifest.permission.SEND_SMS);
    }

    @Override
    public void onPermissionsGranted(int i, List<String> list) {
        new SendSMS(textSms);
        Toast.makeText(getActivity(), "Разрешение получено!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPermissionsDenied(int i, List<String> list) {
        Toast.makeText(getActivity(), "Разрешение НЕ получено!", Toast.LENGTH_SHORT).show();
        FcPermissions.checkDeniedPermissionsNeverAskAgain(getActivity(),"Разрешение для отправки СМС нужно для...",R.string.settings,R.string.cancel,list);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        FcPermissions.onRequestPermissionsResult(requestCode,permissions,grantResults,this);
    }

}
