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

    private ArrayList<int[]> KPM_Array = new ArrayList<>();
    private ArrayList<int[]> KP_Array = new ArrayList<>();
    private int position_main, position_under;
    // по погонным метрам
    private int[] KPM_1 = new int[]{50, 60, 55,150,100,70,50,70,50,70}; // Трафареты
    private int[] KPM_2 = new int[]{6,20,5,10,15,2}; // Буквы и Хештеги
    private int[] KPM_3 = new int[]{150,130,17,150,5,10,10,20,20,20}; // Таблички и указатели
    private int[] KPM_4 = new int[]{200,7,17,8}; // Решетки
    private int[] KPM_5 = new int[]{200,7,17,8,5,5,8}; // Из оргстекла
    private int[] KPM_6 = new int[]{45,60,80,100,150,180,200,200,200}; // Из фанеры
    private int[] KPM_7 = new int[]{45,60,80,100,150}; // ДЕКОР
    private int[] KPM_8 = new int[]{45,45}; // ЛЕКАЛА
    private int[] KPM_9 = new int[]{45,60,45,60,45,60,45,60,45}; // ГРАВИРОВКА
    private int[] KPM_10 = new int[]{45,60,45,60,45,60,45,60,45,45,45,45,45}; // ЛОГОТИПЫ
    private int[] KPM_11 = new int[]{45,60,45,60}; // ИЗ ПЛЕНКИ

    // по площади цены
    private int[] KP_1 = new int[]{9900, 11900, 4900,15000,12000,6000,6500,6000,6500,6000}; // Трафареты
    private int[] KP_2 = new int[]{400,1500,500,1000,500,125}; // Буквы и Хештеги
    private int[] KP_3 = new int[]{2000,14000,600,15000,500,1200,1000,1600,2000,2000}; // Таблички и указатели
    private int[] KP_4 = new int[]{7000,500,600,450}; // Решетки
    private int[] KP_5 = new int[]{7000,500,600,450,1000,100,450}; // Из оргстелка
    private int[] KP_6 = new int[]{1000,1000,1000,4000,1000,1000,1000,1000,1000}; // Из фаанеры
    private int[] KP_7 = new int[]{1000,1000,1000,4000,1000}; // ДЕКОР
    private int[] KP_8 = new int[]{1000,1000}; // ЛЕКАЛА
    private int[] KP_9 = new int[]{300000,300000,250000,250000,350000,350000,350000,350000,350000}; // ГРАВИРОВКА
    private int[] KP_10 = new int[]{1300,450,400,370,2500,2500,2500,2500,2500,5000,5000,3000,1500}; // ЛОГОТИПЫ
    private int[] KP_11 = new int[]{1500,1000,1000,6000}; // ИЗ ПЛЕНКИ

    private String roundedResultMetrs,roundedResulSquare;


    public CalculationFormula(int position_main, int position_under) {
        this.position_main = position_main;
        this.position_under = position_under;

        KPM_Array.add(KPM_1);
        KPM_Array.add(KPM_2);
        KPM_Array.add(KPM_3);
        KPM_Array.add(KPM_4);
        KPM_Array.add(KPM_5);
        KPM_Array.add(KPM_6);
        KPM_Array.add(KPM_7);
        KPM_Array.add(KPM_8);
        KPM_Array.add(KPM_9);
        KPM_Array.add(KPM_10);
        KPM_Array.add(KPM_11);

        KP_Array.add(KP_1);
        KP_Array.add(KP_2);
        KP_Array.add(KP_3);
        KP_Array.add(KP_4);
        KP_Array.add(KP_5);
        KP_Array.add(KP_6);
        KP_Array.add(KP_7);
        KP_Array.add(KP_8);
        KP_Array.add(KP_9);
        KP_Array.add(KP_10);
        KP_Array.add(KP_11);
    }

    // TODO: 29.06.2017 методы (функции) для подсчета итоговой стоимости материала по погонным метрам
    public void countCost(EditText meters, EditText incut, Spinner spinnerMeters, TextView result_meters) {

        String valueMeters = meters.getText().toString();
        String valueIncut = incut.getText().toString();
        String valueSpinnerMetr = spinnerMeters.getSelectedItem().toString();

        if (meters.getText().length() > 0 && incut.length() > 0) {

            //double resultByMeters = Float.valueOf(valueMeters) * Float.valueOf(valueIncut) * Float.valueOf(valueSpinnerMetr) * choose_KPM();
            //  Здесь расчет без учета макета
            double resultByMeters = Float.valueOf(valueMeters)  * Float.valueOf(valueSpinnerMetr)  * choose_KPM()  + 10*Float.valueOf(valueIncut);

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

    //  Возврат номера враздела 2 уровня
    private int choose_KPM() {
        // получить  массив по позиции меню первого уровня
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
