words = list(input())

for i in ['a','e','i','o','u']:
    while i in words :
        words.remove(i)

print (''.join(words))
