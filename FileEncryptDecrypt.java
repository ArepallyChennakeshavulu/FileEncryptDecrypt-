import java.io.*;
import java.util.Scanner;

public class FileEncryptDecrypt {

	public static void encryptFile(String inputFile, String outputFile, int shift) {
		try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
				BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

			int data;
			while ((data = reader.read()) != -1) {
				char character = (char) data;
				char encryptedChar = (char) (character + shift);
				writer.write(encryptedChar);
			}

			System.out.println("File encrypted successfully.");

		} catch (IOException e) {
			System.err.println("Error reading/writing file: " + e.getMessage());
		}
	}

	public static void decryptFile(String inputFile, String outputFile, int shift) {
		try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
				BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

			int data;
			while ((data = reader.read()) != -1) {
				char character = (char) data;
				char decryptedChar = (char) (character - shift);
				writer.write(decryptedChar);
			}

			System.out.println("File decrypted successfully.");

		} catch (IOException e) {
			System.err.println("Error reading/writing file: " + e.getMessage());
		}
	}

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);

		try {
			System.out.print("Enter operation (encrypt/decrypt): ");
			String operation = scanner.nextLine().trim().toLowerCase();

			System.out.print("Enter input file path: ");
			String inputFile = scanner.nextLine().trim();

			System.out.print("Enter output file name (without extension): ");
			String outputFileName = scanner.nextLine().trim();

			
			String outputFile = outputFileName + ".txt"; 

			System.out.print("Enter shift value (integer): ");
			int shift = scanner.nextInt();

			if (operation.equals("encrypt")) {
				encryptFile(inputFile, outputFile, shift);
			} else if (operation.equals("decrypt")) {
				decryptFile(inputFile, outputFile, shift);
			} else {
				System.out.println("Invalid operation. Please choose either 'encrypt' or 'decrypt'.");
			}

		} catch (NumberFormatException e) {
			System.err.println("Error reading input: " + e.getMessage());
		} finally {
			scanner.close();
		}
	}
}
