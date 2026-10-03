# coding: utf-8
def get_ln_inputs():
    return input().split()
 
 
def get_ln_int_inputs():
    return list(map(int, get_ln_inputs()))
 

def reverse_words(words_list):
    return list(map(lambda w: w[::-1], words_list))


def main():
    N = get_ln_int_inputs()[0]
    words = list()
    for _ in range(N):
        words.append(get_ln_inputs()[0])

    rev_dictionary = reverse_words(sorted(reverse_words(words)))

    for i in range(N):
        print(rev_dictionary[i])


main()