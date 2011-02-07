package lib;

import java.util.Observable;
import java.util.Observer;

public class OutputBoolean implements Observer, BooleanWrapper {
	Boolean _value;
	public OutputBoolean()
	{
		_value = false;
	}
	public void update(Observable o, Object arg) {
		
		//the update request should come from a neuron 
		//ignore all others 
		if(o instanceof Neuron)
			setValue(((Neuron)o).getValue());
		
	}

	public Boolean getValue() {
		return _value;
	}

	private void setValue(Boolean b) {
		_value = b;
	}

}
