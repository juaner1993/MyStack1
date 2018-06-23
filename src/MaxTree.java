import java.util.HashMap;
import java.util.Stack;
/**
 * �������ڵ�Ķ���
 * @author juaner
 *
 */
class Node {
	public int value;
	public Node left;
	public Node right;
	
	public Node(int data) {
		this.value = data;
		left = right = null ; //����ʡ�ԣ�������ʱ��Ч
	}
}
/**
 * ���������MaxTree
 * ע�⣺�������û���ظ�Ԫ��
 * MaxTree��һ�Ŷ������������ÿһ��ֵ��Ӧһ���������ڵ�
 * ֵ���Ľڵ�������ͷ
 * ʱ�临�Ӷ�ΪO��N��������ռ临�Ӷ�ΪO��N��
 * @author juaner
 *
 */
public class MaxTree {

	public static void main(String[] args) {
		MaxTree m = new MaxTree();
		int [] a = {3, 4, 5, 1, 2};
		Node head = m.getMaxTree(a);
		m.preOrder(head);//����ǰ�����������
	}
	
	public  Node getMaxTree(int[] arr) {
		Node[] nArr = new Node[arr.length];
		for (int i = 0; i != arr.length; i++) {
			nArr[i] = new Node(arr[i]); //�����ڵ�
		}
		Stack<Node> stack = new Stack<Node>();
		HashMap<Node, Node> lBigMap = new HashMap<Node, Node>();
		HashMap<Node, Node> rBigMap = new HashMap<Node, Node>();
		//����ջ���ҵ�ÿ������ߵĵ�һ������������������ұ�����ջ�б��ֵݼ����У�����������ͣ������pop��ջ��  
        //ֱ��ջ�������������ջ��  
		for (int i = 0; i != nArr.length; i++) {
			Node curNode = nArr[i];
			while ((!stack.isEmpty()) && stack.peek().value < curNode.value) {
				popStackSetMap(stack, lBigMap);//����ջ�������������Ӧ����ߵ�һ��������Ľڵ�  
			}
			stack.push(curNode);// ѹ���½ڵ�
		}
		while(!stack.isEmpty()) { //����ʣ�µ���ջ�а����ϵ��������Ԫ��  
			popStackSetMap(stack, lBigMap);
		}
		//��ͬ���ķ���������������������ÿ�������ҵ�һ����������� 
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
		 //������  
        //ԭ���ǣ�1ÿһ�����ĸ��ڵ�������ߵ�һ����������������ұߵ�һ������������У���С���Ǹ���  
        //2���һ�������û�б�����������ұ�Ҳû�У�Ҳ����˵���������������������ֵ���Ǹ�����������ڵ㡣  
		Node head = null;
		for (int i = 0; i != nArr.length; i++) {
			Node curNode = nArr[i];
			Node left = lBigMap.get(curNode);//�ҵ��ĵ�ǰ�ڵ���ߵ�һ��������Ľڵ�
			Node right = rBigMap.get(curNode);//�ҵ��ĵ�ǰ�ڵ��ұߵ�һ��������Ľڵ�
			if (left == null && right == null) {
				head = curNode;//���ڵ�
			} else if (left == null) {//�������ӹ�ϵ  
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
		Node popNode = stack.pop();//��ջ��ʱ��ȷ������ӳ���ϵ
		if (stack.isEmpty()) {
			map.put(popNode, null);
		} else {
			map.put(popNode, stack.peek());
		}
	}
	 //ǰ�����������
	public void preOrder(Node head) {
		if(head != null) {
			System.out.println(head.value);
			preOrder(head.left);
			preOrder(head.right);
		}
	}

}
