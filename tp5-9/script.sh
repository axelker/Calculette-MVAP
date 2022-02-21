#!/bin/sh
 export CLASSPATH=".:/usr/share/java/*:$CLASSPATH"
 export CLASSPATH=".:/usr/local/lib/antlr-4.9-complete.jar:$CLASSPATH"

java org.antlr.v4.Tool Calculette.g4 && javac *.java
java MainCalculette > test1.mvap
java MVaPAssembler -d test1.mvap 
java CBaP -d test1.mvap.cbap