package com.algorithm.graph.dfs;

// leetcode #1022, due to BaekJoon server maintenance issue
public class BinaryTreeDFS {

}

/*
 	You are given the root of a binary tree where each node has a value 0 or 1.  Each root-to-leaf path represents a binary number starting with the most significant bit.  For example, if the path is 0 -> 1 -> 1 -> 0 -> 1, then this could represent 01101 in binary, which is 13.

For all leaves in the tree, consider the numbers represented by the path from the root to that leaf.

Return the sum of these numbers. The answer is guaranteed to fit in a 32-bits integer.
 * */


class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode() {}
	TreeNode(int val) { this.val = val; }
	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

class Solution {

	int answer = 0;

	public int sumRootToLeaf(TreeNode root) {

		dfs(root, 0);
		return answer;
	}

	// val is coming from parent
	private void dfs(TreeNode node, int val) {

		// when you are coming along a path, recursive sum of 2*(val from parent) + (current node's val) becomes a complete binary number.
		// for instance, if a path indicates 101 in binary, recursive sum will be 1*2^2 + 0*2^1 + 1*2*^0.
		int value = val*2 + node.val;

		if (node.left == null && node.right == null) {
			answer += value;
		}
		if (node.left != null) {
			dfs(node.left, value);
		}
		if (node.right != null){
			dfs(node.right, value);
		}
	}
}