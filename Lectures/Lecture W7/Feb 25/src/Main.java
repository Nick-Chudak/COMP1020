class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 6, 9, 20, 50};
        int target = 20;

        System.out.println(binarySearch(arr, target));
    }

    public static int binarySearch(int[] arr, int target) {
        int l = 0;
        int r = arr.length - 1;

        int foundIndex = -1;

        while (l <= r) {
            int mid = Math.floorDiv(l + r, 2);

            if (arr[mid] > target) {
                r = mid - 1;
            } else if (arr[mid] < target) {
                l = mid + 1;
            } else {
                foundIndex = mid;
                return foundIndex;
            }

        }

        return foundIndex;
    }

    public static int indsertionSort(int[] arr, int target) {
        
    }
}