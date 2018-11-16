import java.util.Scanner;
import java.util.*;

public class Base64_hw {

	public static void main(String[] args) {
		
		final int bit_eight = 8 , bit_six = 6;
		char[] basetable= {'A','B','C','D','E','F','G','H','I','J','K','L','M','N',
                'O','P','Q','R','S','T','U','V','W','X','Y','Z',
                'a','b','c','d','e','f','g','h','i','j','k','l','m','n',
                'o','p','q','r','s','t','u','v','w','x','y','z',
                '0','1','2','3','4','5','6','7','8','9','+','/'};		
		Scanner in = new Scanner(System.in);	
		String input = in.nextLine();
				
		char[] input_ch=input.toCharArray(); //char값으로 변경
		String bin_input = "";

		Queue<Character> queue = new LinkedList<Character>();
	
		for(int i = 0; i< input.length(); i++)
		{
			 bin_input =  String.format("%8s", Integer.toBinaryString(input_ch[i])).replace(' ','0') ; //8비트 2진수
			 char[] input_bin = bin_input.toCharArray();

			 for(int j = 0; j < bit_eight; j++)
		         queue.offer( input_bin[j] );
			// bin_input = "";
		}					

		int i = bit_six , sum = 0;
		while(!queue.isEmpty())
		{			
			if(queue.poll() == '1') //삼항연산자
				sum += (int) Math.pow(2, (i-1) );
			//queue.poll();
			i --;
			
			if(i == 0 || queue.isEmpty())
			{
				System.out.print( basetable[sum] );
				sum = 0;
				i = bit_six;
			}
		}		

		if(input.length() % 3 == 1)  //패딩 연산으로고치기
			System.out.print("==");
		else if(input.length() % 3 == 2)
			System.out.print("=");
	}
}