/*
 * GrandPriest Originals
*/
package com.nabh.test;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class FileSearcher {
	ArrayList <File> list= new ArrayList<File>();
	public ArrayList<File> getList() {
		return list;
	}
	public void FindInFolder() {
		String maindirpath="C:\\Users\\nachoudhary\\Downloads\\New folder";
		File maindir = new File(maindirpath);
		if(maindir.exists() && maindir.isDirectory())
		{
			File arr[] = maindir.listFiles();
            Subfolders(arr,0);
		}
	}
	private void Subfolders(File[] arr,int index) {
		if(index == arr.length)
			return;
		if(arr[index].isFile())
			this.list.add(arr[index]);
		
		else if(arr[index].isDirectory())
			Subfolders(arr[index].listFiles(),0);
		
		Subfolders(arr,index+1);
	}
	static ArrayList<File> getFileList(FileSearcher fs) {
		fs.FindInFolder();
		ArrayList <File> allFiles=fs.getList();
		/*
				  for(File file : allFiles) {
					try {
						System.out.println(file.getName()+" "+file.getCanonicalPath());
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				  
		 */
		
		return allFiles;
	}
}
