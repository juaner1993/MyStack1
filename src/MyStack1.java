import java.util.Stack;
/**
 * 实现一个特殊的栈，在实现栈的基本功能的基础上，再返回栈中最小的元素
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
	 * 压入数据规则
	 * 
	 * @param newNum 当前数据
	 * 假设当前数据为newNum，先将其压入stackData。然后判断stackMin是否为空：
	 * 如果为空，这newNum也压入stackMin。
	 * 如果不为空，则比较newNum和stackMin的栈顶元素哪一个更小：
	 * 如果newNum更小或两者相等，则newNum也压入stackMin；
	 * 如果stackMin中栈顶元素小，则stackMin不压入任何内容。
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
	 * 弹出数据规则
	 * @return
	 * 先在stackData中弹出栈顶元素，记为value。
	 * 然后比较当前stackMin的栈顶元素和value
	 * 当value等于stackMin的栈顶元素，stackMin弹出栈顶元素
	 * 否则，返回value
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
	 * 查询当前栈中的最小操作
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
		System.out.print("栈中最小元素是：" + ms.getMin());
		
	}
}
