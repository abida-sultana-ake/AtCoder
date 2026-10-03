nb_s, nb_c = map(int, input().split())

if nb_s*2 > nb_c:
    print(nb_c // 2)
else:
    nb_used_c = 2*nb_s

    nb_rest_c = int(nb_c) - nb_used_c

    print(int(nb_s) + (nb_rest_c // 4))