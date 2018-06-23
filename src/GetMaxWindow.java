
import java.util.LinkedList;  
  
public class GetMaxWindow {  
  
    public static void main(String[] args) {  
        int[] a = { 4, 3, 5, 4, 3, 3, 6, 7 };  
        int[] solution = solution(a, 3);  
        System.out.print("最大值数组为：");  
        for (int i = 0; i < solution.length; i++) {  
            System.out.print(solution[i] + " ");  
        }  
    }  
  
    public static int[] solution(int[] arr, int w) {  
  
        if (arr == null || w < 1 || arr.length < w) {  
            return null;  
        }  
  
        LinkedList<Integer> qMax = new LinkedList<Integer>();// 定义一个双端队列，保持的时数组下标  
        int[] res = new int[arr.length - w + 1];// 最大值数组元素的个数  
        int index = 0;  
        for (int i = 0; i < arr.length; i++) {  
            int cur = arr[i];  
            while (!qMax.isEmpty() && arr[qMax.peekLast()] <= cur) {// 当双端队列不空，并且当前元素大于等于队列的尾的元素时  
                qMax.pollLast();// 把队列尾部元素弹出  
            }  
            qMax.addLast(i);// 把当前数组下标存到队列中  
            if (qMax.peekFirst() == i - w) {// 当队首的元素下标为i-w时，过期  
                qMax.pollFirst();// 将队首元素弹出  
            }  
            if (i >= w - 1) {// 如i=3，w=3，此时窗口下标应为[1,2,3]，index为0，故此时index加1，即窗口右移  
                res[index++] = arr[qMax.peekFirst()];// 当前窗口的最大值，即窗口右移一位后的首部  
            }  
  
        }  
  
        return res;  
  
    }  
  
}
