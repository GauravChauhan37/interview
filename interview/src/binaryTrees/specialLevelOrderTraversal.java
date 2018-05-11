package binaryTrees;

import java.util.LinkedList;
import java.util.Scanner;

public class specialLevelOrderTraversal {
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
		Node root = null;

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

		// display(nodes[0]);
		solve(nodes[0]);
	}

	private static void solve(Node root) {
		System.out.print(root.data + " ");

		LinkedList<Node> leftQueue = new LinkedList<>();
		LinkedList<Node> rightQueue = new LinkedList<>();
		leftQueue.addLast(root.left);
		rightQueue.addLast(root.right);

		boolean flag = true;
		while (leftQueue.size() > 0 || rightQueue.size() > 0) {
			LinkedList<Node> queue = flag ? leftQueue : rightQueue;
			Node temp = queue.removeFirst();
			System.out.print(temp.data + " ");
			
			if (flag) {
				if (temp.left != null) {
					queue.addLast(temp.left);
				}

				if (temp.right != null) {
					queue.addLast(temp.right);
				}
			} else {
				if (temp.right != null) {
					queue.addLast(temp.right);
				}
				
				if (temp.left != null) {
					queue.addLast(temp.left);
				}
			}
			flag = !flag;
		}
	}
}
