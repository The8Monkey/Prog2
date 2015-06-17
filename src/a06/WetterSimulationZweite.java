package a06;

import javafx.event.EventHandler;
import schimkat.berlin.lernhilfe2015ss.DIRTY.weathersimulationFX.ActionWACEvent;
import schimkat.berlin.lernhilfe2015ss.DIRTY.weathersimulationFX.WeatherSensor;

public class WetterSimulationZweite {

	public static void main(String[] args) {
		WeatherSensor sonnig = new WeatherSensor(Wetterzustand.SONNIG, 5000, 0);
		WeatherSensor bedeckt = new WeatherSensor(Wetterzustand.BEDECKT, 5000, 1000);
		WeatherSensor wolkig = new WeatherSensor(Wetterzustand.WOLKIG, 5000, 2000);
		WeatherSensor regen = new WeatherSensor(Wetterzustand.REGEN, 5000, 3000);
		WeatherSensor gewitter = new WeatherSensor(Wetterzustand.GEWITTER, 5000, 4000);
		
		EventHandler<ActionWACEvent> wetterPrinter =new WetterPrinter();
		EventHandler<ActionWACEvent> wetterDraw =new WetterstationEinfach();
		
		sonnig.addEventHandler(wetterPrinter);
		bedeckt.addEventHandler(wetterPrinter);
		wolkig.addEventHandler(wetterPrinter);
		regen.addEventHandler(wetterPrinter);
		gewitter.addEventHandler(wetterPrinter);
		sonnig.addEventHandler(wetterDraw);
		bedeckt.addEventHandler(wetterDraw);
		wolkig.addEventHandler(wetterDraw);
		regen.addEventHandler(wetterDraw);
		gewitter.addEventHandler(wetterDraw);
		sonnig.start();
		bedeckt.start();
		wolkig.start();
		regen.start();
		gewitter.start();
	}
}
