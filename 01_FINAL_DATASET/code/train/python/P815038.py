A,B,C = map(str, input().split())
iroha = [A, B, C]
iroha.sort()
if (iroha == ['5', '5', '7']):
    print("YES")
else:
    print("NO")
