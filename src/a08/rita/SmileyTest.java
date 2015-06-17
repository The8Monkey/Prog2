package a08.rita;

import schimkat.berlin.lernhilfe2015ss.DIRTY.graphics.DirtyPainter;

public class SmileyTest{

	public static void main(String[] args){
		DirtyPainter dp = new DirtyPainter();
		SmileyModel m = new SmileyModel(100,100,100,40,90.1,false);
		SmileyView s = new SmileyView(m);
		dp.add(s);
		dp.showDrawing();

		m.setX(200);
		m.setY(200);
		dp.showDrawingAfterWaiting(0);

		while (true) {
			m.wachse();
			dp.showDrawingAfterWaiting(0);
		}
//		while(true){
//			m.drehen();
//			dp.showDrawingAfterWaiting(0);
//			if(m.ausrichtung < 360){
//				m.setSmile(true);
//			}
//			if(m.ausrichtung > 360){
//				m.setSmile(false);
//			}
//		}
	}
}

