package a06;

import schimkat.berlin.lernhilfe2015ss.DIRTY.graphics.DirtyPainter;

public class Controller {
	protected DirtyPainter painter;
	protected WeatherStateModel model;
	
	public Controller(DirtyPainter painter , WeatherStateModel model){
		this.painter = painter;
		this.model = model;
	}
	
	public void changeWeather(String weather){
		switch(weather){
		case Wetterzustand.SONNIG:
			model.changeToSonnig();
			break;
		case Wetterzustand.BEDECKT:
			model.changeToBedeckt();
			break;
		case Wetterzustand.WOLKIG:
			model.changeToWolkig();
			break;
		case Wetterzustand.REGEN:
			model.changeToRegen();
			break;
		case Wetterzustand.GEWITTER:
			model.changeToGewitter();
			break;	
		}
		painter.showDrawing();
	}
}
