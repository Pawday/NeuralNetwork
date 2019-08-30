package org.kondle.nn.components;

import org.kondle.nn.functions.NeuralFunctions;

public class Neuron
{

	private NeuralFunctions functions;

	private double offset;
	private double buffer;

	public Neuron(double offset , NeuralFunctions functions)
	{
		this.functions = functions;
		this.offset = offset;
		this.buffer = 0;
	}

	public double getOffset()
	{
		return offset;
	}

	public void changeOffset(double d)
	{
		this.offset += d;
	}
	public void add(double value)
	{
		this.buffer += value;
	}

	public double activate()
	{
		double returnedValue = functions.activationFunction(this.buffer + offset);
		this.buffer = 0;
		return returnedValue;
	}

	public double getBuffer()
	{
		return buffer;
	}
}
