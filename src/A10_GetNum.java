import java.util.LinkedList;

/**
 * 最大值减去最小值小于或等于num的子数组数量
 * O(N)解法
 * Page 31
 * */
public class A10_GetNum {
    public static int getNum(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        LinkedList<Integer> qmin = new LinkedList<>();
        LinkedList<Integer> qmax = new LinkedList<>();
        int i =0;
        int j =0;
        int res =0;
        while (i < arr.length) {
            while (j < arr.length) {
                while (!qmin.isEmpty() && arr[qmin.peekLast()] >= arr[j]) {
                    qmin.pollLast();
                }
                qmin.addLast(j);
                while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[j]) {
                    qmax.pollLast();
                }
                qmax.addLast(j);
                if (arr[qmax.getFirst()] - arr[qmin.getFirst()] > num) {
                    break;
                }
                j++;
            }
            if (qmin.peekFirst() == i) {
                qmin.pollFirst();
            }
            if (qmax.peekFirst() == i) {
                qmax.pollFirst();
            }
            res += j-i;
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1,5,15};
        System.out.println(getNum(arr, 5));
    }
}
