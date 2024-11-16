public class AdditiveHashCodes {

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

    public static void main(String[] args) {
        // Define the strings to be hashed
        String[] strings = {"DEBITCARD", "DORMITORY", "BADCREDIT", "DIRTYROOM"};

        // Calculate and display the hash code for each string
        for (String s : strings) {
            int hashCode = calculateHashCode(s);
            System.out.println("Additive hash code for " + s + " is: " + hashCode);
        }
    }
    
}
