package com.learnbycoding.BinaryTrees;

public class ClientBinaryTree {
	
	public static void main(String[] args) {
		/*
		
		                     40
		                  /     \ 
                         20		  60
                        /  \      /  \
		               10   30   50   70
		              /           \
		             5	           55
		             
		*/             
		BinarySearchTree binTree= new BinarySearchTree();
		
		binTree.insert(40);
		binTree.insert(20);
		binTree.insert(60);
		binTree.insert(10);
		binTree.insert(5);
		binTree.insert(30);
		binTree.insert(50);
		binTree.insert(70);
		binTree.insert(55);
		
		System.out.println("Inorder traversal");
		binTree.inorderTraversal();
		System.out.println();
		
		binTree.delete(55);
		//binTree.delete(8);
		System.out.println("Inorder traversal");
		binTree.inorderTraversal();
		System.out.println();
		
		binTree.insert(55);
		System.out.println("Inorder traversal");
		binTree.inorderTraversal();
		System.out.println();
		
	
		System.out.println("Pre order traversal");
		binTree.preOrderTraversal();
		System.out.println();
		
		System.out.println("Post order traversal");
		binTree.postOrderTraversal();
		
		System.out.println();
		System.out.println("Level order traversal");
		binTree.levelOrderTraversal();
		
		System.out.println();
		System.out.println("Spiral order traversal");
		binTree.spiralLevelOrderTraversal();
		
		System.out.println();
		System.out.println("Reverse order traversal");
		binTree.reverseLevelOrderTraversal();
		
		System.out.println();
		System.out.println("Boundary order traversal");
		binTree.boundaryTraversal();
		
		System.out.println();
		System.out.println();
		System.out.println("printLeafNodesOfABinaryTree ");
		binTree.printLeafNodesOfABinaryTree();
		
		System.out.println();
		System.out.println();
		System.out.println("countLeafNodesOfTree ");
		binTree.countLeafNodesOfTree();
		
		System.out.println();
		System.out.println();
		System.out.println("getMaximumElement " + binTree.getMaximumElement());
		
		System.out.println();
		System.out.println();
		System.out.println("printAllPathsFromRootToLeaf ");
		binTree.printAllPathsFromRootToLeaf();
		
		System.out.println();
		System.out.println();
		System.out.println("printAllPathsFromRootToLeaf ");
		binTree.printAllPathsFromRootToLeaf();
		
		System.out.println();
		System.out.println();
		System.out.println("printVerticalSumOFBinaryTree ");
		binTree.printVerticalSumOFBinaryTree();
			
		System.out.println();
		System.out.println("getLevelOFABinaryTreeNode : " +binTree.getLevelOFABinaryTreeNode(40));
		
		System.out.println();
		System.out.println("lcaOfABinaryNode : " + binTree.lcaOfABinaryNode(55, 70));
	}
}
