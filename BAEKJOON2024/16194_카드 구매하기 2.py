n = int(input())
li = list(map(int,input().split()))
dp_li=[0]+li
for i in range(2,n+1):
    for j in range((i+1)//2,i):
        dp_li[i] = min(dp_li[i], dp_li[j]+dp_li[i-j])
print(dp_li[n])