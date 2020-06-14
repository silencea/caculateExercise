package com.fly.algorithm;

/**
 * Created with IntelliJ IDEA
 * Created By lifeifei
 * Date: 2020/5/4
 * Time: 15:07
 */
public class Demo {

    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 8, 3, 4};
        quickSort(array);
        printArr(array);
    }

    /**
     * 冒泡排序【排序后数组从小到大】
     * 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
     * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数。
     * 针对所有的元素重复以上的步骤，除了最后一个。
     * 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
     *
     * @param numbers 需要排序的整型数组
     */
    public static void bubbleSort(int[] numbers) {
        int temp = 0;
        int size = numbers.length;

        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }
    }


    /**
     * 选择排序
     * 选择排序是不稳定的。算法复杂度O(n2)--[n的平方]
     * 基本思想：在要排序的一组数中，选出最小的一个数与第一个位置的数交换；
     * 然后在剩下的数当中再找最小的与第二个位置的数交换，如此循环到倒数第二个数和最后一个数比较为止
     *
     * @param array
     */
    public static void directSelectSort(int[] array) {
        int size = array.length;
        for (int i = 0; i < size - 1; i++) {
            int min = array[i];
            for (int j = i + 1; j < size; j++) {
                if (array[j] < min) {
                    min = array[j];
                    array[j] = array[i];
                    array[i] = min;

                }
            }
        }
    }


    /**
     * 插入排序
     * 空间复杂度O(1) 时间复杂度O(n2)
     * 通过扫描前面已排序的子列表，将位置i处的元素定位到从0到i的子列表之内的正确的位置上
     * 在列表“近似排序”时，插入排序仍然是线性算法
     *
     * @param arr
     */
    public static void insertSort(int[] arr) {
        int i, j;
        int n = arr.length;
        int target;

        for (i = 1; i < n; i++) {
            j = i;
            target = arr[i];
            while (j > 0 && target < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = target;
        }
    }


    /**
     * 快速排序 快速排序是不稳定的。最理想情况算法时间复杂度O(nlog2n)，最坏O(n2)
     * 基本思想：选择一个基准元素,通常选择第一个元素或者最后一个元素,通过一趟扫描，
     * <p>
     * 将待排序列分成两部分,一部分比基准元素小,一部分大于等于基准元素,此时基准元素在其
     * <p>
     * 排好序后的正确位置,然后再用同样的方法递归地排序划分的两部分。
     * 快速排序是对冒泡排序的一种改进，平均时间复杂度是O(nlogn)
     *
     * @param arr
     * @return
     */
    public static void quickSort(int[] arr) {
        if (arr.length > 0) {
            quickSort(arr, 0, arr.length - 1);
        }
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int middle = getMiddle(arr, low, high);
            quickSort(arr, low, middle - 1);
            quickSort(arr, middle + 1, high);
        }
    }

    private static int getMiddle(int[] list, int low, int high) {
        int temp = list[low];

        while (low < high) {
            while (low < high && list[high] > temp) {
                high--;
            }
            list[low] = list[high];

            while (low < high && list[low] < temp) {
                low++;
            }
            list[high] = list[low];
        }
        list[low] = temp;
        return low;
    }


    /**
     * 二分查找--必须是有序的数组
     * 算法思想：又叫折半查找，要求待查找的序列有序。每次取中间位置的值与待查关键字比较，
     * 如果中间位置的值比待查关键字大，则在前半部分循环这个查找的过程，如果中间位置的值比待查关键字小，
     * 则在后半部分循环这个查找的过程。直到查找到了为止，否则序列中没有待查的关键字。 时间复杂度为 O(logN)
     *
     * @param array
     * @param a
     * @return
     */
    //查找第一个元素出现的位置（元素允许重复）
    public static int biSearch(int[] array, int a) {
        int n = array.length;
        int low = 0;
        int high = n - 1;
        int mid = 0;
        while (low < high) {
            mid = (low + high) / 2;
            if (array[mid] < a) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        if (array[low] != a) {
            return -1;
        } else {
            return low;
        }

    }


    //查询元素最后一次出现的位置
    public static int biSearch2(int[] array, int a) {
        int n = array.length;
        int low = 0;
        int hi = n - 1;
        int mid = 0;
        while (low < hi) {
            mid = (low + hi + 1) / 2;
            if (array[mid] <= a) {
                low = mid;
            } else {
                hi = mid - 1;
            }
        }

        if (array[low] != a) {
            return -1;
        } else {
            return hi;
        }
    }

    public static void printArr(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
    }


}
