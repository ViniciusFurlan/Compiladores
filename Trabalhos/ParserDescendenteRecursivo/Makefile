all: final

final: Lex.o Lex.h
	gcc -g -o parser Lex.o  parser.c

Lex.o: Lex.c Lex.h
	gcc -c -g Lex.c
clean:
	rm  *.o parser
