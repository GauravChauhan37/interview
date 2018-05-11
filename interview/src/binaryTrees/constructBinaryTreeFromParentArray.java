package binaryTrees;

import java.util.Scanner;

public class constructBinaryTreeFromParentArray {
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

		Node root = construct(arr);
		if (root == null) {
			System.out.println("Invalid");
		} else {
			display(root);
		}
	}

	private static Node construct(int[] arr) {
		Node[] nodes = new Node[arr.length];
		for (int i = 0; i < nodes.length; i++) {
			nodes[i] = new Node(i, null, null);
		}
		Node root = new Node(0, null, null);
		for (int i = 0; i < nodes.length; i++) {
			if (arr[i] != -1) {
				int parent = arr[i];
				if (nodes[parent].left == null) {
					nodes[parent].left = nodes[i];
				} else if (nodes[parent].right == null) {
					nodes[parent].right = nodes[i];
				} else {
					System.out.println("Invalid");
					Node root1 = new Node(0, null, null);
					return root1;
				}
			} else {
				root = nodes[i];
			}
		}
		return root;
	}
}
