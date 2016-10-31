import csv
import sys

data=list()
f = open(sys.argv[1], 'rt')
try:
    reader = csv.reader(f)
    
    for row in reader:
        if len(row)==4:
        	data.append(row)
        	
    	
finally:
    f.close()

numff=0
numfr=0
numrf=0
numrr=0
dict={'F':0,'R':0}
vff=0
vfr=0
vrf=0
vrr=0
total=len(data)
for row in data:
	if len(row[1])==4:
		if ''.join([row[1][2],row[1][3]])=='FD':
			numff=numff+1
			vff=vff+int(row[2])
		elif ''.join([row[1][2],row[1][3]])=='FL':
			numfr=numfr+1
			vfr=vfr+int(row[2])
		elif ''.join([row[1][2],row[1][3]])=='RD':
			numrf=numrf+1
			vrf=vrf+int(row[2])
		elif ''.join([row[1][2],row[1][3]])=='RL':
			numrr=numrr+1
			vrr=vrr+int(row[2])
	else:
#		print "kfhdkjh"
		dict[row[1][2]]=dict[row[1][2]]+1
			
if numff!=0:
	print "FD has ",numff,float(vff)/numff
else:
	print "FD has ",numff,"NA"
	
if numfr!=0:
	print "FL has ",numfr,float(vfr)/numfr
else:
	print "FL has ",numfr,"NA"
	
if numrf!=0:
	print "RD has ",numrf,float(vrf)/numrf
else:
	print "RD has ",numrf,"NA"
	
if numrr!=0:
	print "RL has ",numrr,float(vrr)/numrr,"\n"
else:
	print "RL has ",numrr,"NA","\n"
	
	
print "Total : ",total
print "Responded : ",numff+numfr+numrf+numrr
print "Missed : ",total-(numff+numfr+numrf+numrr)
print "Accuracy : ",float(numff+numrr)/(numff+numfr+numrf+numrr)*100,'%'

print "Missed with F : ",dict['F']
print "Missed with R : ",dict['R']

    
# FD FL RD RL 

