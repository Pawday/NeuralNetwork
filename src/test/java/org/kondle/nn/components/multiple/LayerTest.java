package org.kondle.nn.components.multiple;


import org.junit.Test;
import org.kondle.nn.components.Neuron;
import org.kondle.nn.exceptions.LayerException;
import org.kondle.nn.functions.NeuralFunctions;

import static org.junit.Assert.*;

public class LayerTest
{
	private static NeuralFunctions functions;
	private static Layer layer;
	static
	{
		functions = new NeuralFunctions()
		{
			@Override
			public double activationFunction(double val)
			{
				//standard sigmoid function
				return 1 / (1 + (1 / Math.pow(Math.E,val)));
			}
			@Override
			public double derivativeFunction(double val)
			{
				return val;
			}
		};
	}

	@Test
	public void testLoadArrayValues() throws LayerException
	{
		for (int i = 1; i <= 10000; i++)
		{
			layer = new Layer(i,functions);
			double[] arr = new double[i];
			for (int j = 0; j < i; j++)
			{
				arr[j] = Math.random() * 1000;
			}
			layer.loadArrayValues(arr);
			Neuron[] neurons = layer.getNeurons();
			for (int j = 0; j < layer.getNeuronsCount(); j++)
			{
				assertEquals(neurons[j].getBuffer(),arr[j],0);
			}
		}
	}

	@Test
	public void testActivateNeurons() throws LayerException
	{
		for (int i = 1; i <= 1000; i++)
		{
			layer = new Layer(i,functions);
			double[] arr = new double[i];
			for (int j = 0; j < i; j++)
			{
				arr[j] = Math.random() * 1000;
			}
			layer.loadArrayValues(arr);
			double[] actual;
			double[] expected;

			expected = new double[i];
			for (int j = 0; j < expected.length; j++)
			{
				expected[j] = functions.activationFunction(arr[j]);
			}
			actual = layer.activateNeurons();
			assertArrayEquals(expected,actual,0);
		}
	}
	@Test
	public void testNeuralBuffersFlushing() throws LayerException
	{
		for (int i = 1; i <= 1000; i++)
		{
			layer = new Layer(i, functions);
			Neuron[] neurons = layer.getNeurons();
			double[] arr = new double[i];
			for (int j = 0; j < i; j++)
			{
				arr[j] = Math.random() * 1000;
			}
			layer.loadArrayValues(arr);
			layer.activateNeurons();
			for (int j = 0; j < neurons.length; j++)
			{
				assertEquals(neurons[j].getBuffer(), 0, 0);
			}
		}
	}
}
