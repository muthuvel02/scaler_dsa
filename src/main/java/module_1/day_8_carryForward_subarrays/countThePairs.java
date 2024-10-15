package module_1.day_8_carryForward_subarrays;
//Count the pairs "ag"
// given a character array, calculate the number of pairs i,j such the i < j && s[i] = "a" && S[j]
public class countThePairs {

    public static int countThePairsBruteForce(char [] array){
        int count = 0;
        for(int i =0; i< array.length; i++)
        {
            if(array[i] == 'a'){
                for(int j =i; j< array.length;j++)
                {
                    if( array[j]== 'g')
                        count ++;
                }
            }
        }

        return count;
        //o(n2);
    }

    public static int countThePairsOptimiseSolution(char[] array)
    {
        int countA = 0;
        int countParis = 0;

        for(int c : array)
        {
            if( c == 'a') {
                countA++;
            }
            else if( c == 'g') {
                countParis +=countA;
            }
        }
        return countParis;
    }


    public static void main(String[] args) {
        char[] array = {'a', 'b', 'g', 'a', 'g', 'a', 'g'};
        System.out.println("countThePairsBruteForce: " + countThePairsBruteForce(array));  // Output: 5
        System.out.println("countThePairsOptimiseSolution: " + countThePairsBruteForce(array));  // Output: 5

    }

}


