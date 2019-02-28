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
        int max = maxFromThree(firsArray[fLen - 1], secondArray[sLen - 1], thirdArray[tLen - 1]);
        for (int i = 0; i < result.length; i++) {
            int min = minFromThree(firsArray[a], secondArray[b], thirdArray[c]);
            if (min == firsArray[a]) {
                result[i] = firsArray[a];
                if (a < firsArray.length - 1) {
                    a++;
                } else {
                    firsArray[a] = max;
                }

            } else if (min == secondArray[b]) {
                result[i] = secondArray[b];
                if (b < secondArray.length - 1) {
                    b++;
                } else {
                    secondArray[b] = max;
                }
            } else if (min == thirdArray[c]) {
                result[i] = thirdArray[c];
                if (c < thirdArray.length - 1) {
                    c++;
                } else {
                    thirdArray[c] = max;
                }

            }
        }
        return result;
    }

    /**
     * Найдем минимум из 3х чисел.
     * @param first первый аргумент.
     * @param second второй агрумент.
     * @param third третий аргумент.
     * @return минимальное число.
     */
    private int minFromThree(int first, int second, int third) {
            int one = first < second ? first : second;
            int two = second < third ? second : third;
        return one < two ? one : two;
    }

    /**
     * Найдем максимум из 3х чисел.
     * @param first первый аргумент.
     * @param second второй агрумент.
     * @param third третий аргумент.
     * @return максимальное число.
     */
    private  int maxFromThree(int first, int second, int third) {
        int a = first > second ? first : second;
        int b = second > third ? second : third;
        return a > b ? a : b;
    }
}