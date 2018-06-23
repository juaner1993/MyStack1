
import java.util.LinkedList;  
  
public class GetMaxWindow {  
  
    public static void main(String[] args) {  
        int[] a = { 4, 3, 5, 4, 3, 3, 6, 7 };  
        int[] solution = solution(a, 3);  
        System.out.print("���ֵ����Ϊ��");  
        for (int i = 0; i < solution.length; i++) {  
            System.out.print(solution[i] + " ");  
        }  
    }  
  
    public static int[] solution(int[] arr, int w) {  
  
        if (arr == null || w < 1 || arr.length < w) {  
            return null;  
        }  
  
        LinkedList<Integer> qMax = new LinkedList<Integer>();// ����һ��˫�˶��У����ֵ�ʱ�����±�  
        int[] res = new int[arr.length - w + 1];// ���ֵ����Ԫ�صĸ���  
        int index = 0;  
        for (int i = 0; i < arr.length; i++) {  
            int cur = arr[i];  
            while (!qMax.isEmpty() && arr[qMax.peekLast()] <= cur) {// ��˫�˶��в��գ����ҵ�ǰԪ�ش��ڵ��ڶ��е�β��Ԫ��ʱ  
                qMax.pollLast();// �Ѷ���β��Ԫ�ص���  
            }  
            qMax.addLast(i);// �ѵ�ǰ�����±�浽������  
            if (qMax.peekFirst() == i - w) {// �����׵�Ԫ���±�Ϊi-wʱ������  
                qMax.pollFirst();// ������Ԫ�ص���  
            }  
            if (i >= w - 1) {// ��i=3��w=3����ʱ�����±�ӦΪ[1,2,3]��indexΪ0���ʴ�ʱindex��1������������  
                res[index++] = arr[qMax.peekFirst()];// ��ǰ���ڵ����ֵ������������һλ����ײ�  
            }  
  
        }  
  
        return res;  
  
    }  
  
}
