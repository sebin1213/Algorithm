R, C = map(int, input().split())
word_li=[]
puzzle=[]
for _ in range(R):
    word = input()
    puzzle.append(word)
    count=0
    for i in range(C):
        if word[i] =="#":
            if count >= 2:
                word_li.append(word[i-count:i])
            count = 0
        else:
            count += 1
    if count >= 2:
        word_li.append(word[C-count:C])

for c in range(C):
    word=""
    for r in range(R):
        if puzzle[r][c] =="#":
            if len(word) >= 2:
                word_li.append(word)
            word=""
        else:
            word = word+puzzle[r][c]
    if len(word) >= 2:
        word_li.append(word)
word_li.sort()
print(word_li[0])