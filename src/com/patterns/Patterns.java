package com.patterns;

import java.util.Scanner;

public class Patterns {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        pattern_18(5);
    }

    private static void pattern_18(int n) {
        int x = 0;
        int y = 0;
        for (int i = 1; i <= 2 * n; i++) {
            if (i <= n) {
                x = n - i +1;
                y = n + i  ;
            } else {
                x = i - n ;
                y = 3*n - i +1;
            }
            //print left
            for (int j = 1; j <= x; j++) {
                System.out.print("*");
            }

            //print space
            for (int j = x; j <= y; j++) {
                if(j!=n && j!=n+1)
                System.out.print(" ");
            }
            //print right
            for (int j = y; j <= 2 * n; j++) {
                System.out.print("*");
            }
            //print next line
            System.out.println();
        }
    }

    private static void pattern_17(int n) {
        int col = 0;
        int space = 0;
        int value = 0;
        for (int i = 1; i <= 2 * n - 1; i++) {
            ;
            if (i <= n) {
                space = n - i;
                col = 2 * i - 1;
                value = i;
            } else {
                space = i - n;
                col = 2 * (2 * n - i) - 1;
                value = 2 * n - i;
            }

            //printing spaces
            for (int j = 1; j <= space; j++) {
                System.out.print(" ");
            }
            //printing number
            for (int j = 1; j <= col; j++) {

                System.out.print(value);
                if (value > 1) {
                    value--;
                } else {
                    value++;
                }
            }
            // next line
            System.out.println();
        }
    }

    private static void pattern_16(int n) {
        // Outer loop for each row
        for (int i = 0; i < n; i++) {
            int value = 1;  // The first value of every row is always 1

            // Print leading spaces for formatting
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }

            // Inner loop to print the values in each row
            for (int j = 0; j <= i; j++) {
                // Print the current value
                System.out.print(value + " ");

                // Calculate the next value in the row using the previous value
                value = value * (i - j) / (j + 1);
            }

            // Move to the next line after each row
            System.out.println();
        }
    }

    private static void pattern_15(int n) {
        int x = 0, y = 0;
        for (int i = 1; i <= 2 * n - 1; i++) {
            if (i <= n) {
                x = n - i + 1;
                y = n + i - 1;
            } else {
                x = i + 1 - n;
                y = 2 * n - i - 1 + n;
            }
            for (int j = 1; j <= 2 * n - 1; j++) {
                if (j == x || j == y) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

    }

    private static void pattern_14(int n) {
        for (int i = 1; i <= 2 * n - 1; i++) {
            System.out.print("*");

        }
        System.out.println();
        for (int i = 1; i <= n - 1; i++) {
            for (int j = 1; j <= 2 * n - 1; j++) {
                if (j == i + 1 || j == 2 * n - i - 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

    }

    private static void pattern_13(int n) {
        for (int i = 1; i <= n - 1; i++) {
            for (int j = 1; j <= 2 * n - 1; j++) {
                if (j == n - i + 1 || j == n + i - 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        for (int i = 1; i <= 2 * n - 1; i++) {
            System.out.print("*");

        }
    }

    private static void pattern_12(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                System.out.print("  ");
            }
            for (int k = 1; k <= n - i + 1; k++) {
                System.out.print("  * ");
            }
            for (int l = 1; l < i; l++) {
                System.out.print("  ");
            }
            System.out.println();
        }
        for (int i = 1; i <= n; i++) {

            for (int j = 1; j < n - i + 1; j++) {
                System.out.print("  ");
            }
            // Print stars
            for (int k = 1; k <= i; k++) {
                System.out.print(" *  ");
            }
            for (int x = 1; x <= n - i; x++) {
                System.out.print("  ");
            }
            // Move to the next line
            System.out.println();
        }
    }

    private static void pattern_11(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                System.out.print("  ");
            }
            for (int k = 1; k <= n - i + 1; k++) {
                System.out.print("  * ");
            }
            for (int l = 1; l < i; l++) {
                System.out.print("  ");
            }
            System.out.println();
        }
    }

    private static void pattern_10(int n) {
        for (int i = 1; i <= n; i++) {

            for (int j = 1; j < n - i + 1; j++) {
                System.out.print("  ");
            }
            // Print stars
            for (int k = 1; k <= i; k++) {
                System.out.print(" *  ");
            }
            for (int x = 1; x <= n - i; x++) {
                System.out.print("  ");
            }
            // Move to the next line
            System.out.println();
        }
    }

    private static void pattern_9(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= 2 * n - 2 * i + 1; k++) {
                System.out.print("*");
            }
            for (int l = 1; l < i; l++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    private static void pattern_8(int n) {
        for (int i = 1; i <= n; i++) {

            for (int j = 1; j < n - i + 1; j++) {
                System.out.print(" ");
            }
            // Print stars
            for (int k = 1; k <= 2 * i - 1; k++) {
                System.out.print("*");
            }
            for (int x = 1; x <= n - i; x++) {
                System.out.print(" ");
            }
            // Move to the next line
            System.out.println();
        }
    }


    private static void pattern_7(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                System.out.print("  ");
            }
            // Print stars
            for (int k = n; k >= i; k--) {
                System.out.print(" *");
            }

            // Move to the next line
            System.out.println();
        }
    }

    private static void pattern_6(int n) {


        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < n - i + 1; j++) {
                System.out.print(" ");
            }
            // Print stars
            for (int k = 1; k <= i; k++) {
                System.out.print("*");
            }
            // Move to the next line
            System.out.println();
        }
    }


    private static void pattern_5(int n) {
        int c = 0;
        for (int i = 1; i <= 2 * n - 1; i++) {

            if (i <= n) {
                c = i;
            } else {
                c = 2 * n - i;
            }
            for (int j = 1; j <= c; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    private static void pattern_4(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    private static void pattern_3(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i + 1; j++) {
                System.out.print('*' + " ");
            }
            System.out.println();
        }
    }

    private static void pattern_1(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 5; j++) {
                System.out.print('*');
            }
            System.out.println();
        }
    }

    private static void pattern_2(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print('*' + " ");
            }
            System.out.println();
        }
    }
}
