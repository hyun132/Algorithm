package test1;

public class metal_stick {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String arrangement = "()(((()())(())()))(())";
		solution(arrangement);
	}

	public static int solution(String arrangement) {
		arrangement = arrangement.replace("()", "X");
//		System.out.println(arrangement);

//		Stack stack = new Stack();
		int sum = 0;
		int numOfStick = 0;
		for (int i = 0; i < arrangement.length(); i++) {
//			System.out.println(stack);
			if (numOfStick == 0 && arrangement.charAt(i) != 'X') {
//				stack.add(arrangement.charAt(i));
				numOfStick++;
				continue;
			}
			if ('(' == arrangement.charAt(i)) {
//				stack.add(arrangement.charAt(i));
				numOfStick++;
			} else if ((')' == arrangement.charAt(i))) {
//				stack.pop();
				numOfStick--;
				sum += 1;
			} else {
				sum += numOfStick;
			}
		}
		System.out.println(sum);
		return sum;
	}

}
