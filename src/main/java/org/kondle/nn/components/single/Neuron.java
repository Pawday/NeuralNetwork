package org.kondle.nn.components.single;

import org.kondle.nn.functions.NeuralFunctions;

public class Neuron
{
    private NeuralFunctions functions;
    private int accuracyLimit;

    private long state = 0;
    private long bias = 0;

    public Neuron(NeuralFunctions functions, int accuracyLimit, long bias)
    {
        this.bias = bias;
        this.functions = functions;
        this.accuracyLimit = accuracyLimit;
    }

    public void addValue(long value)
    {
        this.state += value;
    }

    public long activate()
    {
        double value = this.state;
        this.state = 0;
        value = value / Math.pow(10, this.accuracyLimit);
        return Math.round(
                this.functions.activationFunction(
                        value + bias / Math.pow(10, this.accuracyLimit)
                ) * Math.pow(10, this.accuracyLimit)
        );
    }

}
