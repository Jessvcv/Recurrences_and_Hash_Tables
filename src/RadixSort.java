import java.util.*;

public class RadixSort {
    public static void radixSort(String[] arr) {
        // Handle empty or null arrays
        if (arr == null || arr.length == 0) return;

        int maxLength = 0;
        //find the maximum string length
        for (String s : arr) maxLength = Math.max(maxLength, s.length());

        //iterate from the last to the first character
        for (int pos = maxLength - 1; pos >= 0; pos--) {
            //buckets for sorting
            Map<Character, List<String>> buckets = new HashMap<>();

            //group words into buckets based on the current character
            for (String s : arr) {
                char key = (pos < s.length()) ? s.charAt(pos) : ' '; //use space for shorter words
                buckets.putIfAbsent(key, new ArrayList<>());
                buckets.get(key).add(s);
            }

            //sort the keys manually to maintain lexicographic order with uppercase precedence
            List<Character> sortedKeys = new ArrayList<>(buckets.keySet());
            sortedKeys.sort((a, b) -> {
                if (Character.isUpperCase(a) && Character.isLowerCase(b)) return -1;
                if (Character.isLowerCase(a) && Character.isUpperCase(b)) return 1;
                return Character.compare(a, b);
            });

            //rebuild the array from the sorted buckets
            int index = 0;
            for (char key : sortedKeys) {
                for (String s : buckets.get(key)) {
                    arr[index++] = s;
                }
            }
        }
    }

    public static void main(String[] args) {
        String[] words = {"google", "gojo", "amazingly", "jogo", "luna", "pup", "solas", "solo", "pupperino", "amaterasu", "amazon", "puppy", "hydra", "amazonia", "vueltiao"};

        radixSort(words);
        System.out.println(String.join(", ", words));
    }
}
