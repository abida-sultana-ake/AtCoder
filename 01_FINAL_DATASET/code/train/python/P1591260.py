N = int(input())
S = input()

Sold = S
while True:
    Snew = Sold.replace('()', '')
    if len(Snew) == len(Sold):
        break
    Sold = Snew

num = Snew.count(')')
print('(' * num + S + ')' * (len(Snew) - num))
