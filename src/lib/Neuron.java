package lib;

import java.util.Observable;
import java.util.Observer;

public class Neuron extends Observable implements Observer, BooleanWrapper{

	private int _threshold; //threshold number of inputs to trigger this neuron
	private int _curValue; //current number of active inputs
	private boolean _inhibited;

	public Neuron(int threshold)
	{
		_threshold = threshold;
	}
	
	public Boolean getValue()
	{
		if(_inhibited)
			return false;
		else 
			return (_curValue >= _threshold);
	}

	//update is called automatically when an upstream neuron
	//has changed state. the update itself is trigged from
	//either a Connection or an InputBoolean 
	public void update(Observable o, Object arg) 
	{
		boolean previousOut = getValue();
		//use the class Boolean rather than primitive 
		//so we can use null to check if there was a mistake
		//in this update being called later on
		Boolean newOut = null;  
		Boolean inputVal = null;
		
		//the update comes from either an observable boolean
		//or another Neuron so figure out which one

		if (o instanceof InputBoolean)
			inputVal = ((InputBoolean)o).getValue();
		else if (o instanceof Connection)
		{
			Connection c = (Connection)o;
			if(c.isInhibitory() && c.sourceValue())
			{
				//this neuron is being inhibited
				//but we should only act if we were
				//not inhibited before 
				if(_inhibited != true)
				{
					_inhibited = true;
					setChanged();
					notifyObservers();
					clearChanged();
					return;
				}
			}
			else 
				inputVal = ((Connection)o).sourceValue();
		}
		if(inputVal != null)
		{
			if(inputVal)
				_curValue++;
			else
				_curValue--;
		}
		
		//alert downstream neurons and other observers
		//that they need to update themselves 
		if(getValue() != previousOut)
		{
			setChanged();
			notifyObservers();
			clearChanged();
		}
	}
	
}
