public class Main {
    public static int binarySearch(int[] arr, int n) {
        int low = 0;
        int high = arr.length - 1;
        int mid;

        while (low <= high) {
            mid = low + (high - low) / 2;

            if (arr[mid] == n) {
                return mid;
            } else if (arr[mid] > n) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    private static int countOccurrences(int[] arr, int n) {
        int index = binarySearch(arr, n);
        int aux = index;
        int count;

        if (index == -1) {
            return 0;
        } else {
            count = 1;

            if (arr[index + 1] == n) {
                aux = aux + 1;
                while (aux < arr.length && arr[aux] == n) {
                    count++;
                }
                aux = index;
            }

            if (arr[index - 1] == n) {
                aux = aux - 1;
                while (aux >= 0 && arr[aux] == n) {
                    aux = aux - 1;
                    count++;
                }
            }
        }
        return count;
    }
    //countOccurrences Time complexity:
    // K = number of n occurrences in array
    // O(K Log N)

    private static int firstOccurrence(int[] arr, int n) {
        int low = 0;
        int high = arr.length - 1;
        int mid;

        while (low <= high) {
            mid = low + (high - low) / 2;

            if (arr[mid] == n) {
                if (mid - 1 >= 0 && arr[mid - 1] == n) {
                    high = mid - 1;
                    continue;
                }
                return mid;
            } else if (arr[mid] > n) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    private static int lastOccurrence(int[] arr, int n) {
        int low = 0;
        int high = arr.length - 1;
        int mid;

        while (low <= high) {
            mid = low + (high - low) / 2;

            if (arr[mid] == n) {
                if (mid < high && arr[mid + 1] == n) {
                    low = mid + 1;
                    continue;
                }
                return mid;
            } else if (arr[mid] > n) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    private static int betterCountOccurrences(int[] arr, int n) {
        return lastOccurrence(arr, n) - firstOccurrence(arr, n) + 1;
    }
    //betterCountOccurrences Time complexity:
    // O(2 Log N) =
    // O(Log N)

    private static int naiveSolution(int[] arr, int n) {
        int count = 0;
        int exec = 0;
        boolean found = false;

        for (int i = 0; i < arr.length; i++) {
            exec++;

            if (arr[i] == n) {
                count++;
                found = true;
            }
            if (found && arr[i] != n)
                break;
        }

        System.out.println("exec:" + exec);
        System.out.println(count);

        return count;
    }
    //naiveSolution Time complexity:
    // O(N)

    public static void main(String[] args) {
        int n = 2;
        // input: 2
        // ->
        // 5;

        int[] arr = new int[]{1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 4, 4, 4, 4, 8, 8, 12, 12, 12};


        int[] array_worse = new int[]{1, 1, 1, 1, 1, 1};

        int[] arr2 = new int[]{1, 2, 3, 4, 5, 6};


        //System.out.println("Number of occurrences of " + n + " in array is: " + countOccurrences(arr, n));
        System.out.println("Number of occurrences of " + n + " in array is: " + betterCountOccurrences(arr, n));
    }
}