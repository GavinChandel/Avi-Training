package javaBasics.date_21_03_24;


import java.util.ArrayList;
import java.util.HashMap;

class BurstingBalloons {

    public static int burstingBalloons(int[] arr, int n) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int counter = 0;
        for (int i = 0; i < n; i++) {
            int currentValue = arr[i];
            if (map.containsKey(currentValue + 1)) {
                map.put(currentValue + 1, map.get(currentValue + 1) - 1);
                if (map.get(currentValue + 1) == 0) {
                    map.remove(currentValue + 1);
                }
                if (map.containsKey(currentValue) == true) {
                    map.put(currentValue, map.get(currentValue) + 1);
                } else {
                    map.put(currentValue, 1);
                }

            } else {
                if (map.containsKey(currentValue) == true) {
                    map.put(currentValue, map.get(currentValue) + 1);
                } else {
                    map.put(currentValue, 1);
                }

            }

        }
        ArrayList<Integer> list = new ArrayList<>(map.keySet());
        for (int val : list) {
            counter += map.get(val);
        }
        return counter;
    }
    public static void main(String[] args)
    {
        int[] points = {2,1,5,4,3};

        System.out.println(burstingBalloons(points, points.length));
    }
}

