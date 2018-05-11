package binaryTrees;

import java.util.Scanner;
import java.util.Stack;

public class iterativePostordertraversal {
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

		int[] arr = new int[scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}

		Node[] nodes = new Node[arr.length];
		for (int i = 0; i < nodes.length; i++) {
			if (arr[i] != -1) {
				nodes[i] = new Node(arr[i], null, null);

				if (i > 0) {
					int pi = (i - 1) / 2;

					if (i == 2 * pi + 1) {
						nodes[pi].left = nodes[i];
					} else {
						nodes[pi].right = nodes[i];
					}
				}
			}
		}

		solve(nodes[0]);
	}

	public static void solve(Node root) {
		Stack<Node> process = new Stack<>();
		Stack<Integer> res = new Stack<>();

		process.push(root);
		while (!process.isEmpty()) {
			Node a = process.pop();

			res.push(a.data);
			if (a.left != null)
				process.push(a.left);
			if (a.right != null)
				process.push(a.right);

		}
		while (!res.isEmpty()) {
			System.out.print(res.pop()+" ");
		}
		// code this here
	}

}
