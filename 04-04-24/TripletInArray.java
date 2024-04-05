package javaBasics.date_04_04_24;

import java.util.Arrays;
import java.util.Collections;
import java.util.Vector;

import static java.lang.Math.abs;

class TripletInArray
{
    static int solution(Vector<Integer> arr, int x)
    {
        Collections.sort(arr);
        long closestSum = Integer.MAX_VALUE;

        for (int i = 0; i < arr.size() - 2; i++)
        {

            int ptr1 = i + 1, ptr2 = arr.size() - 1;
            while (ptr1 < ptr2)
            {

                int sum = arr.get(i) + arr.get(ptr1) + arr.get(ptr2);
                if (abs(x - sum) < abs(x - closestSum))
                {
                    closestSum = sum;
                }

                if (sum > x)
                {
                    ptr2--;
                }
                else
                {
                    ptr1++;
                }
            }
        }
        return (int)closestSum;
    }

    public static void main(String[] args)
    {
        Vector arr = new Vector(Arrays.asList( -1, 2, 1, -4 ));
        int x = 1;
        System.out.println(solution(arr, x));
    }
}

