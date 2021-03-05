/*
 * MIT License
 * 
 * Copyright (c) 2021 Morgan McFord
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;

public class Main {
	
	static String passwords;
	
	
	public static void Generator(String passover, String exclusions, String startphrase) {
		
		Random rA = new Random();
		passwords = null;
		
		String passoverArray[] = passover.split(",");
		String exclusionsArray[] = exclusions.split(" ");
		String localPasswords = "";
		String password;
		boolean skip = false;
		
		int length = (Integer.parseInt(passoverArray[0]) - startphrase.length());
		int number = Integer.parseInt(passoverArray[1]);
		
		System.out.println(startphrase);
		
		for (int j = 0; j < number; j++) {		
			
			if (startphrase.length() < 1) {
				
				password = ""; // need to declare password and set it to anything other than null so the next function works
				
			}
			
			else {
				
				password = startphrase + "_";
				length = (Integer.parseInt(passoverArray[0]) - (startphrase.length() + 1));
				
			}
			
			for (int i = 0; i < length; i++) {
				
				int randomNumber = rA.nextInt(93);
				
				for(int k = 0; k < exclusionsArray.length; k++) {
					
					if(String.valueOf((char)(randomNumber + 33)).equals((exclusionsArray[k]))) {
						skip = true;
					}
					
				}
				
				if (skip == true) {
					i--;
					skip = false;
				}
				
				else {
					password = password + (char)(randomNumber + 33);
				}
			
					
			}
						
			localPasswords = localPasswords + password + "\n";
		}
		
		passwords = localPasswords;
		
	}
	
	public static void GeneratorTwo(int noWords,int noPasswords, String startphrase,Boolean numbers) throws IOException {
		
		Random rA = new Random();
		String password = null;
		passwords = "";
		
		for(int k = 0; k < noPasswords; k++) {
			
			if (startphrase.length() < 1) {
				password = "Words"; // need to declare password and set it to anything other than null so the next function works
			}
			
			else {
				password = startphrase;			
			}
		
			for(int i = 0; i < (noWords - 1); i++) {
				
				int temp = rA.nextInt(2000);
				
				FileInputStream fs= new FileInputStream("words.txt");
				BufferedReader br = new BufferedReader(new InputStreamReader(fs));
				for(int j = 0; j < temp; j++)
				  br.readLine();
				String nextWord = br.readLine();
				
				password = password +  "-" + nextWord;
				
			}
			
			if(numbers == true) {
				
				String tempInt = String.valueOf(rA.nextInt(9));
				
				password = password + "-";
				
				for(int m = 0; m < 4;m++) {
					
					tempInt = tempInt + String.valueOf(rA.nextInt(9));
				}
				
				password = password + tempInt;
				
			}
			
			passwords = passwords + password + "\n" ; 
		}
		
		
	}
	

}
