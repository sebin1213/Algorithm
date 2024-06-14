import heapq

n= int(input())
for i in range(n):
    li=[]
    result=0
    num = int(input())
    f_list = list(map(int,input().split(' ')))
    for i in f_list:
        heapq.heappush(li,i)

    while len(li)>1:
        min_val1 = heapq.heappop(li)
        min_val2 = heapq.heappop(li)

        val = min_val1 + min_val2
        result += val
        heapq.heappush(li,val)
    print(result)