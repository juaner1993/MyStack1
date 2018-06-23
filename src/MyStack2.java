import java.util.Stack;
/*
 *  实现一个特殊的栈，在实现栈的基本功能的基础上，再返回栈中最小的元素
 */
public class MyStack2 {
	private Stack<Integer> stackData;
	private Stack<Integer> stackMin;
	
	public MyStack2() {
		stackData = new Stack<Integer>();
		stackMin = new Stack<Integer>();
	}
	/*
	 * 压入数据规则
	 * 
	 * @param newNum 当前数据
	 * 假设当前数据为newNum，先将其压入stackData。然后判断stackMin是否为空：
	 * 如果为空，这newNum也压入stackMin。
	 * 如果不为空，则比较newNum和stackMin的栈顶元素哪一个更小：
	 * 如果newNum更小或两者相等，则newNum也压入stackMin；
	 * 如果stackMin中栈顶元素小，则stackMin再压入一个栈顶元素。
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
	 * 弹出数据原则
	 * 都弹出
	 */
	public int pop() {
		if(this.stackData.isEmpty()) {
			
		}
		this.stackMin.pop();
		return this.stackData.pop();
	}
	/**
	 * 查询当前栈中的最小操作
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
		System.out.println("当前栈中最小元素是：" + ms.getMin());
	}
}
