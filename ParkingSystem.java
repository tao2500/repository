package ParkingLot;

import java.util.ArrayList;


public class ParkingSystem implements IParking{
	int totalBig=0;    // 大车数总车位
	int totalMedium=0;
	int totalSmall=0;
	int Big=0;      //现有大车数
	int Medium=0;
	int Small=0;
	static int siz=0;
	String massage[][]=new String[3][10];
	int massageSignBig=0;//标记成功失败信息插入到第几个。
	int massageSignMed=0;
	int massageSignSma=0;
	int order[]=new int[30]; //存储车辆的插入顺序1大....
	int ord=0;
	ArrayList<Integer> aar=new ArrayList<Integer>();
	ParkingSystem(int a,int b,int c){
		Big=a;
		Medium=b;
		Small=c;
		totalBig=a;
		totalMedium=b;
		totalSmall=c;
	}
	
	public boolean addCar(int carType){
//		System.out.println("中车="+Medium);
		order[ord]=carType;
		ord+=1;
		Boolean b = false;
//		System.out.println("车 catype="+carType+"Mediu="+Medium);
		switch(carType){
		case 1:
			if(Big>0){
				Big-=1;
				massage[0][massageSignBig]=",true";
				massageSignBig+=1;
				b=true;
				}else{
					massage[0][massageSignBig]=",false";
					massageSignBig+=1;
				}
			break;
		case 2:
			if(Medium>0){
				Medium-=1;
//				System.out.print(",true");
				massage[1][massageSignMed]=",true";
				massageSignMed+=1;
				b=true;
				}else{
//					System.out.println("中车 catype="+carType+"Mediu="+Medium);
					massage[1][massageSignMed]=",false";
					massageSignMed+=1;
				}
			break;
		case 3:
			if(Small>0){
			Small-=1;
//			System.out.print(",true");
			massage[2][massageSignSma]=",true";
			massageSignSma+=1;
			b=true;
			} else{
				massage[2][massageSignSma]=",false";
				massageSignMed+=1;
			}
		break;
		}
//		else System.out.print(",false");
		return b;
	}
	
	
	public void print(){
		System.out.print("[null");
		int o=0;//大车
		int oo=0;
		int ooo=0;
		for(int i=0;i<order.length;i++){
			if(order[i]==1){
				System.out.print(massage[0][o]);
				o+=1;
			}else if(order[i]==2){
				System.out.print(massage[1][oo]);
				oo+=1;
			}else if(order[i]==3){
				System.out.print(massage[2][ooo]);
				ooo+=1;
			}
		}
		System.out.print("]");
	}
		

	
	public ArrayList<Integer> ExistingVehicle() {  //停车场现有车类及数目
		int nowBig=totalBig-Big;
		int nowMedium=totalMedium-Medium;
		int nowSmall=totalSmall-Small;
		int total=nowBig+nowMedium+nowSmall;
		ArrayList<Integer> arr = new ArrayList<Integer>();
		while(nowBig>0){
			arr.add(1);
		}
		while(nowMedium>0){
			arr.add(2);
		}
		while(nowSmall>0){
			arr.add(3);
		}
		return arr;
	}
	
	//[[0,1,2],[1],[2],[2],[3]]
	public static void main(String[] args) throws Exception{
		// TODO 自动生成的方法存根
		IParams params = IParking.parse();
//		System.out.println("big="+params.getBig());
		ParkingSystem ps = new ParkingSystem(params.getBig(),params.getMedium(),params.getSmall());
		ArrayList<Integer> plan =params.getPlanParking();//获得要插入的多辆车的信息
//		System.out.println("siz="+plan.isEmpty());
		siz=plan.size();
//		System.out.print("ok");
		for(int i=0;i<siz;i++){
			ps.addCar(plan.get(i));
		}
		ps.print();
	}


	

	
	
}
