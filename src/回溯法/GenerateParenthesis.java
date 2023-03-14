package 回溯法;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

    //dfs
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        generate(n, n, "");
        return res;
    }

    private void generate(int left, int right, String curStr) {
        if (left == 0 && right == 0) {
            res.add(curStr);
            return;
        }

        if (left > 0) {
            generate(left - 1, right, curStr + "(");
        }
        if (right > left) {
            generate(left, right - 1, curStr + ")");
        }
    }

    public static void main(String[] args) {
        GenerateParenthesis s = new GenerateParenthesis();
        s.generateParenthesis(3);
        System.out.println(s.generateParenthesis(3));
    }
}

