g++ thread.cpp;
 echo $1>>hello;
for((  i = 0 ;  i < $1;  i++  ))
do
./a.out>>hello;
done
g++ eval.cpp;
./a.out<hello;
rm hello
exit 0
