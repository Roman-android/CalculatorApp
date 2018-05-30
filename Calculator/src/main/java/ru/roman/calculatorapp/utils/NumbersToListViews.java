package ru.roman.calculatorapp.utils;

import java.util.ArrayList;

public class NumbersToListViews {

    public ArrayList<String> getNumItems(String[] mItemArray) {
        ArrayList<String> numOfItems = new ArrayList<>();
        for (int i = 1; i <= mItemArray.length; i++) {
            numOfItems.add(String.valueOf(i));
        }
        return numOfItems;
    }


}
