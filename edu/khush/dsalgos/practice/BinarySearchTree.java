package edu.khush.dsalgos.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinarySearchTree {

	public TreeNode root;
	public TreeNode previousInBst;

	public void insert(int data) {

		TreeNode x = root;
		TreeNode temp = x;

		TreeNode newNode = new TreeNode(null, null, data);

		while (x != null) {

			temp = x;
			if (x.getValue() < data)
				x = x.getRight();
			else
				x = x.getLeft();

		}

		if (temp == null)
			root = newNode;
		else {
			if (temp.getValue() > data)
				temp.setLeft(newNode);
			else
				temp.setRight(newNode);
		}
	}

	public void insertUnique(int data) {

		TreeNode x = root;
		TreeNode temp = x;

		TreeNode newNode = new TreeNode(null, null, data);

		while (x != null) {

			temp = x;
			if (x.getValue() < data)
				x = x.getRight();
			else if (x.getValue() < data)
				x = x.getLeft();
			else
				return;

		}

		if (temp == null)
			root = newNode;
		else {
			if (temp.getValue() > data)
				temp.setLeft(newNode);
			else
				temp.setRight(newNode);
		}
	}

	public void insert(TreeNode node) {

		TreeNode x = root;
		TreeNode temp = x;

		TreeNode newNode = node;

		while (x != null) {

			temp = x;
			if (x.getValue() < node.getValue())
				x = x.getRight();
			else
				x = x.getLeft();

		}

		if (temp == null)
			root = newNode;
		else {
			if (temp.getValue() > node.getValue())
				temp.setLeft(newNode);
			else
				temp.setRight(newNode);
		}
	}

	public TreeNode search(int data) {

		TreeNode current = root;

		while (current != null) {

			if (current.getValue() < data)
				current = current.getRight();
			else if (current.getValue() > data)
				current = current.getLeft();
			else
				return current;

		}

		return null;

	}

	public TreeNode getMinimum(TreeNode node) {

		if (node == null)
			return null;

		else {
			TreeNode current = node;
			TreeNode previous = null;
			while (current != null) {
				previous = current;
				current = current.getLeft();
			}

			return previous;
		}
	}

	public TreeNode getMaximum(TreeNode node) {

		if (node == null)
			return null;

		else {
			TreeNode current = node;
			TreeNode previous = null;
			while (current != null) {
				previous = current;
				current = current.getRight();
			}

			return previous;
		}
	}

	public void recursiveInorderWalk(TreeNode node) {

		if (node.getLeft() != null)
			recursiveInorderWalk(node.getLeft());
		System.out.print(node.getValue() + ",");
		if (node.getRight() != null)
			recursiveInorderWalk(node.getRight());

	}

	public void recursivePreorderWalk(TreeNode node) {

		System.out.println(node.getValue());
		if (node.getLeft() != null)
			recursiveInorderWalk(node.getLeft());
		if (node.getRight() != null)
			recursiveInorderWalk(node.getRight());

	}

	public void recursivePostorderWalk(TreeNode node) {

		if (node.getLeft() != null)
			recursivePostorderWalk(node.getLeft());
		if (node.getRight() != null)
			recursivePostorderWalk(node.getRight());
		System.out.print(node.getValue() + ",");

	}

	private LinkedList<ArrayList<TreeNode>> getListsOfNodes() {

		LinkedList<ArrayList<TreeNode>> listOfLists = new LinkedList<ArrayList<TreeNode>>();
		ArrayList<TreeNode> firstLevel = new ArrayList<TreeNode>();
		firstLevel.add(root);

		ArrayList<TreeNode> currentList = firstLevel;

		while (currentList.size() != 0) {

			listOfLists.add(currentList);

			ArrayList<TreeNode> levelList = new ArrayList<TreeNode>();

			for (TreeNode node : currentList) {
				if (node.getLeft() != null)
					levelList.add(node.getLeft());
				if (node.getRight() != null)
					levelList.add(node.getRight());

			}
			currentList = levelList;
		}

		return listOfLists;

	}

	public boolean isBst(TreeNode root) {

		if (root == null)
			return true;

		if (!isBst(root.getLeft()))
			return false;

		if (previousInBst != null
				&& root.getValue() <= previousInBst.getValue())
			return false;
		else
			previousInBst = root;

		return isBst(root.getRight());

	}

	public void iterativeInorderWalk(TreeNode node) {

		TreeNode current = node;
		Stack<TreeNode> treeStack = new Stack<TreeNode>();

		while (current != null || treeStack.size() != 0) {

			if (current != null) {
				treeStack.push(current);
				current = current.getLeft();
			} else {
				current = treeStack.pop();
				System.out.println(current.getValue());
				current = current.getRight();
			}

		}

	}

	public void iterativePreorderWalk(TreeNode node) {

		TreeNode current = node;
		Stack<TreeNode> treeStack = new Stack<TreeNode>();

		while (current != null || treeStack.size() != 0) {

			if (current != null) {
				System.out.println(current.getValue());
				treeStack.push(current);
				current = current.getLeft();
			} else {
				current = treeStack.pop();
				// System.out.println(current.getValue());
				current = current.getRight();
			}

		}

	}

	public TreeNode getLca(TreeNode node1, TreeNode node2) {
		TreeNode current = root;
		TreeNode lca = null;

		while (true) {

			if (current.getValue() > node1.getValue()
					&& current.getValue() > node2.getValue()) {
				current = lca;
				current = current.getRight();
			} else if (current.getValue() < node1.getValue()
					&& current.getValue() < node2.getValue()) {
				current = lca;
				current = current.getRight();
			} else {
				lca = current;
				break;
			}

		}

		return lca;
	}

	public TreeNode getSuccessor(TreeNode node) {

		TreeNode current = root;
		TreeNode successor = null;

		while (current != null) {

			if (current.getValue() < node.getValue()) {
				current = current.getRight();
			} else if (current.getValue() > node.getValue()) {
				successor = current;
				current = current.getLeft();
			} else {

				if (current.getRight() != null)
					return getMinimum(current.getRight());
				else
					return successor;
			}

		}

		return null;

	}

	public TreeNode getPredecessor(int key) {

		TreeNode current = root;
		TreeNode predecessor = null;

		while (current != null) {

			if (current.getValue() < key) {
				if (predecessor == null)
					predecessor = current;
				else if (predecessor.getValue() < current.getValue())
					predecessor = current;
				current = current.getRight();
			} else if (current.getValue() > key) {

				current = current.getLeft();
			} else {
				if (current.getLeft() != null)
					return getMaximum(current.getLeft());
				else if (predecessor != null)
					return predecessor;
				else
					return null;
			}

		}

		return null;

	}

	public boolean recIsSymmetric(TreeNode left, TreeNode right) {

		if (left == null && right == null)
			return true;
		else if (left != null && right != null)
			return (left.getValue() == right.getValue())
					&& recIsSymmetric(left.getRight(), right.getLeft())
					&& recIsSymmetric(left.getLeft(), right.getRight());
		else
			return false;

	}

	public static void main(String args[]) {

		int[] values = { 15, 6, 18, 17, 20, 3, 7, 2, 4, 13, 9 };

		int[] a = { 6, 7, 8, 1, 2, 3, 9, 10 };

		// getMaxSeqProduct(a);

		// System.exit(0);
		BinarySearchTree bst = new BinarySearchTree();
		for (int value : values) {
			bst.insert(value);

		}
		// bst.iterativePreorderWalk1(bst.root);

		//bst.recursiveInorderWalk(bst.root);
		System.out.println();
		//bst.recursivePostorderWalk(bst.root);
		// for (int i:l)
		// System.out.println(i);

		// BalanceOfTree balTree=new BalanceOfTree();
		// System.out.println(balTree.isBalanced(bst.root));

		// TreeNode succ=bst.getPredIterative(new TreeNode(null,null,9));
		/*
		 * if (succ!=null) System.out.println(succ.getValue()); else
		 * System.out.println(succ);
		 */

		// System.out.println(bst.root.getRight().getValue());
		// Search
		// System.out.println(bst.search(99));

		// Recursive Inorder walk
		// bst.recursiveInorderWalk(bst.root);

		// Iterative Inorder walk
		// bst.iterativeInorderWalk(bst.root);

		// Iterative Preorder walk
		// bst.iterativePreorderWalk(bst.root);

		// Get Successor
		// TreeNode succ=bst.getSuccessor(new TreeNode(null, null, 4));
		// System.out.println(succ.getValue());

		SerializeBST serializer = new SerializeBST();
		List<Integer> serializedBst = serializer.serialize1(bst.root,
				new LinkedList<Integer>());

		for (Integer nodeValue : serializedBst) {
			if (nodeValue != null)
				System.out.print(nodeValue + " ");
			else
				System.out.print("# ");
		}
		System.out.println();
		TreeNode rootNew = serializer.deserialize1((LinkedList) serializedBst,
				serializedBst.iterator());

		// BinarySearchTree1 deserializedBst = serializer
		// .deserialize(serializedBst);

		// PathSums ps=new PathSums();
		// ps.calPathSum(bst.root, 0);

		// TreeNode pred=bst.getPredecessor(20);
		// System.out.println(pred.getValue());

	}

	public static int getMaxSeqProduct(int[] a) {

		int[] lgl = new int[a.length];
		int[] lgr = new int[a.length];

		BinarySearchTree bst = new BinarySearchTree();
		for (int i = 0; i < a.length; i++) {
			bst.insert(a[i]);
			TreeNode pred = bst.getPredecessor(a[i]);
			if (pred == null)
				lgl[i] = 0;
			else
				lgl[i] = pred.getValue();

		}

		BinarySearchTree bst_r = new BinarySearchTree();
		for (int i = a.length - 1; i >= 0; i--) {
			bst_r.insert(a[i]);
			TreeNode pred = bst_r.getSuccessor(new TreeNode(null, null, a[i]));
			if (pred == null)
				lgr[i] = 0;
			else
				lgr[i] = pred.getValue();

		}

		int maxProduct = 0;
		int maxProductSoFar = 0;

		for (int i = 0; i < a.length; i++) {
			maxProductSoFar = lgl[i] * a[i] * lgr[i];
			if (maxProduct < maxProductSoFar)
				maxProduct = maxProductSoFar;

		}

		System.out.println(maxProduct);
		return 0;
	}

	public TreeNode getMinimumRecursive(TreeNode node) {

		if (node.getLeft() == null)
			return node;

		else
			return getMinimumRecursive(node.getLeft());

	}

	public TreeNode getMaximumRecursive(TreeNode node) {

		if (node.getLeft() == null)
			return node;

		else
			return getMaximumRecursive(node.getRight());

	}

	public TreeNode getSuccIterative(TreeNode node) {
		TreeNode current = root;
		TreeNode lastLeftAt = null;

		while (current != null) {
			if (current.getValue() < node.getValue()) {
				current = current.getRight();
			} else if (current.getValue() > node.getValue()) {
				lastLeftAt = current;
				current = current.getLeft();
			} else
				break;
		}

		if (current != null && current.getRight() != null)
			return getMinimum(current.getRight());
		else if (current != null)
			return lastLeftAt;

		return null;
	}

	public TreeNode getPredIterative(TreeNode node) {

		int key = node.getValue();
		TreeNode current = root;
		TreeNode predecessor = null;

		while (current != null) {

			if (current.getValue() < key) {
				predecessor = current;
				current = current.getRight();
			} else if (current.getValue() > key) {

				current = current.getLeft();
			} else {
				if (current.getLeft() != null)
					return getMaximum(current.getLeft());
				else if (predecessor != null)
					return predecessor;
				else
					return null;
			}

		}

		return null;

	}

	public void iterativeInorderWalk1(TreeNode node) {
		TreeNode current = node;
		Stack<TreeNode> stack = new Stack<TreeNode>();

		while (stack.size() != 0 || current != null) {
			if (current != null) {
				stack.push(current);
				current = current.getLeft();
			} else {

				current = stack.pop();
				System.out.println(current.getValue());
				current = current.getRight();

			}

		}

	}

	public void iterativePreorderWalk1(TreeNode node) {
		TreeNode current = node;
		Stack<TreeNode> stack = new Stack<TreeNode>();

		while (stack.size() != 0 || current != null) {
			if (current != null) {
				System.out.println(current.getValue());
				stack.push(current);
				current = current.getLeft();

			} else {
				current = stack.pop();
				current = current.getRight();
			}

		}

	}
	
	
	
	
	
	
	public void iterativeInorderWalk2(TreeNode node) {
		
		TreeNode current=node;
		
		Stack<TreeNode> stack=new Stack<TreeNode>();
		
		while(current!=null || !stack.isEmpty())
		{
			if(current!=null)
			{
				stack.push(current);
				current=current.getLeft();
			}
			else 
			{
				current=stack.pop();
				System.out.println(current.getValue());
				current=current.getRight();
				
			}
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
