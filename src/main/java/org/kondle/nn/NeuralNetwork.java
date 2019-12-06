package org.kondle.nn;

public class NeuralNetwork
{
	private int accuracyLimit = 5;

	public NeuralNetwork(int inputNeuronsCount, int[] hiddenLayersVectors, int outputNeuronsCount)
	{

	}

	public int getAccuracyLimit()
	{
		return accuracyLimit;
	}

	public void setAccuracyLimit(int accuracyLimit)
	{
		this.accuracyLimit = accuracyLimit;
	}
}
