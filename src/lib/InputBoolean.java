package lib;

import java.util.Observable;

public class InputBoolean extends Observable implements BooleanWrapper {
	private Boolean val;
	
	public InputBoolean()
	{
		val = false;
	}
	public Boolean getValue()
	{
		return val;
	}
	
	public void flipValue()
	{
		val = !val;
		setChanged();
		notifyObservers();
		clearChanged(); //this will alert the neuron that is using this as an input value
	}
}
