import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch
 {

    // Method to perform BFS traversal from the source vertex
    static void breadthFirstSearch(int[][] matrix, int source) 
    {
        boolean[] visited = new boolean[matrix.length];
        visited[source - 1] = true; // Mark the source as visited

        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);

        System.out.println("BFS traversal starting from vertex " + source + ":");
        while (!queue.isEmpty()) 
        {
            int current = queue.poll();
            System.out.print(current + " ");

            for (int i = 0; i < matrix.length; i++)
             {
                if (matrix[current - 1][i] == 1 && !visited[i])
                 {
                    queue.add(i + 1);
                    visited[i] = true;
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) 
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int vertices = 0;

        // Input number of vertices
        System.out.print("Enter the number of vertices: ");
        try
         {
            vertices = Integer.parseInt(br.readLine());
        } 
        catch (IOException e) 
        {
            System.out.println("Input error!");
            return;
        }

        // Input adjacency matrix
        int[][] matrix = new int[vertices][vertices];
        System.out.println("Enter the adjacency matrix (row-wise):");
        try
         {
            for (int i = 0; i < vertices; i++)
             {
                String[] row = br.readLine().split(" ");
                for (int j = 0; j < vertices; j++)
                 {
                    matrix[i][j] = Integer.parseInt(row[j]);
                }
            }
        }
         catch (IOException e) 
         {
            System.out.println("Input error!");
            return;
        }

        // Input source vertex
        int source = 0;
        System.out.print("Enter the source vertex (starting from 1): ");
        try 
        {
            source = Integer.parseInt(br.readLine());
        } 
        catch (IOException e)
         {
            System.out.println("Input error!");
            return;
        }

        // Perform BFS
        breadthFirstSearch(matrix, source);
    }
}
