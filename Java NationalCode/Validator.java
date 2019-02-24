import java.util.Scanner;

public class Validator {

	public static void main(String[] args) {

		System.out.println("Enter :");
		Scanner in = new Scanner(System.in);
		
		Validator v = new Validator();
		System.out.println(v.checked(in.nextLong()));

	}

	public boolean checked(long nc) {

		char[] digits = Long.toString(nc).toCharArray();

		if (digits.length >= 8 && digits.length <= 10) {

			if (digits.length == 8)
				digits = eight(digits);
			if (digits.length == 9)
				digits = nine(digits);

			int sum = 0;
			int i,j;
			for (i = 0, j = 10; i <9; i++, j--) {
				System.out.println(digits[i] + "*" + j + "=" + (Integer.parseInt(String.valueOf(digits[i])) * j));
				sum += (Integer.parseInt(String.valueOf(digits[i])) * j);
			}
			
			System.out.println("----------------------------");
			System.out.println("sum: " + sum);
			int mod = sum % 11;
			System.out.println("mod: " + sum + "%" + "11" + " = " + mod);
			
			//System.out.println(digits[9] + " !!!!!!!!!!!!!!!!!");
			
			if (mod < 2 && mod == Integer.parseInt(String.valueOf(digits[i])))
				return true;
			if (mod >=2 && 11 - mod == Integer.parseInt(String.valueOf(digits[i])))
				return true;
			else
				return false;
		}

		return false;
	}

	public char[] eight(char[] digit) {

		char[] result = new char[10];
		for (int index = digit.length - 1; index >= 0; index--)
			result[index + 2] = digit[index];

		result[0] = '0';
		result[1] = '0';
		return result;
	}

	public char[] nine(char[] digit) {
		char[] result = new char[10];
		for (int index = digit.length - 1; index >= 0; index--)
			result[index + 1] = digit[index];

		result[0] = '0';
		return result;
	}

}
