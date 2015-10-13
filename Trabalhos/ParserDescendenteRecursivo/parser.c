#include    <stdio.h>
#include    <stdlib.h>
#include "Lex.h"

int main(void) {
    start_lex(); get_next_token();
    require(input());
    return 0;
}

void error(void) {
    printf("Error in expression\n"); exit(1);
}




/* PARSER */
int input(void) {
    return expression() && require(token(EoF));
}

int expression(void) {
    return term() && require(rest_expression());
}

int term(void) {
    return token(IDENTIFIER) || parenthesized_expression();
}

int parenthesized_expression(void) {
    return token('(') && require(expression()) && require(token(')'));
}

int rest_expression(void) {
    return token('+') && require(expression()) || 1;
}

int token(int tk) {
    if (tk != Token.type) return 0;
    get_next_token(); return 1;
}

int require(int found) {
    if (!found) error();
    return 1;
}
