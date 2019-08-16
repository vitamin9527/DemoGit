package demo;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class demo2 {
	public static final int Triple_Attack=3;
	public int round=0;//回合
	public HashMap<Integer, String> roundFighMap=new HashMap<Integer, String>();//每次回合的对战记录
	person p1=new person();//甲
	person p2=new person();//乙
	public int num=0;//合局
	public void Game() {
		Random rounm=new Random();
		while (true) {
			if(p1.getWin()==Triple_Attack||p2.getWin()==Triple_Attack) {
				break;
			}
			if(p1.getType()!=1) {
				ArrayList<Integer> list=new ArrayList<Integer>();
				list.add(0);//剪刀
				list.add(1);//石头
				list.add(2);//布
				p1.setList(list);
			}
			if(p2.getType()!=1) {
				ArrayList<Integer> list1=new ArrayList<Integer>();
				list1.add(0);//剪刀
				list1.add(1);//石头
				list1.add(2);//布
				p2.setList(list1);		
			}
//			System.out.println("甲的对战表是"+Arrays.toString(p1.getList().toArray()));
//			System.out.println("乙的对战表是"+Arrays.toString(p2.getList().toArray()));
			 int roum1=rounm.nextInt(3);
			 int roum2=rounm.nextInt(3);
			 //获取出拳的类型/
			int num1=p1.getList().get(roum1);
			int num2=p2.getList().get(roum2);
//			System.out.println("甲的出拳的类型是"+num1);
//			System.out.println("乙的出拳的类型是"+num2);
			if(num1==2) {//如果甲出了布 下次不会再出布（2）
				int rumm=rounm.nextInt(2);
				p1.getList().set(2, rumm);
				p1.setType(1);
			}else {
				p1.setType(0);
			}
			if(num2==1) {//如果乙出了石头 下次一定会出石头（1）
				p2.getList().set(0, 1);
				p2.getList().set(2, 1);
				p2.setType(1);
			}else {
				p2.setType(0);
			}
			
			String particulars=null;//胜负 和 值
			//和局
			if(num1==num2) {
					p1.setWin(0);
					p2.setWin(0);
					num++;
//				System.out.println("和局");
				particulars="和局";
			}else if ((num1+num2)%2!=0) {
				//说明这两个值挨着
				if(num1>num2) {
					//大的值胜
					p1.setWin(p1.getWin()+1);
					p2.setWin(0);
					p1.setNum(p1.getNum()+1);
//				System.out.println("甲胜");
				particulars="甲胜";
				}
				else {
					p2.setWin(p2.getWin()+1);
					p1.setWin(0);
					p2.setNum(p2.getNum()+1);
//				System.out.println("乙胜");
				particulars="乙胜";
				}
			}else {
				//说明不挨着
				if(num1<num2) {
					//小的值胜
					p1.setWin(p1.getWin()+1);
					p2.setWin(0);
					p1.setNum(p1.getNum()+1);
//				System.out.println("甲胜");
				particulars="甲胜";
				}
				else {
					p2.setWin(p2.getWin()+1);
					p1.setWin(0);
					p2.setNum(p2.getNum()+1);
//				System.out.println("乙胜");
				particulars="乙胜";
				}
			}
			round++;
			//每次回合的对战记录
			//甲
			String str=null;
			if(num1==0) {
				str="剪刀";
			}else if(num1==1){
				str="石头";
			}else {
				str="布";
			}
			//乙
			String str1=null;
			if(num2==0) {
				str1="剪刀";
			}else if(num2==1){
				str1="石头";
			}else {
				str1="布";
			}
			roundFighMap.put(round, "甲出拳："+str+"		乙出拳："+str1+"        "+particulars+"		当前回合次数是："+round);
//			System.out.println("		甲的出拳			："+str);
//			System.out.println("		乙的出拳			："+str1);
//			System.out.println("	"+particulars);
		}
	}
	public void query(HashMap<Integer, String> map) {
		System.out.println("请输入你要查询的第几次回合对战");
		Scanner scnn=new Scanner(System.in);
		Integer tegser;
		try {
			tegser = scnn.nextInt();
			System.out.println("可查看得最大回合数是："+map.size());
			if(tegser<=map.size()&&tegser>0) {
				System.out.println(map.get(tegser));
			}else {
				System.out.println("可查看得最大回合数是："+map.size());
				System.out.println("请重新输入");
				query(map);
			}
		} catch (Exception e) {
			System.out.println("可查看得最大回合数是："+map.size());
			System.out.println("请重新输入");
			query(map);
		}
	}
	
	public static void main(String[] args) {
		demo2 de=new demo2();
		de.Game();
		System.out.println();
		System.out.println("	总回合次数是			:"+de.round);
		System.out.println("	甲的得分是			:"+de.p1.getNum());
		System.out.println("	乙的得分是			:"+de.p2.getNum());
		System.out.println("	合局的次数是			:"+de.num);
		if(Triple_Attack==de.p1.getWin()) {
			System.out.println("甲方胜利");
			//胜率是
			Double doub=((double)de.p1.getNum()/de.round);
			doub=(double)Math.round(doub*100)/100;
			System.out.println("	甲方的胜率是			："+doub*100+"%");
			 doub=((double)de.p2.getNum()/de.round);
			doub=(double)Math.round(doub*100)/100;
			System.out.println("	乙方的胜率是			："+doub*100+"%");
		}else {
			System.out.println("	乙方胜利");
			Double doub=((double)de.p2.getNum()/de.round);
			doub=(double)Math.round(doub*100)/100;
			System.out.println("	乙方的胜率是			："+doub*100+"%");
			 doub=((double)de.p1.getNum()/de.round);
			doub=(double)Math.round(doub*100)/100;
			System.out.println("	甲方的胜率是			："+doub*100+"%");
			
		}
		de.query(de.roundFighMap);
	}
	
	
	
}
