package BinaryNumConverter;

public class BinaryArrayToDecimal {
    public static void main(String[] args) {
        //array
        int[] binaryArray = {1, 0, 1, 0, 1};
        
        //call on the convertBinaryToDecimal function and sets decimal value
        int decimalValue = convertBinaryToDecimal(binaryArray);

        System.out.println("Binary Array: " + arrayToString(binaryArray));
        System.out.println("Decimal Value: " + decimalValue);

    }


    // function takes an array of 1s and 0s as input and converts it to its corresponding decimal value. 
    //Function iterates through the array in reverse order, treating each position as a power of 2. 
    //If the value at the current position is 1, it adds the corresponding power of 2 to the decimal value.
    public static int convertBinaryToDecimal(int[] binaryArray) {
        int decimalValue = 0;
        int power = 0;

        for (int i = binaryArray.length - 1; i >= 0; i--) {
            if (binaryArray[i] == 1) {
                decimalValue += Math.pow(2, power);
                System.out.println(power);
            }
            power++;
        }

        return decimalValue;
    }

    //converts the array to a string
    public static String arrayToString(int[] arr) {
        
        StringBuilder sb = new StringBuilder();
        for (int num : arr) {

            sb.append(num);
        }
        return sb.toString();
    }
}