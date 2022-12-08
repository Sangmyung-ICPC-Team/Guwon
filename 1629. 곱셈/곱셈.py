import sys

input = sys.stdin.readline

A, B, C = map(int, input().split())

def DaC(a, b):
    if b == 1:
        return a % C
    else:
        temp = DaC(a, b // 2)
        #짝수일 때 temp*temp
        if b % 2 == 0:
            return temp * temp % C
        #홀수일 때 temp*temp*a
        else:
            return temp * temp * a % C

print(DaC(A, B))