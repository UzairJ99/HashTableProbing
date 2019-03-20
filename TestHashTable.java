package si4Lab4;

public class TestHashTable {

	public static void main(String[] args) 
	{
		//testing the size of the hash table as given in the program description
		HashTableQuad table1 = new HashTableQuad(5, 0.5);
		System.out.println("Table size: " + table1.getSize().toString());
		table1.insert(1);
		table1.insert(2);
		table1.insert(34);
		table1.insert(67);
		table1.insert(8);
		table1.insert(20);
		table1.insert(32); //after this point the table is rehashed
		table1.insert(45);
		table1.insert(22);
		table1.insert(47);
		table1.printKeysAndIndexes();
		System.out.println("Table size: " +  table1.getSize().toString()); //resized with the rehash
		
		
		HashTableLin table2 = new HashTableLin(5, 0.5);
		System.out.println("Table size: " + table2.getSize().toString());
		table2.insert(10);
		table2.insert(2);
		table2.insert(0);
		table2.insert(1);
		table2.insert(8);
		table2.insert(20);
		table2.insert(32); //after this point the table is rehashed
		table2.insert(45);
		table2.insert(22);
		table2.insert(47);
		table2.insert(46);
		table2.insert(32);
		table2.insert(23);
		table2.printKeysAndIndexes();
		System.out.println("Table size: " +  table2.getSize().toString()); //resized with the rehash
		double sn = (double)(table2.getProbes())/(double)(table2.getNumOfKeys());
		System.out.println(sn);
	}

}
