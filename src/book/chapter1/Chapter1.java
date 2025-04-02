package book.chapter1;
import java.lang.System; //redundant import
import java.lang.*; //redundant import
import java.util.Random;
import java.util.*; //redundant import


public class Chapter1 {
	int classVariable;
	public Chapter1(){
		System.out.println("Chapter1");
		System.out.println("classVariable default value: "+classVariable);
		new ImportExample();
	}
	{
		int codeBlockInt;
		codeBlockInt=8;
		System.out.println(codeBlockInt);
	}
}
class ImportExample{
	ImportExample(){
		Random r=new Random();
		int localVariable;
		System.out.println("Random " + r.nextInt(10));		
		//System.out.println("localVariable default value: "+localVariable); Does not compile
	}
}