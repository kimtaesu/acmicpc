package acmicpc.tree;

import org.junit.Test;

public class B1991 {
    String[] stringTree = new String[]{
            "A B C",
            "B D .",
            "C E F",
            "E . .",
            "F . G",
            "D . .",
            "G . ."
    };

    @Test
    public void test() {
        for (String s : stringTree) {
            s.split(" ");


        }

        solution(7, new String[]{
                "A B C",
                "B D .",
                "C E F",
                "E . .",
                "F . G",
                "D . .",
                "G . ."});
    }

    public void solution(int n, String[] tree) {

    }
}

class TreeNode {
    char data;
    TreeNode left;
    TreeNode right;

    public TreeNode(char data) {
        this.data = data;
    }
}