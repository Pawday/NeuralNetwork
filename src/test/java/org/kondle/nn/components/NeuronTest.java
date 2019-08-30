package org.kondle.nn.components;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.kondle.nn.functions.NeuralFunctions;

import static org.junit.Assert.*;


public class NeuronTest
{
	public static NeuralFunctions functions;
	public static Neuron n;
	static
	{
		functions = new NeuralFunctions()
		{
			@Override
			public double activationFunction(double val)
			{
				//standard sigmoid function
//				return 1 / (1 + (1 / Math.pow(Math.E,val)));

				return val + 1;
			}
			@Override
			public double derivativeFunction(double val)
			{
				return val;
			}
		};
	}

	@Test
	public void testChangeOffset()
	{
		for (int i = -1000000; i < 1000000; i++)
		{
			n = new Neuron(i,functions);
			double min = -10000000;
			double max = 10000000;
			double offset = randomRange(min,max);
			n.changeOffset(offset);
			assertEquals(i + offset, n.getOffset(),0);
		}
	}

	private static double randomRange(double min, double max)
	{
		return Math.random() * (max - min) + min;
	}

	@Test
	public void testMultiLoad()
	{
		n = new Neuron(0,functions);
		n.add(5);
		n.add(10);
		assertEquals(16,n.activate(),0);
	}

}
