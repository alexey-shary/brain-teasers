package xyz.my;

import java.util.HashMap;

public class VladimirFibonacci {
    private static HashMap<Integer, Integer> cache = new HashMap<>();

    public static void main(String[] args) {
        int n = Integer.valueOf(args[0]);
        System.out.println(fibonacci(n));
    }

    private static int fibonacci(int n) {
        if (n <= 1) {
            cache.put(1, 0);
            return 0;
        }
        if (n == 2) {
            cache.put(2, 1);
            return 1;
        }
        Integer current = cache.get(n);
        if (current == null) {
            current = fibonacci(n - 2) + fibonacci(n - 1);
            cache.put(n, current);
        }
        return current;
    }
}