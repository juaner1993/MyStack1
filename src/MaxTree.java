import java.util.HashMap;
import java.util.Stack;
/**
 * 二叉树节点的定义
 * @author juaner
 *
 */
class Node {
	public int value;
	public Node left;
	public Node right;
	
	public Node(int data) {
		this.value = data;
		left = right = null ; //不能省略，创建树时有效
	}
}
/**
 * 构造数组的MaxTree
 * 注意：素组必须没有重复元素
 * MaxTree是一颗二叉树，素组的每一个值对应一个二叉树节点
 * 值最大的节点是树的头
 * 时间复杂度为O（N）、额外空间复杂度为O（N）
 * @author juaner
 *
 */
public class MaxTree {

	public static void main(String[] args) {
		MaxTree m = new MaxTree();
		int [] a = {3, 4, 5, 1, 2};
		Node head = m.getMaxTree(a);
		m.preOrder(head);//按照前序遍历二叉树
	}
	
	public  Node getMaxTree(int[] arr) {
		Node[] nArr = new Node[arr.length];
		for (int i = 0; i != arr.length; i++) {
			nArr[i] = new Node(arr[i]); //创建节点
		}
		Stack<Node> stack = new Stack<Node>();
		HashMap<Node, Node> lBigMap = new HashMap<Node, Node>();
		HashMap<Node, Node> rBigMap = new HashMap<Node, Node>();
		//利用栈，找到每个数左边的第一个比它大的数，从左到右遍历，栈中保持递减序列，新来的数不停地利用pop出栈顶  
        //直到栈顶比新数大或者栈空  
		for (int i = 0; i != nArr.length; i++) {
			Node curNode = nArr[i];
			while ((!stack.isEmpty()) && stack.peek().value < curNode.value) {
				popStackSetMap(stack, lBigMap);//弹出栈顶，并保存其对应的左边第一个比它大的节点  
			}
			stack.push(curNode);// 压入新节点
		}
		while(!stack.isEmpty()) { //处理剩下的在栈中按从上到下升序的元素  
			popStackSetMap(stack, lBigMap);
		}
		//用同样的方法，从右往左遍历，求得每个数往右第一个比它大的数 
		for (int i = nArr.length - 1; i != -1; i--) {
			Node curNode = nArr[i];
			while ((!stack.isEmpty()) && stack.peek().value < curNode.value) {
				popStackSetMap(stack, rBigMap);
			}
			stack.push(curNode);
		}
		while(!stack.isEmpty()) {
			popStackSetMap(stack, rBigMap);
		}
		 //构建树  
        //原则是：1每一个数的父节点是它左边第一个比它大的数和它右边第一个比它大的数中，较小的那个。  
        //2如果一个数左边没有比它大的数，右边也没有，也就是说，这个数是整个数组的最大值，那个这个是树根节点。  
		Node head = null;
		for (int i = 0; i != nArr.length; i++) {
			Node curNode = nArr[i];
			Node left = lBigMap.get(curNode);//找到的当前节点左边第一个比它大的节点
			Node right = rBigMap.get(curNode);//找到的当前节点右边第一个比它大的节点
			if (left == null && right == null) {
				head = curNode;//根节点
			} else if (left == null) {//建立父子关系  
				if (right.left == null) {
					right.left = curNode;
				} else {
					right.right = curNode;
				}
			} else if (right == null) {
				if (left.left == null) {
					left.left = curNode;
				} else {
					left.right = curNode;
				}
			}else {
				Node parent = left.value < right.value ? left : right;
				if (parent.left == null) {
					parent.left = curNode;
				} else {
					parent.right = curNode;
				}
			}
		}
		return head;
	}

	public static void popStackSetMap(Stack<Node> stack, HashMap<Node, Node> map) {
		Node popNode = stack.pop();//出栈的时候，确定好了映射关系
		if (stack.isEmpty()) {
			map.put(popNode, null);
		} else {
			map.put(popNode, stack.peek());
		}
	}
	 //前序遍历二叉树
	public void preOrder(Node head) {
		if(head != null) {
			System.out.println(head.value);
			preOrder(head.left);
			preOrder(head.right);
		}
	}

}
