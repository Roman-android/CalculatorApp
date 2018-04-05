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
        int[] materials_1_1 = new int[]{R.drawable.img_1_1_1,R.drawable.img_1_1_2};
        //1 элемент главного списка
        //item_2 элемент подсписка
        int[] materials_1_2 = new int[]{R.drawable.img_1_2_1,R.drawable.img_1_2_2};
        //item_3 элемент подсписка
        //item_3 элемент главного списка
        int[] materials_1_3 = new int[]{R.drawable.img_1_3_1, R.drawable.img_1_3_2, R.drawable.img_1_3_3};

        //item_2 элемент главного списка
           //1 элемент подсписка
        int[] materials_1d = new int[]{R.drawable.ic_essential_regular_31_document_copy, R.drawable.ic_essential_regular_33_lock_open};
        //item_2 элемент главного списка
        //item_2 элемент подсписка
        int[] materials_2d = new int[]{R.drawable.ic_essential_regular_44_phone, R.drawable.ic_essential_regular_45_user};

        //item_3 элемент главного списка
           //1 элемент главного списка
        int[] materials_3d = new int[]{R.drawable.ic_essential_regular_49_magnifier};
        //item_3 элемент главного списка
        //item_2 элемент главного списка
        /*int[] materials_4d = new int[]{R.drawable.ic_essential_regular_52_photo, R.drawable.ic_essential_regular_54_desktop,
                R.drawable.ic_essential_regular_55_attachment, R.drawable.ic_essential_regular_57_globe};*/

        int[][] massivMat_1 = new int[][]{materials_1_1, materials_1_2, materials_1_3};
        int[][] massivMat_2 = new int[][]{materials_1d, materials_2d};
        int[][] massivMat_3 = new int[][]{materials_3d};

        kindMaterialArray.add(massivMat_1);
        kindMaterialArray.add(massivMat_2);
        kindMaterialArray.add(massivMat_3);

        // TODO: 07.08.2017 массивы для значений spinnerMeters
        String[] spinnerMetr_1_1 = new String[]{"1", "1.item_2"};
        String[] spinnerMetr_1_2 = new String[]{"item_2", "item_2.item_5", "item_2"};
        String[] spinnerMetr_1_3 = new String[]{"0.item_7", "1", "1.item_2", "1.item_5", "item_2"};

        String[] spinnerMetr_2_1 = new String[]{"item_4", "item_6", "10", "12", "20", "22", "30"};
        String[] spinnerMetr_2_2 = new String[]{"item_2", "item_3", "item_4", "item_5"};

        String[] spinnerMetr_3_1 = new String[]{"1.item_2", "1.item_7", "item_2.1"};

        String[][] massivSpinnerMetr_1 = new String[][]{spinnerMetr_1_1, spinnerMetr_1_2,spinnerMetr_1_3};
        String[][] massivSpinnerMetr_2 = new String[][]{spinnerMetr_2_1, spinnerMetr_2_2};
        String[][] massivSpinnerMetr_3 = new String[][]{spinnerMetr_3_1};

        spinnerMetrArray.add(massivSpinnerMetr_1);
        spinnerMetrArray.add(massivSpinnerMetr_2);
        spinnerMetrArray.add(massivSpinnerMetr_3);


        // TODO: 07.08.2017 массивы для значений descrText

        String [] descText_1_1 = context.getResources().getStringArray(R.array.descr_text_1_1);
        String [] descText_1_2 = context.getResources().getStringArray(R.array.descr_text_1_2);
        String [] descText_1_3 = context.getResources().getStringArray(R.array.descr_text_1_3);

        String [] descText_2_1 = context.getResources().getStringArray(R.array.descr_text_2_1);
        String [] descText_2_2 = context.getResources().getStringArray(R.array.descr_text_2_2);

        String [] descText_3_1 = context.getResources().getStringArray(R.array.descr_text_3_1);

        String [][] descMassiv_1 = new String [][]{descText_1_1,descText_1_2,descText_1_3};
        String [][] descMassiv_2 = new String [][]{descText_2_1,descText_2_2};
        String [][] descMassiv_3 = new String [][]{descText_3_1};

        descTextArray.add(descMassiv_1);
        descTextArray.add(descMassiv_2);
        descTextArray.add(descMassiv_3);

    }


    /*
    HashMap<String,String []> multiReturn(int position_main, int position_under){

        String [][] positionSpinner = spinnerMetrArray.get(position_main);
        String [][] positionDescText = descTextArray.get(position_main);

        HashMap <String,String[]> dataToReturn = new HashMap<>();

        dataToReturn.put("spinner",positionSpinner[position_under]);
        dataToReturn.put("descText",positionDescText[position_under]);

        return dataToReturn;
    }
    */


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
