import java.util.Scanner;
/**
 * 用递归的方法求解汉诺塔问题
 * 注意：限制移动时必须经过中间
 * @author juaner
 *
 */

public class Hanoi1 {

	public static void main(String[] args) {

		Hanoi1 h = new Hanoi1();
		Scanner cin = new Scanner(System.in);
		System.out.print("请输入汉诺塔的个数： " );
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
		 * 当塔数为一层时
		 */
		if (num == 1) {
			//当塔数为一层时，并且移到中间或从中间移动时，只需一步
			if (from.equals(mid) || to.equals(mid)) {
				System.out.println("Move 1 from " + from + " to " + to);
				System.out.println("The number of step is 1");
				return 1;
			} else {//其他情况，需要移动两步
				System.out.println("Move 1 from " + from + " to " + mid);
				System.out.println("Move 1 from " + mid + " to " + to);
				//System.out.println("The number of step is 2");
				return 2;
			}
		}
		/**
		 * 当塔数为多层时
		 */
		if (from.equals(mid) || to.equals(mid)) {//当塔数为多层时，并且移到中间或从中间移动时，需要三个步骤
			//假如选的是right，即从左全部移动到中时
			String another = (from.equals(mid) || to.equals(mid)) ? right : left;
			//第一步：将1~n-1层全部从左移到右，交给递归过程
			int part1 = process(num - 1, left, mid, right, from, another);
			//第二步：将第n层从左移到中
			int part2 = 1;
			System.out.println("Move " + num + " from " + from + " to " + to);
			//第三步：将1~n-1层全部从右移到中，交给递归过程
			int part3 = process(num - 1, left, mid, right, another, to);
			return part1 + part2 + part3;
		} else {//其他情况，需要5个步骤
			/**
			 * 假设从左移到右
			 */
			//第一步：将1~n-1层全部从左移到右，交给递归过程
			int part1 =  process(num - 1, left, mid, right, from, to);
			//第二步：将第n层从左移到中
			int part2 = 1;
			System.out.println("Move " + num + " from " + from + " to " + mid);
			//第三步：将1~n-1层全部从右移到左，交给递归过程
			int part3 = process(num - 1, left, mid, right, to, from);
			//第四步：将第n层从中移到右
			int part4 = 1;
			System.out.println("Move " + num + " from " + mid + " to " + to);
			//第五步：将1~n-1层全部从左移到右，交给递归过程
			int part5 = process(num - 1, left, mid, right, from, to);
			return part1 + part2 + part3 + part4 + part5;
		}
	}
}
