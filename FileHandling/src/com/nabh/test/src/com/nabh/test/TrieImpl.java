/*
 * GrandPriest Originals
*/

package com.nabh.test;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TrieImpl {

	private static ArrayList<File> recommendedFiles=new ArrayList<File>();
	
	/*
	 * Trie Operations
	 */
	
	private static void buildTrie(Trie root, ArrayList<File> allFiles){
		for(File files:allFiles) {
			insertTrie(root,files);
		}
	}
	
	private static void insertTrie(Trie root, File file) {
		String key=file.getName();
		int level; 
		int length = key.length(); 
		int index; 
		
		Trie node = root; 
		//System.out.println(file.getName()+"<--file added now");
		for (level = 0; level < length; level++) 
		{ 
			index = key.charAt(level) - '*'; 
			if (node.children[index] == null) 
				node.children[index] = new Trie(); 
			node = node.children[index]; 
		} 
		node.isEndOfWord = true; 
		node.filePresent=file;
	}
	
	private static File searchTrie(Trie root, String key) {
		int level; 
		int length = key.length(); 
		int index; 
		Trie node = root; 
		for (level = 0; level < length; level++) 
		{ 
			index = key.charAt(level) - '*'; 
	
			if (node.children[index] == null) 
				return null; 
	
			node = node.children[index]; 
		} 
		if(node != null && node.isEndOfWord)
			return node.filePresent;
		else
			return null;
	}
	
	private static void findAlmostSimiliarFiles(Trie root, String key) {
		int level; 
		int length = key.length(); 
		int index; 
		Trie node = root; 
		for (level = 0; level < length; level++) 
		{ 
			index = key.charAt(level) - '*'; 
	
			if(node.filePresent!=null)
				recommendedFiles.add(node.filePresent);
			if (node.children[index] == null) 
				break; 
	
			node = node.children[index]; 
		}
		if(level==0)
			return;
		findAllFilesinSubTree(node);
	}
	
	private static void findAllFilesinSubTree(Trie node) {
		int index; 
		for(index=0;index<256;index++)
		{
			if(node.children[index]!=null)
				findAllFilesinSubTree(node.children[index]);
		}
		if(node.filePresent!=null)
			recommendedFiles.add(node.filePresent);
	}

	
	/*
	 * Main System Call
	 */
	public static void main(String[] args) {
		Trie root=new Trie();
		
		FileSearcher fs = new FileSearcher();
		
		ArrayList<File>allFiles=FileSearcher.getFileList(fs);
		buildTrie(root,allFiles);
		
		System.out.println("File name to be searched???");
		String fileName="";
		Scanner sc= new Scanner(System.in);
		fileName=sc.next();
		
		File isFile=searchTrie(root,fileName);
		
		if(isFile!=null)
		{
			System.out.println(isFile.getAbsolutePath());
			FileOperations oper=new FileOperations(isFile);
			Desktop desktop=Desktop.getDesktop();
			try {
				desktop.open(isFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		else
		{
			System.out.println("Searched File Not Present");
			findAlmostSimiliarFiles(root,fileName);
			if(recommendedFiles.size()>0)
			{
				int cnt=1;
				System.out.println("Recommended Files:");
				for(File file:recommendedFiles) {
					System.out.println(cnt+"--"+file.getName());
					cnt++;
				}
				System.out.println("File index to be accessed??");
				int choice=sc.nextInt();
				File file=recommendedFiles.get(choice-1);
				System.out.println("File Selected : "+file.getAbsolutePath());
				FileOperations oper=new FileOperations(file);
			}
			
		}
			
	}

	
}
