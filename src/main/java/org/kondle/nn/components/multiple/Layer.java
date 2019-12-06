package org.kondle.nn.components.multiple;

import org.kondle.nn.components.single.Neuron;
import org.kondle.nn.functions.NeuralFunctions;

public class Layer
{
    private int neuronsCount;
    private Neuron[] neurons;
    private int accuracyLimit;
    private NeuralFunctions functions;

    public Layer(int neuronsCount,NeuralFunctions functions)
    {
        this.functions = functions;
        this.neuronsCount = neuronsCount;
        this.neurons = new Neuron[neuronsCount];
        for (int i = 0; i < neuronsCount; i++)
            this.neurons[i] = new Neuron(functions, accuracyLimit, 0);
    }

    public int getNeuronsCount()
    {
        return neuronsCount;
    }

    public void loadVector(long[] vector)
    {
        //TODO: check vector.length == this.neuronsCount for throwing exceptions
        for (int i = 0; i < neuronsCount; i++)
            this.neurons[i].addValue(vector[i]);
    }

    public long[] activateLayer()
    {
        long[] returnVector = new long[this.neuronsCount];
        for (int i = 0; i < neuronsCount; i++)
            returnVector[i] = this.neurons[i].activate();
        return returnVector;
    }

    public void setAccuracyLimit(int accuracyLimit)
    {
        this.accuracyLimit = accuracyLimit;
    }
}

