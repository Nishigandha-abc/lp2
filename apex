public class ArraySorting {

    public static void sortArray() {

        Integer[] arr = new Integer[]{5, 3, 8, 1, 2};

        Integer temp;

        // Simple Bubble Sort
        for(Integer i = 0; i < arr.size(); i++) {

            for(Integer j = 0; j < arr.size()-1; j++) {

                if(arr[j] > arr[j+1]) {

                    // Swap numbers
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        System.debug('Sorted Array: ' + arr);
    }
}
