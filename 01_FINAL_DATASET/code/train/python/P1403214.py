N,M = map(int, input().split())

if M<N*2 or N*4<M :
    print('-1 -1 -1')
    exit()

dif = M - N*3
if dif==0:
    print('0 {0} 0'.format(N))
elif dif<0:
    print('{0} {1} 0'.format(-dif, N+dif))
else:
    print('0 {0} {1}'.format(N-dif,dif))
