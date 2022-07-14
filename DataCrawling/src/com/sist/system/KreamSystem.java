package com.sist.system;
import java.util.*;
import java.io.*;
import com.sist.vo.*;
public class KreamSystem {
  private static ArrayList<KreamVO> list=new ArrayList<KreamVO>();
  // 초기화 
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
		  
//		  for (KreamVO k:list) {
//			  System.out.println(k.getName());
//		  }
//		  System.out.println();
	  }catch(Exception ex){}
  }
  
  
//  public int menu()
//  {
//	  Scanner scan=new Scanner(System.in);
//	  System.out.println("========== 뮤직 메뉴 =======");
//	  System.out.println("1. Top100");
//	  System.out.println("2. 가요");
//	  System.out.println("3. POP");
//	  System.out.println("4. OST");
//	  System.out.println("5. 트롯");
//	  System.out.println("6. JAZZ");
//	  System.out.println("7. Classic");
//	  System.out.println("9. Exit");
//	  System.out.println("==========================");
//	  System.out.println("메뉴 선택:");
//	  return scan.nextInt();
//  }
  public static void print()
  {
	  for(KreamVO k:list)
	  {
		  
		  
			  System.out.println(k.getName()+"["+k.getAmount()+"]");
		  
	  }
  }
//  public void process()
//  {
//	  while(true)
//	  {
//		  int m=menu();
//		  if(m==9)
//		  {
//			  System.out.println("프로그램 종료");
//			  break;
//		  }
//		  else
//		  {
//			  print(m);
//		  }
//	  }
//  }
  public static void main(String[] args) {
	print();
  }
}
