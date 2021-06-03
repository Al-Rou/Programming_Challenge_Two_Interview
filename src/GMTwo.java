import java.util.*;

public class GMTwo {
    public static void main(String[] args)
    {
        //Ask the user to enter input numbers
        System.out.println("Enter numbers: ");
        Scanner in = new Scanner(System.in);
        //Read the input
        String inputNumbers = in.nextLine();
        //Separating the first number which is the length of array
        int i = 0;
        String lengthOfArrayInString = "";
        while (inputNumbers.charAt(i) != ';')
        {
            lengthOfArrayInString += inputNumbers.charAt(i);
            i++;
        }
        int lengthOfArray = Integer.parseInt(lengthOfArrayInString);
        int[] inputArray = new int[lengthOfArray];
        //Inserting the rest numbers into the array
        String aux = "";
        int counterOfArray = 0;
        for (int j = i+1; j < inputNumbers.length(); j++)
        {
            if (inputNumbers.charAt(j) != ',')
            {
                aux += inputNumbers.charAt(j);
            }
            else
            {
                inputArray[counterOfArray] = Integer.parseInt(aux);
                counterOfArray++;
                aux = "";
            }
        }
        inputArray[counterOfArray] = Integer.parseInt(aux);
        //Deep copy of the array
        int[] auxiliaryArray = new int[lengthOfArray];
        for (int z = 0; z < lengthOfArray; z++)
        {
            auxiliaryArray[z] = inputArray[z];
        }
        //Sorting the auxiliary array
        for (int z = 0; z < lengthOfArray-1; z++)
        {
            for (int j = z+1; j < lengthOfArray; j++)
            {
                if (auxiliaryArray[z] > auxiliaryArray[j])
                {
                    int temp = auxiliaryArray[z];
                    auxiliaryArray[z] = auxiliaryArray[j];
                    auxiliaryArray[j] = temp;
                }
            }
        }
        //Print the sorted array
        for(int z = 0; z < lengthOfArray; z++)
        {
            System.out.print(auxiliaryArray[z] + ",");
        }
        System.out.print("\n");
        //Print the original array
        for (int z = 0; z < lengthOfArray; z++)
        {
            System.out.print(inputArray[z] + ",");
        }
        //Finding two neighbours which are equal and printing it out
        for (int z = 0; z < lengthOfArray-1; z++)
        {
            if(auxiliaryArray[z] == auxiliaryArray[z+1])
            {
                System.out.print("\n" + auxiliaryArray[z]);
                return;
            }
        }
    }
}
