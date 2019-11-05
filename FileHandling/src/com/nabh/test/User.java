package com.nabh.test;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class User {
	
	private static ArrayList<File> getFileList(FileSearcher fs) {
		fs.FindInFolder();
		ArrayList <File> allFiles=fs.getList();
		for(File file : allFiles) {
			try {
				System.out.println(file.getName()+" "+file.getCanonicalPath());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return allFiles;
	}
	
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
		System.out.println(file.getName()+"<--file added now");
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
	public static void main(String[] args) {
		Trie root=new Trie();
		FileSearcher fs = new FileSearcher();
		ArrayList<File>allFiles=getFileList(fs);
		buildTrie(root,allFiles);
		String fileName="";
		Scanner sc= new Scanner(System.in);
		fileName=sc.next();
		File isFile=searchTrie(root,fileName);
		if(isFile!=null)
		{
			System.out.println(isFile.getAbsolutePath());
			Desktop desktop=Desktop.getDesktop();
			try {
				desktop.open(isFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else
			System.out.println("File Not Present");
	}
}
