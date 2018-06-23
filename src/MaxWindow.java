import java.util.LinkedList;
/**
 * ���ɴ������ֵ����
 * ���Ӷ�O��N����ʵ�ֹؼ��ǣ�����˫�˶�����ʵ�ִ������ֵ�ĸ���
 * @author juaner
 *
 */
public class MaxWindow {
	//����
	public static void main(String[] args) {
		int [] a = {4, 3, 5, 4, 3, 3, 6, 7};
		for (int j = 0; j< a.length; j++) {
			System.out.print(a[j] + " ");
		}
		int [] s = getMaxWindow(a, 3);
		System.out.println(" ");
		System.out.print("�������ֵΪ�� ");
		for (int i = 0; i < s.length; i++) {
			System.out.print(s[i] + " ");
		}
	}

	
	public static int[] getMaxWindow(int[] arr, int w) {
		/**
		 * �������Ϊ�ջ��ߴ���С��1��������û�д��ڴ������κδ���ֱ�ӷ���
		 */
		if (arr == null || w < 1 || arr.length < w) {
			return null;
		}
		//����һ��˫�˶��У��������arr�е��±�
		LinkedList<Integer> qmax = new LinkedList<Integer>();
		//����res�����������ÿ�δ����е����ֵ�������СΪ������ĸ���-���ڴ�Сw + 1
		int [] res = new int[arr.length - w + 1];
		int index = 0;
		for (int i = 0; i < arr.length; i++) {
			//���qmax��Ϊ����qmax�Ķ�βֵС��arr[i]���򵯳���β��Ԫ��
			while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]) {
				qmax.pollLast();
			}
			//������������arr[i]���뵽qmax�Ķ�β
			qmax.addLast(i);
			//������ڣ��򵯳�qmax��ͷ��Ԫ��
			if (qmax.peekFirst() == i - w) {
				qmax.pollFirst();
			}
			//��������ƶ�һ��������Ҫ�Ѵ������ֵ���뵽res������ȥ
			if(i >= w-1) {
				res[index++] = arr[qmax.peekFirst()];
			}
		}
		//���ش������ֵres����
		return res;
	}
}
