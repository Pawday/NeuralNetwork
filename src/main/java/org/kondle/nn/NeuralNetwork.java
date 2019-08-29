package org.kondle.nn;

import org.kondle.nn.functions.NeuralFunctions;
import org.kondle.nn.components.multiple.Layer;

public class NeuralNetwork
{
	private Layer[] layers;
	private NeuralFunctions functions;

	public NeuralNetwork(int[] neuronsCounts, NeuralFunctions functions)
	{
		this.functions = functions;
		this.layers = new Layer[neuronsCounts.length];
		for (int i = 0; i < neuronsCounts.length; i++)
			this.layers[i] = new Layer(neuronsCounts[i], this.functions);

	}
}
