DIGITO			[0-9]
LETRA				[a-zA-Z]

INTEGER_LITERAL			{DIGITO}+
IDENTIFIER			    {LETRA}({LETRA}|{DIGITO}|"_")*

ANYTHING			.

WHITESPACE			[ \n\t\r]+

EOF				[<<EOF>>]


FechaConchete			"]"
Virgula				    ","
PontoVirgura			";"
Ponto 				    "."
AbreChaves			  "{"
FechaChaves			  "}"
AbreParenteses		"("
FechaParenteses		")"
AbreConchete			"["
Exclamacao			  "!"

palavraReservada		("class"|"return"|"public"|"new"|"this"|"true"|"false"|"public"|"static"|"void"|"main"|"extends"|"int"|"boolean"|"String"|"if"|"while"|"System.out.println"|".length")

Operadores			("&&"|"<"|"+"|"-"|"*"|"=")

Comentario			"//"{ANYTHING}*


%%
{DIGITO}+			{printf("Numero: %s\n",yytext);}

{AbreChaves}			  {printf("Abre Chaves: %s\n",yytext);}
{FechaChaves}		   	{printf("Fecha Chaves: %s\n",yytext);}
{AbreParenteses}		{printf("Abre Parenteses: %s\n",yytext);}
{FechaParenteses}		{printf("Fecha Parenteses: %s\n",yytext);}
{AbreConchete}			{printf("Abre Conchete: %s\n",yytext);}
{FechaConchete}			{printf("Fecha Conchete: %s\n",yytext);}
{Virgula}			      {printf("Virgula: %s\n",yytext);}
{PontoVirgura}			{printf("Ponto-Virgula: %s\n",yytext);}
{Ponto}				      {printf("Ponto: %s\n",yytext);}
{Exclamacao}		  	{printf("Exclamacao: %s\n",yytext);}

{palavraReservada}			{printf("Palavra reservada: %s\n",yytext);}

{Operadores}			{printf("Operador: %s\n",yytext);}

{Comentario}			{printf("Comentario: %s\n",yytext);}

{EOF}				{printf("Final de Arquivo: %s\n",yytext);}

{IDENTIFIER}			{printf("Identificador: %s\n",yytext);}

{WHITESPACE}			{}

%%
int yywrap();

main(){
  yylex();
}

int yywrap(){
 return 1;
}
