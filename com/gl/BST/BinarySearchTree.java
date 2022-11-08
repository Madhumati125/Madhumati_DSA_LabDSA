package com.gl.BST;

import java.util.ArrayList;
import java.util.Scanner;

public class BinarySearchTree {
	ArrayList<Integer> nodelist = new ArrayList<>();

	private static Node newNode(int n) {
		Node temp = new Node();
		temp.left = null;
		temp.data = n;
		temp.right = null;

		return temp;
	}

	private void insert(Node root, Node nn) {
		if (nn.data < root.data) {
			if (root.left == null) {
				root.left = nn;
			} else {
				insert(root.left, nn);
			}
		} else {
			if (root.right == null) {
				root.right = nn;
			} else {
				insert(root.right, nn);
			}
		}

	}

	private void traversegl(Node root) {
		if (root != null) {
			traversegl(root.left);
			traversegl(root.right);
			nodelist.add(root.data);
		}

	}

	public static void main(String args[]) {
		BinarySearchTree bst = new BinarySearchTree();
		Node root = null;
		Node nn = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Number Of Nodes");
		int k = sc.nextInt();
		int i;
		for (i = 1; i <= k; i++) {
			System.out.println("Enter Data For The Node");
			int n = sc.nextInt();
			nn = newNode(n);
			if (root == null) {
				root = nn;
			} else {
				bst.insert(root, nn);
			}
		}

		bst.traversegl(root);
		System.out.println(bst.nodelist);

		System.out.print("Sum = ");
		int sum = sc.nextInt();
		int flag = 0;
		for (int j = 0; j < bst.nodelist.size(); j++) {
			int n1 = bst.nodelist.get(j);
			int n2 = sum - n1;
			if (bst.nodelist.contains(n2)) {
				System.out.print("Pair is");
				System.out.print("(" + n2 + "," + n1 + ")");
				flag = 1;
				break;
			}
		}

		if (flag == 0) {
			System.out.println("Print Nodes Are Not Found.");
		}
	}
} 