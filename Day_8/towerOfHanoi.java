package javaBasics.day8;

import java.util.*;
import java.io.*;
import java.math.*;
class towerOfHanoi {
    static void towerOfHanoi(int n, char source,char aux, char dest) {
        if (n == 0) {
            return;
        }
        towerOfHanoi(n - 1, source, dest, aux);
        System.out.println("Move disk " + n + " from rod " +source + " to rod " + dest);
                towerOfHanoi(n - 1, aux, source, dest);
    }

    public static void main(String args[]) {
        int n = 4; // Number of disks
        towerOfHanoi(n, 'A', 'B', 'C'); // A, B and C are names of rods
    }
}  