package a03;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/*Auswertung eines Rechteckigen Labyrinthes.*/

public class Maze {

	public static void main(String[] args) {
		String path = "./Test/a03/testMaze";
		int[] mazeSize = getMazeSize(path);
		char[][] maze = new char[mazeSize[0]][mazeSize[1]];
		maze=getMaze(maze, path);
//		printMaze(maze);
		if(canExit(maze,0,0,mazeSize[0],mazeSize[1])==true){
			System.out.println("Can exit maze!");
		}
	}
	
	public static int[] getMazeSize(String path){
		Scanner in = new Scanner(openFile(path));
		int row=0;
		int column=0;
		int[] size=new int[2];
		if(in.hasNextLine()){
			column = in.nextLine().length();
			row++;
		}
		while(in.hasNextLine()){
			if(in.nextLine().length()!=column){
				System.err.println("Only rectangular maze!");
				in.close();
				return null;
			}
			row++;
		}
		in.close();
		size[0]=row;
		size[1]=column;
		return size;
	}
	
//	private static void printMaze(char[][] maze) {
//		for(int i = 0 ;i<=maze[0].length-1;i++){
//			for(int j = 0 ;j<=maze.length-1;j++){
//				System.out.print(maze[i][j]);
//			}
//			System.out.println();
//		}
//	}
	
	public static char[][] getMaze(char[][] maze, String path) {
		Scanner in = new Scanner(openFile(path));
		String line = null;
		while(in.hasNextLine()){
			for(int i = 0 ;i<=maze.length-1;i++){
				line=in.nextLine();
				for(int j = 0 ;j<=maze[0].length-1;j++){
					maze[i][j]=line.charAt(j);
				}
			}
		}
		System.out.println("Einlesen erfolgreich!");
		in.close();
		return maze;
	}
	
	private static FileReader openFile(String path) {
		FileReader fr=null;
		try{
			fr=new FileReader(path);
			return fr;
		}catch (FileNotFoundException e){
			System.err.println("File not found!");
			return null;
		}
	}
	
	public static boolean canExit(char[][] maze,int i, int j, int n, int m){
		if(i<0 || j<0 || i==n || j==m){
			return false;
		}
		if(maze[i][j]=='x'){
			return false;
		}
		maze[i][j]='x';
		if(i==n-1 && j==n-1
				||canExit(maze,i+1,j,n,m)
				||canExit(maze,i,j+1,n,m)
				||canExit(maze,i-1,j,n,m)
				||canExit(maze,i,j-1,n,m)){
			System.out.println("["+i+" "+j+"]");
			return true;
		}
		return false;
	}
}
