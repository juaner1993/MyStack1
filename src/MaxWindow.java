import java.util.LinkedList;
/**
 * 生成窗口最大值数组
 * 复杂度O（N）的实现关键是：利用双端队列来实现窗口最大值的更新
 * @author juaner
 *
 */
public class MaxWindow {
	//测试
	public static void main(String[] args) {
		int [] a = {4, 3, 5, 4, 3, 3, 6, 7};
		for (int j = 0; j< a.length; j++) {
			System.out.print(a[j] + " ");
		}
		int [] s = getMaxWindow(a, 3);
		System.out.println(" ");
		System.out.print("窗口最大值为： ");
		for (int i = 0; i < s.length; i++) {
			System.out.print(s[i] + " ");
		}
	}

	
	public static int[] getMaxWindow(int[] arr, int w) {
		/**
		 * 如果数组为空或者窗口小于1或者数组没有窗口大，则不做任何处理，直接返回
		 */
		if (arr == null || w < 1 || arr.length < w) {
			return null;
		}
		//定义一个双端队列，存放数组arr中的下标
		LinkedList<Integer> qmax = new LinkedList<Integer>();
		//定义res数组用来存放每次窗口中的最大值，数组大小为：数组的个数-窗口大小w + 1
		int [] res = new int[arr.length - w + 1];
		int index = 0;
		for (int i = 0; i < arr.length; i++) {
			//如果qmax不为空且qmax的队尾值小于arr[i]，则弹出队尾的元素
			while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]) {
				qmax.pollLast();
			}
			//其他情况，则把arr[i]加入到qmax的队尾
			qmax.addLast(i);
			//如果过期，则弹出qmax队头的元素
			if (qmax.peekFirst() == i - w) {
				qmax.pollFirst();
			}
			//如果向右移动一步，就需要把窗口最大值加入到res数组中去
			if(i >= w-1) {
				res[index++] = arr[qmax.peekFirst()];
			}
		}
		//返回窗口最大值res数组
		return res;
	}
}
