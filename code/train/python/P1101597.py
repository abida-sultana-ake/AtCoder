s = input()
posA = s.find('A')
posZ = len(s) - s[::-1].find('Z') - 1 # s[::-1]でsを反転
print(posZ - posA + 1)