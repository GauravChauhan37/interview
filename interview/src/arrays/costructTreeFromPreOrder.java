
package arrays;

import java.util.ArrayList;
import java.util.Scanner;

public class costructTreeFromPreOrder {
	private static class Node {
		int data;
		Node left;
		Node right;

		Node(int data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}

	public static void display(Node node) {
		if (node == null) {
			return;
		}

		String str = "";

		str += node.left == null ? "." : node.left.data;
		str += " => " + node.data + " <= ";
		str += node.right == null ? "." : node.right.data;

		System.out.println(str);

		display(node.left);
		display(node.right);
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] preData = new int[Integer.parseInt(scn.next())];
		for (int i = 0; i < preData.length; i++) {
			preData[i] = Integer.parseInt(scn.next());
		}
		String[] lnData = new String[preData.length];
		for (int i = 0; i < lnData.length; i++) {
			lnData[i] = scn.next();
		}

		Node root = construct(preData, lnData);
		if (root == null) {
			System.out.println("Invalid");
		} else {
			display(root);
		}
	}

	static int idx = 0;

	private static Node construct(int[] preData, String[] lnData) {
		if (idx >= preData.length) {
			return null;
		}
		Node node = new Node(preData[0], null, null);
		if (lnData[idx] != "L") {
			idx++;
			Node left_Node = construct(preData, lnData);
			node.left = left_Node;
			Node right_Node = construct(preData, lnData);
			node.right = right_Node;

		} else {
			idx++;
			return node;
		}
		return node;
	}
}
