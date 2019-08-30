package org.kondle.nn.components.multiple;

import org.kondle.nn.exceptions.RelationsBoxException;
import org.kondle.nn.components.Relation;

public class RelationsBox
{
	private Relation[][] relations;


	private Layer backLayer;
	private Layer frontLayer;

	public RelationsBox(Layer backLayer, Layer frontLayer)
	{
		this.backLayer = backLayer;
		this.frontLayer = frontLayer;
		this.relations = new Relation[this.backLayer.getNeuronsCount()][this.frontLayer.getNeuronsCount()];

		for (int i = 0; i < relations.length; i++)
			for (int j = 0; j < relations[i].length; j++)
				this.relations[i][j] = new Relation(0);
	}
	public Relation[] getBackLayerRelations(int neuronIndex) throws RelationsBoxException
	{
		if (neuronIndex >= frontLayer.getNeuronsCount())
			throw new RelationsBoxException("In front layer there is not neuron with index " + neuronIndex);
		if (neuronIndex < 0)
			throw new RelationsBoxException("Index is not be smalled than zero");
		Relation[] returned = new Relation[backLayer.getNeuronsCount()];
		for (int i = 0; i < backLayer.getNeuronsCount(); i++)
			returned[i] = relations[i][neuronIndex];
		return returned;
	}

	public Relation[] getFrontLayerRelations(int neuronIndex) throws RelationsBoxException
	{
		if (neuronIndex > backLayer.getNeuronsCount())
			throw new RelationsBoxException("In back layer there is not neuron with index " + neuronIndex);
		if (neuronIndex < 0)
			throw new RelationsBoxException("Index is not be smalled than zero");
		Relation[] returned = new Relation[frontLayer.getNeuronsCount()];
		for (int i = 0; i < frontLayer.getNeuronsCount(); i++)
			returned[i] = relations[neuronIndex][i];
		return returned;
	}
	public Relation[][] getRelationsMultiArray()
	{
		return relations;
	}
}
