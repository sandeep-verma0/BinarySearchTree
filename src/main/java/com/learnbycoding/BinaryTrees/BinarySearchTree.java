package com.learnbycoding.BinaryTrees;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

public class BinarySearchTree {

	private Node root;
	private int size = 0;

	public BinarySearchTree() {
		//root = new Node();
	}

	boolean isEmpty() {
		return size == 0;
	}

	private int getSize() {
		return size;
	}

	private class Counter {
		int count = 0;
	}

	public void insert(int data) {
		root = insertUtil(root, data);
	}

	private Node insertUtil(Node root, int data) {

		if (root == null) {
			Node newNode = new Node();
			newNode.setData(data);
			root = newNode;
			return root;
		}

		Node temp = root;
		if (temp.data < data)
			root.right = insertUtil(root.right, data);
		else if (temp.data > data)
			root.left = insertUtil(root.left, data);
		else
			return root;

		return root;
	}

	private int search(int data) {
		return searchUtil(root, data);

	}

	public int searchUtil(Node root, int data) {
		if (root == null)
			return -1;

		Node temp = root;
		if (temp.data < data)
			return searchUtil(root.right, data);
		else if (temp.data > data)
			return searchUtil(root.left, data);
		else {
			return root.data;
		}
	}

	private int findInorderSuccessor(Node root) {

		Node current = root;
		while (current.left != null) {
			current = current.left;
		}

		return current.data;
	}

	public void delete(int data) {
		root = deleteUtil(root, data);
		size--;
	}

	private int height(Node root) {

		if (root == null)
			return 0;
		else
			return (Math.max(height(root.left), height(root.right)) + 1);
	}

	private Node deleteUtil(Node root, int data) {
		if (root == null)
			return null;

		if (root.data > data)
			root.left = deleteUtil(root.left, data);
		else if (root.data < data)
			root.right = deleteUtil(root.right, data);
		else {
			if (root.left == null)
				return root.right;
			else if (root.right == null)
				return root.left;
			else {
				root.data = findInorderSuccessor(root.right);
				root.right =deleteUtil(root.right, root.data);
			}
		}
		return root;
	}

	public void inorderTraversal() {
		inorderTraversalUtil(root);
	}

	private void inorderTraversalUtil(Node root) {
		if (root == null)
			return;

		inorderTraversalUtil(root.left);
		System.out.print(root.data + " ");
		inorderTraversalUtil(root.right);
	}

	public void preOrderTraversal() {
		preOrderTraversalUtil(root);
	}

	private void preOrderTraversalUtil(Node root) {
		if (root == null)
			return;

		System.out.print (root.data + " ") ;
		preOrderTraversalUtil(root.left);
		preOrderTraversalUtil(root.right);
	}

	public void postOrderTraversal() {
		postOrderTraversalUtil(root);
	}

	private void postOrderTraversalUtil(Node root) {
		if (root == null)
			return;

		postOrderTraversalUtil(root.left);
		postOrderTraversalUtil(root.right);
		System.out.print(root.data + " ");
	}

	public void levelOrderTraversal() {
		// levelOrderTraversalUtil(root);
		levelOrderTraversalUtil2(root);
	}

