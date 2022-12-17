
public class DecryptString {
    public static void printString(String inputStringToDecode) {
        String[] stringToWords = inputStringToDecode.split(" ");

        stringToBinary(stringToWords);
    }

    private static void stringToBinary(String[] stringToWords) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < stringToWords.length - 1; i++) {
            if (stringToWords[i].equals("0") && i % 2 == 0) {
                for (int j = 0; j < stringToWords[i + 1].length(); j++) {
                    str.append("1");
                }
            } else if (stringToWords[i].equals("00") && i % 2 == 0) {
                for (int j = 0; j < stringToWords[i + 1].length(); j++) {
                    str.append("0");
                }
            }
        }
        StringBuilder output = new StringBuilder();
        int ch = 0;
        for (int i = 0; i < str.length(); i += 7) {
            String r = str.substring(i, i + 7);
            ch = Integer.parseInt(r, 2);
            output.append((char)ch);
        }
        System.out.print("Decoded string:\n " + output);
        System.out.println();
    }
}
