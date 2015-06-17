package a06;

import javafx.event.EventHandler;
import schimkat.berlin.lernhilfe2015ss.DIRTY.weathersimulationFX.ActionWACEvent;
import schimkat.berlin.lernhilfe2015ss.DIRTY.weathersimulationFX.WeatherSensor;

public class WetterSimulationErste {
	public static void main(String[] args){
		WeatherSensor sonnig = new WeatherSensor(Wetterzustand.SONNIG, 2500, 0);
		WeatherSensor bedeckt = new WeatherSensor(Wetterzustand.BEDECKT, 2500, 500);
		WeatherSensor wolkig = new WeatherSensor(Wetterzustand.WOLKIG, 2500, 1000);
		WeatherSensor regen = new WeatherSensor(Wetterzustand.REGEN, 2500, 1500);
		WeatherSensor gewitter = new WeatherSensor(Wetterzustand.GEWITTER, 2500, 2000);
		
		EventHandler<ActionWACEvent> eh =new WetterPrinter();
		
		sonnig.addEventHandler(eh);
		bedeckt.addEventHandler(eh);
		wolkig.addEventHandler(eh);
		regen.addEventHandler(eh);
		gewitter.addEventHandler(eh);
		sonnig.start();
		bedeckt.start();
		wolkig.start();
		regen.start();
		gewitter.start();
	}
}
