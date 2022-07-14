package com.sist.system;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import com.sist.vo.KreamVO;

public class Read {
	 private static ArrayList<KreamVO> list=new ArrayList<KreamVO>();
	 
	 static
	  {
		  try
		  {
			  FileInputStream fis=
					  new FileInputStream("c:\\java_data\\kream.txt");
			  ObjectInputStream ois=
					  new ObjectInputStream(fis);
			  list=(ArrayList<KreamVO>)ois.readObject();
			  ois.close();
			  fis.close();
			  
			  
//			  for (KreamVO k:list) {
//				  System.out.println(k.getName());
//			  }
//			  System.out.println();
		  }catch(Exception ex){}
	  }

	 public static void main(String[] args) {
		  for(KreamVO k:list)
		  {
			  
			  
				  System.out.println(k.getName()+"["+k.getAmount()+"]");
			  
		  }
	}
}


