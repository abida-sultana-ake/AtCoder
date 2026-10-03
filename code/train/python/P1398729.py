s = input()

length = len(s) - 2

def guumoji(s):
    length = len(s)

    if s[:length//2] == s[length//2:]:
        return True

    return False

while length > 0:
    if guumoji(s[:length]):
        break

    length -= 2

print(length)