package tree;
import java.util.HashMap;
import tree.BinaryTreeHeight.Node;

public class BuildTreePreorderInorder {
	static class Node{
		int data;
		Node left;
		Node right;
		Node(int data){
		this.data=data;
		}
	}
	static int preorderIndex=0;
	static HashMap<Integer, Integer> inorderMap=new HashMap<>();
	static Node buildTree(int[] preorder, int left, int right) {
		//No elements
		if(left>right) {
			return null;
		}
		//preorder gives root
		int rootValue=preorder[preorderIndex++];
		Node root=new Node(rootValue);
		//find root position in inorder
		int  rootIndex=inorderMap.get(rootValue);
		//construct left subtree
		root.left=buildTree(preorder,left,rootIndex-1);
		//construct right subtree
		root.right=buildTree(preorder,rootIndex+1,right);
		return root;
	}
	static void inorder(Node root) {
		if(root==null) {
			return;
		}
		inorder(root.left);
		System.out.print(root.data+" ");
		inorder(root.right);
	}
	static void preorder(Node root) {
		if(root==null) {
			return;
		}
		System.out.print(root.data+" ");
		preorder(root.left);
		preorder(root.right);
	}static void postorder(Node root) {
		if(root==null) {
			return;
		}
		postorder(root.left);
		
		postorder(root.right);
		System.out.print(root.data+" ");
	}
	public static void main(String[] args) {
		int[] preorder= {50,30,20,40,70,60,80};
		int[] inorder= {20,30,40,50,60,70,80};
		//store inorder positions
		for(int i=0;i<inorder.length;i++) {
			inorderMap.put(inorder[i],i);
		}
		Node root=buildTree(preorder,0,inorder.length-1);
		System.out.println("Inorder");
		inorder(root);
		System.out.println();
		System.out.println("preorder");
		preorder(root);
		System.out.println();
		System.out.println("postorder");
		postorder(root);
	}
}
		
		
		
		
	
		
