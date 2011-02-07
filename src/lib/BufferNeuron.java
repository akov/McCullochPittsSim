package lib;

//IOBoolean is a class that holds a boolean and can be 
//both an observer and observed by other objects
public class BufferNeuron extends Neuron {

	//it is a Neuron with a threshold of 1
	//because that provides all we need
	//it just feeds the value connected to it forward
	public BufferNeuron() 
	{
		super(1);
	}

}
