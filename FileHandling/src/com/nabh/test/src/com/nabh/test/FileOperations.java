/*
 * GrandPriest Originals
*/
package com.nabh.test;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

public class FileOperations {

	

	private void Permission(File file) {
		System.out.println("File is readable? "+file.canRead());
        System.out.println("File is writable? "+file.canWrite());
        System.out.println("File is executable? "+file.canExecute());
        
	}
	private void FileSize(File file) {
		double sizeFile= (double) file.length() / 1024;
		System.out.println("File Size is "+sizeFile+"kb");
	}

	private void DeleteFile(File file) {
		file.delete();
	}

	private void OpenFile(File file) {
		Desktop desktop=Desktop.getDesktop();
		try {
			desktop.open(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void LastModifiedDate(File file) {
		long timestamp = file.lastModified();
        System.out.println("Last modified date = "+new Date(timestamp));
	}
	public FileOperations(File file) {
		System.out.println("Operations to be performed ??");
		System.out.println("1.Open");
		System.out.println("2.Delete");
		System.out.println("3.FileSize");
		System.out.println("4.Permission");
		System.out.println("5.LastModified Date");
		
		int choice;
		Scanner sc= new Scanner(System.in);
		choice=sc.nextInt();
		switch(choice)
		{
			case 1:OpenFile(file);break;
			case 2:DeleteFile(file);break;
			case 3:FileSize(file);break;
			case 4:Permission(file);break;
			case 5:LastModifiedDate(file);break;
		}
		
	}

	

	

}
