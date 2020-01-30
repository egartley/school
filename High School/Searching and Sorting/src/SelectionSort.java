import java.util.Arrays;

public class SelectionSort 
{
    public static void main(String[] args)
    {
        int[] array1 = generateArrayOfLength(10);
        int[] array2 = generateArrayOfLength(100);
        
        System.out.print("First array: ");
        System.out.println(Arrays.toString(array1));
        System.out.print("Second array: ");
        System.out.println(Arrays.toString(array2));
        System.out.println();

        // sort first array
        selectionSort(array1);
        // sort second array
        selectionSort(array2);

        System.out.print("First array sorted: ");
        System.out.println(Arrays.toString(array1));
        System.out.print("Second array sorted: ");
        System.out.println(Arrays.toString(array2));
    }
    public static int[] generateArrayOfLength(int length)
    {
        int[] arr = new int[length];
        for(int i = 0; i < length; i++)
        {
            arr[i] = (int)(Math.random()*100);
        }       
        return arr;
    }
    /*
     * Selection sort takes in an array of integers and
     * returns a sorted array of the same integers.
     */
    public static int[] selectionSort(int[] arr)
    {
        int count = 0;
        for (int i = 0; i < arr.length - 1; i++)
        {
            int currentMinIndex = i;
            for (int j = i + 1; j < arr.length; j++)
            {

            }
            // swap numbers if needed
            if (i != currentMinIndex)
            {
                
            }
        }
        // Print out the number of comparisons that took place
        System.out.println(count);
        return arr;
    }
}