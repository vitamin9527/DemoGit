package demo;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class demo2 {
	public static final int Triple_Attack=3;
	public int round=0;//�غ�
	public HashMap<Integer, String> roundFighMap=new HashMap<Integer, String>();//ÿ�λغϵĶ�ս��¼
	person p1=new person();//��
	person p2=new person();//��
	public int num=0;//�Ͼ�
	public void Game() {
		Random rounm=new Random();
		while (true) {
			if(p1.getWin()==Triple_Attack||p2.getWin()==Triple_Attack) {
				break;
			}
			if(p1.getType()!=1) {
				ArrayList<Integer> list=new ArrayList<Integer>();
				list.add(0);//����
				list.add(1);//ʯͷ
				list.add(2);//��
				p1.setList(list);
			}
			if(p2.getType()!=1) {
				ArrayList<Integer> list1=new ArrayList<Integer>();
				list1.add(0);//����
				list1.add(1);//ʯͷ
				list1.add(2);//��
				p2.setList(list1);		
			}
//			System.out.println("�׵Ķ�ս����"+Arrays.toString(p1.getList().toArray()));
//			System.out.println("�ҵĶ�ս����"+Arrays.toString(p2.getList().toArray()));
			 int roum1=rounm.nextInt(3);
			 int roum2=rounm.nextInt(3);
			 //��ȡ��ȭ������/
			int num1=p1.getList().get(roum1);
			int num2=p2.getList().get(roum2);
//			System.out.println("�׵ĳ�ȭ��������"+num1);
//			System.out.println("�ҵĳ�ȭ��������"+num2);
			if(num1==2) {//����׳��˲� �´β����ٳ�����2��
				int rumm=rounm.nextInt(2);
				p1.getList().set(2, rumm);
				p1.setType(1);
			}else {
				p1.setType(0);
			}
			if(num2==1) {//����ҳ���ʯͷ �´�һ�����ʯͷ��1��
				p2.getList().set(0, 1);
				p2.getList().set(2, 1);
				p2.setType(1);
			}else {
				p2.setType(0);
			}
			
			String particulars=null;//ʤ�� �� ֵ
			//�;�
			if(num1==num2) {
					p1.setWin(0);
					p2.setWin(0);
					num++;
//				System.out.println("�;�");
				particulars="�;�";
			}else if ((num1+num2)%2!=0) {
				//˵��������ֵ����
				if(num1>num2) {
					//���ֵʤ
					p1.setWin(p1.getWin()+1);
					p2.setWin(0);
					p1.setNum(p1.getNum()+1);
//				System.out.println("��ʤ");
				particulars="��ʤ";
				}
				else {
					p2.setWin(p2.getWin()+1);
					p1.setWin(0);
					p2.setNum(p2.getNum()+1);
//				System.out.println("��ʤ");
				particulars="��ʤ";
				}
			}else {
				//˵��������
				if(num1<num2) {
					//С��ֵʤ
					p1.setWin(p1.getWin()+1);
					p2.setWin(0);
					p1.setNum(p1.getNum()+1);
//				System.out.println("��ʤ");
				particulars="��ʤ";
				}
				else {
					p2.setWin(p2.getWin()+1);
					p1.setWin(0);
					p2.setNum(p2.getNum()+1);
//				System.out.println("��ʤ");
				particulars="��ʤ";
				}
			}
			round++;
			//ÿ�λغϵĶ�ս��¼
			//��
			String str=null;
			if(num1==0) {
				str="����";
			}else if(num1==1){
				str="ʯͷ";
			}else {
				str="��";
			}
			//��
			String str1=null;
			if(num2==0) {
				str1="����";
			}else if(num2==1){
				str1="ʯͷ";
			}else {
				str1="��";
			}
			roundFighMap.put(round, "�׳�ȭ��"+str+"		�ҳ�ȭ��"+str1+"        "+particulars+"		��ǰ�غϴ����ǣ�"+round);
//			System.out.println("		�׵ĳ�ȭ			��"+str);
//			System.out.println("		�ҵĳ�ȭ			��"+str1);
//			System.out.println("	"+particulars);
		}
	}
	public void query(HashMap<Integer, String> map) {
		System.out.println("��������Ҫ��ѯ�ĵڼ��λغ϶�ս");
		Scanner scnn=new Scanner(System.in);
		Integer tegser;
		try {
			tegser = scnn.nextInt();
			System.out.println("�ɲ鿴�����غ����ǣ�"+map.size());
			if(tegser<=map.size()&&tegser>0) {
				System.out.println(map.get(tegser));
			}else {
				System.out.println("�ɲ鿴�����غ����ǣ�"+map.size());
				System.out.println("����������");
				query(map);
			}
		} catch (Exception e) {
			System.out.println("�ɲ鿴�����غ����ǣ�"+map.size());
			System.out.println("����������");
			query(map);
		}
	}
	
	public static void main(String[] args) {
		demo2 de=new demo2();
		de.Game();
		System.out.println();
		System.out.println("	�ܻغϴ�����			:"+de.round);
		System.out.println("	�׵ĵ÷���			:"+de.p1.getNum());
		System.out.println("	�ҵĵ÷���			:"+de.p2.getNum());
		System.out.println("	�ϾֵĴ�����			:"+de.num);
		if(Triple_Attack==de.p1.getWin()) {
			System.out.println("�׷�ʤ��");
			//ʤ����
			Double doub=((double)de.p1.getNum()/de.round);
			doub=(double)Math.round(doub*100)/100;
			System.out.println("	�׷���ʤ����			��"+doub*100+"%");
			 doub=((double)de.p2.getNum()/de.round);
			doub=(double)Math.round(doub*100)/100;
			System.out.println("	�ҷ���ʤ����			��"+doub*100+"%");
		}else {
			System.out.println("	�ҷ�ʤ��");
			Double doub=((double)de.p2.getNum()/de.round);
			doub=(double)Math.round(doub*100)/100;
			System.out.println("	�ҷ���ʤ����			��"+doub*100+"%");
			 doub=((double)de.p1.getNum()/de.round);
			doub=(double)Math.round(doub*100)/100;
			System.out.println("	�׷���ʤ����			��"+doub*100+"%");
			
		}
		de.query(de.roundFighMap);
	}
	
	
	
}
