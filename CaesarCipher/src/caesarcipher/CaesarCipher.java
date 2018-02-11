package caesarcipher;

import java.util.Scanner;

public class CaesarCipher {

	final static String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	static String message;
	static int shiftKey;
	static int lengthEncryptMessage;
	static char mostLetterEncryptMessage;
	static char mostLetterOryginalMessage;
	static int[] arrayCount = new int[26];

	public static String encryptMessage(String text, int shiftKey) 
	{
		text = text.toUpperCase();
		String cipherText = "";
		for (int i = 0; i < text.length(); i++) {
			int charPosition = ALPHABET.indexOf(text.charAt(i));
			int key = (shiftKey + charPosition) % 26;
			char replace = ALPHABET.charAt(key);
			cipherText += replace;
		}
		return cipherText;
	}

	// return the most frequently occurring letter in an encrypted message
	public static char calculatemostLetterEncryptMessage(String encryptMessage, int lengthEncryptMessage) {

		encryptMessage = encryptMessage.toUpperCase();
		int max = 0;
		int count;
		int index = 0;

		for (int i = 0; i < ALPHABET.length(); i++) {

			count = 0;

			for (int j = 0; j < lengthEncryptMessage; j++) {

				char letter = encryptMessage.charAt(j);

				if (ALPHABET.charAt(i) == letter) {

					count++;
				}
			}

			arrayCount[i] = count;
		}
		max = arrayCount[0];

		for (int j = 1; j < 26; j++) {

			if (max < arrayCount[j]) {

				max = arrayCount[j];
				index = j;
			}
		}

		mostLetterEncryptMessage = ALPHABET.charAt(index);
		return mostLetterEncryptMessage;

	}

	//calculate the offset
	public static int calculateShiftKey(char mostLetterOryginalMessage, char mostLetterEncryptMessage) {

		int index = ALPHABET.indexOf(mostLetterOryginalMessage);
		int index2 = ALPHABET.indexOf(mostLetterEncryptMessage);

		shiftKey = index2 - index;

		if (shiftKey < 0) {

			shiftKey = Math.abs(shiftKey);
		}

		return shiftKey;
	}

	
	public static String decrypt(String cipherText, int shiftKey) 
	{
		cipherText = cipherText.toUpperCase();
		String decryptText = "";
		for (int i = 0; i < cipherText.length(); i++) {
			int charPosition = ALPHABET.indexOf(cipherText.charAt(i));
			int keyVal = (charPosition - shiftKey) % 26;
			if (keyVal < 0) {
				keyVal = ALPHABET.length() + keyVal;
			}
			char replaceVal = ALPHABET.charAt(keyVal);
			decryptText += replaceVal;
		}
		return decryptText;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String mess;
		int shift;

		
		System.out.println("Enter the message you want to encrypt: ");
		mess = sc.next();
		System.out.println("Enter the offset: ");
		shift = sc.nextInt();
		System.out.println("Message encrypted: ");
		System.out.println(encryptMessage(mess, shift));

		System.out.println("Enter the length of the encrypted message: ");
		lengthEncryptMessage = sc.nextInt();
		System.out.println("Enter the most common letter in the original message: ");
		mostLetterOryginalMessage = sc.next().charAt(0);
		char mostLetterOrygText = Character.toUpperCase(mostLetterOryginalMessage); 
		System.out.println("Enter the encrypted message: ");
		message = sc.next();

		calculatemostLetterEncryptMessage(message, lengthEncryptMessage);
		calculateShiftKey(mostLetterOrygText, mostLetterEncryptMessage);
		System.out.println(decrypt(message, shiftKey));

		sc.close();
	}

}
