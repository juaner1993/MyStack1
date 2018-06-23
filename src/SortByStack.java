import java.util.Stack;
/**
 * 用一个栈实现另一个栈的排序，将栈从顶到底按从大到小的顺序排序
 * @author juaner
 *
 */
public class SortByStack {
	/**
	 * 
	 * @param stack
	 * 如果cur小于等于help的栈顶元素，则将cur直接压入help
	 * 如果cur大于help的栈顶元素，则将help的元素逐一压入到stack中
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
