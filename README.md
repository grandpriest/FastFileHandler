# Fast File Handler

This project is a model of file searcher and handler implemented by operating system for locating a searched file in the directory provided by user, also performing actions like opening, deleting, finding file size, permisssions available and finding last modified date for the file. The project is entirely based on Java.

![Alt text](https://github.com/grandpriest/FastFileHandler/blob/master/FileHandling/src/com/nabh/test/src/com/nabh/test/ScreenShots/ffh2.PNG)

In broader terms, the project consists of following parts:

#### 1.File Seacher : 
For implementing the search operation on the given directory, FileSearcher.java is called, which is provided with the address of the directory on which the search operation is to be implemented. FileSearcher.java calls visits sub-directory recursively to locate files present in the directory as a whole.

Once the list of files present in the directory is generated a TRIE is build on the name of files present. User provides the name of the file he wants to seach, and following prefix search algorithm  of TRIE data structure, the list of files whose names match the desired file is presented to the user in an impressive time of

```O(N), where N: Length of the file to be searched by the user.```


#### 2.File Operator : 
Once the desired file seached by the user is found, the flow then goes to FileOperations.java. In this program java package java.io.File is used to perform file operations on the file seached by the user.
These operations involve:
```
1.Opening File
2.Deleting File
3.Finding File Size
4.Finding and Editing File Permissions
5.Finding Last Modified Date for the file.
```

## Getting Started

Just download the whole repository in zip format, unzip it. 
### Prerequisites

#### Concepts

```
1. Java Basics and fundamentals of java.io.File.
2. Fundamental of TRIE data-structures(building, updating, deleting elements), prefix search using TRIE data-structures.
```
#### Software and Tools

```
Java IDE with pre-installed JDK in the system.(I used Eclipse IDE for Java Developers).
```
![Alt text](https://github.com/grandpriest/FastFileHandler/blob/master/FileHandling/src/com/nabh/test/src/com/nabh/test/ScreenShots/ffh1.PNG)
### Installing

Download all the files of the repository. Create a project in IDE and add the files of the repository to the project. Now build the project and run it.

The step by step screenshots are provided at [Link](https://github.com/grandpriest/FastFileHandler/tree/master/FileHandling/src/com/nabh/test/src/com/nabh/test/ScreenShots).

## Authors

* **Nabh Choudhary** - *Initial work* - [grandpriest](https://github.com/grandpriest).
* **Anudeex Shetty** - *Later Updates* - [anudeexCR7](https://github.com/anudeexCR7).


## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details