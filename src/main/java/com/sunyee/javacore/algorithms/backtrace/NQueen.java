package com.sunyee.javacore.algorithms.backtrace;

import java.util.*;

/**
 * 给你一个 N×N 的棋盘，让你放置 N 个皇后，使得它们不能互相攻击。
 *
 * PS：皇后可以攻击同一行、同一列、左上左下右上右下四个方向的任意单位。
 *
 * 这个问题本质上跟全排列问题差不多，决策树的每一层表示棋盘上的每一行；每个节点可以做出的选择是，在该行的任意一列放置一个皇后。
 *
 *
 * 示例 1：
 * 输入：n = 4
 * 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * 解释：如上图所示，4 皇后问题存在两个不同的解法。
 *
 * Created by lishunyi on 2021/3/3
 */
public class NQueen {

    public List<List<String>> boardResult = new ArrayList<>();


    /* 输入棋盘边长 n，返回所有合法的放置 */
    public List<List<String>> sloveQueen(int n){
        // '.' 表示空，'Q' 表示皇后，初始化空棋盘。
        List<List<String>> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<String> stringBuilder = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                stringBuilder.add(".");
            }
            board.add(stringBuilder);
        }
        backTrace(board, 0);
        return boardResult;
    }

    // 路径：board 中小于 row 的那些行都已经成功放置了皇后
    // 选择列表：第 row 行的所有列都是放置皇后的选择
    // 结束条件：row 超过 board 的最后一行
    private void backTrace(List<List<String>> board, int row){
        //触发结束条件
        if (row == board.size()){
            List<String> flag = new ArrayList<>();
            for (List<String> boardRow: board){
                String s = null;
                for (String ss: boardRow){
                    s = s == null ? ss: s + ss;
                }
                flag.add(s);
            }
            boardResult.add(flag);
            return;
        }
        int cols = board.size();
        for (int col = 0; col < cols; col++){
            if (!isValid(board, row, col)){
                continue;   //不合法选择，过滤
            }
            //做选择
            board.get(row).set(col, "Q");
            //进入下一行做决策
            backTrace(board, row + 1);
            //撤销选择
            board.get(row).set(col, ".");
        }

    }

    private boolean isValid(List<List<String>> board, int row, int col){
        // 检查列
        for (int i = 0; i < row ; i++){
            if ("Q".equals(board.get(i).get(col))){
                return false;
            }
        }
        // 检查左上方
        for (int i = row - 1, j = col - 1; i >=0 && j >=0; i--, j--){
            if ("Q".equals(board.get(i).get(j))){
                return false;
            }
        }
        // 检查右上方
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.size(); i--, j++){
            if ("Q".equals(board.get(i).get(j))){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<List<String>> boards = new NQueen().sloveQueen(4);
        System.out.println(Arrays.deepToString(boards.toArray()));
    }
}

