package com.nacaroglu.dsa.practice.recursion;

public class DecimalToBinary {

	public static void main(String[] args) {
		
		System.out.println(decimalToBinary(9));

	}
	
	public static int decimalToBinary(int n) {
        
        StringBuilder sb = new StringBuilder();

        d2b(n, sb);       
        
        String x = "";
        

        int result = 0;
                
        for(int i=0; i<sb.length(); i++){
            result = result *10 + sb.charAt(i) - '0';
        }

        return result;
    }

    public static void d2b(int n, StringBuilder sb){

        if(n<2){
        	sb.append(n);
            return;
        }

       sb.append(n%2);
        d2b(n/2, sb);
    }

}
