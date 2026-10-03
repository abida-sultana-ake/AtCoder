A, B = map(int, raw_input().split())

result = A + B

while True:
    if 24 <= result:
        result -= 24
    else:
        break

print(result)