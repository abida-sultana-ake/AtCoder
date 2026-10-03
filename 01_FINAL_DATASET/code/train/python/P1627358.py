# coding: utf-8
def map_list(fn, itr):
    return list(map(fn, itr))


def get_ln_inputs():
    return input().split()


def get_ln_int_inputs():
    return map_list(int, get_ln_inputs())


def is_semi_prime(n):
    if n < 2:
        return False
    if n == 2 or n == 3 or n == 5:
        return True
    elif (n % 2) != 0 and (n % 3) != 0 and (n % 5) != 0:
        return True 
    return False

def main():
    N = get_ln_int_inputs()[0]
    if is_semi_prime(N):
        print("Prime")
    else:
        print("Not Prime")
    return


main()