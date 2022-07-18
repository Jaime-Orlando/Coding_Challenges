package trees;

public class Trie 
{
	
	// The root of a Trie needs to be a dummy (empty) TrieNode
	private TrieNode root;
	
	public Trie() 
	{
		// \0 represents an empty character
		this.root = new TrieNode('\0');
	}
	
	public void insert(String word) 
	{
		TrieNode currentNode = this.root;
		for(int i = 0; i < word.length(); i++) 
		{
			char currentChar = word.charAt(i);
			// We need to check if currentNode is already associated to currentChar	
			// Note: a - a = 0, b - a = 1,... z-a = 25
			if(currentNode.children[currentChar - 'a'] == null) 
			{
				currentNode.children[currentChar - 'a'] = new TrieNode(currentChar);
			}
			
			// Update Current Node
			currentNode = currentNode.children[currentChar-'a'];
		}
		
		// The last char of the word should be marked
		currentNode.isTerminalChar = true;
	}
	
	private TrieNode getNode(String word) throws Exception 
	{
		TrieNode currentNode = this.root;
		for(int i = 0; i < word.length(); i++)
		{
			char currentChar = word.charAt(i);
			if(currentNode.children[currentChar - 'a'] == null) 
			{
				throw new Exception("No such word exists!!");
			}
			
			currentNode = currentNode.children[currentChar - 'a'];		
		}
		
		return currentNode;
	}
	
	public boolean search(String word) 
	{
		boolean isPresent = false;
		try 
		{
			TrieNode finalWordLetter = getNode(word);
			if(finalWordLetter.isTerminalChar) 
			{
				isPresent = true;
			}
		}
		
		catch(Exception e) 
		{
			System.out.println(e.getMessage());
		}
		
		
		return isPresent;
		
	}
	
	public boolean prefixExists(String prefix) 
	{
		boolean exists = false;
		try 
		{
			TrieNode prefixFinal = getNode(prefix);
			exists = true;
		}
		
		catch(Exception e) 
		{
			// exists will remain false
		}
		
		return exists;
	}
	
	class TrieNode
	{
		public char c;
		public boolean isTerminalChar;
		public TrieNode[] children;
		
		public TrieNode(char c) 
		{
			this.c = c;
			this.isTerminalChar = false;
			// Max size is 26 because we only consider [a-z]
			this.children = new TrieNode[26];
		}
		
	}
	
	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("gong");
		trie.insert("flamingo");
		System.out.println(trie.search("mary"));
		System.out.println(trie.prefixExists("go"));
		System.out.println(trie.prefixExists("cha"));
	}

}
