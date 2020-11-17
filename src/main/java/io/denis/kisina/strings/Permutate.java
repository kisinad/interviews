package io.denis.kisina.strings;

public class Permutate {

    public static void permutate(String str){
        permutation("", str);
    }

    private static void permutation(String ans, String str) {
        int n = str.length();

        if(n == 0){
            System.out.println(ans);

        }else{
            for(int i=0; i < n; i++){

                permutation(ans + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
            }
        }
    }

    public static void main(String[] args) {
        permutate("abc");
    }
}
