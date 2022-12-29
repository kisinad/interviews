package io.denis.kisina.strings;

class Permutation {

    public static void permutation(String str){
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
        permutation("abc");
    }
}
