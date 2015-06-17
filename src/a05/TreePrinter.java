package a05;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Iterator;

import javax.swing.tree.TreeNode;

import schimkat.berlin.lernhilfe2015ss.tree.QadTree;
import schimkat.berlin.lernhilfe2015ss.tree.QadTreeWalker;
import a04.TreeFactory;

public class TreePrinter {
	public static void main(String[] args){
		PrintWriter out = new PrintWriter(System.out,true);
		QadTree tree = TreeFactory.createTree("./lib/lib-tree/tree-02.txt");
//		tree.showInGUI();
//		Iterator<TreeNode> preOrder = QadTreeWalker.preorderIterator(tree);
//		out.println();
//		printTree(preOrder, out);
//		out.println();
//		Iterator<TreeNode> inOrder = QadTreeWalker.inorderIterator(tree);
//		printTree(inOrder,out);
//		printTree(inOrder, out, 15,true);
//		out.println();
		Iterator<TreeNode> postOrder = QadTreeWalker.postorderIterator(tree);
		out.println();
		printTree(postOrder, out);
		printTree(tree, out, 15);
		out.println();
		QadTree ioTest = TreeFactory.createTree("./lib/lib-tree/tree-02.txt");
		writeTreeBinary(ioTest, "./Test/a05/treeWriteTest");
		QadTree ioTree = readTreeBinary("./Test/a05/treeWriteTest");
		ioTree.showInGUI();
		printTree(ioTree, out, 15);
	}
	public static void printTree(Iterator<TreeNode> iterator, PrintWriter out){
		while(iterator.hasNext()){
			out.println(iterator.next());
		}
	}
	public static void printTree(Iterator<TreeNode> iterator, PrintWriter out,int width, boolean skipLeafs){
		while(iterator.hasNext()){
			TreeNode node = iterator.next();
			if(skipLeafs && node.isLeaf()){
				continue;
			}
			out.printf("%-"+width+"s ",node);
		}
	}
	public static void printTree(QadTree tree, PrintWriter out, int width){
		Iterator<TreeNode> preOrder = QadTreeWalker.preorderIterator(tree);
		out.println();
		out.println();
		while(preOrder.hasNext()){
			TreeNode node = preOrder.next();
			if(node.getParent()==null){
				out.println(node);
			}
			if(node.getChildCount()!=0){
				out.printf("%-"+width+"s ", node);
				for(int i = 0;i<=node.getChildCount()-1;i++){
					out.printf("%-"+width+"s ",node.getChildAt(i));
				}
				out.println();
			}
		}
	}
	public static void writeTreeBinary(QadTree tree, String path){
		try{
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
			oos.writeObject(tree);
			oos.close();
		}catch(IOException e){
			System.err.println("File:"+path+" not found!" );
		}
	}
	public static QadTree readTreeBinary(String path){
		QadTree tree = null;
		try {
			ObjectInputStream ois =new ObjectInputStream(new FileInputStream(path));
			tree = (QadTree) ois.readObject();
			ois.close();
			return tree;
		} catch (FileNotFoundException e) {
			System.err.println("File:"+path+" not found!");
		} catch (IOException e) {
			System.err.println("IO exception!");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.err.println("QadTree not found!");
			e.printStackTrace();
		}
		return tree;
	}
}