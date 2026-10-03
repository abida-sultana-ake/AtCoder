A,B,K,L = map(int, input().split())

print((int)(K/L)*B+min((K%L)*A,B))