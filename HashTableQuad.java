package si4Lab4;

public class HashTableQuad
{
	private Integer tableSize; //variable to store the size of the hash table
	private Integer[] table; //reference array to store the keys
	private double maxLoad; //maximum load factor for table
	private int keys;
	
	public HashTableQuad(int maxNum, double load)
	{
		int size = (int)(maxNum/load); //calculates the load factor to the nearest integer
		maxLoad = load;
		tableSize = new Integer(determineSize(size)); //sets the size of the hash table
		table = new Integer[tableSize]; //create the hash table
	}
	
	public void insert(int n)
	{
		//h(x) = x % M
		int m = tableSize;
		int index = n % m;
		//check if the key already has a value paired in the table
		if (!isIn(n))
		{
			double newLoad = ((double)keys)/tableSize;
			//check if load factor is exceeded
			if(newLoad > maxLoad)
			{
				rehash();
			}
			else
			{
				int k = 1; //quadratic increment counter
				for(int i = index; i < tableSize; i = k*k + index) //squares the increment and adds to the current index
				{
                    //check for empty space
                    if(table[i % tableSize] == null)
                    {   
                        table[i % tableSize] = n;
                        keys++; //add to key count
                        break;
                    }
                    k++;
                }
			}
		}
	}
	package si4Lab4;

public class HashTableQuad
{
	private Integer tableSize; //variable to store the size of the hash table
	private Integer[] table; //reference array to store the keys
	private double maxLoad; //maximum load factor for table
	private int keys;
	
	public HashTableQuad(int maxNum, double load)
	{
		int size = (int)(maxNum/load); //calculates the load factor to the nearest integer
		maxLoad = load;
		tableSize = new Integer(determineSize(size)); //sets the size of the hash table
		table = new Integer[tableSize]; //create the hash table
	}
	
	public void insert(int n)
	{
		//h(x) = x % M
		int m = tableSize;
		int index = n % m;
		//check if the key already has a value paired in the table
		if (!isIn(n))
		{
			double newLoad = ((double)keys)/tableSize;
			//check if load factor is exceeded
			if(newLoad > maxLoad)
			{
				rehash();
			}
			else
			{
				int k = 1; //quadratic increment counter
				for(int i = index; i < tableSize; i = k*k + index) //squares the increment and adds to the current index
				{
                    //check for empty space
                    if(table[i % tableSize] == null)
                    {   
                        table[i % tableSize] = n;
                        keys++; //add to key count
                        break;
                    }
                    k++;
                }
			}
		}
	}
	
    private void rehash()
    {
    	tableSize = 2*tableSize;
        tableSize = determineSize(tableSize);
        Integer [] rehashed = new Integer[tableSize];
        
        for(int j = 0; j < table.length; j++)
        { 
            if(table[j] != null)
            {  
            	//rehash table with elements from the old hash function
                int k = j % tableSize;
                while(rehashed[k] != null)
                {    
                    k++; //linearly probes through the table
                }
                //new rehashed table
                rehashed[k % tableSize] = table[j];
            }
        }
        table = rehashed;
    }

    public void printKeys()
    {
        for(int i = 0; i < this.tableSize; i++)
        {
        	//print non-empty keys
            if(table[i] != null)
            {
                System.out.print(table[i] + ", ");
            }
        }
    }    
    
    public void printKeysAndIndexes()
    {
        for(int i = 0; i < this.tableSize; i++)
        {
        	//print non-empty keys
            if(table[i] != null)
            {
                System.out.println("Index: " + i + " value: " + table[i]);
            }
        }
    }  
	public boolean isIn(int f)
	{
        Integer n = (Integer) f; 
        //start search at appropriate index till end of table
        for(int i = n % tableSize; i < tableSize; i++)
        {
            if(table[i % tableSize] == n) //check if index and element correctly match
            {
                return true;
            }
            else if(table[i % tableSize] == null)
            {
                return false;
            }
        }
        return false;
    }
	
	public int determineSize(int size)
	{
		//if the number is not prime it will search for the next smallest prime number possible
		while (!isPrime(size))
		{
			size++;
		}
		return size;
	}
	
	//https://www.javatpoint.com/prime-number-program-in-java
	public static boolean isPrime(int n) 
	{  
	       if (n <= 1)  
	           return false;  
	       for (int i = 2; i <= Math.sqrt(n); i++) 
	       {  
	           if (n % i == 0) 
	               return false;   
	       }  
	       return true;  
	}  
	
	public Integer getSize()
	{
		return this.tableSize;
	}

	public double getLoad()
	{
		return this.maxLoad;
	}
	
	public int getNumOfKeys()
	{
		return this.keys;
	}

}

    private void rehash()
    {
        int rehashSize = 2*tableSize; //the new table will be double the original size
        tableSize = new Integer(determineSize(rehashSize));
        Integer [] rehashed = new Integer[rehashSize];
        
        for(int j = 0; j < table.length; j++)
        { 
            if(table[j] != null)
            {  
            	//rehash table with elements from the old hash function
                int k = j % rehashSize;
                while(rehashed[k] != null)
                {    
                    k++; //linearly probes through the table
                }
                //new rehashed table
                rehashed[k % rehashSize] = table[j];
            }
        }
        this.table = rehashed;
    }

    public void printKeys()
    {
        for(int i = 0; i < this.tableSize; i++)
        {
        	//print non-empty keys
            if(table[i] != null)
            {
                System.out.print(table[i] + ", ");
            }
        }
    }    
    
    public void printKeysAndIndexes()
    {
        for(int i = 0; i < this.tableSize; i++)
        {
        	//print non-empty keys
            if(table[i] != null)
            {
                System.out.println("Index: " + i + " value: " + table[i]);
            }
        }
    }  
	public boolean isIn(int f)
	{
        Integer n = (Integer) f; 
        //start search at appropriate index till end of table
        for(int i = n % tableSize; i < tableSize; i++)
        {
            if(table[i % tableSize] == n) //check if index and element correctly match
            {
                return true;
            }
            else if(table[i % tableSize] == null)
            {
                return false;
            }
        }
        return false;
    }
	
	public int determineSize(int size)
	{
		//if the number is not prime it will search for the next smallest prime number possible
		while (!isPrime(size))
		{
			size++;
		}
		return size;
	}
	
	//https://www.javatpoint.com/prime-number-program-in-java
	public static boolean isPrime(int n) 
	{  
	       if (n <= 1)  
	           return false;  
	       for (int i = 2; i <= Math.sqrt(n); i++) 
	       {  
	           if (n % i == 0) 
	               return false;   
	       }  
	       return true;  
	}  
	
	public Integer getSize()
	{
		return this.tableSize;
	}

	public double getLoad()
	{
		return this.maxLoad;
	}
	
	public int getNumOfKeys()
	{
		return this.keys;
	}

}
