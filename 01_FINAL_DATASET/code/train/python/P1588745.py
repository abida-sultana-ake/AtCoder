from itertools import permutations
 
 
def warshallFloyd(V, dp):
    for k in range(V):
        for i in range(V):
            for j in range(V):
                # dp[i][j] = min(dp[i][j], dp[i][k] + dp[k][j])
                new_dist = dp[i][k] + dp[k][j]
                if dp[i][j] > new_dist:
                    dp[i][j] = new_dist
 
 
def main():
    N, M, R = [int(x) for x in input().split()]
    destinations = [int(x) for x in input().split()]
    dp = [[float('inf')]*(N+1) for _ in range(N+1)]
    for i in range(N+1):
        dp[i][i] = 0
    for _ in range(M):
        f, t, d = [int(x) for x in input().split()]
        dp[f][t] = dp[t][f] = d
 
    warshallFloyd(N+1, dp)
 
    minimum_cost = float('inf')
    for route in permutations(destinations, len(destinations)):
        cost = 0
        while len(route) > 1:
            f, t = route[0], route[1]
            cost += dp[f][t]
            if cost > minimum_cost:
                break
            route = route[1:]
        if cost < minimum_cost:
            minimum_cost = cost
    print(minimum_cost)
 
 
if __name__ == '__main__':
    main()