import java.util.*;

public class W0Arrays {
    
    public static void main(String[] args) {
        int[] myarr = {1, 2, 3};

        System.out.println(Arrays.toString(reverseArray(myarr)));
    }

    public static int[] reverseArray(int[] array) {
        int[] reversedArray = new int[array.length];
        
        int index = 0;
        for (int i = array.length - 1; i > -1; i--) {
            reversedArray[index] = array[i];
            index++;
        }

        return reversedArray;
    }
}
