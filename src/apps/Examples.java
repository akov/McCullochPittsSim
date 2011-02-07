package apps;

import lib.*;
import logic.*;

public class Examples {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//a simple majority neuron with 3 inputs 
		majorityTest();
		inhibitionTest();
		IOBooleanTest();
	}
	
	public static void majorityTest()
	{
		//initialize everything
		InputBoolean b1 = new InputBoolean();
		InputBoolean b2 = new InputBoolean();
		InputBoolean b3 = new InputBoolean();
		
		Neuron majority = new Neuron(2);
		
		OutputBoolean out = new OutputBoolean();
		
		//now connect everything
		Connection.connect(b1, majority);
		Connection.connect(b2, majority);
		Connection.connect(b3, majority);

		majority.addObserver(out);
		
		b1.flipValue();
		b2.flipValue();
		System.out.println("Majority neuron output with 2/3 inputs active: "
				+ out.getValue());
		b2.flipValue();
		System.out.println("Majority neuron output with 1/3 inputs active: "
				+ out.getValue());
		
	}
	
	public static void inhibitionTest()
	{
		//initialize everything
		InputBoolean b1 = new InputBoolean();
		InputBoolean b2 = new InputBoolean();
		InputBoolean b3 = new InputBoolean();
		InputBoolean inhibit = new InputBoolean();
		
		Neuron majority = new Neuron(2);
		OutputBoolean out = new OutputBoolean();

		//now connect everything
		Connection.connect(b1, majority);
		Connection.connect(b2, majority);
		Connection.connect(b3, majority);
		Connection.connect(inhibit, majority, true);
		majority.addObserver(out);
		
		b1.flipValue();
		b2.flipValue();
		
		System.out.println("Majority neuron output with 2/3 inputs active and inhibition inactive: "
				+ out.getValue());
		
		inhibit.flipValue();
		
		System.out.println("Majority neuron output with 2/3 inputs active and inhibition active: "
				+ out.getValue());
		
		b2.flipValue();
		
		System.out.println("Majority neuron output with 1/3 inputs active and inhibition active: "
				+ out.getValue());
	}
	
	public static void IOBooleanTest()
	{
		BufferNeuron n = new BufferNeuron();
		InputBoolean input = new InputBoolean();
		
		Connection.connect(input, n);
		System.out.println("BufferNeuron with false input: " + n.getValue());
		input.flipValue();
		System.out.println("BufferNeuron with true input: " + n.getValue());
		
	}

}
