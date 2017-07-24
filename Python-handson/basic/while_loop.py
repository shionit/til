# coding: UTF-8
# ループ (while)

n = 0

while n < 10:
    if n == 3:
        n += 1
        continue
    print(n)
    n += 1
else:
    print("end")
