package a06;

import schimkat.berlin.lernhilfe2015ss.DIRTY.weathersimulationFX.WeatherComponentDrawable;

public class WeatherStateModel{
	protected WeatherComponentDrawable drawable;
	
	public WeatherStateModel(WeatherComponentDrawable drawable){
		this.drawable = drawable;
	}
	public void changeToSonnig(){
		drawable.setState(Wetterzustand.SONNIG);
	}
	public void changeToBedeckt(){
		drawable.setState(Wetterzustand.BEDECKT);
	}
	public void changeToWolkig(){
		drawable.setState(Wetterzustand.WOLKIG);
	}
	public void changeToRegen(){
		drawable.setState(Wetterzustand.REGEN);
	}
	public void changeToGewitter(){
		drawable.setState(Wetterzustand.GEWITTER);
	}
}
