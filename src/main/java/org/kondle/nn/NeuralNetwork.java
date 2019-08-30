package org.kondle.nn;

import org.kondle.nn.components.Neuron;
import org.kondle.nn.components.Relation;
import org.kondle.nn.components.multiple.RelationsBox;
import org.kondle.nn.exceptions.NeuralNetworkException;
import org.kondle.nn.functions.NeuralFunctions;
import org.kondle.nn.components.multiple.Layer;

public class NeuralNetwork
{
	private Layer[] layers;
	private RelationsBox[] relationsBoxes;
	private NeuralFunctions functions;
	private int[] neuronsCounts;

	public NeuralNetwork(int[] neuronsCounts, NeuralFunctions functions) throws NeuralNetworkException
	{
		this.neuronsCounts = neuronsCounts;
		if (neuronsCounts.length < 2)
			throw new NeuralNetworkException("The number of layers in a neural network must be more than one");
		for (int neuronsCount : neuronsCounts)
			if (neuronsCount < 1)
				throw new NeuralNetworkException("The number of neurons in the layer should be more than zero");
		if (functions == null)
			throw new NeuralNetworkException("The NeuralFunctions parameter isn't be a null");
		this.functions = functions;
		this.layers = new Layer[neuronsCounts.length];
		for (int i = 0; i < neuronsCounts.length; i++)
			this.layers[i] = new Layer(neuronsCounts[i], this.functions);
		this.relationsBoxes = new RelationsBox[this.layers.length - 1];
		if (this.relationsBoxes.length != 0)
			for (int i = 0; i < this.relationsBoxes.length; i++)
				this.relationsBoxes[i] = new RelationsBox(this.layers[i], this.layers[i + 1]);
	}

	public double[] get(double[] values) throws NeuralNetworkException
	{
		if (values.length != this.neuronsCounts[0])
			throw new NeuralNetworkException("Count of parameters must match count of neurons in input layer");
		double[] backArray = values;
		for (int i = 0; i < this.layers.length; i++)
		{
			Layer currentLayer = this.layers[i];
			if (i == 0)
			{
				currentLayer.loadArrayValues(values);
				backArray = currentLayer.activateNeurons();
				continue;
			}
			Neuron[] neurons = currentLayer.getNeurons();
			RelationsBox backLayerRelationsBox = relationsBoxes[i - 1];
			for (int j = 0; j < neurons.length; j++)
			{
				Neuron currentNeuron = neurons[j];
				Relation[] relationsCurrentNeuron = backLayerRelationsBox.getBackLayerRelations(j);
				for (int k = 0; k < backArray.length; k++)
					currentNeuron.add(backArray[k] * relationsCurrentNeuron[k].getWeight());
			}
			backArray = currentLayer.activateNeurons();
		}
		return backArray;
	}

	public RelationsBox[] getRelationsBoxes() { return relationsBoxes; }
	public Layer[] getLayers() { return layers; }
}
