import random, time
import os
import math
random.seed(999999999999999999999999999999999999)
key=0
flag="###########"
i=math.floor(random.random()*100)
while i > 0:
    random.random() #to mix it up a little
    i-=1
key=math.floor(random.random()*1000000)
#os.system('echo ' + str('nc stuyctf.me 34567'))
os.system('echo '+str(key)+' | nc stuyctf.me 34567')