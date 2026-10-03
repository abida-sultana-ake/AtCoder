w = input()
result = ""
for i in w:
    if(i not in {'a', 'i', 'u', 'e', 'o'}):
        result += i

print(result)
