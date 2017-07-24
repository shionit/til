# coding: UTF-8
# 条件分岐 if

# <= >= > < == !=

score = 70

if score >= 80:
    print("pass!")
else:
    print("not pass!")

# 1 liner
print("pass!" if score >= 80 else "not pass!")

if score >= 80:
    print("OK!")
elif score >= 60:
    print("so so")
else:
    print("oh....")
    
if 40 <= score < 60:
    print("mmmmmmm")
