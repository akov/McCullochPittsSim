package lib;

import java.util.Observable;
import java.util.Observer;

//the connection class defines the connection between a boolean wrapper
//and the neuron its connected to , it observes the source 
//and alerts the destination when there's a change 
public class Connection extends Observable implements Observer {
	private boolean _inhibit;
	BooleanWrapper _source;
	
	
	public static void connect(InputBoolean source, Neuron dest)
	{
		//if the method is called without an inhibit value we assume false
		new Connection(source, dest, false);
		
	}
	public static void connect(InputBoolean source, Neuron dest, boolean inhibit)
	{
		new Connection(source, dest, inhibit);
	}
	
	public static void connect(Neuron source, Neuron dest)
	{
		//if the method is called without an inhibit value we assume false
		new Connection(source, dest, false);
		
	}
	public static void connect(Neuron source, Neuron dest, boolean inhibit)
	{
		new Connection(source, dest, inhibit);
	}
	
	//we don't want client code to directly construct this guy because the client
	//doesn't have any business having a reference to this class
	private Connection(InputBoolean source, Neuron dest, Boolean inhibit)
	{
		source.addObserver(this);
		this.addObserver(dest);
		_source = source;
		_inhibit = inhibit;
	}
	
	private Connection(Neuron source, Neuron dest, Boolean inhibit)
	{
		source.addObserver(this);
		this.addObserver(dest);
		_source = source;
		_inhibit = inhibit;
	}
	
	public boolean isInhibitory()
	{
		return _inhibit;
	}
	
	public boolean sourceValue()
	{
		return _source.getValue();
	}
	
	public void update(Observable o, Object arg) 
	{
		setChanged();
		notifyObservers();
		clearChanged();
	}
	
}
