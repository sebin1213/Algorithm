a = input()
count, pipe = 0, 0
laser = True
for i in a:
    if i == "(":
        pipe+=1
        laser = True
    else:
        pipe-=1
        if laser:
            count+=pipe
            laser = False
        else:
            count+=1
print(count)