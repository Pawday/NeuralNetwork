package org.kondle.nn.components;


public class Relation
{
	private double weight;

	public Relation(double weight)
	{
		this.weight = weight;
	}

	public double getWeight()
	{
		return weight;
	}

	public void changeWeight(double d)
	{
		this.weight += d;
	}

}
