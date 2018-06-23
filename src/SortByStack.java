import java.util.Stack;
/**
 * ��һ��ջʵ����һ��ջ�����򣬽�ջ�Ӷ����װ��Ӵ�С��˳������
 * @author juaner
 *
 */
public class SortByStack {
	/**
	 * 
	 * @param stack
	 * ���curС�ڵ���help��ջ��Ԫ�أ���curֱ��ѹ��help
	 * ���cur����help��ջ��Ԫ�أ���help��Ԫ����һѹ�뵽stack��
	 */
	public static void sortStackByStack(Stack<Integer> stack) {
		Stack<Integer> help = new Stack<Integer>();
		while(!stack.isEmpty()) {
			int cur = stack.pop();
			while(!help.isEmpty() && help.peek() < cur) {
				stack.push(help.pop());
			}
			help.push(cur);
		}
		
		while(!help.isEmpty()) {
			stack.push(help.pop());
		}
	}
	
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(2);
		stack.push(5);
		stack.push(4);
		sortStackByStack(stack);
		while(!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}

	}

}
