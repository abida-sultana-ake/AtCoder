name = input()
print('YES' if all(name[i] == name[-(i + 1)] for i in range(len(name)//2)) else 'NO')
