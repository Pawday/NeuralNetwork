package org.kondle.nn.components.multiple;

import org.kondle.nn.exceptions.LayerException;
import org.kondle.nn.functions.NeuralFunctions;
import org.kondle.nn.components.Neuron;

public class Layer
{
	public Layer(int neuronsCount, NeuralFunctions functions)
	{
		this.neurons = new Neuron[neuronsCount];
		this.neuronsCount = neuronsCount;
		for (int i = 0; i < neuronsCount; i++)
		{
			this.neurons[i] = new Neuron(0,functions);
		}
	}

	private Neuron[] neurons;
	private int neuronsCount;

	public void loadArrayValues(double[] values) throws LayerException
	{
		if(values.length != this.neurons.length)
			throw new LayerException("Count of values loading don't match with count of neurons");
		for (int i = 0; i < values.length; i++)
			this.neurons[i].add(values[i]);
	}

	public double[] activateNeurons()
	{
		double[] returned = new double[this.neuronsCount];
		for (int i = 0; i < this.neuronsCount; i++)
			returned[i] = this.neurons[i].activate();
		return returned;
	}

	public int getNeuronsCount()
	{
		return neuronsCount;
	}

	public Neuron[] getNeurons()
	{
		return neurons;
	}

}
