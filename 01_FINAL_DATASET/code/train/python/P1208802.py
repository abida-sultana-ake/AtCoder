odd_strs = input()
even_strs = input()
length = len(odd_strs)

password = ""
for i in range(length):
    password += odd_strs[i]
    if i < len(even_strs):
        password += even_strs[i]

print(password)