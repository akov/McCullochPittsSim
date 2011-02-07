package lib;

//the network class defines a network and gives access to
//the input and output neurons, this allows client code to 
//encapsulate certain structures 
public class Network {
	private BufferNeuron[] _inputs;
	private BufferNeuron[] _outputs;
	
	public Network(int numIn, int numOut)
	{
		_inputs = new BufferNeuron[numIn];
		_outputs = new BufferNeuron[numOut];
		for(int i = 0; i < numIn; i++)
		{
			_inputs[i] = new BufferNeuron();
		}
		for(int i = 0; i < numOut; i++)
		{
			_outputs[i] = new BufferNeuron();
		}
	}
	
	public BufferNeuron getInput(int n)
	{
		return _inputs[n];
	}
	
	public BufferNeuron getOutput(int n)
	{
		return _outputs[n];
	}
}
