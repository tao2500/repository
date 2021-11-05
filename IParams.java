package ParkingLot;

import java.util.ArrayList;

interface IParams{
	public int getBig();
	public int getMedium(); 
	public int getSmall();
	/* 获取停车序列，例如 [1 2 2 3] 表示 依次停一辆大车，中车，中车，小车*/
	public ArrayList<Integer> getPlanParking();
	public int getSize();  
}
