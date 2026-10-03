A, B = input().split()
print(max(int('9' + A[1:]) - int(B),
          int(A[0] + '9' + A[2]) - int(B),
          int(A[0:2] + '9') - int(B),
          int(A) - int('1' + B[1:]),
          int(A) - int(B[0] + '0' + B[2]),
          int(A) - int(B[0:2] + '0')))
