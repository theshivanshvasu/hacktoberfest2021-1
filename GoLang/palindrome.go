package main

/**
Returns true/false if a input character is a palindrome or not
@Usage
isPalindrome("OYO") @Returns True
isPalindrome("DYO") @Returns False
*/
func isPalindrome(str string) bool {
	for i := 0; i < len(str); i++ {
		if str[i] != str[len(str)-1-i] {
			return false
		}
	}
	return true
}
