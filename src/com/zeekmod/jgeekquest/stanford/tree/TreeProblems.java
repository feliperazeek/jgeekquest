package com.zeekmod.jgeekquest.stanford.tree;

public class TreeProblems {

	public BinaryTree testTree() {
		BinaryTree t = new BinaryTree();
		t.insert(5);
		t.insert(3);
		t.insert(9);
		t.insert(1);
		t.insert(4);
		t.insert(6);
		return t;
	}

	public BinaryTree build(int[] nos) {
		BinaryTree t = new BinaryTree();
		for (int i : nos) {
			t.insert(i);
		}
		return t;
	}

	private void check(int a, int b) {
		if (a != b) {
			throw new RuntimeException(a + " != " + b);
		} else {
			System.out.println("Good! " + a + " = " + b);
		}
	}

	private void check(boolean a, boolean b) {
		if (a != b) {
			throw new RuntimeException(a + " != " + b);
		}
	}

	private void testSize() {
		BinaryTree t = testTree();
		this.check(6, t.size());
	}

	private void testMaxDepth() {
		this.check(3, this.testTree().getMaxDepth());
	}

	private void testMinValue() {
		this.check(1, this.testTree().getMinValue());

		int[] a = { 0, 4, 5, 6, 8 };
		this.check(0, this.build(a).getMinValue());

		int[] a1 = { 4, 5, 6, 8, -50 };
		this.check(-50, this.build(a1).getMinValue());
	}

	private void testMaxValue() {
		this.check(9, this.testTree().getMaxValue());

		int[] a1 = { 4, 5, 6, 8, -50, 1000 };
		this.check(1000, this.build(a1).getMaxValue());
	}

	private void testPrintTree() {
		this.breadLine();
		int[] nos = { 4, 2, 5, 1, 3 };
		this.log("Print Tree");
		this.build(nos).printTree();
	}

	private void testPrintPostOrder() {
		this.breadLine();
		int[] nos = { 4, 2, 5, 1, 3 };
		this.log("Post Order");
		this.build(nos).printPostOrder();
		this.breadLine();
	}

	private void log(Object o) {
		System.out.println(o);
	}

	private void breadLine() {
		System.out.println("");
	}

	private void testHasPathSum() {
		int[] nos = { 5, 3, 4, 8, 11, 7, 2, 13, 1 };
		this.check(false, this.build(nos).hasPathSum(5, 10));
		this.check(true, this.build(nos).hasPathSum(5, 12));
		this.check(true, this.build(nos).hasPathSum(5, 20));
		this.check(true, this.build(nos).hasPathSum(5, 11));
		this.check(true, this.build(nos).hasPathSum(5, 37));
		this.check(false, this.build(nos).hasPathSum(5, 8));
		this.check(false, this.build(nos).hasPathSum(5, 18));
	}

	private void testMirror() {
		BinaryTree t1 = null;
		int[] nos = { 4, 2, 1, 5, 3 };
		t1 = this.build(nos);
		System.out.println("------------------------------");
		System.out.println("Mirror Print Tree T1");
		t1.printPathLevels();
		System.out.println("Mirror Print Tree T2");
		t1.mirror();
		t1.printPathLevels();
		System.out.println("------------------------------");
	}

	private void testPrintPaths() {
		System.out.println("------------------------------");
		System.out.println("Print Paths");
		int[] nos = { 5, 3, 4, 8, 11, 7, 2, 13, 1 };
		this.build(nos).printPaths();
		System.out.println("------------------------------");
	}

	private void testDoubleTree() {
		int[] nos = { 2, 1, 3 };
		BinaryTree t1 = null;
		t1 = this.build(nos);
		System.out.println("------------------------------");
		System.out.println("Double Print Tree T1");
		t1.printPathLevels();
		int i1 = t1.size();
		System.out.println("Double Print Tree T2");
		t1.doubleTree();
		t1.printPathLevels();
		int i2 = t1.size();
		this.check(i1*2, i2);
		System.out.println("------------------------------");
	}
	
	private void testSameTree() {
		int[] nos = { 5, 3, 4, 8, 11, 7, 2, 13, 1 };
		BinaryTree t1 = this.build(nos);
		BinaryTree t2 = this.build(nos);
		if ( t1.sameTree(t2) == false ) {
			throw new RuntimeException( t1 + " != " + t2 );
		}
		int[] nos2 = { 5, 3, 4, 8, 11, 7, 2, 13, 2 };
		
		t2 = this.build(nos2);
		if ( t1.sameTree(t2) == true ) {
			throw new RuntimeException( t1 + " != " + t2 );
		}
	}
	
	private void testCount() {
		this.check(14, new BinaryTree().countTrees(4));
	}
	
	private void testIsBST() {
		int[] n1 = { 5, 3, 4, 8, 11, 7, 2, 13, 1 };
		BinaryTree t1 = this.build(n1);
		if ( t1.isBST() == false ) {
			throw new RuntimeException( t1.toString() );
		}
		
		int[] n2 = { 5, 3 };
		BinaryTree t2 = this.build(n2);
		if ( t2.isBST() == false ) {
			throw new RuntimeException( t2.toString() );
		}
		
		BinaryTree t3 = BinaryTree.buildInvalidBST();
		if ( t3.isBST() == true ) {
			throw new RuntimeException( t3.toString() );
		}
	}

	private void testSuite() {
		// Problem 2
		this.testSize();

		// Problem 3
		this.testMaxDepth();

		// Problem 4
		this.testMinValue();
		this.testMaxValue();

		// Problem 5
		this.testPrintTree();

		// Problem 6
		this.testPrintPostOrder();

		// Problem 7
		this.testHasPathSum();

		// Problem 8
		this.testPrintPaths();

		// Problem 9: Mirror
		this.testMirror();

		// Problem 10: Double
		this.testDoubleTree();
		
		// Problem 11: Same Tree
		this.testSameTree();

		// Problem 12: Count Trees
		this.testCount();
		
		// Problem 13: isBST
		this.testIsBST();
	}

	public static void main(String[] args) {
		TreeProblems t = new TreeProblems();
		t.testSuite();
	}

}
