package a08;

import schimkat.berlin.lernhilfe2015ss.DIRTY.graphics.DirtyPainter;

public class SmileyTest {

	public static void main(String[] args) {
		DirtyPainter dp = new DirtyPainter();
		int radius=500;
		SmileyModel test = new SmileyModel(radius, true);
		SmileyView view = new SmileyView(test);
		dp.add(view);
		dp.showDrawing();
		int i=0;
		while(true){
			test.rotateEye(i);
			i+=10;
			if(i%90==0){
				if(test.smile){
					test.setSmile(false);
					continue;
				}
				test.setSmile(true);
				test.setSize(radius+=20);
			}
			dp.showDrawingAfterWaiting(0);
		}
	}

}
