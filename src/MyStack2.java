import java.util.Stack;
/*
 *  ʵ��һ�������ջ����ʵ��ջ�Ļ������ܵĻ����ϣ��ٷ���ջ����С��Ԫ��
 */
public class MyStack2 {
	private Stack<Integer> stackData;
	private Stack<Integer> stackMin;
	
	public MyStack2() {
		stackData = new Stack<Integer>();
		stackMin = new Stack<Integer>();
	}
	/*
	 * ѹ�����ݹ���
	 * 
	 * @param newNum ��ǰ����
	 * ���赱ǰ����ΪnewNum���Ƚ���ѹ��stackData��Ȼ���ж�stackMin�Ƿ�Ϊ�գ�
	 * ���Ϊ�գ���newNumҲѹ��stackMin��
	 * �����Ϊ�գ���Ƚ�newNum��stackMin��ջ��Ԫ����һ����С��
	 * ���newNum��С��������ȣ���newNumҲѹ��stackMin��
	 * ���stackMin��ջ��Ԫ��С����stackMin��ѹ��һ��ջ��Ԫ�ء�
	 */
	public void push(int newNum) {
		if(this.stackMin.isEmpty()) {
			this.stackMin.push(newNum);
		}else if(newNum < this.stackMin.peek()) {
			this.stackMin.push(newNum);
		}else {
			int newMin = this.stackMin.peek();
			this.stackMin.push(newMin);
		}
		this.stackData.push(newNum);
	}
	/*
	 * ��������ԭ��
	 * ������
	 */
	public int pop() {
		if(this.stackData.isEmpty()) {
			
		}
		this.stackMin.pop();
		return this.stackData.pop();
	}
	/**
	 * ��ѯ��ǰջ�е���С����
	 * @return
	 */
	public int getMin() {
		if(this.stackMin.isEmpty()) {
			throw new RuntimeException("Your stack is empty!");
		}
		return this.stackMin.peek();
	}
	
	public static void main(String[] args) {
		MyStack2 ms = new MyStack2();
		ms.push(3);
		ms.push(4);
		ms.push(5);
		ms.push(1);
		ms.push(2);
		ms.push(1);
		System.out.println("��ǰջ����СԪ���ǣ�" + ms.getMin());
	}
}
