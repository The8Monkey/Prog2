package a06;

import schimkat.berlin.lernhilfe2015ss.DIRTY.graphics.DirtyPainter;
import schimkat.berlin.lernhilfe2015ss.DIRTY.weathersimulationFX.ActionWACEvent;
import schimkat.berlin.lernhilfe2015ss.DIRTY.weathersimulationFX.WeatherComponentDrawable;
import javafx.event.EventHandler;

public class WetterstationEinfach implements EventHandler<ActionWACEvent>{
	protected DirtyPainter dp;
	protected WeatherComponentDrawable drawable;
	protected WeatherStateModel model;
	protected Controller controller;
	public void handle(ActionWACEvent e) {
		if(dp == null){
			dp = new DirtyPainter();
			drawable = new WeatherComponentDrawable();
			model = new WeatherStateModel(drawable);
			controller = new Controller(dp, model);
			dp.add(drawable);
		}
		controller.changeWeather(e.getActionCommand());
	}	
}