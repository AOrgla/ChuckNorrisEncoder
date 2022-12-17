
import java.util.Arrays;

public class EncryptString {

    public static void printBinary(byte[] input) {

        StringBuilder binary = new StringBuilder("");
        for (byte b : input) {
            binary.append(String.format("%7s",
                    Integer.toBinaryString(b)).replace(" ", "0"));
        }
        printEncryptedString(binary);

    }

    private static void printEncryptedString(StringBuilder binary) {
        boolean zeroSeries = binary.charAt(0) == '0';
        StringBuilder output = new StringBuilder();
        int seriesLength = 1;

        for (int i = 1; i < binary.length(); i++) {
            if (binary.charAt(i) == binary.charAt(i - 1)) {
                seriesLength++;
            } else {
                output.append(formatSeries(zeroSeries, seriesLength)).append(" ");
                zeroSeries = !zeroSeries;
                seriesLength = 1;
            }
        }
        System.out.println("Encoded string:\n " + output.append(formatSeries(zeroSeries, seriesLength)));
    }

    private static String formatSeries(boolean zeroSeries, int seriesLength) {
        char[] seriesLengthAsChars = new char[seriesLength];
        Arrays.fill(seriesLengthAsChars, '0');
        return (zeroSeries ? "00" : "0") + " " + new String(seriesLengthAsChars);
    }
}
