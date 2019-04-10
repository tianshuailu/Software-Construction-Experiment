package P1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MagicSquare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		boolean result1,result2,result3,result4,result5,result6;
		System.out.print("1.txt ");
		result1 = isLegalMagicSquare("C:\\1.txt");
		System.out.println(result1);
		System.out.print("2.txt ");
		result2 = isLegalMagicSquare("C:\\2.txt");
		System.out.println(result2);
		System.out.print("3.txt ");
		result3 = isLegalMagicSquare("C:\\3.txt");
		System.out.println(result3);
		System.out.print("4.txt ");
		result4 = isLegalMagicSquare("C:\\4.txt");
		System.out.println(result4);
		System.out.print("5.txt ");
		result5 = isLegalMagicSquare("C:\\5.txt");
		System.out.println(result5);
		System.out.print("6.txt ");
		result6 = generateMagicSquare(-1);
		System.out.println(result6);
		System.out.print("6.txt ");
		result6 = isLegalMagicSquare("C:\\Users\\LTS\\workspace\\Lab1_1163710208\\src\\P1\\txt\\6.txt");
		System.out.println(result6);
	}
	
	static boolean isLegalMagicSquare(String fileName) {
		
		String str[] = new String[1000];
		int ms[][] = new int[1000][1000];
		int i=0;
		int sum=0;
		int s=0;
        
        try{
			File file  = new File(fileName);
			BufferedReader reader = new BufferedReader(new FileReader(file));
            while((str[i]=reader.readLine())!=null){
            	i++;
            }
            reader.close();
	    }
		catch(IOException ex){
	        System.out.print("读取文件时出错 ");
		}
        //转换成数据矩阵
        for(int j=0;j<i;j++){
        	String[] m = str[j].split("\t");
        	if(i != m.length){
        	    System.out.print("该文件不是矩阵\t");
        	    return false;
        	}	
        	for(int k=0;k<i;k++){
        		try{
        		    ms[j][k] = Integer.valueOf(m[k]);
        		}
        		catch(NumberFormatException ex){
        		    System.out.print("矩阵有数据为非正整数\t");
        		    return false;
        		}
        		if(ms[j][k]<=0){
        		    System.out.print("矩阵有数据为非正整数\t");
        		    return false;
        		}
        	}
        }
        //求第一行的和
        for(int j=0;j<i;j++){
        	sum += ms[0][j];
        }
        //检验每一行是否相等
        for(int j=0;j<i;j++){
            for(int k=0;k<i;k++){
            	s += ms[j][k];
            }
            if(sum != s) return false;
            s=0;
        }
        //检验每一列是否相等
        for(int j=0;j<i;j++){
            for(int k=0;k<i;k++){
            	s += ms[k][j];
            }
            if(sum != s) return false;
            s=0;
        }
        //检验对角线是否相等
        for(int j=0;j<i;j++){
            s += ms[j][j];
        }
        if(sum != s) return false;
        s=0;
        for(int j=0;j<i;j++){
            s += ms[j][i-j-1];
        }
        if(sum != s) return false;
        s=0;
        System.out.print("该矩阵是MagicSqure\t");
        return true;
	}
    
    public static boolean generateMagicSquare(int n) {
    	if(n % 2 == 0){
    		System.out.print("n不能为偶数\t");
    		return false;
    	}
    	if(n < 0){
    		System.out.print("n不能为负数\t");
    		return false;
    	}
        int magic[][] = new int[n][n];
        int row = 0, col = n / 2, i, j, square = n * n;
        for (i = 1; i <= square; i++) {
       	    magic[row][col] = i;
        	if (i % n == 0)
        		row++;
        	else {
        		if (row == 0)
        			row = n - 1;
        		else
        			row--;
        		if (col == (n - 1))
        			col = 0;
        		else
        			col++;
        	}
        }
        try{
        	File file = new File("C:\\Users\\LTS\\workspace\\Lab1_1163710208\\src\\P1\\txt\\6.txt");
        	BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        	for (i = 0; i < n; i++) {
        		for (j = 0; j < n; j++)
        			writer.write(magic[i][j] + "\t");
        		writer.newLine();
        	}
        	writer.flush();
        	writer.close();
        }catch(IOException ex){
        	System.out.println("写入文件时出错 ");
        	return false;
        }
        System.out.print("创建MagicSqure成功 ");
        return true;
	}
}