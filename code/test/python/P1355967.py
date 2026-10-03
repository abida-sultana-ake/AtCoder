S=input()
if len(S)%2 == 0:
  print('First' if S[0]==S[-1] else 'Second')
else:
  print('First' if S[0]!=S[-1] else 'Second')
