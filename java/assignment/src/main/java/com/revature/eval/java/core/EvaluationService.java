package com.revature.eval.java.core;

import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class EvaluationService {

	/**
	 * 1. Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 * 
	 * @param string
	 * @return
	 */
	public String reverse(String string) {
		char[] reversed = new char[string.length()];
		for (int i = reversed.length - 1, j = 0; i >= 0; i--, j++) {
			reversed[j] = string.charAt(i);
		}
		return new String(reversed);
	}

	/**
	 * 2. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 * @return
	 */
	public String acronym(String phrase) {
		// TODO Write an implementation for this method declaration
		String acronym = new String();
		acronym += phrase.charAt(0);
		for (int i = 0; i < phrase.length() - 1; i++) {
			if (phrase.charAt(i) == ' ' || phrase.charAt(i) == '-')
				acronym += phrase.charAt(i + 1);
		}
		acronym = acronym.toUpperCase();
		return acronym;
	}

	/**
	 * 3. Determine if a triangle is equilateral, isosceles, or scalene. An
	 * equilateral triangle has all three sides the same length. An isosceles
	 * triangle has at least two sides the same length. (It is sometimes specified
	 * as having exactly two sides the same length, but for the purposes of this
	 * exercise we'll say at least two.) A scalene triangle has all sides of
	 * different lengths.
	 *
	 */
	static class Triangle {
		private double sideOne;
		private double sideTwo;
		private double sideThree;

		public Triangle() {
			super();
		}

		public Triangle(double sideOne, double sideTwo, double sideThree) {
			this();
			this.sideOne = sideOne;
			this.sideTwo = sideTwo;
			this.sideThree = sideThree;
		}

		public double getSideOne() {
			return sideOne;
		}

		public void setSideOne(double sideOne) {
			this.sideOne = sideOne;
		}

		public double getSideTwo() {
			return sideTwo;
		}

		public void setSideTwo(double sideTwo) {
			this.sideTwo = sideTwo;
		}

		public double getSideThree() {
			return sideThree;
		}

		public void setSideThree(double sideThree) {
			this.sideThree = sideThree;
		}

		public boolean isEquilateral() {
			if (this.sideOne == this.sideTwo && this.sideOne == this.sideThree)
				return true;
			else
				return false;
		}

		public boolean isIsosceles() {
			// TODO Write an implementation for this method declaration
			if (this.sideOne == this.sideTwo || this.sideOne == this.sideThree || this.sideTwo == this.sideThree)
				return true;
			else
				return false;
		}

		public boolean isScalene() {
			// TODO Write an implementation for this method declaration
			if (this.sideOne != this.sideTwo && this.sideTwo != this.sideThree)
				return true;
			else
				return false;
		}

	}

	/**
	 * 4. Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 * 
	 * @param string
	 * @return
	 */
	public int getScrabbleScore(String string) {
		// TODO Write an implementation for this method declaration
		String string2 = string.toLowerCase();
		int score = 0;
		for (int i = 0; i < string.length(); i++) {
			if (string2.charAt(i) == 'a' || string2.charAt(i) == 'e' || string2.charAt(i) == 'i'
					|| string2.charAt(i) == 'o' || string2.charAt(i) == 'u' || string2.charAt(i) == 'l'
					|| string2.charAt(i) == 'n' || string2.charAt(i) == 'r' || string2.charAt(i) == 's'
					|| string2.charAt(i) == 't')
				score++;
			if (string2.charAt(i) == 'd' || string2.charAt(i) == 'g')
				score += 2;
			if (string2.charAt(i) == 'b' || string2.charAt(i) == 'c' || string2.charAt(i) == 'm'
					|| string2.charAt(i) == 'p')
				score += 3;
			if (string2.charAt(i) == 'f' || string2.charAt(i) == 'h' || string2.charAt(i) == 'v'
					|| string2.charAt(i) == 'w' || string2.charAt(i) == 'y')
				score += 4;
			if (string2.charAt(i) == 'k')
				score += 5;
			if (string2.charAt(i) == 'j' || string2.charAt(i) == 'x')
				score += 8;
			if (string2.charAt(i) == 'q' || string2.charAt(i) == 'z')
				score += 10;

		}

		return score;
	}

	/**
	 * 5. Clean up user-entered phone numbers so that they can be sent SMS messages.
	 * 
	 * The North American Numbering Plan (NANP) is a telephone numbering system used
	 * by many countries in North America like the United States, Canada or Bermuda.
	 * All NANP-countries share the same international country code: 1.
	 * 
	 * NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan
	 * Area code, commonly known as area code, followed by a seven-digit local
	 * number. The first three digits of the local number represent the exchange
	 * code, followed by the unique four-digit number which is the subscriber
	 * number.
	 * 
	 * The format is usually represented as
	 * 
	 * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
	 * from 0 through 9.
	 * 
	 * Your task is to clean up differently formatted telephone numbers by removing
	 * punctuation and the country code (1) if present.
	 * 
	 * For example, the inputs
	 * 
	 * +1 (613)-995-0253 613-995-0253 1 613 995 0253 613.995.0253 should all produce
	 * the output
	 * 
	 * 6139950253
	 * 
	 * Note: As this exercise only deals with telephone numbers used in
	 * NANP-countries, only 1 is considered a valid country code.
	 */
	public String cleanPhoneNumber(String string) {
		// TODO Write an implementation for this method declaration
		if (string.matches("(\\w)") || string.contains("@") || string.contains(":") || string.contains("!"))
			throw new IllegalArgumentException();
		String string2 = new String(string);
		string2 = string2.replaceAll("(\\D)", "");
		if (string2.length() >= 11)
			throw new IllegalArgumentException("Can't be more than 11 digits!");

		return string2;
	}

	/**
	 * 6. Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 * 
	 * @param string
	 * @return
	 */
	public Map<String, Integer> wordCount(String string) {
		// TODO Write an implementation for this method declaration
		Map<String, Integer> map = new HashMap<>();
		int beginDex = 0;
		String substring = new String();
		string = string.replaceAll("\n", "");
		string = string.replaceAll("\\s+", " ");
		//System.out.println(string);
		for (int i = 0; i <= string.length(); i++) {
			if (i == (string.length()) || string.charAt(i) == (' ') || string.charAt(i) == ',') {
				substring = string.substring(beginDex, i);
				if (!map.containsKey(substring))
					map.put(substring, 1);
				else
					map.replace(substring, map.get(substring), map.get(substring) + 1);
				beginDex = i + 1;
			} // if at the end of a word
		} // for
		//System.out.println(map.toString());
		return map;
	}

	/**
	 * 7. Implement a binary search algorithm.
	 * 
	 * Searching a sorted collection is a common task. A dictionary is a sorted list
	 * of word definitions. Given a word, one can find its definition. A telephone
	 * book is a sorted list of people's names, addresses, and telephone numbers.
	 * Knowing someone's name allows one to quickly find their telephone number and
	 * address.
	 * 
	 * If the list to be searched contains more than a few items (a dozen, say) a
	 * binary search will require far fewer comparisons than a linear search, but it
	 * imposes the requirement that the list be sorted.
	 * 
	 * In computer science, a binary search or half-interval search algorithm finds
	 * the position of a specified input value (the search "key") within an array
	 * sorted by key value.
	 * 
	 * In each step, the algorithm compares the search key value with the key value
	 * of the middle element of the array.
	 * 
	 * If the keys match, then a matching element has been found and its index, or
	 * position, is returned.
	 * 
	 * Otherwise, if the search key is less than the middle element's key, then the
	 * algorithm repeats its action on the sub-array to the left of the middle
	 * element or, if the search key is greater, on the sub-array to the right.
	 * 
	 * If the remaining array to be searched is empty, then the key cannot be found
	 * in the array and a special "not found" indication is returned.
	 * 
	 * A binary search halves the number of items to check with each iteration, so
	 * locating an item (or determining its absence) takes logarithmic time. A
	 * binary search is a dichotomic divide and conquer search algorithm.
	 * 
	 */
	static class BinarySearch<T extends Comparable> {
		private List<T> sortedList;

		public int indexOf(T t) {
			// TODO Write an implementation for this method declaration
			int stIndex = sortedList.size() / 2;
			int rIndex = sortedList.size();
			int lIndex = 0;
			if (sortedList.isEmpty())
				return -1;
			T value; 
			
			while (lIndex <= rIndex) {
				
				//System.out.println(sortedList.size());
				value = sortedList.get(stIndex);
				//System.out.println(t.compareTo(value) + " value: " + value + " t: " + t + " index " + stIndex);
				if (t.compareTo(value) == 0)
					return stIndex;
				else if (t.compareTo(value) > 0)// go right
					lIndex = stIndex + 1;
				else // go left
					rIndex = stIndex-1;
				stIndex = (lIndex + rIndex)/2;
			}//iterative approach

			return stIndex;
		}

		public BinarySearch(List<T> sortedList) {
			super();
			this.sortedList = sortedList;
		}

		public List<T> getSortedList() {
			return sortedList;
		}

		public void setSortedList(List<T> sortedList) {
			this.sortedList = sortedList;
		}

	}

	/**
	 * 8. Implement a program that translates from English to Pig Latin.
	 * 
	 * Pig Latin is a made-up children's language that's intended to be confusing.
	 * It obeys a few simple rules (below), but when it's spoken quickly it's really
	 * difficult for non-children (and non-native speakers) to understand.
	 * 
	 * Rule 1: If a word begins with a vowel sound, add an "ay" sound to the end of
	 * the word. Rule 2: If a word begins with a consonant sound, move it to the end
	 * of the word, and then add an "ay" sound to the end of the word. There are a
	 * few more rules for edge cases, and there are regional variants too.
	 * 
	 * See http://en.wikipedia.org/wiki/Pig_latin for more details.
	 * 
	 * @param string
	 * @return
	 */
	public String toPigLatin(String string) {
		// TODO Write an implementation for this method declaration
		String substring;
		String parse[] = string.split("[ ]+");
		String newString = "";

		for (int i = 0; i < parse.length; i++) {
			for (int x = 0; x < parse[i].length(); x++) {
				if (parse[i].charAt(x) == 'a' || parse[i].charAt(x) == 'e' || parse[i].charAt(x) == 'i'
						|| parse[i].charAt(x) == 'o' || parse[i].charAt(x) == 'u') {
					substring = parse[i].substring(0, x); // take consonant
					if ((substring + parse[i].charAt(x)).equals("qu"))
						substring = parse[i].substring(0, x + 1);// checking for qu consonant case, unsure of other
																	// cases so that I can add the logic for it
					parse[i] = parse[i].replace(substring, "");
					parse[i] += substring;
					parse[i] += "ay";
					newString += parse[i] + " ";
					break;
				} // vowel check

			} // word
				// System.out.println(parse[i]);
			if (parse[i].indexOf('a') == -1)
				newString += parse[i] + "ay" + " ";// case where no vowels existed in the word
		} // phrase
		newString = newString.substring(0, newString.length() - 1);
		// System.out.println(newString);
		return newString;
	}

	/**
	 * 9. An Armstrong number is a number that is the sum of its own digits each
	 * raised to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9 10 is not an Armstrong number,
	 * because 10 != 1^2 + 0^2 = 2 153 is an Armstrong number, because: 153 = 1^3 +
	 * 5^3 + 3^3 = 1 + 125 + 27 = 153 154 is not an Armstrong number, because: 154
	 * != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 Write some code to determine whether
	 * a number is an Armstrong number.
	 * 
	 * @param input
	 * @return
	 */
	public boolean isArmstrongNumber(int input) {
		// TODO Write an implementation for this method declaration
		int input2 = input;
		int baseN = 0, sum = 0, digits;

		digits = (int) (Math.log10(input) + 1);
		while (input2 > 0) {
			baseN = input2 % 10;
			input2 /= 10;
			sum += Math.pow(baseN, digits);
		}
		if (sum == input)
			return true;
		else
			return false;
	}

	/**
	 * 10. Compute the prime factors of a given natural number.
	 * 
	 * A prime number is only evenly divisible by itself and 1.
	 * 
	 * Note that 1 is not a prime number.
	 * 
	 * @param l
	 * @return
	 */
	public List<Long> calculatePrimeFactorsOf(long l) {
		// TODO Write an implementation for this method declaration
		List<Long> longList = new ArrayList<Long>();
		long primeC = l;
		while (primeC % 2 == 0) {
			longList.add((long) 2);
			primeC /= 2;
		} // while

		for (int i = 3; i <= Math.sqrt(primeC); i += 2) {
			while (primeC % i == 0) {
				longList.add((long) i);
				primeC /= i;

			} // while
		} // for
		if (primeC > 2)
			longList.add(primeC);
		// System.out.println(longList.toString());
		return longList;
	}

	/**
	 * 11. Create an implementation of the rotational cipher, also sometimes called
	 * the Caesar cipher.
	 * 
	 * The Caesar cipher is a simple shift cipher that relies on transposing all the
	 * letters in the alphabet using an integer key between 0 and 26. Using a key of
	 * 0 or 26 will always yield the same output due to modular arithmetic. The
	 * letter is shifted for as many values as the value of the key.
	 * 
	 * The general notation for rotational ciphers is ROT + <key>. The most commonly
	 * used rotational cipher is ROT13.
	 * 
	 * A ROT13 on the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: nopqrstuvwxyzabcdefghijklm It is
	 * stronger than the Atbash cipher because it has 27 possible keys, and 25
	 * usable keys.
	 * 
	 * Ciphertext is written out in the same formatting as the input including
	 * spaces and punctuation.
	 * 
	 * Examples: ROT5 omg gives trl ROT0 c gives c ROT26 Cool gives Cool ROT13 The
	 * quick brown fox jumps over the lazy dog. gives Gur dhvpx oebja sbk whzcf bire
	 * gur ynml qbt. ROT13 Gur dhvpx oebja sbk whzcf bire gur ynml qbt. gives The
	 * quick brown fox jumps over the lazy dog.
	 */
	static class RotationalCipher {
		private int key;
		private String alphabet = new String("abcdefghijklmnopqrstuvwxyz");

		public RotationalCipher(int key) {
			super();
			this.key = key;

		}

		public String rotate(String string) {
			// TODO Write an implementation for this method declaration
			int nIndex = 0;
			String rotatedString = new String();
			char currChar;
			for (int i = 0; i < string.length(); i++) {
				// System.out.println(string.substring(i, i+1));
				currChar = string.charAt(i);
				if (string.substring(i, i + 1).matches("[a-zA-Z]")) {
					if (Character.isUpperCase(currChar)) {
						nIndex = (alphabet.indexOf(Character.toLowerCase(currChar)) + key) % 26;
						rotatedString += Character.toUpperCase(alphabet.charAt(nIndex));
					} // upper case
					else {
						nIndex = ((alphabet.indexOf(string.charAt(i)) + key) % 26);
						rotatedString += alphabet.charAt(nIndex);
					} // lower case
				} // not a letter
				else {
					rotatedString += string.charAt(i);
				}
				// System.out.println(rotatedString);
				// System.out.println("old Index " + i + " new Index " + nIndex);
			}
			// System.out.println(rotatedString);
			return rotatedString;
		}

	}

	/**
	 * 12. Given a number n, determine what the nth prime is.
	 * 
	 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
	 * that the 6th prime is 13.
	 * 
	 * If your language provides methods in the standard library to deal with prime
	 * numbers, pretend they don't exist and implement them yourself.
	 * 
	 * @param i
	 * @return
	 */

	public int calculateNthPrime(int i) {
		// TODO Write an implementation for this method declaration
		int primeCount = 0;
		boolean isPrime = true;
		int x = 2, answer = 0;
		if (i == 0)
			throw new IllegalArgumentException();

		while (primeCount != i) {

			// System.out.println(x);
			for (int y = 2; y < x; y++) {
				if (x % y == 0) {
					isPrime = false;
					// System.out.println(x + " % " + y + " " + isPrime + " " + primeCount);
					break;
				} else {
					// System.out.println(x + " % " + y + " " + isPrime + " " + primeCount);
					isPrime = true;
				}
			} // checks if x is prime

			if (isPrime) {

				answer = x;
				primeCount++;
				// System.out.println("Primes " + primeCount);
			} // updatePrimeCount
			x++;
		}
		// System.out.println(i + " " + answer + " " + primeCount);
		return answer;
	}

	/**
	 * 13 & 14. Create an implementation of the atbash cipher, an ancient encryption
	 * system created in the Middle East.
	 * 
	 * The Atbash cipher is a simple substitution cipher that relies on transposing
	 * all the letters in the alphabet such that the resulting alphabet is
	 * backwards. The first letter is replaced with the last letter, the second with
	 * the second-last, and so on.
	 * 
	 * An Atbash cipher for the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: zyxwvutsrqponmlkjihgfedcba It is a
	 * very weak cipher because it only has one possible key, and it is a simple
	 * monoalphabetic substitution cipher. However, this may not have been an issue
	 * in the cipher's time.
	 * 
	 * Ciphertext is written out in groups of fixed length, the traditional group
	 * size being 5 letters, and punctuation is excluded. This is to make it harder
	 * to guess things based on word boundaries.
	 * 
	 * Examples Encoding test gives gvhg Decoding gvhg gives test Decoding gsvjf
	 * rxpyi ldmul cqfnk hlevi gsvoz abwlt gives thequickbrownfoxjumpsoverthelazydog
	 *
	 */
	static class AtbashCipher {

		/**
		 * Question 13
		 * 
		 * @param string
		 * @return
		 */
		public static String encode(String string) {
			// TODO Write an implementation for this method declaration
			string = string.toLowerCase();
			String firstHalfAlph = new String("abcdefghijklm");
			String secondHalfAlph = new String("zyxwvutsrqpon");
			// String originalStr = new String(string);
			String newString = new String();
			int spaceCount = 0;
			boolean isChange = false;
			// System.out.println(firstHalfAlph.length());
			// System.out.println(secondHalfAlph.length());

			for (int i = 0; i < string.length(); i++) {
				isChange = false;
				for (int x = 0; x < firstHalfAlph.length(); x++) {

					if (string.charAt(i) == firstHalfAlph.charAt(x)) {
						newString += secondHalfAlph.charAt(x);
						isChange = true;
						continue;
					} else if (string.charAt(i) == secondHalfAlph.charAt(x)) {
						newString += firstHalfAlph.charAt(x);
						isChange = true;
						continue;
					}

				} // for checks for letters

				if (!isChange && string.substring(i, i + 1).matches("\\d.*")) {
					newString += string.charAt(i);
					isChange = true;
				} // checks for digits

				if (isChange && (newString.length() - spaceCount) % 5 == 0) {
					newString += " ";
					// System.out.println(newString.length());
					spaceCount++;
				} // intended to check every 5 spaces
			}
			if (newString.substring(newString.length() - 1, newString.length()).equals(" "))
				newString = newString.substring(0, newString.length() - 1); // eliminates any additional spaces created
																			// at the end of string
			// System.out.println(newString);
			return newString;
		}

		/**
		 * Question 14
		 * 
		 * @param string
		 * @return
		 */
		public static String decode(String string) {
			// TODO Write an implementation for this method declaration
			string = string.toLowerCase();
			String firstHalfAlph = new String("abcdefghijklm");
			String secondHalfAlph = new String("zyxwvutsrqpon");
			// String originalStr = new String(string);
			String newString = new String();
			int spaceCount = 0;
			boolean isChange = false;
			// System.out.println(firstHalfAlph.length());
			// System.out.println(secondHalfAlph.length());

			for (int i = 0; i < string.length(); i++) {
				// System.out.println(string.indexOf(string.indexOf(firstHalfAlph.charAt(i))));
				isChange = false;
				for (int x = 0; x < firstHalfAlph.length(); x++) {

					if (string.charAt(i) == firstHalfAlph.charAt(x)) {
						newString += secondHalfAlph.charAt(x);
						isChange = true;
						continue;
					} else if (string.charAt(i) == secondHalfAlph.charAt(x)) {
						newString += firstHalfAlph.charAt(x);
						isChange = true;
						continue;
					}

				} // for checks for letters

				if (!isChange && string.substring(i, i + 1).matches("\\d.*")) {
					newString += string.charAt(i);
					isChange = true;
				} // checks for digits

			}
			// System.out.println(newString);
			return newString;
		}
	}

	/**
	 * 15. The ISBN-10 verification process is used to validate book identification
	 * numbers. These normally contain dashes and look like: 3-598-21508-8
	 * 
	 * ISBN The ISBN-10 format is 9 digits (0 to 9) plus one check character (either
	 * a digit or an X only). In the case the check character is an X, this
	 * represents the value '10'. These may be communicated with or without hyphens,
	 * and can be checked for their validity by the following formula:
	 * 
	 * (x1 * 10 + x2 * 9 + x3 * 8 + x4 * 7 + x5 * 6 + x6 * 5 + x7 * 4 + x8 * 3 + x9
	 * * 2 + x10 * 1) mod 11 == 0 If the result is 0, then it is a valid ISBN-10,
	 * otherwise it is invalid.
	 * 
	 * Example Let's take the ISBN-10 3-598-21508-8. We plug it in to the formula,
	 * and get:
	 * 
	 * (3 * 10 + 5 * 9 + 9 * 8 + 8 * 7 + 2 * 6 + 1 * 5 + 5 * 4 + 0 * 3 + 8 * 2 + 8 *
	 * 1) mod 11 == 0 Since the result is 0, this proves that our ISBN is valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isValidIsbn(String string) {
		// TODO Write an implementation for this method declaration

		String formattedString = new String(string.toLowerCase());
		ArrayList<Integer> list = new ArrayList<>();
		Integer sum = 0;
		string = string.replaceAll(" ", "");
		string = string.replaceAll("-", "");
		string = string.toLowerCase();
		formattedString = string.substring(0, string.length() - 1);
		formattedString = formattedString.replaceAll("\\D", "");

		if (string.substring(string.length() - 1, string.length()).matches("\\d")
				|| string.substring(string.length() - 1, string.length()).equals("x"))
			formattedString += string.substring(string.length() - 1, string.length());

		if (formattedString.length() != string.length() || formattedString.length() != 10) {
			return false;
		} // invalid character

		if (!string.equals(formattedString) || formattedString.length() < 1) {
			return false;
		} else {
			for (int i = 0; i < formattedString.length(); i++) {
				try {
					list.add(Integer.parseInt(formattedString.substring(i, i + 1)));
					sum += (list.get(i) * (10 - i));
				} catch (NumberFormatException e) {
					list.add(10);
					sum += (list.get(i) * (10 - i));
				}

			}
		} // no invalid characters
		if (sum % 11 == 0) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * 16. Determine if a sentence is a pangram. A pangram (Greek: Ï€Î±Î½
	 * Î³Ï�Î¬Î¼Î¼Î±, pan gramma, "every letter") is a sentence using every letter of
	 * the alphabet at least once. The best known English pangram is:
	 * 
	 * The quick brown fox jumps over the lazy dog.
	 * 
	 * The alphabet used consists of ASCII letters a to z, inclusive, and is case
	 * insensitive. Input will not contain non-ASCII symbols.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isPangram(String string) {
		// TODO Write an implementation for this method declaration
		string = string.toLowerCase();
		HashSet<Character> allChars = new HashSet<>();
		// string = string.replaceAll("\\W", "");
		// System.out.println(string);
		for (int i = 0; i < string.length(); i++) {
			if (string.substring(i, i + 1).matches("\\w") && string.substring(i, i + 1).matches("\\D")
					&& string.charAt(i) != ' ')
				allChars.add(string.charAt(i));
		} // adds only alphabetical characters into set from the string
			// System.out.println(allChars.toString());
		if (allChars.size() == 26) {
			return true;
		} // since this is a set no duplicate characters will be added to the set so
			// checking the size of the set matches the length of the alphabet
			// should prove this is a pangram
		else {

			return false;
		}

	}

	/**
	 * 17. Calculate the moment when someone has lived for 10^9 seconds.
	 * 
	 * A gigasecond is 109 (1,000,000,000) seconds.
	 * 
	 * @param given
	 * @return
	 */
	public Temporal getGigasecondDate(Temporal given) {
		// TODO Write an implementation for this method declaration
		LocalDateTime date;
		if (given.getClass().equals(LocalDate.class)) {
			date = ((LocalDate) given).atStartOfDay();
			date = date.plus(1000000000, ChronoUnit.SECONDS);
			// System.out.println(date.toString());
			return date;
		} else {
			given = given.plus(1000000000, ChronoUnit.SECONDS);
			// System.out.println(given.toString());
			return given;
		}
	}

	/**
	 * 18. Given a number, find the sum of all the unique multiples of particular
	 * numbers up to but not including that number.
	 * 
	 * If we list all the natural numbers below 20 that are multiples of 3 or 5, we
	 * get 3, 5, 6, 9, 10, 12, 15, and 18.
	 * 
	 * The sum of these multiples is 78.
	 * 
	 * @param i
	 * @param set
	 * @return
	 */
	public int getSumOfMultiples(int i, int[] set) {
		// TODO Write an implementation for this method declaration
		int sum = 0;
		// System.out.println("i: " + i);
		HashSet<Integer> multSet = new HashSet<Integer>();
		for (int x = 0; x < set.length; x++) {

			for (int j = 1; (set[x] * j) < i; j++) {
				multSet.add(Integer.valueOf(set[x] * j));
			} // for
		} // for
		Iterator<Integer> iter = multSet.iterator();
		while (iter.hasNext())
			sum += iter.next();
		// System.out.println("------------------");
		// System.out.println(sum);
		return sum;
	}

	/**
	 * 19. Given a number determine whether or not it is valid per the Luhn formula.
	 * 
	 * The Luhn algorithm is a simple checksum formula used to validate a variety of
	 * identification numbers, such as credit card numbers and Canadian Social
	 * Insurance Numbers.
	 * 
	 * The task is to check if a given string is valid.
	 * 
	 * Validating a Number Strings of length 1 or less are not valid. Spaces are
	 * allowed in the input, but they should be stripped before checking. All other
	 * non-digit characters are disallowed.
	 * 
	 * Example 1: valid credit card number 1 4539 1488 0343 6467 The first step of
	 * the Luhn algorithm is to double every second digit, starting from the right.
	 * We will be doubling
	 * 
	 * 4_3_ 1_8_ 0_4_ 6_6_ If doubling the number results in a number greater than 9
	 * then subtract 9 from the product. The results of our doubling:
	 * 
	 * 8569 2478 0383 3437 Then sum all of the digits:
	 * 
	 * 8+5+6+9+2+4+7+8+0+3+8+3+3+4+3+7 = 80 If the sum is evenly divisible by 10,
	 * then the number is valid. This number is valid!
	 * 
	 * Example 2: invalid credit card number 1 8273 1232 7352 0569 Double the second
	 * digits, starting from the right
	 * 
	 * 7253 2262 5312 0539 Sum the digits
	 * 
	 * 7+2+5+3+2+2+6+2+5+3+1+2+0+5+3+9 = 57 57 is not evenly divisible by 10, so
	 * this number is not valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isLuhnValid(String string) {
		// TODO Write an implementation for this method declaration
		String formattedString = new String(string);
		string = string.replaceAll(" ", "");
		formattedString = formattedString.replaceAll("(\\D)", "");
		ArrayList<Integer> list = new ArrayList<>();
		Integer sum = 0;
		// System.out.println("Format: " + formattedString);
		if (!string.equals(formattedString) || formattedString.length() < 1) {
			// System.out.println(string);
			// System.out.println("Invalid");
			return false;
		} else {
			for (int i = 0; i < formattedString.length(); i++) {
				list.add(Integer.parseInt(formattedString.substring(i, i + 1)));

			}
			for (int j = 0; j < list.size(); j++) {
				if (j % 2 == 1) {
					if ((list.get(j) * 2) > 9)
						list.set(j, (list.get(j) * 2) - 9);
					else
						list.set(j, list.get(j) * 2);

				} // other number
					// System.out.println(list.get(j));
				sum += list.get(j);
			} // doubling stuff
		} // no invalid characters
		if (sum % 10 == 0) {
			// System.out.println(formattedString + " Valid");
			return true;
		} else {
			// System.out.println(formattedString + " Invalid");
			return false;
		}
	}

	/**
	 * 20. Parse and evaluate simple math word problems returning the answer as an
	 * integer.
	 * 
	 * Add two numbers together.
	 * 
	 * What is 5 plus 13?
	 * 
	 * 18
	 * 
	 * Now, perform the other three operations.
	 * 
	 * What is 7 minus 5?
	 * 
	 * 2
	 * 
	 * What is 6 multiplied by 4?
	 * 
	 * 24
	 * 
	 * What is 25 divided by 5?
	 * 
	 * 5
	 * 
	 * @param string
	 * @return
	 */
	public int solveWordProblem(String string) {
		// TODO Write an implementation for this method declaration
		string = string.toLowerCase();
		String delims = new String("[ ?]+");
		String[] tokens = string.split(delims);
		Integer[] x = { 0, 0 };
		int op = 0;
		boolean plus = false;
		boolean mult = false;
		boolean sub = false;
		boolean div = false;
		Integer answer = 0;
		for (int i = 0; i < tokens.length; i++) {

			if (tokens[i].matches("-?\\d+(\\.\\d+)?")) {
				x[op] = x[op].parseInt(tokens[i]);
				op++;
			}

			if (tokens[i].equals("plus"))
				plus = true;
			if (tokens[i].equals("minus"))
				sub = true;
			if (tokens[i].equals("multiplied"))
				mult = true;
			if (tokens[i].equals("divided"))
				div = true;

		} // for
		if (plus)
			answer = x[0] + x[1];
		if (sub)
			answer = x[0] - x[1];
		if (mult)
			answer = x[0] * x[1];
		if (div)
			answer = x[0] / x[1];
		return answer;
	}

}
