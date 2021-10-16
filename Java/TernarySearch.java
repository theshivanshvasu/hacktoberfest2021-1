class TernarySearch {
    public int search(int start, int end, int key, int[] numbers) {
        if(start <= end) {
            int mid1 = start + (end-start)/3;
            int mid2 = end - (end-start)/3;

            if(key == numbers[mid1]) {
                return mid1;
            }
            if(key == numbers[mid2]) {
                return mid2;
            }

            if(key < numbers[mid1]) {
                return search(start, mid1-1, key, numbers);
            }
            else if(key > numbers[mid1] && key < numbers[mid2]) {
                return search(mid1+1, mid2-1, key, numbers);
            }
            else if(key > numbers[mid2]) {
                return search(mid2+1, end, key, numbers);
            }
        }
        return -1;
    }
    //Time Complexity: O(log3(N))

    public static int ternarySearch(int[] numbers, int key) {
        TernarySearch tsearch = new TernarySearch();
        return tsearch.search(0, numbers.length, key, numbers);
    }

    public static void main(String[] args) {
        int n = 7;
        int[] numbers = new int[]{1, 4, 5, 12, 19, 20, 39};

        System.out.println("Performing Ternary Search...");
        System.out.println("Number 20 exists at index: " + ternarySearch(numbers, 20));
        System.out.println("Number 4 exists at index: " + ternarySearch(numbers, 4));
        System.out.println("Number 39 exists at index: " + ternarySearch(numbers, 39));
        System.out.println("Number 17 exists at index: " + ternarySearch(numbers, 17)); 
    }
}