package apps;

import lib.*;
import logic.*;

//OneBitAdder takes in two bits and produces the two bits
//representing the sum of the input bits 
public class OneBitAdder extends Network {
	public OneBitAdder() {
		super(2, 2);
		
		//the least significant digit is given by a XOR of the inputs
		XORNetwork xorNet = new XORNetwork();
		Connection.connect(getInput(0), xorNet.getInput(0));
		Connection.connect(getInput(1), xorNet.getInput(1));
		
		//the most significant bit is the AND of the inputs
		ANDNeuron andNeuron = new ANDNeuron();
		Connection.connect(getInput(0), andNeuron);
		Connection.connect(getInput(1), andNeuron);
		
		Connection.connect(xorNet.getOutput(0),getOutput(1));
		Connection.connect(andNeuron, getOutput(0)); 
	}
	
	public static void main(String[] args)
	{
		OneBitAdder adder = new OneBitAdder();
		InputBoolean bit1 = new InputBoolean();
		InputBoolean bit2 = new InputBoolean();
		
		Connection.connect(bit1, adder.getInput(0));
		Connection.connect(bit2, adder.getInput(1));
		
		System.out.println("Testing 1 bit adder: ");
		System.out.println("0 + 0 = " + adder.getOutput(0).getValue() 
				+ " " + adder.getOutput(1).getValue());
		bit1.flipValue();
		System.out.println("1 + 0 = " + adder.getOutput(0).getValue() 
				+ " " + adder.getOutput(1).getValue());
		
		bit1.flipValue();
		bit2.flipValue();
		
		System.out.println("0 + 1 = " + adder.getOutput(0).getValue() 
				+ " " + adder.getOutput(1).getValue());
		
		bit1.flipValue();
		System.out.println("1 + 1 = " + adder.getOutput(0).getValue() 
				+ " " + adder.getOutput(1).getValue());
	}

}
