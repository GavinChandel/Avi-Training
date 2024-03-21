package javaBasics.date_21_03_24;

/*
    Time Complexity: O(N*(M^2))
    Space Complexity: O(1)

    Where 'N' and 'M' denotes the number of rows
    and the number of columns in the matrix respectively.
*/

import java.util.ArrayList;

public class FindCommonElements {
    public static ArrayList<Integer> findCommonElements(ArrayList<ArrayList<Integer>> mat)
    {
        int n = mat.size();
        int m = mat.get(0).size();

        ArrayList<Integer> ans = new ArrayList<Integer>();

        for (int k = 0; k < m; k++)
        {
            int isDuplicate = 0;
            for (int i = 0; i < ans.size(); i++)
            {
                if ((ans.get(i)).equals(mat.get(0).get(k)))
                {
                    isDuplicate = 1;
                    break;
                }
            }
            if (isDuplicate == 1)
            {
                continue;
            }

            int isPresentInAllRows = 1;

            for (int i = 1; i < n; i++)
            {
                int isPresentInCurrentRow = 0;
                for (int j = 0; j < m; j++)
                {
                    if ((mat.get(i).get(j)).equals(mat.get(0).get(k)))
                    {
                        isPresentInCurrentRow = 1;
                        break;
                    }
                }
                if (isPresentInCurrentRow == 0)
                {
                    isPresentInAllRows = 0;
                    break;
                }
            }
            if (isPresentInAllRows == 1)
            {
                ans.add(mat.get(0).get(k));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> MAT = new ArrayList<>();
        ArrayList<Integer> l1 = new ArrayList<>();
        l1.add(1);
        l1.add(4);
        l1.add(5);
        l1.add(6);

        ArrayList<Integer> l2 = new ArrayList<>();
        l2.add(3);
        l2.add(4);
        l2.add(5);
        l2.add(6);

        ArrayList<Integer> l3 = new ArrayList<>();
        l3.add(5);
        l3.add(6);
        l3.add(7);
        l3.add(2);

        MAT.add(l1);
        MAT.add(l2);
        MAT.add(l3);
        System.out.println(findCommonElements(MAT));
    }
}

