package com.xk;

public class Test {
    /*计算数组和，出入int类型数组*/
    public static int arraySum(int[] ints){
        int sum=0;
        for (int i = 0; i < ints.length; i++) {
            sum+=ints[i];
        }
        return sum;
    }
    /*计算三角形面积，传入底边和高*/
    public static double triangularArea(double base,double height){
        double area=0;
        area=base*height/2;
        return area;
    }
    /*区分一个字符串大小写，先输出大写，后输出小写，传入一个字符串*/
    public static void stringCase(String s){
        String capital="";
        String lowercase="";
        for (int i = 0; i < s.length(); i++) {
            char ch=s.charAt(i);
            if (ch >='A' && ch<= 'Z'){
                capital+=ch;
            }else if (ch >='a' && ch<= 'z'){
                lowercase+=ch;
            }
        }
        System.out.println(capital);
        System.out.println(lowercase);
    }
    /*计算一个字符串中b出现了几次*/
    private static int sum=0;
    public static int frequency(String s){
        String string;
        if (s.indexOf("b") != -1){
            sum++;
            string=s.substring(s.indexOf("b")+1);
            frequency(string);
        }
        return sum;
    }


    public static void main(String[] args) {
        int[] ints=new int[]{1,2,3};
        System.out.println(arraySum(ints));
        System.out.println(triangularArea(4,5));
        stringCase("Zhangxiaoli");
        System.out.println(frequency("absdfghbsssssbaaaaab"));

    }


}
