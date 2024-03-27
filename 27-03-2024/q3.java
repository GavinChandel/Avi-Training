package javaBasics.date_27_03_24;

public class q3 {
    public static void main(String[] args) {
        int[] valueInHouse = {1, 2, 3, 1};
        System.out.println(houseRobber(valueInHouse));
    }

    public static long houseRobber(int[] valueInHouse) {
        if (valueInHouse.length == 0) {
            return 0;
        }

        if (valueInHouse.length == 1) {
            return valueInHouse[0];
        }

        return Math.max(houseRobberUtil(valueInHouse, 0, valueInHouse.length - 1),
                houseRobberUtil(valueInHouse, 1, valueInHouse.length));
    }

    public static long houseRobberUtil(int[] valueInHouse, int start, int end) {
        long[] valueAtIthHouse = new long[valueInHouse.length];
        if (start == 0) {
            valueAtIthHouse[0] = valueInHouse[0];
            valueAtIthHouse[1] = Math.max(valueInHouse[0], valueInHouse[1]);
        } else {
            valueAtIthHouse[0] = 0;
            valueAtIthHouse[1] = valueInHouse[1];
        }

        for (int i = 2; i < end; i++) {
            valueAtIthHouse[i] = Math.max(valueAtIthHouse[i - 2] + valueInHouse[i], valueAtIthHouse[i - 1]);
        }

        return valueAtIthHouse[end - 1];
    }
}

