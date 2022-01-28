package trie;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Trie 
{
	
	static class Node
	{
		char ch ;
		Map<Character, Node> map ;
		boolean isLast = false ;
		
		public Node(char ch) {
			this.ch = ch ;
			map = new HashMap<>();
		}
	}
	
	static class MyTrie
	{
		Node root = new Node(' ');
		
		void insert(String word)
		{
			Node curr = root ;
			
			for (int curr_ind = 0 ; curr_ind < word.length(); curr_ind++)
			{
				if (!curr.map.containsKey(word.charAt(curr_ind))) {
					curr.map.put(word.charAt(curr_ind), new Node(word.charAt(curr_ind))) ;
				}
				curr = curr.map.get(word.charAt(curr_ind)) ;
			}
			
			curr.isLast = true ;
		}
		
		boolean search(String word)
		{
			
			Node curr = root ;
			
			for (int i = 0 ; i < word.length() ; i++)
			{
				char c = word.charAt(i) ;
				if (curr.map.containsKey(c))
				{
					curr = curr.map.get(c) ;
				}
				else return false ;
			}
			
			return curr.isLast ;
		}
		
	}

	
	public static void main(String[] args) 
	{
		
		Scanner sc  = new Scanner(System.in) ;
		MyTrie trie = new MyTrie();
		trie.insert("apple");
		trie.insert("ape");
		trie.insert("ab");
		trie.insert("abc");
		trie.insert("abdc");
		trie.insert("dfg");
		trie.insert("dfh");
		
		
		for (int i = 0 ; i < 10; i++)
		{
			System.out.print("Enter a word to search : ");
			String word = sc.next();
			if (trie.search(word))
				System.out.println("YES");
			else System.out.println("NO");
		}
		
		sc.close();
		
		
			
	}
	
	
	
	
	
	
	
}
