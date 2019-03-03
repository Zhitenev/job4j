package ru.job4j.array;
/**
 *Объединение 3х отсротированных массивов.
 *@author Oleg Zhieten
 *@since 2019
 *@version 1
 */
public class SortArrays {
    /**
     * Собрать 3 отсортированных масива в один.
     *
     * @param firsArray   первый отсортированный массив.
     * @param secondArray второй отсортированный массив.
     * @param thirdArray  третий отсортированный массив.
     * @return объедененый отсрортированный массив.
     */
    public int[] oneSortArray(int[] firsArray, int[] secondArray, int[] thirdArray) {
        int fLen = firsArray.length, sLen = secondArray.length, tLen = thirdArray.length;
        int[] result = new int[fLen + sLen + tLen];
        int a = 0;
        int b = 0;
        int c = 0;
        int max = Integer.max(Integer.max(firsArray[fLen - 1], secondArray[sLen - 1]), thirdArray[tLen - 1]);
        for (int i = 0; i < result.length; i++) {
            int min = Integer.min(Integer.min(firsArray[a], secondArray[b]), thirdArray[c]);
            if (min == firsArray[a]) {
                result[i] = firsArray[a];
                firsArray[a] = a == fLen - 1 ? max : firsArray[a];
                a = a < (fLen - 1) ? ++a : a;
                } else if (min == secondArray[b]) {
                    result[i] = secondArray[b];
                    secondArray[b] = b == sLen - 1 ? max : secondArray[b];
                    b = b < (sLen - 1) ? ++b : b;
                    } else if (min == thirdArray[c]) {
                        result[i] = thirdArray[c];
                        thirdArray[c] = c == tLen - 1 ? max : thirdArray[c];
                        c = c < tLen - 1 ? ++c : c;
            }
        }
    return result;
    }
}