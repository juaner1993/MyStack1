import java.util.Stack;
/*
 * ���õݹ麯����ջ��������һ��ջ
 */
public class Reverse {
	/*
	 * ��ջ��ջ��Ԫ�ط��ز��Ƴ�
	 */
	public static int getAndRemoveLastElement(Stack<Integer> stack) {
		int result = stack.pop();
		if(stack.empty()) {
			return result;
		}else {
			int last = getAndRemoveLastElement(stack);
			stack.push(result);
			return last;
		}
		
	}
	
	public static void reverse(Stack<Integer> stack) {
		if(stack.empty()) {
			return;
		}
		int i = getAndRemoveLastElement(stack);
		reverse(stack);
		stack.push(i);
	}
	
	public static void main(String[] args) {
		
		Reverse r =new Reverse();
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(5);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		r.reverse(stack);
		r.reverse(stack);
		System.out.println(stack.peek());
	}

}
