import heapq

n = int(input())
h_li=[]
now_time=10e9
for _ in range(n):
    t_i, s_i= map(int,input().split())
    heapq.heappush(h_li,[-s_i,t_i])
for _ in range(n):
    t_i, s_i = heapq.heappop(h_li)
    t_i = -t_i
    if now_time > t_i:
        now_time = t_i
    now_time -= s_i
if now_time < 0:
    now_time=-1
print(now_time)