	private void levelOrderTraversalUtil(Node root) {
		if (root == null)
			return;

		Deque<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node current = queue.pollFirst();

			System.out.print(current.data + " ");

			if (root.left != null)
				queue.add(root.left);

			if (root.right != null)
				queue.add(root.right);
		}

	}

	public void levelOrderTraversalUtil2(Node root) {
		if (root == null)
			return;

		int height = height(root);
		for (int i = 1; i <= height; i++) {
			System.out.println();
			levelOrderTraversalHelper(root, i);
		}
	}

	private void levelOrderTraversalHelper(Node root, int level) {

		if (root == null)
			return;
		if (level == 1) {
			System.out.print(root.data + " ");
			return;
		} else {
			levelOrderTraversalHelper(root.left, level - 1);
			levelOrderTraversalHelper(root.right, level - 1);
		}
	}

	public void spiralLevelOrderTraversal() {

		if (root == null)
			return;

		int height = height(root);
		boolean isToRightSidePrinting = true;
		for (int i = 1; i <= height; i++) {
			System.out.println();
			spiralLevelOrderTraversalUtil(root, i, isToRightSidePrinting);
			isToRightSidePrinting = !(isToRightSidePrinting);
		}
	}

	private void spiralLevelOrderTraversalUtil(Node root, int level,
			boolean isToRightSidePrinting) {

		if (root == null)
			return;
		if (level == 1)
			System.out.print(root.data + " ");

		if (isToRightSidePrinting) {
			spiralLevelOrderTraversalUtil(root.left, level-1,
					isToRightSidePrinting);
			spiralLevelOrderTraversalUtil(root.right, level-1,
					isToRightSidePrinting);
		} else {
			spiralLevelOrderTraversalUtil(root.right, level-1,
					isToRightSidePrinting);
			spiralLevelOrderTraversalUtil(root.left, level-1,
					isToRightSidePrinting);
		}
	}

	public void reverseLevelOrderTraversal() {

		if (root == null)
			return;

		int height = height(root);
		for (int i = height; i >= 1; i--) {
			System.out.println();
			reverseLevelOrderTraversalUtil(root, i);

		}
	}

	private void reverseLevelOrderTraversalUtil(Node root, int level) {
		if (root == null)
			return;
		if (level == 1)
			System.out.print(root.data + " ");

		else {
			reverseLevelOrderTraversalUtil(root.left, level-1);
			reverseLevelOrderTraversalUtil(root.right, level-1);
		}
	}

	public void boundaryTraversal() {

		Node current = root;

		if (current.left == null) {
			System.out.print(current.data + " ");
		} else {
			while (current.left != null) {
				System.out.print(current.data + " ");
				current=current.left;
			}
		}

		boundaryTraversalUtil(root);
		current=root;
		Stack<Node> stack = new Stack<Node>();
		if (current.right == null) {
			System.out.print(current.data + " ");
		} else {
			while (current.right.right != null) {
				stack.push(current.right);
				current=current.right;
			}
		}

		while (!stack.isEmpty()) {
			System.out.print(stack.pop().data + " ");
		}

	}

	private void boundaryTraversalUtil(Node root) {
		if (root == null)
			return;

		if (root.left == null && root.right == null)
			System.out.print(root.data + " ");

		else {
			boundaryTraversalUtil(root.left);
			boundaryTraversalUtil(root.right);
		}
	}

	public void printLeafNodesOfABinaryTree() {
		printLeafNodesOfABinaryTreeUtil(root);
	}

	private void printLeafNodesOfABinaryTreeUtil(Node root) {
		Node current = root;
		if (current == null)
			return;

		if (root.left == null && root.right == null) {
			System.out.print(root.data + " ");
		} else {
			printLeafNodesOfABinaryTreeUtil(root.left);
			printLeafNodesOfABinaryTreeUtil(root.right);
		}
	}

	public void countLeafNodesOfTree() {
		Counter count = new Counter();
		countLeafNodesOfTreeUtil(root, count);
		System.out.println("Total number odf leaf Nodes are : " + count.count);
	}

	private void countLeafNodesOfTreeUtil(Node root, Counter count) {
		Node current = root;
		if (current == null)
			return;

		if (root.left == null && root.right == null) {
			count.count++;
		} else {
			countLeafNodesOfTreeUtil(root.left, count);
			countLeafNodesOfTreeUtil(root.right, count);
		}
	}

	public int getMaximumElement() {
		return getMaximumElementUtil(root);
	}

	private int getMaximumElementUtil(Node root) {

		if (root == null)
			return -1;
		int max = 0;

		int leftMax = getMaximumElementUtil(root.left);
		int rightMax = getMaximumElementUtil(root.right);

		max = Math.max(root.data, Math.max(leftMax, rightMax));

		return max;
	}

	public void printAllPathsFromRootToLeaf() {
		ArrayList<Node> listOfNodesFromRootToLeaf = new ArrayList<>();
		printAllPathsFromRootToLeafUtil(root, listOfNodesFromRootToLeaf);
	}

	private void printAllPathsFromRootToLeafUtil(Node root,
			ArrayList<Node> listOfNodesFromRootToLeaf) {

		if (root == null)
			return;

		listOfNodesFromRootToLeaf.add(root);
		if (root.left == null && root.right == null) {
			listOfNodesFromRootToLeaf.forEach(node -> System.out
					.print(node.data + " "));
			System.out.println();
		} else {
			printAllPathsFromRootToLeafUtil(root.left, new ArrayList<>(
					listOfNodesFromRootToLeaf));
			printAllPathsFromRootToLeafUtil(root.right, new ArrayList<>(
					listOfNodesFromRootToLeaf));
		}

	}

	public void printVerticalSumOFBinaryTree() {
		Map<Integer, Integer> levelToSumMap = new HashMap<Integer, Integer>();
		int level = 0;
		printVerticalSumOFBinaryTreeUtil(root, levelToSumMap, level);

		levelToSumMap.forEach((key , value)-> System.out.println("key : " + key + " value : " + value));	
	}

	public void printVerticalSumOFBinaryTreeUtil(Node root,
			Map<Integer, Integer> levelToSumMap, int level) {

		if (root == null)
			return;

		levelToSumMap.compute(level, (key, value) -> value==null ? root.data : (value + root.data));

		printVerticalSumOFBinaryTreeUtil(root.left, levelToSumMap, level - 1);
		printVerticalSumOFBinaryTreeUtil(root.right, levelToSumMap, level + 1);

	}

	public int getLevelOFABinaryTreeNode(int data) {
		int level=1;
	   return getLevelOfABinaryTreeNodeUtil(root, data, level); 
	}

	private int getLevelOfABinaryTreeNodeUtil(Node root, int data, int level) {
		if(root==null)
			return -1;
		
		if(root.data==data){
			return level;
		}else if(root.data > data){
			return getLevelOfABinaryTreeNodeUtil(root.left, data, level+1);
		}else {
			return getLevelOfABinaryTreeNodeUtil(root.right, data, level+1);
		}
	}
	
	
	public int lcaOfABinaryNode(int dataA , int dataB){
		Node A= new Node();
		Node B= new Node();
		A.setData(dataA);
		B.setData(dataB);
		
		return lcaOfABinaryNode(A, B);
	}
	
	private int lcaOfABinaryNode(Node A, Node B){
		Node lca=lcaOfABinaryNodeUtil(root, A, B);
		if(lca!=null)
		return lca.data;
		else 
			return -1;
	}
	
	private Node lcaOfABinaryNodeUtil(Node root, Node A, Node B){
		
		if(root==null)
			return null;
		
		Node current=root;
		
		while(current!=null){
		if(current.data > A.data  && current.data < B.data){
			return current;
		}
		else if(current.data > A.data  && current.data > B.data ) {
			current=current.left;
		}
		else if (current.data < A.data  && current.data < B.data ) {
			current=current.right;
		}
		}
	   return current;
	}
}
