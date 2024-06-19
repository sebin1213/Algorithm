N, K = map(int, input().split())
levels = [int(input()) for _ in range(N)]
low, high = min(levels), max(levels) + K
max_level = -10e9

def check(T):
    total = 0
    for level in levels:
        if level < T:
            total += (T - level)
        if total > K:
            return False
    return total <= K

while low <= high:
    mid = (low + high) // 2
    if check(mid):
        max_level = mid
        low = mid + 1
    else:
        high = mid - 1

print(max_level)