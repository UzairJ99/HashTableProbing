package si4Lab4;

public class TestHashTable 
{

	public static void main(String[] args) 
	{
		//testing average probes count Sn
		System.out.println(getQuadSn(100,0.2));
		System.out.println(getLinSn(100,0.2));		
	}
	
	public static double getQuadSn(int tests, double load)
	{
		double sn = 0;
		//perform multiple tests
		for(int j = 0; j < tests; j++)
		{
			//create a hash table of 100000 items
			HashTableQuad table1 = new HashTableQuad(100000, load);
			for (int i = 0; i < 100000; i++)
			{
				//randomly generate the keys
				int random = (int)(Math.random() * 5000000 + 1);
				table1.insert(random);
			}
			//count the total probes and average it
			sn += (double)(table1.getProbes())/(double)(table1.getNumOfKeys());
		}
		//get the average number of probes of each table over all the tests
		sn/=tests;
		return sn;
	}
	
	public static double getLinSn(int tests, double load)
	{
		double sn = 0;
		for(int j = 0; j < tests; j++)
		{
			HashTableLin table1 = new HashTableLin(100000, load);
			for (int i = 0; i < 100000; i++)
			{
				int random = (int)(Math.random() * 5000000 + 1);
				table1.insert(random);
			}
			sn += (double)(table1.getProbes())/(double)(table1.getNumOfKeys());
		}
		sn/=tests;
		return sn;
	}

}
