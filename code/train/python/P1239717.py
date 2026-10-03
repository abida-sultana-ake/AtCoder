import sys
def read(): return list(map(int, input().split()))


a = int(input())
b = int(input())

if a == b:
    print("EQUAL")
    sys.exit()

print("GREATER" if a > b else "LESS")