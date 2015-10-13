#define EoF         256
#define IDENTIFIER  257

typedef struct Token {
    int type;
    char repr;
} Token_Type;

extern Token_Type Token;

extern void start_lex(void);
extern void get_next_token(void);

