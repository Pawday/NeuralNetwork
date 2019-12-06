package org.kondle.nn.components.multiple;

import java.util.Arrays;

public class RelationsMatrix
{

    private long[][] matrix;

    private Layer inputLayer;
    private Layer outputLayer;
    private int accuracyLimit;

    public RelationsMatrix(Layer inputLayer, Layer outputLayer, int accuracyLimit)
    {
        this.accuracyLimit = accuracyLimit;
        this.inputLayer = inputLayer;
        this.outputLayer = outputLayer;
        this.inputLayer.setAccuracyLimit(this.accuracyLimit);
        this.outputLayer.setAccuracyLimit(this.accuracyLimit);
        matrix = new long[this.inputLayer.getNeuronsCount()][];
        for (int i = 0; i < matrix.length; i++)
        {
            matrix[i] = new long[this.outputLayer.getNeuronsCount()];
            Arrays.fill(matrix[i],0);
        }
    }

    public void fillRandom(double maxValue)
    {
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[i].length; j++)
                matrix[i][j] = Math.round(Math.random() * maxValue * Math.pow(10, this.accuracyLimit));
    }
}
