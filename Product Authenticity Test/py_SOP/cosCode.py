import numpy as np
import re
import matplotlib.pyplot as plt
import scipy.io
# rl_mat = scipy.io.loadmat('/home/aronzx/Desktop/py/RL.mat')
# fl_mat = scipy.io.loadmat('/home/aronzx/Desktop/py/FL.mat')
# rd_mat = scipy.io.loadmat('/home/aronzx/Desktop/py/RD.mat')
# fd_mat = scipy.io.loadmat('/home/aronzx/Desktop/py/FD.mat')
# rl_mat.keys()
comp = scipy.io.loadmat('comp.mat')
lis=[];
rl_pattern = re.compile("RealLike_Segment_0..")
fl_pattern = re.compile("FakeLike_Segment_0..")
rd_pattern = re.compile("RealDislike_Segment_0..")
fd_pattern = re.compile("FakeDislike_Segment_0..")
rl_list=[];
fl_list=[];
rd_list=[];
fd_list=[];
for k in comp:
    if(rl_pattern.match(k)):
        rl_list.append(k)
    if(fl_pattern.match(k)):
        fl_list.append(k)
    if(rd_pattern.match(k)):
        rd_list.append(k)
    if(fd_pattern.match(k)):
        fd_list.append(k)
rlmat = np.zeros(shape=(33,500))
flmat = np.zeros(shape=(33,500))
rdmat = np.zeros(shape=(33,500))
fdmat = np.zeros(shape=(33,500))
                 
for k in rl_list:
    rlmat=rlmat+np.array(comp[k])
rlmat=np.divide(rlmat,len(rl_list))

for k in fl_list:
    flmat=flmat+np.array(comp[k])
flmat=np.divide(flmat,len(fl_list))

for k in rd_list:
    rdmat=rdmat+np.array(comp[k])
rdmat=np.divide(rdmat,len(rd_list))

for k in fd_list:
    fdmat=fdmat+np.array(comp[k])
fdmat=np.divide(fdmat,len(fd_list))

#plt.plot(rlmat[9])
#plt.plot(flmat[9])
#plt.plot(rdmat[9])
#plt.plot(fdmat[9])
#plt.show()
rl_scatter=np.zeros(shape=(1,500));
fl_scatter=np.zeros(shape=(1,500));
rd_scatter=np.zeros(shape=(1,500));
fd_scatter=np.zeros(shape=(1,500));

for k in rl_list:
	rl_scatter=np.array(comp[k][0]);
	x=0;y=abs(rl_scatter[0]);
	z=0;
	for e in rl_scatter:
		
		if(abs(e)>y):
			x=z;
			y=e;
		z=z+1;
	plt.scatter(x,y)
plt.show()	


for k in fl_list:
	fl_scatter=np.array(comp[k][0]);
	x=0;y=abs(fl_scatter[0]);
	z=0;
	for e in fl_scatter:
		
		if(abs(e)>y):
			x=z;
			y=e;
		z=z+1;
	plt.scatter(x,y)
plt.show()

for k in rd_list:
	rd_scatter=np.array(comp[k][0]);
	x=0;y=abs(rd_scatter[0]);
	z=0;
	for e in rd_scatter:
		
		if(abs(e)>y):
			x=z;
			y=e;
		z=z+1;
	plt.scatter(x,y)
plt.show()	
	
for k in fd_list:
	fd_scatter=np.array(comp[k][0]);
	x=0;y=abs(fd_scatter[0]);
	z=0;
	for e in fd_scatter:
		
		if(abs(e)>y):
			x=z;
			y=e;
		z=z+1;
	plt.scatter(x,y)


plt.scatter(2,3)
plt.show()
#plt.show()
