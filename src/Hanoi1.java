import java.util.Scanner;
/**
 * �õݹ�ķ�����⺺ŵ������
 * ע�⣺�����ƶ�ʱ���뾭���м�
 * @author juaner
 *
 */

public class Hanoi1 {

	public static void main(String[] args) {

		Hanoi1 h = new Hanoi1();
		Scanner cin = new Scanner(System.in);
		System.out.print("�����뺺ŵ���ĸ����� " );
		int a = cin.nextInt();
		h.hanoiProblem1(a, "left", "mid", "right");

	}

	
	public int hanoiProblem1(int num ,String left , String mid ,String right) {
		if (num < 1) {
			return 0;
		}
		
		return process(num, left, mid, right, left, right);
	}


	public int process(int num, String left, String mid, String right, String from, String to) {
		/**
		 * ������Ϊһ��ʱ
		 */
		if (num == 1) {
			//������Ϊһ��ʱ�������Ƶ��м����м��ƶ�ʱ��ֻ��һ��
			if (from.equals(mid) || to.equals(mid)) {
				System.out.println("Move 1 from " + from + " to " + to);
				System.out.println("The number of step is 1");
				return 1;
			} else {//�����������Ҫ�ƶ�����
				System.out.println("Move 1 from " + from + " to " + mid);
				System.out.println("Move 1 from " + mid + " to " + to);
				//System.out.println("The number of step is 2");
				return 2;
			}
		}
		/**
		 * ������Ϊ���ʱ
		 */
		if (from.equals(mid) || to.equals(mid)) {//������Ϊ���ʱ�������Ƶ��м����м��ƶ�ʱ����Ҫ��������
			//����ѡ����right��������ȫ���ƶ�����ʱ
			String another = (from.equals(mid) || to.equals(mid)) ? right : left;
			//��һ������1~n-1��ȫ�������Ƶ��ң������ݹ����
			int part1 = process(num - 1, left, mid, right, from, another);
			//�ڶ���������n������Ƶ���
			int part2 = 1;
			System.out.println("Move " + num + " from " + from + " to " + to);
			//����������1~n-1��ȫ�������Ƶ��У������ݹ����
			int part3 = process(num - 1, left, mid, right, another, to);
			return part1 + part2 + part3;
		} else {//�����������Ҫ5������
			/**
			 * ��������Ƶ���
			 */
			//��һ������1~n-1��ȫ�������Ƶ��ң������ݹ����
			int part1 =  process(num - 1, left, mid, right, from, to);
			//�ڶ���������n������Ƶ���
			int part2 = 1;
			System.out.println("Move " + num + " from " + from + " to " + mid);
			//����������1~n-1��ȫ�������Ƶ��󣬽����ݹ����
			int part3 = process(num - 1, left, mid, right, to, from);
			//���Ĳ�������n������Ƶ���
			int part4 = 1;
			System.out.println("Move " + num + " from " + mid + " to " + to);
			//���岽����1~n-1��ȫ�������Ƶ��ң������ݹ����
			int part5 = process(num - 1, left, mid, right, from, to);
			return part1 + part2 + part3 + part4 + part5;
		}
	}
}
