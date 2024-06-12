n = int(input())

li = list(map(int,input().split()))

min_li = [10e9]*n
min_li[0] = 0
min_li[1] = 1 + abs(li[1] - li[0])

for j in range(1, n):
    for i in range(j-1,-1,-1):
        min_li[j] = min(min_li[j] ,max(min_li[i], (j-i) * (1 + abs(li[i] - li[j]))))
print(min_li[n-1])