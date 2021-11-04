package keben;

import java.util.ArrayList;

import ParkingLot.IParams;

public interface IParKing {
	public void print();
	public boolean addCar(int carType);
	//分析命令行输入的参数（文档）
	public static IParams parse() throws Exception{
		return null;
	}
	ArrayList<Integer> getPlanParking();

}
//interface IParams{
//	public int getBig();
//	public int getMedium();
//	public int getSmall();
//	/* 获取停车序列，例如 [1 2 2 3] 表示 依次停一辆大车，中车，中车，小车*/
//	public ArrayList<Integer> getPlanParking();
//}