package uz.bakhromjon;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * @author : Bakhromjon Khasanboyev
 **/
public class Graph {
    private Map<Integer, List<Integer>> adjVertices;

    public Graph() {
        this.adjVertices = new HashMap<>();
    }

    public void dfs(int start) {
        Stack<Integer> stack = new Stack<>();
        boolean[] isVisited = new boolean[adjVertices.size()];
        stack.push(start);
        while (!stack.isEmpty()) {
            int current = stack.pop();
            if (!isVisited[current]) {
                isVisited[current] = true;
                visit(current);
                for (int dest : adjVertices.get(current)) {
                    if (!isVisited[dest])
                        stack.push(dest);
                }
            }
        }
    }

    private void visit(int value) {
        System.out.print(" " + value);
    }
}
