package javaBasics.date_09_04_24;

import java.util.ArrayList;
import java.util.Stack;

public class BlackShapes {
    class Pair{
        int x,y;
        Pair(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    int[] xArr = new int[]{-1,1,0,0};
    int[] yArr = new int[]{0,0,-1,1};
    boolean isValid(int i, int j, boolean visit[][], int x, int y, ArrayList<String> arr){
        if(i>=0 && i<x && j>=0 && j<y && !visit[i][j] && arr.get(i).charAt(j)=='X') return true;
        return false;
    }
    public void dfsCall(Stack<Pair> stack, boolean visit[][], ArrayList<String> arr, int i, int j, int row, int col){
        stack.push(new Pair(i,j));
        visit[i][j]=true;
        while(!stack.isEmpty()){
            Pair p = stack.pop();
            int x= p.x,y=p.y;
            for(int t = 0;t<4;t++){
                int nx= x+xArr[t];
                int ny= y+yArr[t];
                if(isValid(nx,ny,visit,row,col,arr)){
                    stack.push(new Pair(nx,ny));
                    visit[nx][ny]=true;
                }
            }
        }
    }
    public int black(ArrayList<String> arr) {
        int row= arr.size();
        int col=arr.get(0).length();
        Stack<Pair> stack = new Stack<>();
        int ans=0;
        boolean visit[][] = new boolean[row+1][col+1];
        for(int i=0;i<row;i++)
            for(int j=0;j<col;j++){
                if(!visit[i][j] && arr.get(i).charAt(j)=='X'){
                    ans++;
                    dfsCall(stack,visit,arr,i,j,row,col);
                }
            }
        return ans;
    }

    public static void main(String[] args) {
        BlackShapes blackShapes = new BlackShapes();
        ArrayList<String> arr = new ArrayList<>();
        arr.add("OOOXOOO");
        arr.add("OOXXOXO");
        arr.add("OXOOOXO");

        int result = blackShapes.black(arr);
        System.out.println(result);
    }
}


