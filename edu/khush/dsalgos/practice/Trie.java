package edu.khush.dsalgos.practice;

public class Trie {

	Node root;

	public Trie() {
		root = new Node();
	}

	public void addWord(Node vertex, String word) {
		
		
		if ("".equals(word))
			vertex.wordCount = vertex.wordCount + 1;

		else {
			vertex.prefixCount = vertex.prefixCount + 1;
			int first = word.charAt(0);
			int firstCharIndex = first % 97;
			System.out.println(Character.toChars(first));
			if (vertex.edges[firstCharIndex] == null)
				vertex.edges[firstCharIndex] = new Node();
			word = word.substring(1, word.length());
			addWord(vertex.edges[firstCharIndex], word);

		}

	}

	public int countWords(Node vertex, String word) {
		
		if ("".equals(word))
			return vertex.wordCount;
		else {
			int first = word.charAt(0);
			int firstCharIndex = first % 97;

			if (vertex.edges[firstCharIndex] == null)
				return 0;
			else {
				word = word.substring(1, word.length());
				return countWords(vertex.edges[firstCharIndex], word);
			}
		}

	}
	
	
	public int countPrefixes(Node vertex, String word) {
		
		System.out.println("Lenght of word is: "+word.length());
		if ("".equals(word))
		{
			System.out.println("Comes here now: "+vertex.wordCount);
			return vertex.prefixCount;
		}
		else {
			
			int first = word.charAt(0);
			int firstCharIndex = first % 97;
			if (vertex.edges[firstCharIndex] == null)
			{
				System.out.println("Comes here");
				return 0;
			}
			else {
				word = word.substring(1, word.length());
				System.out.println("Word is: "+word);
				return countPrefixes(vertex.edges[firstCharIndex], word);
			}
		}

	}
	
	public static void main(String args[])
	{
		
		// "tree", "trie", "algo", "assoc", "all", and "also."
		Trie trie=new Trie();
		trie.addWord(trie.root, "tree");
		trie.addWord(trie.root, "trie");
		trie.addWord(trie.root, "algo");
		trie.addWord(trie.root, "assoc");
		trie.addWord(trie.root, "all");
		trie.addWord(trie.root, "also");
		
		//for (int i=0;i<26;i++)
			//System.out.println(trie.root.edges[i]+","+(i));
		
		for (int j=0;j<26;j++)
			if(trie.root.edges[0].edges[j]!=null)
			{
				char k=(char)(j+97);
				System.out.println("********");
			System.out.println(trie.root.edges[0].edges[j].prefixCount);
			System.out.println(new Character(k).toString());
			}
					//edges[j].prefixCount);
		System.out.println(trie.countWords(trie.root, "algo"));
		
		
	}
}
