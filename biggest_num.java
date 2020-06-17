package test1;

import java.util.Arrays;
import java.util.Comparator;

public class biggest_num {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers= {0,0,0,0};
//		int[] numbers= {3, 30, 34, 5, 9};
		solution(numbers);
	}

	public static String solution(int[] numbers) {
		String answer = "";
		String[] num= new String[numbers.length];
		for(int i=0;i<numbers.length;i++) {
			num[i]=""+numbers[i];
		}
		Arrays.sort(num,Comparator.reverseOrder());
		Arrays.sort(num,new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if (Integer.parseInt(o1+o2) > Integer.parseInt(o2+o1)) return -1;
				else return 1;
					
//				for (int i=0;i<Math.min(o1.length(), o2.length());i++) {
//					if (o1.charAt(i)==o2.charAt(i)) {
//						if (o1.length()>o2.length()) {
//							if (o1.charAt(i+1)>o2.charAt(i)) return -1;
//							else return 1;
//						}
//						else if (o1.length()<o2.length()) {
//							if (o2.charAt(i+1)>o1.charAt(i)) return 1;
//							else return -1;
//						}
//					}
//					else return o2.charAt(i)-o1.charAt(i);
//				}
//				return 0;
			}
		});
		System.out.println(Arrays.toString(num));
//		StringBuilder sb =new StringBuilder();
        for (String string:num) {
        	answer+=string;
        }
        System.out.println(answer);
        if (answer.charAt(0)=='0') return "0";
        else return answer;
    }
	
}
