def input_parser():
    N=int(input())
    return N

N=input_parser()
bank=0
for i in range(0,N,1):
    bank+=800
    if (i+1)%15 is 0:
        bank-=200

def output_parser(bank):
    print(bank)

output_parser(bank)