package si4Lab4;

public class TestHashTable {

	public static void main(String[] args) 
	{
		//testing the size of the hash table as given in the program description
		HashTableLin table1 = new HashTableLin(5, 0.4);
		System.out.println(table1.getSize().toString());
	}

}
