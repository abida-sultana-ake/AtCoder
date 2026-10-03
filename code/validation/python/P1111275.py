
_input = input().split(' ')
_A = int(_input[0])
_B = int(_input[1])
A = max(_A, _B)
B = min(_A, _B)


def calc_ten(n):
    ans_list  = [ calc_five( abs(n-10*i) ) + i for i in range(0, 5)]
    return min(ans_list)


def calc_five(n):
    ans_list = [ abs(n - 5*i)+i for i in range(0, 2)]
    return min(ans_list)



gap = abs(A-B)
# if( B == 0 and A%10 != 0):
#     print(gap//10+1)
# elif( A == 40 and B%10 != 0 ):
#     print(gap//10+1)
# else:
print(str(calc_ten(gap)))