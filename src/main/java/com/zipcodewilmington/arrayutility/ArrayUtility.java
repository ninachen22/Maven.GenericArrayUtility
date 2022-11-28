package com.zipcodewilmington.arrayutility;

//import sun.security.util.ArrayUtil;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility <T> {
    public T[] genericArr;
    public ArrayUtility(T[] inputArray) {
        this.genericArr = inputArray;
    }

    public Integer getNumberOfOccurrences(T valueToEvaluate) {
        int freq = 0;
        for (int i = 0; i < genericArr.length; i++) {
            if (genericArr[i].equals(valueToEvaluate)) {
                freq++;
            }
        }
        return freq;
    }

    public T getMostCommonFromMerge(T[] arrayToMerge) {
        int newArrLength = genericArr.length + arrayToMerge.length;
        T[] mergedArr = Arrays.copyOf(genericArr, newArrLength);
        int j = genericArr.length;
        for (int i = 0; i < arrayToMerge.length; i++) {
            mergedArr[j] = arrayToMerge[i];
            j++;
        }
        T mc = null;
        int freq = 0;
        for (T t : mergedArr) {
            int temp = getNumberOfOccurrences(t);
            if (temp > freq) {
                freq = temp;
                mc = t;
            }
        }
        return mc;
    }

    public Integer countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate) {
        int newArrLength = genericArr.length + arrayToMerge.length;
        T[] mergedArr = Arrays.copyOf(genericArr, newArrLength);
        int j = genericArr.length;
        for (int i = 0; i < arrayToMerge.length; i++) {
            mergedArr[j] = arrayToMerge[i];
            j++;
        }
        int freq = 0;
        for (int i = 0; i < mergedArr.length; i++) {
            if (mergedArr[i].equals(valueToEvaluate)) {
                freq++;
            }
        }
        return freq;
    }

    public T[] removeValue(T valueToRemove) {
        int freqOfValueNotToRemove = 0;
        int valueToRemFreq = genericArr.length - getNumberOfOccurrences(valueToRemove);
        T[] temp = Arrays.copyOf(genericArr, valueToRemFreq);
        for (int i = 0; i < genericArr.length; i++) {
            if (!genericArr[i].equals(valueToRemove)) {
                temp[freqOfValueNotToRemove] = genericArr[i];
                freqOfValueNotToRemove++;
            }
        }
        return temp;
//        ArrayList<T> temp = new ArrayList<>();
//        for (int i = 0; i < genericArr.length; i++) {
//            if (!genericArr[i].equals(valueToRemove)) {
//                temp.add(genericArr[i]);
//            }
//        }
//        return temp.toArray(new T[0]); //Type parameter 'T' cannot be instantiated directly
    }
}