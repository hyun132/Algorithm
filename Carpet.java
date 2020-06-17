package test1;

public class Carpet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution(10,2);
//		solution(8,1);
//		solution(24,24);
	}
	
	public static int[] solution(int brown, int yellow) {
		int[] answer= new int[2];
		int size=brown+yellow;
		for(int x=brown; x>2;x--) {
			for (int y=3;x*y<=size;y++) {
				if (x*y==size && (x-2)*(y-2)==yellow ) {
					answer[0]=x;
					answer[1]=y;
					System.out.println(x+" "+y);
					return answer;
				}
			}
		}
        return answer;
    }

}
