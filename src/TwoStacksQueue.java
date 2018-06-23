import java.util.Stack;
/**
 * ������ջʵ��һ�����У�֧�ֶ��еĻ���������add,poll,peek��
 * @author juaner
 *
 */
public class TwoStacksQueue {
	/*
	 * һ��ջ��Ϊѹ��ջ����ѹ������ʱֻ�����ջ��ѹ�룬��ΪstackPush
	 * ��һ��ջֻ��Ϊ����ջ���ڵ�������ʱֻ�����ջ��������ΪsatckPop
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
	 * ���stackpushҪ��stackPop��ѹ�����ݣ���ô����һ���԰�stackPush�е�����ȫ��ѹ��
	 * ���stackPop��Ϊ�գ�stackPush���Բ�����stackPop��ѹ������
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
