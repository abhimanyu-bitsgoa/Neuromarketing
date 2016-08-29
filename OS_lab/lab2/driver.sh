clear;
while true
do
clear;
echo "Select the program";
echo " Press 0 to see all the process along with the i values";
echo " Press 1 to see all the process along with the level values";
echo " Press 2 to see the death of 2 Grandchildren";
echo " Press 3 to enter into the matrix multiplication mode";
echo " Press q to quit"

read key;
echo $key;

#iterations
if [ "$key" = "0" ]
  then
    clear;
  g++ iterate.cpp;
  clear;
  echo "Please enter N ";
  ./a.out|sort|uniq>temp;
  cat temp;
  echo -n "No of processes = ";
  wc -l temp | cut -d ' ' -f 1 ;
  rm temp;

  echo "Press anything to continue"
  read x
fi

#levels
if [ "$key" = "1" ]
  then
    clear;
  g++ level.cpp;
  clear;
  echo "Please enter N ";
  ./a.out|sort|uniq
  echo "Press anything to continue"
  read x
fi

#grandchildren
if [ "$key" = "2" ]
  then
    clear;
  g++ grand.cpp;
  clear;
  ./a.out
  echo "Press anything to continue"
  read x
fi

#matrix
if [ "$key" = "3" ]
  then
  clear;
  g++ matrix.cpp;
  clear;
  echo "How many times you want to run? ";
  read num
  touch matrix_out;
  rm matrix_out;
  for((  i = 0 ;  i < $num;  i++  ))
do
./a.out>>matrix_out;
echo " ">>matrix_out;
done
cat matrix_out;
echo "Press anything to continue"
read x
fi

if [ "$key" = "q" ]
  then
    break;
fi

done

clear
echo "Thanks ";
