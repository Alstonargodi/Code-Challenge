import array

# def Anagrams(word1,word2):
#     if len(word1) != len(word2):
#         return False
# 
#     charCount = array.array('i',(0 for i in range(0,26)))
#     
#     for i in len(word1):
#         charCount[word1[i]-'a']


def Anagrams(word1,word2):
    # sort word per character
    if(sorted(word1) == sorted(word2)):
        print("yes")
    else:
        print("no")

Anagrams("listen","silent")
    