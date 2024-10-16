package module_1.day_8_carryForward_subarrays;
//closest Min Max
// given an array find the length of smallest subarray which contains both Min and Max of array.
public class MinAndMax {

    public static int closestMinMaxBruteForce(int [] arr){
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;

        // Step 1: Find the minimum and maximum values in the array
        for (int num : arr) {
            minValue = Math.min(minValue, num);
            maxValue = Math.max(maxValue, num);
        }

        int minLength = Integer.MAX_VALUE;

        // Step 2: Check every possible subarray
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                boolean hasMin = false;
                boolean hasMax = false;

                // Check if subarray arr[i...j] contains both min and max
                for (int k = i; k <= j; k++) {
                    if (arr[k] == minValue) hasMin = true;
                    if (arr[k] == maxValue) hasMax = true;
                }

                // If subarray contains both min and max, update minLength
                if (hasMin && hasMax) {
                    minLength = Math.min(minLength, j - i + 1);
                }
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
    public static int minMaxUsingCarryForward(int [] array)
    {
        // Fist lets find the min and max
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;

        for(int c : array)
        {
            minValue = Math.min(minValue, c);
            maxValue = Math.max(maxValue, c);

        }
        System.out.println("maxValue = " + maxValue);
        System.out.println("minValue = " + minValue);

        // Now run the loop and find the length of the sub array
        int minIndex = -1;
        int maxIndex = -1;
        int minLength = Integer.MAX_VALUE;
        for(int i =0; i<array.length; i++)
        {
            if(array[i] == minValue){
                minIndex = i;
                // just we are checking weather the max value has been already calculated, if it so it will calculate the min length and the max length
                if(maxIndex != -1)
                {
                     minLength = Math.min(minLength, Math.abs(minIndex - maxIndex )+1);// just the get the positive value  we are using the Math.abs
                }
            }
            if(array[i] == maxValue){
                maxIndex = i;
                // just we are checking weather the max value has been already calculated, if it so it will calculate the min length and the max length
                if(minIndex != -1)
                {
                    minLength=  Math.min(minLength, Math.abs(maxIndex - minIndex )+1);// just the get the positive value  we are using the Math.abs
                }
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    public static void main(String[] args) {
            int [] array = { 1,2,3,1,3,4,6,4,6,3};
            System.out.println("closestMinMaxBruteForce(array) = " + closestMinMaxBruteForce(array));
        System.out.println("minMaxUsingCarryForward(array) = " + minMaxUsingCarryForward(array));

    }
}
