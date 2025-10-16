import java.util.Arrays;
import java.util.stream.Collectors;

public class MoveZerosToEnd {
    public static void main(String[] args) {
        int[] arr = {5,0,1,0,3,0,2,0,4};
        //{0,5,1,0,3,0,2,0,4}
        //{0,5,0,1,3,0,2,0,4}
        //{0,0,5,1,3,0,2,0,4}
        moveZeroesToFront(arr);
        System.out.println(Arrays.stream(arr).mapToObj(String::valueOf).collect(Collectors.joining(", ")));

        arr = new int[]{5,0,1,0,3,0,2,0,4};
        moveZeroesToEnd(arr);
        System.out.println(Arrays.stream(arr).mapToObj(String::valueOf).collect(Collectors.joining(", ")));
    }

    public static void moveZeroesToFront(int[] arr) {
        int z = 0;
        int nz = 0;

        while(nz < arr.length) {
            if (arr[nz] == 0) {
                for(int j = nz; j > z; j--) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
                nz++;
                z++;
            } else {
                nz++;
            }
        }
    }

    public static void moveZeroesToEnd(int[] arr) {
        int z = arr.length - 1;
        int nz = arr.length - 1;

        while(nz >= 0) {
            if(arr[nz] == 0) {
                for(int j = nz; j < z; j++) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
                nz--;
                z--;
            } else {
                nz--;
            }
        }
    }
}
