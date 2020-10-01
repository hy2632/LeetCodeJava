import java.util.Arrays;

public class NC22 {
    public static void merge(int A[], int m, int B[], int n) {
        int[] C = new int[m + n];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < m && j < n){
            if(A[i] <= B[j]){
                C[k] = A[i];
                i++;
            } else {
                C[k] = B[j];
                j++;
            }
            k++;
        }
        while (i < m){
            C[k++] = A[i++];
        }
        while (j < n){
            C[k++] = B[j++];
        }

        for (int l = 0; l < C.length; l++){
            A[l] = C[l];
        }
        return;
    }
    public static void main(String[] args){
        int[] a = new int[8];
        a[0] = 1;
        a[1] = 2;
        a[2] = 3;
        a[3] = 4;
        int[] b = {2,4,5,6};
        merge(a, 4, b, 4);
        System.out.println(Arrays.toString(a));
    }
}