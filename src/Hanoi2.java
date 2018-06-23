import java.util.Stack;

/**
 * ��ջ����⺺ŵ������
 * @author juaner
 *
 */
public class Hanoi2 {
	//����
	public static void main(String[] args) {
		hanoiProblem2(2,"left","mid","right");
      

	}
	/**
	 * 4��ʵ�ʶ���
	 * @author juaner
	 *
	 */
	public enum Action {
		No, LToM, MToL, MToR, RToM
	}
	
	public static int hanoiProblem2 (int num, String left, String mid, String right) {
		//�����С��������ص�����ջ
		Stack<Integer> ls = new Stack<Integer>();
		Stack<Integer> ms = new Stack<Integer>();
		Stack<Integer> rs = new Stack<Integer>();
		ls.push(Integer.MAX_VALUE);
		ms.push(Integer.MAX_VALUE);
		rs.push(Integer.MAX_VALUE);
		/**
		 * lsջ����ջ����1~num
		 */
		for (int i = num; i > 0; i--) {
			ls.push(i);
		}
		Action[] record = {Action.No};
		int step = 0;
		while (rs.size()!= num + 1) {
			step += fStackTotStack(record, Action.MToL, Action.LToM, ls, ms, left, mid);
			step += fStackTotStack(record, Action.LToM, Action.MToL, ms, ms, mid, left);
			step += fStackTotStack(record, Action.RToM, Action.MToR, ms, rs, mid, right);
			step += fStackTotStack(record, Action.MToR, Action.RToM, rs, ms, right, mid);
		}
		  System.out.println("һ������" + step + "��");
		return step;
	}

	public static  int fStackTotStack(Action[] record, Action preNoAct, Action nowAct, Stack<Integer> fStack, Stack<Integer> tStack,
			String from, String to) {
		/**
		 * һ�������������Ⱦ������ǲ�Υ��Сѹ������ڲ�����ԭ��
		 */
		if (record[0] != preNoAct && fStack.peek() < tStack.peek()) {
			tStack.push(fStack.pop());
			System.out.println("Move" + tStack.peek() + " from " + from + " to " + to);
			record[0] = nowAct;
			return 1;
		}
		return 0;
	}
	
}
