import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) {
        int[] array = {9,9,9,9};
        int[] output = SolutionPlusOne(array);
        System.out.println(Arrays.toString(output));
    }

    // private static int[] SolutionPlusOne(int[] array) {
    // int arrlen = array.length;
    // if (arrlen == 0){
    // return new int[] {1};
    // }
    // if (array[arrlen-1] == 9){
    // int[] array_beforelast = Arrays.copyOfRange(array, 0, arrlen - 1);
    // // System.out.println("array_beforelast: "+
    // Arrays.toString(array_beforelast));
    // int[] array_beforelast_plus = SolutionPlusOne(array_beforelast);
    // // System.out.println("array_beforelast_plus: "+
    // Arrays.toString(array_beforelast_plus));
    // int [] new_array = new int[array_beforelast_plus.length+1];
    // System.arraycopy(array_beforelast_plus, 0, new_array, 0,
    // array_beforelast_plus.length);
    // return new_array;
    // }else{
    // array[arrlen-1] ++;
    // return array;
    // }
    // }

    // Time 100%, Memory 89%
    private static int[] SolutionPlusOne(int[] array) {
        array[array.length - 1]++;
        if (array[array.length - 1] < 10)
            return array;
        else {
            // 最后一位是10，则需要变0进1
            for (int idx = array.length - 1; idx >= 1; idx--) {
                if (array[idx] == 10) {
                    array[idx] = 0;
                    array[idx - 1]++;
                } else
                    return array;
            }
        }
        // 如果第一位还是10
        if (array[0] == 10){
            int[] new_array = new int[array.length + 1];
            System.arraycopy(array, 0, new_array, 1, array.length);
            new_array[0] = 1;
            new_array[1] = 0;
            return new_array;
        }
        else return array;
        
    }
}