import java.util.Stack;
/**
 * 用两个栈实现一个队列，支持队列的基本操作（add,poll,peek）
 * @author juaner
 *
 */
public class TwoStacksQueue {
	/*
	 * 一个栈作为压入栈，在压入数据时只往这个栈中压入，记为stackPush
	 * 另一个栈只作为弹出栈，在弹出数据时只从这个栈弹出，记为satckPop
	 */
	private Stack<Integer> stackPush;
	private Stack<Integer> stackPop;
	
	public TwoStacksQueue() {
		stackPush = new Stack<Integer>();
		stackPop = new Stack<Integer>();
	}
	
	public void add(int pushInt) {
		this.stackPush.push(pushInt);
	}
	/*
	 * 如果stackpush要往stackPop中压入数据，那么必须一次性把stackPush中的数据全部压入
	 * 如果stackPop不为空，stackPush绝对不能向stackPop中压入数据
	 */
	public int poll() {
		if(this.stackPush.empty() && this.stackPop.empty()) {
			throw new RuntimeException("Queue is empty!");
		} else if(this.stackPop.empty()) {
			while(!this.stackPush.empty()) {
				this.stackPop.push(this.stackPush.pop());
			}
		}
		return this.stackPop.pop();
	}
	
	public int peek() {
		if(this.stackPush.empty() && this.stackPop.empty()) {
			throw new RuntimeException("Queue is empty!");
		} else if(this.stackPop.empty()) {
			while(!this.stackPush.empty()) {
				this.stackPop.push(this.stackPush.pop());
			}
		}
		return this.stackPop.peek();
	}
	
	public static void main(String[] args) {
		TwoStacksQueue tsq = new TwoStacksQueue();
		tsq.add(5);
		tsq.add(6);
		tsq.add(7);
		System.out.println(tsq.peek());
		tsq.add(8);
		tsq.add(9);
		tsq.poll();
		tsq.poll();
		tsq.poll();
		System.out.println(tsq.peek());
	}

}
