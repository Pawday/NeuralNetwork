package org.kondle.nn.components.multiple;


import org.junit.Test;
import org.kondle.nn.exceptions.RelationsBoxException;

import static org.junit.Assert.*;


public class RelationsBoxTest
{
	private static RelationsBox box;
	private static void changeBox(int backLayerNeuronsCount, int frontLayerNeuronsCount)
	{
		box = new RelationsBox(new Layer(backLayerNeuronsCount,null),new Layer(frontLayerNeuronsCount,null));
	}
	private static void changeBox(Layer backLayer,Layer frontLayer)
	{
		box = new RelationsBox(backLayer,frontLayer);
	}

	@Test
	public void testRelationsCount() throws RelationsBoxException
	{
		for (int i = 1; i <= 100; i++)
		{
			for (int j = 1; j <= 100; j++)
			{
				int trueCount = i * j;
				int resCount = 0;
				changeBox(i,j);

				for (int k = 0; k < j; k++)
				{
					resCount += box.getBackLayerRelations(k).length;
				}
				assertEquals(trueCount,resCount);
			}
		}
	}
}
