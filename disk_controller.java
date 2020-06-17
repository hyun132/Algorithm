package test1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
class Task implements Comparable<Task>{
	int input_time;
	int take_time;
	
	public Task(int input_t,int take_t) {
		input_time=input_t;
		take_time=take_t;
	}

	public int getInput_time() {
		return input_time;
	}

	public int getTake_time() {
		return take_time;
	}

	@Override
	public int compareTo(Task o) {
//		오름차순 정렬
		if(this.take_time<o.take_time) return -1;
		else if(this.take_time>o.take_time) return 1;
		return 0;
	}

}
public class disk_controller {
	
	public static void main(String[] args) {
		int[][] jobs= {{24, 10}, {18, 39}, {34, 20}, {37, 5}, {47, 22}, {20, 47}, {15, 34}, {15, 2}, {35, 43}, {26, 1}};
//		int[][] jobs= {{0, 3}, {1, 9}, {2, 6}};
		solution(jobs);
	}
	public static int solution(int[][] jobs) {
		Arrays.sort(jobs, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[0]-o2[0];
			}
		});
		for (int i=0; i<jobs.length;i++) {
			System.out.print(Arrays.toString(jobs[i]));
		}
		PriorityQueue<Task> pq = new PriorityQueue<Task>();
		int idx=0;
		int time=0;
		int sum=0;
		Task node;
		while (true) {
			
			if (pq.isEmpty() && idx<jobs.length) {
				while(true) {
					pq.offer(new Task(jobs[idx][0], jobs[idx][1]));
					idx++;
					if (idx<jobs.length && jobs[idx][0]!=jobs[idx-1][0] || idx==jobs.length) {
						time+=jobs[idx-1][0]-time;
						break;
					}
				}
			}
			if (!pq.isEmpty()) {
				node=pq.poll();
//				sum+=time-node.getInput_time();
				for (int i=idx;i<jobs.length;i++) {
					if (time<=jobs[idx][0] && jobs[idx][0]<time+node.getTake_time()) {
						pq.offer(new Task(jobs[idx][0], jobs[idx][1]));
						idx++;
					}else {
						break;
					}
				} time+=node.getTake_time();
				sum+=(time-node.getInput_time());
			}
//			if (pq.isEmpty() && idx==jobs.length-1) break;
			else break;
			System.out.println(idx+" "+time+" "+sum);
		}
		System.out.println(idx+" "+time+" "+sum);
		System.out.println((int)sum/jobs.length);
        return (int)sum/jobs.length;
    }

}
