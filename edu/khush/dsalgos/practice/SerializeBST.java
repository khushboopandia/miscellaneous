package edu.khush.dsalgos.practice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SerializeBST {
	
	public static void main()
	{
		int[] inorder={2,3,4,6,7,9,13,15,17,18,20};
		int[] postorder={2,4,3,9,13,7,6,17,20,18,15};
		
		
		
	}

	public TreeNode[] serialize(BinarySearchTree tree, int size) {
		// TreeNode[] serializedBst = new TreeNode[100];
		TreeNode[] serializedBst = new TreeNode[2 * size + 2];

		serializedBst[0] = tree.root;
		int counter = 1;
		int ptr = 0;

		while (counter < size) {

			// System.out.println(counter);
			TreeNode node = serializedBst[ptr];
			if (node != null) {
				if (node.getLeft() != null)
					serializedBst[2 * ptr + 1] = node.getLeft();
				else
					serializedBst[2 * ptr + 1] = null;

				if (node.getRight() != null)
					serializedBst[2 * ptr + 2] = node.getRight();
				else
					serializedBst[2 * ptr + 2] = null;
				counter += 1;
			}

			ptr++;
		}

		return serializedBst;

	}

	public BinarySearchTree deserialize(TreeNode[] serializedTree) {

		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(serializedTree[0]);

		for (int i = 0; i < serializedTree.length; i++) {
			if (2 * i + 2 < serializedTree.length) {
				if (serializedTree[i] != null) {
					if (serializedTree[2 * i + 1] != null)
						serializedTree[i].setLeft(serializedTree[2 * i + 1]);
					if (serializedTree[2 * i + 2] != null)
						serializedTree[i].setRight(serializedTree[2 * i + 2]);

				}
			}

		}

		return bst;

	}

	public List<Integer> serialize1(TreeNode node,
			LinkedList<Integer> treeAsList) {

		if (node == null) {
			treeAsList.add(null);
			return treeAsList;
		}

		else {
			treeAsList.add(node.getValue());
			serialize1(node.getLeft(), treeAsList);
			serialize1(node.getRight(), treeAsList);
			return treeAsList;
		}

	}

	public TreeNode deserialize1(LinkedList<Integer> treeAsList,
			Iterator<Integer> it) {
		
		Integer current = it.next();
		System.out.println(current);
		if (current == null) {
			return null;
		} else {
			TreeNode newNode = new TreeNode(null, null, current);
			newNode.setLeft(deserialize1(treeAsList, it));
			newNode.setRight(deserialize1(treeAsList, it));
			return newNode;

		}

	}
	
	public TreeNode createBST(int[] in, int[] post)
	{
		
		
		return null;
		
	}

}
