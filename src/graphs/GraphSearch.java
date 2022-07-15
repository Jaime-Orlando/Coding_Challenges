package graphs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GraphSearch 
{
	
	int numberOfVertices;
	
	// This is a list of lists of Integers
	ArrayList<Integer> adjacencyList[];
	
	@SuppressWarnings("unchecked")
	public GraphSearch(int numberOfVertices) 
	{
		this.numberOfVertices = numberOfVertices;
		adjacencyList = new ArrayList[numberOfVertices];
		for(int i = 0; i < numberOfVertices; i++) {
			// We create an adjacency list for each node
			adjacencyList[i] = new ArrayList<>();
		}
	}
	
	void addEdge(int vertex1, int vertex2) 
	{
		adjacencyList[vertex1].add(vertex2);
	}
	
	void bfs(int sourceVertex) 
	{
		boolean[] visited = new boolean[numberOfVertices];
		Queue<Integer> queue = new LinkedList<>();
		visited[sourceVertex] = true;
		queue.add(sourceVertex);
		while(!queue.isEmpty()) 
		{
			sourceVertex = queue.poll();
			System.out.println(sourceVertex);
			Iterator<Integer> adjacentIterator = adjacencyList[sourceVertex].iterator();
			while(adjacentIterator.hasNext()) 
			{
				int nextAdjacent = adjacentIterator.next();
				if(!visited[nextAdjacent]) 
				{
					visited[nextAdjacent] = true;
					queue.add(nextAdjacent);
				}
			}
		}
	}
	
	void dfs(int sourceVertex) 
	{
		boolean[] visited = new boolean[this.numberOfVertices];
		Stack<Integer> stack = new Stack<>();
		int node;
		stack.push(sourceVertex);
		while(!stack.isEmpty()) 
		{
			sourceVertex = stack.pop();
			for(int i = 0; i < adjacencyList[sourceVertex].size(); i++) 
			{
				node = adjacencyList[sourceVertex].get(i);
				if(!visited[node]) 
				{
					stack.push(node);
				}
			}
			
			if(visited[sourceVertex] == false)
			{
				System.out.println(sourceVertex);
				visited[sourceVertex] = true;
			}
		}
	}
	
	public static void main(String[] args)
	{
		GraphSearch gs = new GraphSearch(6);
		gs.addEdge(0, 1);
		gs.addEdge(0, 2);
		gs.addEdge(0, 5);
		gs.addEdge(1, 0);
		gs.addEdge(1, 2);
		gs.addEdge(2, 0);
		gs.addEdge(2, 1);
		gs.addEdge(2, 3);
		gs.addEdge(2, 4);
		gs.addEdge(3, 2);
		gs.addEdge(4, 2);
		gs.addEdge(4, 5);
		gs.addEdge(5, 0);
		gs.addEdge(5, 4);
		
		gs.bfs(0);
		System.out.println("----");
		gs.dfs(0);
	}
	

}
