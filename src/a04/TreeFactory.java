
package a04;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import schimkat.berlin.lernhilfe2015ss.tree.QadTree;

public class TreeFactory {
	public static void main(String[] args){
		buildTree().showInGUI();
		String testTree = "./Test/a04/test_tree";
		createTree(testTree).showInGUI();
		String pflanzenTree = "./Test/a04/pflanzen";
		createTree(pflanzenTree).showInGUI();
	}
	
	public static QadTree buildTree(){
		QadTree tree = new QadTree("a");
		tree.addChild("a", "b");
		tree.addChild("b", "b1");
		tree.addChild("a", "c");
		tree.addChild("a", "d");
		tree.addChild("c", "c1");
		tree.addChild("d", "d1");
		tree.addChild("d", "d2");
		tree.addChild("d2", "d21");
		return tree;
	}
	
	public static QadTree createTree(String path){
		String[] lines = readLines(path);
		QadTree tree = createTree(lines);
		return tree;
	}
	
	private static QadTree createTree(String[] lines) {
		QadTree tree = new QadTree(lines[0]);
		String parent="";
		String child="";
		for(int i = 1;i<lines.length;i++){
			Scanner in = new Scanner(lines[i]);
			parent=in.next();
			while(in.hasNext()){
				child=in.next();
				try{
					tree.addChild(parent, child);
				}catch(IllegalArgumentException e){
					System.err.println("Cant add child:"+child+" to parent:"+parent+" that not exist!");
				}
			}
			in.close();
		}
		return tree;
	}

	private static String[] readLines(String path) {
		Scanner in = null;
		try{
			in = new Scanner(openFile(path));
			System.out.println("Einlesen erfolgreich!");
		}catch(FileNotFoundException e){
			System.err.println("file:"+path+" not found!");
			return null;
		}
		ArrayList<String> test = new ArrayList<String>();
		String inputLine = "";
		while(in.hasNextLine()){
			inputLine = in.nextLine();
			if(inputLine.equals("")){
				continue;
			}else{
				test.add(inputLine);
			}
		}
		in.close();
		String[] lines = new String[test.size()];
		int i =0;
		for(String line: test){
				lines[i]=line;
				i++;
			}
			return lines;
		}		

	private static FileReader openFile(String path) throws FileNotFoundException {
		return new FileReader(path);
	}
}
