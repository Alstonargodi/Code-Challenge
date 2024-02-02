def palindrome(word):
    if word == word[::-1]:
        print("yes")
    else:
        print("no")


palindrome("malayalam")