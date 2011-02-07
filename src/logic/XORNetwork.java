package logic;

import lib.*;

public class XORNetwork extends Network {

	public XORNetwork() 
	{
		super(2, 1);
		
		//set up an OR neuron
		
		Neuron xorNeuron = new ORNeuron();
		
		Connection.connect(getInput(0), xorNeuron);
		Connection.connect(getInput(1), xorNeuron);
		Connection.connect(xorNeuron, getOutput(0));
		
		//then inhibit it with an AND neuron 
		Neuron andNeuron = new ANDNeuron();
		
		Connection.connect(getInput(0), andNeuron);
		Connection.connect(getInput(1), andNeuron);
		Connection.connect(andNeuron, xorNeuron, true);
	}
	
	
	public static void main(String[] args)
	{
		InputBoolean a = new InputBoolean();
		InputBoolean b = new InputBoolean();
	
		XORNetwork orNet = new XORNetwork();
		
		Connection.connect(a, orNet.getInput(0));
		Connection.connect(b, orNet.getInput(1));
		
		System.out.println("XORNetwork output with 0/2 inputs on: " 
				+ orNet.getOutput(0).getValue());
		a.flipValue();
		
		System.out.println("XORNetwork output with 1/2 inputs on: " 
				+ orNet.getOutput(0).getValue());
		
		a.flipValue();
		b.flipValue();
		
		System.out.println("XORNetwork output with 1/2 inputs (other input) on: " 
				+ orNet.getOutput(0).getValue());
		
		a.flipValue();
		System.out.println("XORNetwork output with 2/2 inputs on: " 
				+ orNet.getOutput(0).getValue()); 
	}

}
