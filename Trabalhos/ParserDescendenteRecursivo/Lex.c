#include "Lex.h"
Token_Type Token;

void start_lex(void) {
}

void get_next_token(void) {
    int ch;

    while (ch = getchar(), ch == ' ' || ch == '\n') {
        /* skip garbage produced by MSDOS echo */
    }

    Token.type =
        (   ch < 0 ? EoF
        :   ('a' <= ch && ch <= 'z') ? IDENTIFIER

        :   ch
        );
    Token.repr = (ch < 0 ? '$' : ch);
}
