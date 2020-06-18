package test1;

public class integer_triangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] triangle= {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
		solution(triangle);
	}
	
	public static int solution(int[][] triangle) {
		int[][] visited=new int[triangle.length][triangle.length];
		int answer = func(0, 0, triangle,visited);
		System.out.println(answer);
        return answer;
    }
	
	public static int func(int idx,int depth ,int[][] triangle, int[][] visited) {
		if (depth==triangle.length-1) return triangle[depth][idx];
		
		if (visited[depth][idx] !=0) {
			return visited[depth][idx];
		}
		else {
			visited[depth][idx] = triangle[depth][idx]+Math.max(func(idx, depth+1, triangle,visited),func(idx+1, depth+1, triangle,visited));
			return visited[depth][idx];
		}
	}
}
