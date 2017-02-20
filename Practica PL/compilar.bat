java -jar ../jflex-1.6.1\lib\jflex-1.6.1.jar *.flex
javac Yylex.java
java Yylex p0-0.txt > resultado.txt
pause