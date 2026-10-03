import sys

S = raw_input()
S = S[::-1]
T = ''
words = ['dreamer', 'dream', 'eraser', 'erase']
for i in range(len(words)):
    words[i] = words[i][::-1]
while len(S):
    N = len(S)
    for word in words:
        if S[:len(word)] == word:
            S = S[len(word):]
            break
    if N == len(S):
        sys.stdout.write('NO')
        break
    if len(S) == 0:
        sys.stdout.write('YES')