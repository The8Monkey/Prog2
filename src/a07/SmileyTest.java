package a07;

import schimkat.berlin.lernhilfe2015ss.DIRTY.graphics.DirtyPainter;

public class SmileyTest {

	public static void main(String[] args) {
		DirtyPainter dp = new DirtyPainter();
		int radius=200;
		Smiley test = new Smiley(radius, true);
		dp.add(test);
		dp.showDrawing();
		int i=0;
		while(true){
			test.setEyeAngel(i);
			i++;
			if(i%90==0){
				if(test.smile){
					test.setSmile(false);
					continue;
				}
				test.setSmile(true);
				test.setRadius(radius+=20);
			}
			dp.showDrawingAfterWaiting(0);
		}
	}

}
