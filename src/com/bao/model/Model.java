package com.bao.model;



public interface Model {
	
	//��ö���������жϵ�ǰ����
	public enum Current {TWO(2),EIGHT(8),TEN(10),SIXTEEN(16);
	//��Ա����
	public int value;
	//ö����Ĺ��췽��
    private Current(int value) {
        this.value = value;
    }		
	};
	
	public class Dangwei{
		public String name;
		public double value;
		public int index;
		Dangwei(String name,double value,int index){
			this.name=name;
			this.value=value;
			this.index=index;
		}
	}
	
	public class Leixing{
		public Dangwei dangwei;
		public String name;
		public int index;
		public Leixing(String name,Dangwei dangwei,int index) {
			this.name=name;
			this.dangwei=dangwei;
			this.index=index;
		}
	}
	
	public static Dangwei QIANGKE=new Dangwei("ǧ��", 1.0, 0);
	public static Dangwei KE=new Dangwei("��", 1000, 1);
	public static Dangwei BANG=new Dangwei("��", 2.205, 2);
	public static Dangwei DUN=new Dangwei("��", 0.001, 3);
	public static Dangwei JIN=new Dangwei("��", 2.0, 4);
	public static Dangwei LIANG=new Dangwei("��", 20.0, 5);
	
	public static Dangwei MI2=new Dangwei("ƽ����", 1.0, 0);
	public static Dangwei QIANMI2=new Dangwei("ƽ��ǧ��", 0.000001, 1);
	public static Dangwei MU=new Dangwei("Ķ(�й�)", 0.0015, 2);
	public static Dangwei GONGMU=new Dangwei("��Ķ", 0.01, 3);
	public static Dangwei YINGMU=new Dangwei("ӢĶ", 0.000247, 4);
	public static Dangwei GONGQING=new Dangwei("����", 0.0001, 5);

	public static Dangwei MI=new Dangwei("��", 1.0, 0);
	public static Dangwei GONGLI=new Dangwei("����", 0.001, 1);
	public static Dangwei CHI=new Dangwei("��(�й�)", 3.0, 2);
	public static Dangwei CUN=new Dangwei("��(�й�)", 30.0, 3);
	public static Dangwei LI=new Dangwei("��(�й�)", 0.002, 4);
	public static Dangwei YINGCHI=new Dangwei("Ӣ��", 3.28, 5);
	
	public static Dangwei CHN=new Dangwei("�����", 1.0, 0);
	public static Dangwei USA=new Dangwei("��Ԫ", 0.1648, 1);
	public static Dangwei HK=new Dangwei("��Ԫ", 1.278, 2);
	public static Dangwei TW=new Dangwei("̨��", 4.986, 3);
	public static Dangwei EUR=new Dangwei("ŷԪ", 0.1204, 4);
	public static Dangwei UK=new Dangwei("Ӣ��", 0.0985, 5);
	
	public static Leixing LENGTH=new Leixing("����",MI,0);
	public static Leixing SQUARE=new Leixing("���",MI2,1);
	public static Leixing MASS=new Leixing("����",QIANGKE,2);
	public static Leixing MONEY=new Leixing("����",CHN,3);
}
