public class AdditiveHashCodes {
    // the size of the hash table (array), used to calculating the compressed hash function that serves as what index to add at 
    private static final int m = 31;

    // Method to calculate additive hash code of a string
    public static int calculateHashCode(String input) {
        int hashCode = 0;

        // Iterate over each character in the input string
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            // Add ASCII value of the character to hashCode
            hashCode += (int) c;
        }

        return hashCode;
    }

    public static int calculateCompressedHashCode(int hashCode) {
        return hashCode % m;
    }
    

    public static void main(String[] args) {
        // Define the strings to be hashed
        String[] strings = {"SOIL", "OILS"};

        // Calculate and display the hash code for each string
        for (String s : strings) {
            int hashCode = calculateHashCode(s);
            System.out.println("Additive hash code for " + s + " is: " + hashCode);

            int compressedHashCode = calculateCompressedHashCode(hashCode);
            System.out.println("Compressed hash code for " + s + " is: " + compressedHashCode);

            System.out.println();
        }



    }
    
}