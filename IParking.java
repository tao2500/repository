package ParkingLot;

import java.util.ArrayList;
import java.util.Scanner;

public interface IParking {
	//打印输出结果
	public void print();
	//检查是否有 carType对应的停车位
	//没有返回falsse、否则返回true
	public boolean addCar(int carType);
	//解析命令行参数
	public static IParams parse()throws Exception{
		Scanner sc=new Scanner(System.in);
//		String str1=sc.next();
		System.out.println("请输入执行语句");  
		String str=sc.next();
//		System.out.println("s="+str);
		//[[1,1,0],[1],[2],[3],[1]]
		String[]s=str.split("\\D+");
//		System.out.println("4="+s[4]);
//		System.out.println("5="+s[5]);
		ArrayList<Integer> list=new ArrayList();
		list.add(Integer.parseInt(s[4]));
		list.add(Integer.parseInt(s[5]));
		list.add(Integer.parseInt(s[6]));
		list.add(Integer.parseInt(s[7]));
		
	   return new IParams(){
		   public int getBig(){
			   return Integer.parseInt(s[1]);
		   }
		   public int getMedium(){
			   return Integer.parseInt(s[2]);
		   }
		   public int getSmall(){
			   return Integer.parseInt(s[3]);
		   }
		   public ArrayList<Integer> getPlanParking(){
			   return list;
		   }
		   public int getSize(){
			   return list.size();
		   }
	   };
	}
}