package org.kondle.nn.tools.standard.functions;

import org.kondle.nn.functions.NeuralFunctions;

public class LogisticFunction
{
	public static NeuralFunctions getInstance()
	{
		return functions;
	}
	private static NeuralFunctions functions = new NeuralFunctions()
	{
		@Override
		public double activationFunction(double val)
		{
			return 1 / (1 + 1 / (Math.pow(Math.E,val)));
		}
		@Override
		public double derivativeFunction(double val)
		{
			return this.activationFunction(val) * (1 - this.activationFunction(val));
		}
	};

}
