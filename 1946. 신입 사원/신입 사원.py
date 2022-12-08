from sys import stdin

for i in range(int(stdin.readline())):
    a = []
    for j in range(int(stdin.readline())):
        a.append(list(map(int, stdin.readline().split())))

    a.sort()
    temp = a[0][1]

    index = 1
    for j in range(len(a)):
        if temp > a[j][1]:
            index += 1
            temp = a[j][1]
    print(index)