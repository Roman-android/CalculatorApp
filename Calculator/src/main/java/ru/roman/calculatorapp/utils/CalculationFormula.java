package ru.roman.calculatorapp.utils;

import android.util.Log;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Roman on 30.01.2018.
 */

public class CalculationFormula {

    private final String CALC_LOG = "calc_log";
    int k = 1;
    int KPM_1_1 = 50;
    int KPM_1_2 = 60;
    int KPM_1_3 = 55;
    int KPM_2_1 = 6;
    int KPM_2_2 = 18;//17.5;
    int KP_1_1 = 9900;
    int KP_1_2 = 11900;
    int KP_1_3 = 4900;
    int KP_2_1 = 95;
    int KP_2_2 = 1250;
    private ArrayList<int[]> KPM_Array = new ArrayList<>();
    private ArrayList<int[]> KP_Array = new ArrayList<>();
    private int position_main, position_under;
    private int[] KPM_1 = new int[]{50, 60, 55};
    private int[] KPM_2 = new int[]{6, 18};
    private int[] KP_1 = new int[]{9900, 11900, 4900};
    private int[] KP_2 = new int[]{95, 1250};
    private String roundedResultMetrs,roundedResulSquare;


    public CalculationFormula(int position_main, int position_under) {
        this.position_main = position_main;
        this.position_under = position_under;

        KPM_Array.add(KPM_1);
        KPM_Array.add(KPM_2);

        KP_Array.add(KP_1);
        KP_Array.add(KP_2);
    }

    // TODO: 29.06.2017 методы (функции) для подсчета итоговой стоимости материала по погонным метрам
    public void countCost(EditText meters, EditText incut, Spinner spinnerMeters, TextView result_meters) {

        String valueMeters = meters.getText().toString();
        String valueIncut = incut.getText().toString();
        String valueSpinnerMetr = spinnerMeters.getSelectedItem().toString();

        if (meters.getText().length() > 0 && incut.length() > 0) {

            //double resultByMeters = Float.valueOf(valueMeters) * Float.valueOf(valueIncut) * Float.valueOf(valueSpinnerMetr) * choose_KPM();
            double resultByMeters = Float.valueOf(valueMeters) * Float.valueOf(valueIncut) * Float.valueOf(valueSpinnerMetr) * 10 * choose_KPM() + 500;

            roundedResultMetrs = String.valueOf(Math.round(resultByMeters));
            result_meters.setText(roundedResultMetrs);
            Log.d(CALC_LOG, "Неокругленный resultByMeters: " + String.valueOf(resultByMeters));
        } else {
            result_meters.setText("Заполните все поля");
        }

    }

    public String roundMetr() {
        return roundedResultMetrs;
    }

    private int choose_KPM() {
        int [] position = KPM_Array.get(position_main);
        return position[position_under];
    }


    // TODO: 29.06.2017 методы (функции) для подсчета итоговой стоимости материала по площади
    public void countCost(EditText length, EditText width, EditText numLists, Spinner spinnerSquare, TextView result_square) {

        String valueLength = length.getText().toString();
        String valueWidth = width.getText().toString();
        String valueNumLists = numLists.getText().toString();
        String valueSpinnerSquare = spinnerSquare.getSelectedItem().toString();

        if (length.getText().length() > 0 && width.length() > 0 && numLists.length() > 0) {

            //double resultBySquare = Float.valueOf(valueLength) * Float.valueOf(valueWidth) * Float.valueOf(valueNumLists) * Float.valueOf(valueSpinnerSquare) * choose_KP();
            double resultBySquare = Float.valueOf(valueLength) / 1000 * Float.valueOf(valueWidth) / 1000 * Float.valueOf(valueNumLists) * Float.valueOf(valueSpinnerSquare) * choose_KP() + 500;

            roundedResulSquare = String.valueOf(Math.round(resultBySquare));
            result_square.setText(roundedResulSquare);
            Log.d(CALC_LOG, "Неокругленный resultByMeters: " + String.valueOf(resultBySquare));
        } else {
            result_square.setText("Заполните все поля");
        }

    }

    public String roundSquare() {
        return roundedResulSquare;
    }

    private int choose_KP() {
        int [] position = KP_Array.get(position_main);
        return position[position_under];
    }


}
