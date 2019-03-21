package si4Lab4;

public class TestHashTable 
{

	public static void main(String[] args) 
	{
		System.out.println("Uzair Jawaid; jawaidu; 400114899");
		System.out.println("Testing table size");
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("Expected value: 13");
		System.out.println("Actual value:");
		System.out.print("Quad table: ");
		HashTableQuad tableA = new HashTableQuad(5, 0.4);
		System.out.println(tableA.getSize());
		System.out.print("Lin table: ");
		HashTableLin tableB = new HashTableLin(5, 0.4);
		System.out.println(tableB.getSize());
		
		System.out.println("----------------------------------------------------------------------------");
		
		System.out.println("Testing insert with linear probing");
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("Expected values (h(x) = n % M) : 1,40 4,30 7,20 10,10 11,50");
		System.out.println("Actual value:");
		tableB.insert(10);
		tableB.insert(20);
		tableB.insert(30);
		tableB.insert(40);
		tableB.insert(50);
		tableB.printKeysAndIndexes();
		
		System.out.println("----------------------------------------------------------------------------");
		
		System.out.println("Testing insert with quadratic probing");
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("Expected values (h(x) = n % M) : 1,40 4,30 7,20 10,10 11,50");
		System.out.println("Actual value:");
		tableA.insert(10);
		tableA.insert(20);
		tableA.insert(30);
		tableA.insert(40);
		tableA.insert(50);
		tableA.printKeysAndIndexes();
		
		System.out.println("----------------------------------------------------------------------------");
		
		System.out.println("Testing isIn with valid input");
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("Expected value: true");
		System.out.print("Actual value:");
		System.out.println(tableA.isIn(20));
		System.out.println("Expected value: true");
		System.out.print("Actual value:");
		System.out.println(tableB.isIn(20));
		
		System.out.println("----------------------------------------------------------------------------");
		
		System.out.println("Testing rehash with linear probing");
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("Expected values (h(x) = n % M) : 1,40 2,1 4,30 7,20 9,9 10,10 11,50 18,685, 22,22");
		System.out.println("Actual value:");
		tableB.insert(10);
		tableB.insert(20);
		tableB.insert(30);
		tableB.insert(40);
		tableB.insert(50);
		tableB.insert(1);
		tableB.insert(7);
		tableB.insert(22);
		tableB.insert(685);
		tableB.insert(9);
		tableB.printKeysAndIndexes();
		
		System.out.println("----------------------------------------------------------------------------");
		
		System.out.println("Testing rehash with quadratic probing");
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("Expected values (h(x) = n % M) : 1,40 4,30 5,1 7,20 9,9 10,10 11,50 18,685 22,22");
		System.out.println("Actual value:");
		tableA.insert(10);
		tableA.insert(20);
		tableA.insert(50);
		tableA.insert(40);
		tableA.insert(50);
		tableA.insert(1);
		tableA.insert(7);
		tableA.insert(22);
		tableA.insert(685);
		tableA.printKeysAndIndexes();
		
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("Testing Sn values");
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("Expected value: 1.05");
		System.out.println("Actual values:");
		//testing average probes count Sn
		System.out.println(getQuadSn(100,0.1));
		System.out.println(getLinSn(100,0.1));	
		System.out.println("Expected value: 1.12");
		System.out.println("Actual values:");
		//testing average probes count Sn
		System.out.println(getQuadSn(100,0.2));
		System.out.println(getLinSn(100,0.2));
		System.out.println("Expected value: 1.21");
		System.out.println("Actual values:");
		//testing average probes count Sn
		System.out.println(getQuadSn(100,0.3));
		System.out.println(getLinSn(100,0.3));
		System.out.println("Expected value: 1.33");
		System.out.println("Actual values:");
		//testing average probes count Sn
		System.out.println(getQuadSn(100,0.4));
		System.out.println(getLinSn(100,0.4));
		System.out.println("Expected value: 1.5");
		System.out.println("Actual values:");
		//testing average probes count Sn
		System.out.println(getQuadSn(100,0.5));
		System.out.println(getLinSn(100,0.5));
		System.out.println("Expected value: 1.75");
		System.out.println("Actual values:");
		//testing average probes count Sn
		System.out.println(getQuadSn(100,0.6));
		System.out.println(getLinSn(100,0.6));
		System.out.println("Expected value: 2.16");
		System.out.println("Actual values:");
		//testing average probes count Sn
		System.out.println(getQuadSn(100,0.7));
		System.out.println(getLinSn(100,0.7));
		System.out.println("Expected value: 3");
		System.out.println("Actual values:");
		//testing average probes count Sn
		System.out.println(getQuadSn(100,0.8));
		System.out.println(getLinSn(100,0.8));
		System.out.println("Expected value: 5.5");
		System.out.println("Actual values:");
		//testing average probes count Sn
		System.out.println(getQuadSn(100,0.9));
		System.out.println(getLinSn(100,0.9));
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
