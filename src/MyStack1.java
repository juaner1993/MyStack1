import java.util.Stack;
/**
 * ʵ��һ�������ջ����ʵ��ջ�Ļ������ܵĻ����ϣ��ٷ���ջ����С��Ԫ��
 * @author juaner
 *
 */
public class MyStack1 {
	private Stack<Integer> stackData ;
	private Stack<Integer> stackMin;
	
	public MyStack1() {
		this.stackData = new Stack<Integer>();
		this.stackMin = new Stack<Integer>();
	}
	/**
	 * ѹ�����ݹ���
	 * 
	 * @param newNum ��ǰ����
	 * ���赱ǰ����ΪnewNum���Ƚ���ѹ��stackData��Ȼ���ж�stackMin�Ƿ�Ϊ�գ�
	 * ���Ϊ�գ���newNumҲѹ��stackMin��
	 * �����Ϊ�գ���Ƚ�newNum��stackMin��ջ��Ԫ����һ����С��
	 * ���newNum��С��������ȣ���newNumҲѹ��stackMin��
	 * ���stackMin��ջ��Ԫ��С����stackMin��ѹ���κ����ݡ�
	 */
	public void push(int newNum) {
		if(this.stackMin.isEmpty()) {
			this.stackMin.push(newNum);
		}else if(newNum <= this.getMin()) {
			this.stackMin.push(newNum);
		}
		this.stackData.push(newNum);
	}
	/**
	 * �������ݹ���
	 * @return
	 * ����stackData�е���ջ��Ԫ�أ���Ϊvalue��
	 * Ȼ��Ƚϵ�ǰstackMin��ջ��Ԫ�غ�value
	 * ��value����stackMin��ջ��Ԫ�أ�stackMin����ջ��Ԫ��
	 * ���򣬷���value
	 */
	public int pop() {
		if(this.stackData.isEmpty()) {
			throw new RuntimeException("Your stack is empty!");
		}
		int value = this.stackData.pop();
		if(value == this.getMin()) {
			this.stackMin.pop();
		}
		return value;
	}
	/**
	 * ��ѯ��ǰջ�е���С����
	 * @return
	 */
	public int getMin() {
		if(this.stackMin.isEmpty()) {
			throw new RuntimeException("Your stack id empty!");
		}
		return this.stackMin.peek();
	}
	
	public static void main(String[] args) {
		MyStack1 ms = new MyStack1();
		ms.push(3);
		ms.push(4);
		ms.push(5);
		ms.push(6);
		ms.push(2);
		ms.push(2);
		ms.pop();
		ms.pop();
		System.out.print("ջ����СԪ���ǣ�" + ms.getMin());
		
	}
}
