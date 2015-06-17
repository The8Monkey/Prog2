package a06;

import javafx.event.EventHandler;
import schimkat.berlin.lernhilfe2015ss.DIRTY.weathersimulationFX.ActionWACEvent;

public class WetterPrinter implements EventHandler<ActionWACEvent>{
	protected long time;
	public void handle(ActionWACEvent e) {
		if(time==0){
			time = System.currentTimeMillis();
		}
		System.out.printf("Wetternachricht um"+"%7d"+"[ms]:"+"%15s%n",System.currentTimeMillis()-time,e.getActionCommand());
	}
}
