package AlgoRehearsal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ArrayBlockingQueue;

public class BFS {
	int color[],pred[],dist[];
	private ArrayList<Integer>[] graph;
	
	public BFS(ArrayList<Integer> g[]) {
		graph = g;
		init();
		algo(0);
	}
	
	private void algo(int source) {
		ArrayBlockingQueue<Integer> q = new ArrayBlockingQueue<>(graph.length);
		q.add(source);
		dist[source] = 0;
		while(!q.isEmpty()){
			int u = q.poll();
			for (Integer v : graph[u]) {
				if(color[v] == 0){
					color[v] = 1;
					pred[v] = u;
					dist[v] = dist[u]+1;
					q.add(v);
				}
				
			}
			color[u] = 2;
		}
		
		
	}

	private void init() {
		color = new int[graph.length];
		pred = new int[graph.length];
		dist = new int[graph.length];
		Arrays.fill(pred, -1);
		Arrays.fill(dist, Integer.MAX_VALUE);
		
	}

	public static void main(String[] args) {
		ArrayList<Integer> g[] = new ArrayList[7];
		for (int i = 0; i < g.length; i++) {
			g[i] = new ArrayList<>();
		}
		g[0].add(1);
		g[1].add(0);
		g[1].add(2);
		g[1].add(5);
		g[2].add(1);
		g[2].add(3);
		g[3].add(2);
		g[3].add(4);
		g[4].add(3);
		g[5].add(1);
		g[5].add(6);
		g[6].add(5);
		BFS b = new BFS(g);
		b.printMats();
	//	System.out.println(b.getPath(0, 5));
	}

	private void printMats() {
		System.out.println("====Color====");
		System.out.println(Arrays.toString(color));
		System.out.println("=============");
		System.out.println("====Pred=====");
		System.out.println(Arrays.toString(pred));
		System.out.println("=============");
		System.out.println("====Dist=====");
		System.out.println(Arrays.toString(dist));
		System.out.println("=============");
	}
}
