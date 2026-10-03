line = input()
s = len(line)
last = line[0]
count = 0
for letter in line:
    if letter!=last:
        last = letter
        count+=1
print(count)