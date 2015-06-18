package a08;


public class SmileyTest {

	public static void main(String[] args) {
		int radius=500;
		SmileyModel test = new SmileyModel(radius, true);
		SmileyView view = new SmileyView(test);
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
		}
	}

}
