import string
small_letter = string.ascii_lowercase
letter_to_int = dict()
int_to_letter = dict()
counter = 0
for i in small_letter:
    letter_to_int[i] = counter
    int_to_letter[counter] = i
    counter += 1
n = int(input())
sol_vec = [[0 for i in range(26)] for j in range(2)]
tmp = input()
for j in tmp:
    sol_vec[0][letter_to_int[j]] += 1
for i in range(n-1):
    tmp = input()
    for j in tmp:
        if sol_vec[0][letter_to_int[j]] > 0:
            sol_vec[1][letter_to_int[j]] += 1
    for j in range(26):
        if sol_vec[1][j] < sol_vec[0][j]:
            sol_vec[0][j] = sol_vec[1][j]
        sol_vec[1][j] = 0
ans_string = ""
for i in range(26):
    ans_string +=  int_to_letter[i] * sol_vec[0][i]
print(ans_string)