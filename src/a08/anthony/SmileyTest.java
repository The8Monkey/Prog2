package a08.anthony;

import schimkat.berlin.lernhilfe2015ss.DIRTY.graphics.DirtyPainter;

public class SmileyTest{
    public static void main(String [] args){
        DirtyPainter dp = new DirtyPainter();

        SmileyModel model = new SmileyModel();
        SmileyView 	view = new SmileyView(model);
        dp.add(view);
        int j = 10;
        for(int i = 0; i < 20; i++){
            dp.showDrawingAfterWaiting(0);
            model.setX(j+=10);
        }
        //		model.setPupile(90);



        //		Smiley smile2 = new Smiley(800, 0, 100, 0, false, false);
        //		smile2.setPosition(0, 200);
        //		dp.add(smile2);



    }
}