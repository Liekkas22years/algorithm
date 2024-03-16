package leetcode.other;

import java.util.ArrayList;
import java.util.Arrays;

//有效的数独
//暴力法
/*
执行用时：4 ms, 在所有 Java 提交中击败了8.81%的用户
内存消耗：41.2 MB, 在所有 Java 提交中击败了5.12%的用户
 */
public class L_36_1 {
    public static boolean isValidSudoku(char[][] board) {
        for(int i=0;i<9;i++){
            ArrayList<String> arrayList =new ArrayList(Arrays.asList('1','2','3','4','5','6','7','8','9'));
            for (int j=0;j<9;j++){
                if(board[i][j]=='.'){
                    continue;
                }
                if(arrayList.contains(board[i][j])){
                    arrayList.set(board[i][j]-49,".");
                }
                else {
                    return false;
                }

            }
        }
        for(int i=0;i<9;i++){
            ArrayList<String> arrayList =new ArrayList(Arrays.asList('1','2','3','4','5','6','7','8','9'));
            for (int j=0;j<9;j++){
                if(board[j][i]=='.'){
                    continue;
                }
                if(arrayList.contains(board[j][i])){
                    arrayList.set(board[j][i]-49,".");
                }
                else {
                    return false;
                }

            }
        }
        ArrayList<String> arrayList =new ArrayList(Arrays.asList('1','2','3','4','5','6','7','8','9'));
        for(int i=0;i<3;i++){

            for (int j=0;j<3;j++){
                if(board[i][j]=='.'){
                    continue;
                }
                if(arrayList.contains(board[i][j])){
                    arrayList.set(board[i][j]-49,".");
                }
                else {
                    return false;
                }

            }
        }
        ArrayList<String> arrayList1 =new ArrayList(Arrays.asList('1','2','3','4','5','6','7','8','9'));
        for(int i=3;i<6;i++){

            for (int j=0;j<3;j++){
                if(board[i][j]=='.'){
                    continue;
                }
                if(arrayList1.contains(board[i][j])){
                    arrayList1.set(board[i][j]-49,".");
                }
                else {
                    return false;
                }

            }
        }
        ArrayList<String> arrayList2 =new ArrayList(Arrays.asList('1','2','3','4','5','6','7','8','9'));
        for(int i=6;i<9;i++){

            for (int j=0;j<3;j++){
                if(board[i][j]=='.'){
                    continue;
                }
                if(arrayList2.contains(board[i][j])){
                    arrayList2.set(board[i][j]-49,".");
                }
                else {
                    return false;
                }

            }
        }
        ArrayList<String> arrayList3 =new ArrayList(Arrays.asList('1','2','3','4','5','6','7','8','9'));
        for(int i=0;i<3;i++){

            for (int j=3;j<6;j++){
                if(board[i][j]=='.'){
                    continue;
                }
                if(arrayList3.contains(board[i][j])){
                    arrayList3.set(board[i][j]-49,".");
                }
                else {
                    return false;
                }

            }
        }
        ArrayList<String> arrayList4 =new ArrayList(Arrays.asList('1','2','3','4','5','6','7','8','9'));
        for(int i=3;i<6;i++){

            for (int j=3;j<6;j++){
                if(board[i][j]=='.'){
                    continue;
                }
                if(arrayList4.contains(board[i][j])){
                    arrayList4.set(board[i][j]-49,".");
                }
                else {
                    return false;
                }

            }
        }
        ArrayList<String> arrayList5 =new ArrayList(Arrays.asList('1','2','3','4','5','6','7','8','9'));
        for(int i=6;i<9;i++){

            for (int j=3;j<6;j++){
                if(board[i][j]=='.'){
                    continue;
                }
                if(arrayList5.contains(board[i][j])){
                    arrayList5.set(board[i][j]-49,".");
                }
                else {
                    return false;
                }

            }
        }
        ArrayList<String> arrayList6 =new ArrayList(Arrays.asList('1','2','3','4','5','6','7','8','9'));
        for(int i=0;i<3;i++){

            for (int j=6;j<9;j++){
                if(board[i][j]=='.'){
                    continue;
                }
                if(arrayList6.contains(board[i][j])){
                    arrayList6.set(board[i][j]-49,".");
                }
                else {
                    return false;
                }

            }
        }
        ArrayList<String> arrayList7 =new ArrayList(Arrays.asList('1','2','3','4','5','6','7','8','9'));
        for(int i=3;i<6;i++){

            for (int j=6;j<9;j++){
                if(board[i][j]=='.'){
                    continue;
                }
                if(arrayList7.contains(board[i][j])){
                    arrayList7.set(board[i][j]-49,".");
                }
                else {
                    return false;
                }

            }
        }
        ArrayList<String> arrayList8 =new ArrayList(Arrays.asList('1','2','3','4','5','6','7','8','9'));
        for(int i=6;i<9;i++){

            for (int j=6;j<9;j++){
                if(board[i][j]=='.'){
                    continue;
                }
                if(arrayList8.contains(board[i][j])){
                    arrayList8.set(board[i][j]-49,".");
                }
                else {
                    return false;
                }

            }
        }
        return true;
    }
    public static void main(String[] args) {
        char[][] a= new char[][]{{'5','3','.','.','7','.','.','.','.'}
,{'6','.','.','1','9','5','.','.','.'}
,{'.','9','8','.','.','.','.','6','.'}
,{'8','.','.','.','6','.','.','.','3'}
,{'4','.','.','8','.','3','.','.','1'}
,{'7','.','.','.','2','.','.','.','6'}
,{'.','6','.','.','.','.','2','8','.'}
,{'.','.','.','4','1','9','.','.','5'}
,{'.','.','.','.','8','.','.','7','9'}};
        System.out.println(isValidSudoku(a));
    }
}
