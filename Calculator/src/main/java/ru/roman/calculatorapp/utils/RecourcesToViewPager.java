package ru.roman.calculatorapp.utils;

import android.content.Context;

import java.util.ArrayList;

import ru.roman.calculatorapp.R;

/**
 * Created by Roman on 26.12.2017.
 */

public class RecourcesToViewPager {

    private final String RECOURCES_PAGER_LOG = "RecourcesToViewPagerLog";

    private ArrayList<int[][]> kindMaterialArray = new ArrayList<>();
    private ArrayList<String [][]> spinnerMetrArray = new ArrayList<>();
    private ArrayList<String [][]> descTextArray = new ArrayList<>();

    private int position_main, position_under;

    public RecourcesToViewPager(Context context, int position_main, int position_under) {

        this.position_main = position_main;
        this.position_under = position_under;

        // TODO: 07.08.2017 массивы для картинок ViewPager
        //1 элемент главного списка
           //1 элемент подсписка
        int[] materials_1_1 = new int[]{R.drawable.img_1_1_1, R.drawable.img_1_1_2, R.drawable.img_1_1_3};
        //item_2 элемент подсписка
        int[] materials_1_2 = new int[]{R.drawable.img_1_2_1, R.drawable.img_1_2_2, R.drawable.img_1_2_3, R.drawable.img_1_2_4};
        //item_3 элемент подсписка
        int[] materials_1_3 = new int[]{R.drawable.img_1_3_1, R.drawable.img_1_3_2, R.drawable.img_1_3_3};
        //item_4 элемент подсписка - из нержавейки
        int[] materials_1_4 = new int[]{R.drawable.img_1_1_1, R.drawable.img_1_1_1, R.drawable.img_1_1_1};
        //item_5 элемент подсписка - из оцинковки
        int[] materials_1_5 = new int[]{R.drawable.img_1_1_1, R.drawable.img_1_1_1, R.drawable.img_1_1_1};
        //item_6 элемент подсписка - из пластика
        int[] materials_1_6 = new int[]{R.drawable.img_1_1_1, R.drawable.img_1_1_1, R.drawable.img_1_1_1};
         //item_6 элемент подсписка - из пленки
        int[] materials_1_7 = new int[]{R.drawable.img_1_1_1, R.drawable.img_1_1_1, R.drawable.img_1_1_1};


        //item_2 элемент главного списка БУКВЫ. ХЕШТЕГИ
        //  2.1 элемент подсписка
        int[] materials_1d = new int[]{R.drawable.ic_essential_regular_31_document_copy, R.drawable.ic_essential_regular_33_lock_open};
        //  2.2 элемент подсписка
        int[] materials_2d = new int[]{R.drawable.ic_essential_regular_44_phone, R.drawable.ic_essential_regular_45_user};
        //  2.3 элемент подсписка
        int[] materials_2_3 = new int[]{R.drawable.img_1_1_1, R.drawable.img_1_1_1, R.drawable.img_1_1_1};
       //  2.4 элемент подсписка
        int[] materials_2_4 = new int[]{R.drawable.img_1_1_1, R.drawable.img_1_1_1, R.drawable.img_1_1_1};
         //  2.5 элемент подсписка
        int[] materials_2_5 = new int[]{R.drawable.img_1_1_1, R.drawable.img_1_1_1, R.drawable.img_1_1_1};
         //  2.6 элемент подсписка
        int[] materials_2_6 = new int[]{R.drawable.img_1_1_1, R.drawable.img_1_1_1, R.drawable.img_1_1_1};


        //item_3 элемент главного списка
        int[] materials_3_1 = new int[]{R.drawable.img_1_1_1, R.drawable.img_1_1_1, R.drawable.img_1_1_1};
        int[] materials_3_2 = new int[]{R.drawable.img_1_1_1, R.drawable.img_1_1_1, R.drawable.img_1_1_1};
        int[] materials_3_3 = new int[]{R.drawable.img_1_1_1, R.drawable.img_1_1_1, R.drawable.img_1_1_1};
        int[] materials_3_4 = new int[]{R.drawable.img_1_1_1, R.drawable.img_1_1_1, R.drawable.img_1_1_1};
        int[] materials_3_5 = new int[]{R.drawable.img_1_1_1, R.drawable.img_1_1_1, R.drawable.img_1_1_1};
        int[] materials_3_6 = new int[]{R.drawable.img_1_1_1, R.drawable.img_1_1_1, R.drawable.img_1_1_1};
        int[] materials_3_7 = new int[]{R.drawable.img_1_1_1, R.drawable.img_1_1_1, R.drawable.img_1_1_1};
        int[] materials_3_8 = new int[]{R.drawable.img_1_1_1, R.drawable.img_1_1_1, R.drawable.img_1_1_1};

        //item_4 элемент главного списка. Решетки
        int[] materials_4_1 = new int[]{R.drawable.img_1_1_1, R.drawable.img_1_1_1, R.drawable.img_1_1_1};
        int[] materials_4_2 = new int[]{R.drawable.img_1_1_1, R.drawable.img_1_1_1, R.drawable.img_1_1_1};
        int[] materials_4_3 = new int[]{R.drawable.img_1_1_1, R.drawable.img_1_1_1, R.drawable.img_1_1_1};
        int[] materials_4_4 = new int[]{R.drawable.img_1_1_1, R.drawable.img_1_1_1, R.drawable.img_1_1_1};

        //item_5 элемент главного списка. Из Оргстекла
        int[] materials_5_1 = new int[]{R.drawable.img_1_1_1, R.drawable.img_1_1_1, R.drawable.img_1_1_1};
        int[] materials_5_2 = new int[]{R.drawable.img_1_1_1, R.drawable.img_1_1_1, R.drawable.img_1_1_1};
        int[] materials_5_3 = new int[]{R.drawable.img_1_1_1, R.drawable.img_1_1_1, R.drawable.img_1_1_1};
        int[] materials_5_4 = new int[]{R.drawable.img_1_1_1, R.drawable.img_1_1_1, R.drawable.img_1_1_1};
        int[] materials_5_5 = new int[]{R.drawable.img_1_1_1, R.drawable.img_1_1_1, R.drawable.img_1_1_1};
        int[] materials_5_6 = new int[]{R.drawable.img_1_1_1, R.drawable.img_1_1_1, R.drawable.img_1_1_1};
        int[] materials_5_7 = new int[]{R.drawable.img_1_1_1, R.drawable.img_1_1_1, R.drawable.img_1_1_1};

        //item_6 элемент главного списка. Из фанеры
        int[] materials_6_1 = new int[]{R.drawable.img_1_1_1, R.drawable.img_1_1_1, R.drawable.img_1_1_1};
        int[] materials_6_2 = new int[]{R.drawable.img_1_1_1, R.drawable.img_1_1_1, R.drawable.img_1_1_1};
        int[] materials_6_3 = new int[]{R.drawable.img_1_1_1, R.drawable.img_1_1_1, R.drawable.img_1_1_1};
        int[] materials_6_4 = new int[]{R.drawable.img_1_1_1, R.drawable.img_1_1_1, R.drawable.img_1_1_1};
        int[] materials_6_5 = new int[]{R.drawable.img_1_1_1, R.drawable.img_1_1_1, R.drawable.img_1_1_1};
        int[] materials_6_6 = new int[]{R.drawable.img_1_1_1, R.drawable.img_1_1_1, R.drawable.img_1_1_1};
        int[] materials_6_7 = new int[]{R.drawable.img_1_1_1, R.drawable.img_1_1_1, R.drawable.img_1_1_1};


        //item_6 элемент главного списка. ДЕКОР
        int[] materials_7_1 = new int[]{R.drawable.img_1_1_1, R.drawable.img_1_1_1, R.drawable.img_1_1_1};
        int[] materials_7_2 = new int[]{R.drawable.img_1_1_1, R.drawable.img_1_1_1, R.drawable.img_1_1_1};
        int[] materials_7_3 = new int[]{R.drawable.img_1_1_1, R.drawable.img_1_1_1, R.drawable.img_1_1_1};
        int[] materials_7_4 = new int[]{R.drawable.img_1_1_1, R.drawable.img_1_1_1, R.drawable.img_1_1_1};
        int[] materials_7_5 = new int[]{R.drawable.img_1_1_1, R.drawable.img_1_1_1, R.drawable.img_1_1_1};
        int[] materials_7_6 = new int[]{R.drawable.img_1_1_1, R.drawable.img_1_1_1, R.drawable.img_1_1_1};
        int[] materials_7_7 = new int[]{R.drawable.img_1_1_1, R.drawable.img_1_1_1, R.drawable.img_1_1_1};
        //item_3 элемент главного списка
        //item_2 элемент главного списка
        /*int[] materials_4d = new int[]{R.drawable.ic_essential_regular_52_photo, R.drawable.ic_essential_regular_54_desktop,
                R.drawable.ic_essential_regular_55_attachment, R.drawable.ic_essential_regular_57_globe};*/

        int[][] massivMat_1 = new int[][]{materials_1_1, materials_1_2, materials_1_3, materials_1_4, materials_1_5, materials_1_6, materials_1_7};
        int[][] massivMat_2 = new int[][]{materials_1d, materials_2d, materials_2_3, materials_2_4, materials_2_5, materials_2_6};
        int[][] massivMat_3 = new int[][]{materials_3_1, materials_3_2, materials_3_3, materials_3_4,materials_3_5, materials_3_6, materials_3_7,materials_3_8};
        int[][] massivMat_4 = new int[][]{materials_4_1, materials_4_2, materials_4_3, materials_4_4};
        int[][] massivMat_5 = new int[][]{materials_5_1, materials_5_2, materials_5_3, materials_5_4, materials_5_5, materials_5_6,materials_5_7};
        int[][] massivMat_6 = new int[][]{materials_6_1, materials_6_2, materials_6_3, materials_6_4, materials_6_5, materials_6_6,materials_6_7};
        int[][] massivMat_7 = new int[][]{materials_7_1, materials_7_2, materials_7_3, materials_7_4, materials_7_5, materials_7_6,materials_7_7};

        kindMaterialArray.add(massivMat_1);
        kindMaterialArray.add(massivMat_2);
        kindMaterialArray.add(massivMat_3);
        kindMaterialArray.add(massivMat_4);
        kindMaterialArray.add(massivMat_5);
        kindMaterialArray.add(massivMat_6);
        kindMaterialArray.add(massivMat_7);

        // TODO: 07.08.2017 массивы для значений spinnerMeters толщина материала
        String[] spinnerMetr_1_1 = new String[]{"1", "1.2"};
        String[] spinnerMetr_1_2 = new String[]{"2", "2.5"};
        String[] spinnerMetr_1_3 = new String[]{"0.7", "1", "1.2", "1.5", "2"};
        String[] spinnerMetr_1_4 = new String[]{"0.8", "1", "1.2"};
        String[] spinnerMetr_1_5 = new String[]{"0.5", "0.7"};
        String[] spinnerMetr_1_6 = new String[]{"0.3", "0.5","0.7","1","1.5","2"};
        String[] spinnerMetr_1_7 = new String[]{"0.2","0.3"};

        String[] spinnerMetr_2_1 = new String[]{"10", "15", "20", "25", "30"};
        String[] spinnerMetr_2_2 = new String[]{"3","4"};
        String[] spinnerMetr_2_3 = new String[]{"4", "6", "8", "10", "12", "15","20"};
        String[] spinnerMetr_2_4 = new String[]{"1.5", "2", "3", "4", "6", "8","10", "12"};
        String[] spinnerMetr_2_5 = new String[]{"2", "3", "4", "6", "8","10","12"};
        String[] spinnerMetr_2_6 = new String[]{"50", "100", "150", "200", "250"};

        String[] spinnerMetr_3_1 = new String[]{"1.5","2","2.5","3.5","6.5"};
        String[] spinnerMetr_3_2 = new String[]{"0.5", "0.7"};
        String[] spinnerMetr_3_3 = new String[]{"2", "3", "4", "6", "8","10","12"};
        String[] spinnerMetr_3_4 = new String[]{"0.8", "1", "1.2"};
        String[] spinnerMetr_3_5 = new String[]{"4", "6", "8", "10", "12", "15","20"};
        String[] spinnerMetr_3_6 =  new String[]{"1.5", "2", "3", "4", "6", "8","10", "12"};
        String[] spinnerMetr_3_7 =  new String[]{"1.5", "2", "3", "4", "6", "8","10", "12"};
        String[] spinnerMetr_3_8 =  new String[]{"3","4"};

        String[] spinnerMetr_4_1 = new String[]{"1.5","2","3","4","5","6"};
        String[] spinnerMetr_4_2 = new String[]{"6","10", "16","18","20","22","24"};
        String[] spinnerMetr_4_3 = new String[]{"2", "3", "4", "6", "8","10","12"};
        String[] spinnerMetr_4_4 = new String[]{"25", "30", "35","40"};

        String[] spinnerMetr_5_1 = new String[]{"1","1.5","2","3","4","5","6","8","10","12"};
        String[] spinnerMetr_5_2 = new String[]{"1","1.5","2","3","4","5","6","8","10","12"};
        String[] spinnerMetr_5_3 = new String[]{"1","1.5","2","3","4","5","6","8","10","12"};
        String[] spinnerMetr_5_4 = new String[]{"1","1.5","2","3","4","5","6","8","10","12"};
        String[] spinnerMetr_5_5 = new String[]{"1","1.5","2","3","4","5","6","8","10","12"};
        String[] spinnerMetr_5_6 = new String[]{"1","1.5","2","3","4","5","6","8","10","12"};
        String[] spinnerMetr_5_7 = new String[]{"1","1.5","2","3","4","5","6","8","10","12"};

        String[] spinnerMetr_6_1 = new String[]{"4","6","8","9","10","15","18","21"};
        String[] spinnerMetr_6_2 = new String[]{"4","6","8","9","10","15","18","21"};
        String[] spinnerMetr_6_3 = new String[]{"4","6","8","9","10","15","18","21"};
        String[] spinnerMetr_6_4 = new String[]{"4","6","8","9","10","15","18","21"};
        String[] spinnerMetr_6_5 = new String[]{"4","6","8","9","10","15","18","21"};
        String[] spinnerMetr_6_6 = new String[]{"4","6","8","9","10","15","18","21"};
        String[] spinnerMetr_6_7 = new String[]{"4","6","8","9","10","15","18","21"};

        String[] spinnerMetr_7_1 = new String[]{"4","6","8","9","10","15","18","21"};
        String[] spinnerMetr_7_2 = new String[]{"4","6","8","9","10","15","18","21"};
        String[] spinnerMetr_7_3 = new String[]{"4","6","8","9","10","15","18","21"};
        String[] spinnerMetr_7_4 = new String[]{"4","6","8","9","10","15","18","21"};
        String[] spinnerMetr_7_5 = new String[]{"4","6","8","9","10","15","18","21"};
        String[] spinnerMetr_7_6 = new String[]{"4","6","8","9","10","15","18","21"};
        String[] spinnerMetr_7_7 = new String[]{"4","6","8","9","10","15","18","21"};

        String[][] massivSpinnerMetr_1 = new String[][]{spinnerMetr_1_1, spinnerMetr_1_2,spinnerMetr_1_3, spinnerMetr_1_4, spinnerMetr_1_5, spinnerMetr_1_6,spinnerMetr_1_7};
        String[][] massivSpinnerMetr_2 = new String[][]{spinnerMetr_2_1, spinnerMetr_2_2, spinnerMetr_2_3, spinnerMetr_2_4, spinnerMetr_2_5, spinnerMetr_2_6};
        String[][] massivSpinnerMetr_3 = new String[][]{spinnerMetr_3_1,spinnerMetr_3_2, spinnerMetr_3_3, spinnerMetr_3_4,spinnerMetr_3_5, spinnerMetr_3_6, spinnerMetr_3_7, spinnerMetr_3_8};
        String[][] massivSpinnerMetr_4 = new String[][]{spinnerMetr_4_1,spinnerMetr_4_2, spinnerMetr_4_3, spinnerMetr_4_4};
        String[][] massivSpinnerMetr_5 = new String[][]{spinnerMetr_5_1,spinnerMetr_5_2, spinnerMetr_5_3, spinnerMetr_5_4,spinnerMetr_5_5,spinnerMetr_5_6, spinnerMetr_5_7};
        String[][] massivSpinnerMetr_6 = new String[][]{spinnerMetr_6_1,spinnerMetr_6_2, spinnerMetr_6_3, spinnerMetr_6_4,spinnerMetr_6_5,spinnerMetr_6_6, spinnerMetr_6_7};
        String[][] massivSpinnerMetr_7 = new String[][]{spinnerMetr_7_1,spinnerMetr_7_2, spinnerMetr_7_3, spinnerMetr_7_4,spinnerMetr_7_5,spinnerMetr_7_6, spinnerMetr_7_7};

        spinnerMetrArray.add(massivSpinnerMetr_1);
        spinnerMetrArray.add(massivSpinnerMetr_2);
        spinnerMetrArray.add(massivSpinnerMetr_3);
        spinnerMetrArray.add(massivSpinnerMetr_4);
        spinnerMetrArray.add(massivSpinnerMetr_5);
        spinnerMetrArray.add(massivSpinnerMetr_6);
        spinnerMetrArray.add(massivSpinnerMetr_7);


        // TODO: 07.08.2017 массивы для значений descrText описание

        String [] descText_1_1 = context.getResources().getStringArray(R.array.descr_text_1_1);
        String [] descText_1_2 = context.getResources().getStringArray(R.array.descr_text_1_2);
        String [] descText_1_3 = context.getResources().getStringArray(R.array.descr_text_1_3);
        String [] descText_1_4 = context.getResources().getStringArray(R.array.descr_text_1_4);
        String [] descText_1_5 = context.getResources().getStringArray(R.array.descr_text_1_5);
        String [] descText_1_6 = context.getResources().getStringArray(R.array.descr_text_1_6);
        String [] descText_1_7 = context.getResources().getStringArray(R.array.descr_text_1_7);

        String [] descText_2_1 = context.getResources().getStringArray(R.array.descr_text_2_1);
        String [] descText_2_2 = context.getResources().getStringArray(R.array.descr_text_2_2);
        String [] descText_2_3 = context.getResources().getStringArray(R.array.descr_text_2_3);
        String [] descText_2_4 = context.getResources().getStringArray(R.array.descr_text_2_4);
        String [] descText_2_5 = context.getResources().getStringArray(R.array.descr_text_2_5);
        String [] descText_2_6 = context.getResources().getStringArray(R.array.descr_text_2_6);

        String [] descText_3_1 = context.getResources().getStringArray(R.array.descr_text_3_1);
        String [] descText_3_2 = context.getResources().getStringArray(R.array.descr_text_3_2);
        String [] descText_3_3 = context.getResources().getStringArray(R.array.descr_text_3_3);
        String [] descText_3_4 = context.getResources().getStringArray(R.array.descr_text_3_4);
        String [] descText_3_5 = context.getResources().getStringArray(R.array.descr_text_3_5);
        String [] descText_3_6 = context.getResources().getStringArray(R.array.descr_text_3_6);
        String [] descText_3_7 = context.getResources().getStringArray(R.array.descr_text_3_7);
        String [] descText_3_8 = context.getResources().getStringArray(R.array.descr_text_3_8);

        String [] descText_4_1 = context.getResources().getStringArray(R.array.descr_text_4_1);
        String [] descText_4_2 = context.getResources().getStringArray(R.array.descr_text_4_2);
        String [] descText_4_3 = context.getResources().getStringArray(R.array.descr_text_4_3);
        String [] descText_4_4 = context.getResources().getStringArray(R.array.descr_text_4_4);

        String [] descText_5_1 = context.getResources().getStringArray(R.array.descr_text_5_1);
        String [] descText_5_2 = context.getResources().getStringArray(R.array.descr_text_5_2);
        String [] descText_5_3 = context.getResources().getStringArray(R.array.descr_text_5_3);
        String [] descText_5_4 = context.getResources().getStringArray(R.array.descr_text_5_4);
        String [] descText_5_5 = context.getResources().getStringArray(R.array.descr_text_5_5);
        String [] descText_5_6 = context.getResources().getStringArray(R.array.descr_text_5_6);
        String [] descText_5_7 = context.getResources().getStringArray(R.array.descr_text_5_7);

        String [] descText_6_1 = context.getResources().getStringArray(R.array.descr_text_6_1);
        String [] descText_6_2 = context.getResources().getStringArray(R.array.descr_text_6_2);
        String [] descText_6_3 = context.getResources().getStringArray(R.array.descr_text_6_3);
        String [] descText_6_4 = context.getResources().getStringArray(R.array.descr_text_6_4);
        String [] descText_6_5 = context.getResources().getStringArray(R.array.descr_text_6_5);
        String [] descText_6_6 = context.getResources().getStringArray(R.array.descr_text_6_6);
        String [] descText_6_7 = context.getResources().getStringArray(R.array.descr_text_6_7);

        String [] descText_7_1 = context.getResources().getStringArray(R.array.descr_text_7_1);
        String [] descText_7_2 = context.getResources().getStringArray(R.array.descr_text_7_2);
        String [] descText_7_3 = context.getResources().getStringArray(R.array.descr_text_7_3);
        String [] descText_7_4 = context.getResources().getStringArray(R.array.descr_text_7_4);
        String [] descText_7_5 = context.getResources().getStringArray(R.array.descr_text_7_5);
        String [] descText_7_6 = context.getResources().getStringArray(R.array.descr_text_7_6);
        String [] descText_7_7 = context.getResources().getStringArray(R.array.descr_text_7_7);

        String [][] descMassiv_1 = new String [][]{descText_1_1,descText_1_2,descText_1_3,descText_1_4,descText_1_5, descText_1_6,descText_1_7};
        String [][] descMassiv_2 = new String [][]{descText_2_1,descText_2_2, descText_2_3, descText_2_4, descText_2_5, descText_2_6};
        String [][] descMassiv_3 = new String [][]{descText_3_1, descText_3_2, descText_3_3, descText_3_4, descText_3_5, descText_3_6, descText_3_7, descText_3_8};
        String [][] descMassiv_4 = new String [][]{descText_4_1, descText_4_2, descText_4_3, descText_4_4};
        String [][] descMassiv_5 = new String [][]{descText_5_1, descText_5_2, descText_5_3, descText_5_4,descText_5_5,descText_5_6,descText_5_7};
        String [][] descMassiv_6 = new String [][]{descText_6_1, descText_6_2, descText_6_3, descText_6_4,descText_6_5,descText_6_6,descText_6_7};
        String [][] descMassiv_7 = new String [][]{descText_7_1, descText_7_2, descText_7_3, descText_7_4,descText_7_5,descText_7_6,descText_7_7};

        descTextArray.add(descMassiv_1);
        descTextArray.add(descMassiv_2);
        descTextArray.add(descMassiv_3);
        descTextArray.add(descMassiv_4);
        descTextArray.add(descMassiv_5);
        descTextArray.add(descMassiv_6);
        descTextArray.add(descMassiv_7);

    }


    public int[] chooseImgArray() {
        int [][] position = kindMaterialArray.get(position_main);

        return position[position_under];
    }

    public String[] chooseSpinnerArray() {
        String [][] position = spinnerMetrArray.get(position_main);

        return position[position_under];
    }

    public String[] chooseTextArray() {
        String [][] position = descTextArray.get(position_main);

        return position[position_under];
    }

}