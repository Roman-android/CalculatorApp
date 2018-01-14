package ru.roman.calculatorapp;

import android.content.Context;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Roman on 26.12.2017.
 */

public class RecourcesToViewPager {

    Context context;

    private ArrayList<int[][]> kindMaterialArray = new ArrayList<>();
    private ArrayList<String [][]> spinnerMetrArray = new ArrayList<>();
    private ArrayList<String [][]> descTextArray = new ArrayList<>();

    RecourcesToViewPager(Context context, int position_main, int position_under) {

        this.context = context;
        // TODO: 07.08.2017 массивы для картинок ViewPager
        //1 элемент главного списка
           //1 элемент подсписка
        int[] materials_1 = new int[]{R.drawable.img_1_1_1,R.drawable.img_1_1_2};
        //1 элемент главного списка
           //2 элемент подсписка
        int[] materials_2 = new int[]{R.drawable.img_1_2_1,R.drawable.img_1_2_2};
        //3 элемент подсписка
           //3 элемент главного списка
        int[] materials_3 = new int[]{R.drawable.img_1_3_1,R.drawable.img_1_3_2};

        //2 элемент главного списка
           //1 элемент подсписка
        int[] materials_1d = new int[]{R.drawable.ic_essential_regular_31_document_copy, R.drawable.ic_essential_regular_33_lock_open,
                R.drawable.ic_essential_regular_36_download, R.drawable.ic_essential_regular_41_home};
        //2 элемент главного списка
           //2 элемент подсписка
        int[] materials_2d = new int[]{R.drawable.ic_essential_regular_44_phone, R.drawable.ic_essential_regular_45_user,
                R.drawable.ic_essential_regular_46_print};

        //3 элемент главного списка
           //1 элемент главного списка
        int[] materials_3d = new int[]{R.drawable.ic_essential_regular_47_video, R.drawable.ic_essential_regular_48_clipboard,
                R.drawable.ic_essential_regular_49_magnifier};
        //3 элемент главного списка
           //2 элемент главного списка
        int[] materials_4d = new int[]{R.drawable.ic_essential_regular_52_photo, R.drawable.ic_essential_regular_54_desktop,
                R.drawable.ic_essential_regular_55_attachment, R.drawable.ic_essential_regular_57_globe};

        int[][] massivMat_1 = new int[][]{materials_1, materials_2, materials_3};
        int[][] massivMat_2 = new int[][]{materials_1d, materials_2d};
        int[][] massivMat_3 = new int[][]{materials_3d, materials_4d};

        kindMaterialArray.add(massivMat_1);
        kindMaterialArray.add(massivMat_2);
        kindMaterialArray.add(massivMat_3);

        //chooseImgArray(position_main,position_under);

        // TODO: 07.08.2017 массивы для значений spinnerMeters
        String[] spinnerMetr_1 = new String[]{"1", "1.5", "1,8"};
        String[] spinnerMetr_2 = new String[]{"2", "2.5", "2"};
        String[] spinnerMetr_3 = new String[]{"3", "3.5", "3.9"};

        String[] spinnerMetr_4 = new String[]{"4.2", "1.7", "2.1"};
        String[] spinnerMetr_5 = new String[]{"1.9", "2.2", "2.5"};

        String[] spinnerMetr_6 = new String[]{"1.2", "1.7", "2.1"};
        String[] spinnerMetr_7 = new String[]{"1.9", "2.2", "2.5"};

        String[][] massivSpinnerMetr_1 = new String[][]{spinnerMetr_1, spinnerMetr_2,spinnerMetr_3};
        String[][] massivSpinnerMetr_2 = new String[][]{spinnerMetr_4, spinnerMetr_5};
        String[][] massivSpinnerMetr_3 = new String[][]{spinnerMetr_6, spinnerMetr_7};

        spinnerMetrArray.add(massivSpinnerMetr_1);
        spinnerMetrArray.add(massivSpinnerMetr_2);
        spinnerMetrArray.add(massivSpinnerMetr_3);


        // TODO: 07.08.2017 массивы для значений descrText
        String [] descText_1 = context.getResources().getStringArray(R.array.descr_text_1);
        String [] descText_2 = context.getResources().getStringArray(R.array.descr_text_2);
        String [] descText_3 = context.getResources().getStringArray(R.array.descr_text_3);

        String [][] descMassiv_1 = new String [][]{descText_1,descText_2,descText_3};

        descTextArray.add(descMassiv_1);

    }


    public HashMap<String,String []> multiReturn (int position_main, int position_under){

        String [][] positionSpinner = spinnerMetrArray.get(position_main);
        String [][] positionDescText = descTextArray.get(position_main);

        HashMap <String,String[]> dataToReturn = new HashMap<>();

        dataToReturn.put("descText",positionDescText[position_under]);
        dataToReturn.put("spinner",positionSpinner[position_under]);

        return dataToReturn;
    }



    int[] chooseImgArray(int position_main, int position_under) {
        int [][] position = kindMaterialArray.get(position_main);

        return position[position_under];
    }

    String [] chooseSpinnerArray(int position_main, int position_under) {
        String [][] position = spinnerMetrArray.get(position_main);

        return position[position_under];
    }

    String [] chooseTextArray(int position_main, int position_under) {
        String [][] position = descTextArray.get(position_main);

        return position[position_under];
    }


}