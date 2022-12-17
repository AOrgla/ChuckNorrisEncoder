import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String opType = "";
        do {
            System.out.println("Please input operation (encode/decode/exit): ");
            opType = scanner.nextLine();
            switch (opType) {
                case "encode":
                    startEncode();
                    break;
                case "decode":
                    methodCatchingException();
                    break;
                case "exit":
                    System.out.println("Bye!");
                    break;
                default:
                    System.out.println("There is no " +"'" + opType + "'" + " operation");
                    break;
            }
        }while (!opType.equals("exit"));

    }

    private static void startEncode() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input string:");
        byte[] inputStringToEncode = scanner.nextLine().getBytes(StandardCharsets.UTF_8);
        EncryptString.printBinary(inputStringToEncode);
    }

    private static void startDecode() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input encoded string:");
        String inputStringToDecode = scanner.nextLine();
        String inputCheck = inputStringToDecode.replaceAll(" ", "");
        int inputChecker = Integer.parseInt(inputCheck);
        if (inputChecker == 0 && inputStringToDecode.charAt(0) != '0' && inputStringToDecode.charAt(1) != ' ' ||
                inputStringToDecode.charAt(0) != '0' &&  inputStringToDecode.charAt(1) != '0' && inputStringToDecode.charAt(2) != ' ') {
            System.out.println("Encoded string is not valid");
        }
        DecryptString.printString(inputStringToDecode);
    }
    private static void methodCatchingException() {
        try {
            startDecode();
        } catch (NumberFormatException | StringIndexOutOfBoundsException e) {
            System.out.println("Encoded string is not valid");
        }
    }
}