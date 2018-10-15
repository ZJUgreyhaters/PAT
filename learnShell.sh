#!/bin/bash
:<<comment
Here is a format of Comment.
comment

#-----
#注释
#-----

#参数
echo $1
#$0指当前执行的文件
echo "$0 is excuting..."
#字符串
my_name="wbchen"
#双引号可以应用变量
greeting="Hello, my name is ${my_name}. and..."
echo ${greeting}
# # 指长度
echo "thhe length of the greeting above is ${#greeting}"
for skill in Java C Julia; do
        echo "I am good at ${skill}."
done

#参数
para[0]="age : 22"
para[1]="major : CS"
para[2]="$1"
para[3]="$2"

echo "Array : ${para[@]} and length is ${#para[@]}"

echo "$?. (0 means no errors.)"
