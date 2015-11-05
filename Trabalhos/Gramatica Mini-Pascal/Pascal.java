/* Generated By:JavaCC: Do not edit this line. Pascal.java */
import java.io.*;
public class Pascal implements PascalConstants {

  public static void main(String args[]) throws ParseException,IOException {

    Pascal parser = new Pascal(new FileInputStream(args[0]));
    parser.Programa();
  }

  static final public void Programa() throws ParseException {
    jj_consume_token(PROGRAM);
    jj_consume_token(ID);
    jj_consume_token(LBRACE);
    Lista_de_identificadores();
    jj_consume_token(RBRACE);
    jj_consume_token(SEMI);
    Declaracoes();
    Declaracoes_de_subprogramas();
    Enunciado_composto();
    jj_consume_token(35);
    jj_consume_token(0);
  }

  static final public void Lista_de_identificadores() throws ParseException {
    jj_consume_token(ID);
    Lista2();
  }

  static final public void Lista2() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case VIRG:
      jj_consume_token(VIRG);
      jj_consume_token(ID);
      Lista2();
      break;
    default:
      jj_la1[0] = jj_gen;
      ;
    }
  }

  static final public void Declaracoes() throws ParseException {
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case VAR:
        ;
        break;
      default:
        jj_la1[1] = jj_gen;
        break label_1;
      }
      Declaracao();
    }
  }

  static final public void Declaracao() throws ParseException {
    jj_consume_token(VAR);
    Lista_de_identificadores();
    jj_consume_token(TWODOT);
    Tipo();
    jj_consume_token(SEMI);
  }

  static final public void Tipo() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case INTEIRO:
    case REAL:
      Tipo_padrao();
      break;
    case ARRAY:
      jj_consume_token(ARRAY);
      jj_consume_token(LBRACKET);
      jj_consume_token(NUM);
      jj_consume_token(DOTDOT);
      jj_consume_token(OF);
      Tipo_padrao();
      break;
    default:
      jj_la1[2] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void Tipo_padrao() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case INTEIRO:
      jj_consume_token(INTEIRO);
      break;
    case REAL:
      jj_consume_token(REAL);
      break;
    default:
      jj_la1[3] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void Declaracoes_de_subprogramas() throws ParseException {
    Declaracao_de_subprograma();
  }

  static final public void Declaracao_de_subprograma() throws ParseException {
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case FUNCTION:
      case PROCEDURE:
        ;
        break;
      default:
        jj_la1[4] = jj_gen;
        break label_2;
      }
      Cabecalho_de_subprograma();
      Enunciado_composto();
      jj_consume_token(SEMI);
    }
  }

  static final public void Cabecalho_de_subprograma() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case FUNCTION:
      jj_consume_token(FUNCTION);
      jj_consume_token(ID);
      Argumentos();
      jj_consume_token(TWODOT);
      Tipo_padrao();
      jj_consume_token(SEMI);
      break;
    case PROCEDURE:
      jj_consume_token(PROCEDURE);
      jj_consume_token(ID);
      Argumentos();
      jj_consume_token(SEMI);
      break;
    default:
      jj_la1[5] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void Argumentos() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case LBRACE:
      jj_consume_token(LBRACE);
      Lista_de_parametros();
      jj_consume_token(RBRACE);
      break;
    default:
      jj_la1[6] = jj_gen;
      ;
    }
  }

  static final public void Lista_de_parametros() throws ParseException {
    label_3:
    while (true) {
      Lista_de_identificadores();
      jj_consume_token(TWODOT);
      Tipo();
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case ID:
        ;
        break;
      default:
        jj_la1[7] = jj_gen;
        break label_3;
      }
    }
  }

  static final public void Enunciado_composto() throws ParseException {
    jj_consume_token(BEGIN);
    Enunciados_opcionais();
    jj_consume_token(END);
  }

  static final public void Enunciados_opcionais() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case BEGIN:
    case IF:
    case WHILE:
    case ID:
      Lista_de_enunciados();
      break;
    default:
      jj_la1[8] = jj_gen;
      ;
    }
  }

  static final public void Lista_de_enunciados() throws ParseException {
    Enunciado();
    label_4:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case SEMI:
        ;
        break;
      default:
        jj_la1[9] = jj_gen;
        break label_4;
      }
      jj_consume_token(SEMI);
      Enunciado();
    }
  }

  static final public void Enunciado() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ID:
      jj_consume_token(ID);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case LBRACKET:
      case OPERADOR_DE_ATRIBUICAO:
        label_5:
        while (true) {
          switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
          case LBRACKET:
            ;
            break;
          default:
            jj_la1[10] = jj_gen;
            break label_5;
          }
          jj_consume_token(LBRACKET);
          Expressao();
          jj_consume_token(RBRACKET);
        }
        jj_consume_token(OPERADOR_DE_ATRIBUICAO);
        Expressao();
        break;
      default:
        jj_la1[12] = jj_gen;
        label_6:
        while (true) {
          switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
          case LBRACE:
            ;
            break;
          default:
            jj_la1[11] = jj_gen;
            break label_6;
          }
          jj_consume_token(LBRACE);
          Lista_de_expressoes();
          jj_consume_token(RBRACE);
        }
      }
      break;
    case BEGIN:
      Enunciado_composto();
      break;
    case IF:
      jj_consume_token(IF);
      Expressao();
      jj_consume_token(THEN);
      Enunciado();
      jj_consume_token(ELSE);
      Enunciado();
      break;
    case WHILE:
      jj_consume_token(WHILE);
      Expressao();
      jj_consume_token(DO);
      Enunciado();
      break;
    default:
      jj_la1[13] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void Variavel() throws ParseException {
    jj_consume_token(ID);
    label_7:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case LBRACKET:
        ;
        break;
      default:
        jj_la1[14] = jj_gen;
        break label_7;
      }
      jj_consume_token(LBRACKET);
      Expressao();
      jj_consume_token(RBRACKET);
    }
  }

  static final public void Chamada_de_procedimento() throws ParseException {
    jj_consume_token(ID);
    label_8:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case LBRACE:
        ;
        break;
      default:
        jj_la1[15] = jj_gen;
        break label_8;
      }
      jj_consume_token(LBRACE);
      Lista_de_expressoes();
      jj_consume_token(RBRACE);
    }
  }

  static final public void Lista_de_expressoes() throws ParseException {
    Expressao();
    label_9:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case VIRG:
        ;
        break;
      default:
        jj_la1[16] = jj_gen;
        break label_9;
      }
      jj_consume_token(VIRG);
      Expressao();
    }
  }

  static final public void Expressao() throws ParseException {
    Expressao_simples();
    label_10:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case OPERADOR_RELACIONAL:
        ;
        break;
      default:
        jj_la1[17] = jj_gen;
        break label_10;
      }
      jj_consume_token(OPERADOR_RELACIONAL);
      Expressao_simples();
    }
  }

  static final public void Expressao_simples() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 36:
    case 37:
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 36:
        jj_consume_token(36);
        break;
      case 37:
        jj_consume_token(37);
        break;
      default:
        jj_la1[18] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      break;
    default:
      jj_la1[19] = jj_gen;
      ;
    }
    Termo();
    label_11:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case OR:
      case 36:
      case 37:
        ;
        break;
      default:
        jj_la1[20] = jj_gen;
        break label_11;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 36:
        jj_consume_token(36);
        break;
      case 37:
        jj_consume_token(37);
        break;
      case OR:
        jj_consume_token(OR);
        break;
      default:
        jj_la1[21] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 36:
      case 37:
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case 36:
          jj_consume_token(36);
          break;
        case 37:
          jj_consume_token(37);
          break;
        default:
          jj_la1[22] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        break;
      default:
        jj_la1[23] = jj_gen;
        ;
      }
      Termo();
    }
  }

  static final public void Termo() throws ParseException {
    Fator();
    label_12:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case OPERADOR_MULTIPLICATIVO:
        ;
        break;
      default:
        jj_la1[24] = jj_gen;
        break label_12;
      }
      jj_consume_token(OPERADOR_MULTIPLICATIVO);
      Fator();
    }
  }

  static final public void Fator() throws ParseException {
    label_13:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case NOT:
        ;
        break;
      default:
        jj_la1[25] = jj_gen;
        break label_13;
      }
      jj_consume_token(NOT);
    }
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ID:
      jj_consume_token(ID);
      label_14:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case LBRACE:
          ;
          break;
        default:
          jj_la1[26] = jj_gen;
          break label_14;
        }
        jj_consume_token(LBRACE);
        Lista_de_expressoes();
        jj_consume_token(RBRACE);
      }
      break;
    case NUM:
      jj_consume_token(NUM);
      break;
    case LBRACE:
      jj_consume_token(LBRACE);
      Expressao();
      jj_consume_token(RBRACE);
      break;
    default:
      jj_la1[27] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public PascalTokenManager token_source;
  static SimpleCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[28];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x20000000,0x100,0x400c0,0xc0,0xc00,0xc00,0x1000,0x0,0x4a00000,0x4000,0x10000,0x1000,0x10000,0x4a00000,0x10000,0x1000,0x20000000,0x0,0x0,0x0,0x80000000,0x80000000,0x0,0x0,0x40000000,0x10000000,0x1000,0x81000,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x1,0x1,0x0,0x0,0x0,0x2,0x1,0x0,0x0,0x0,0x4,0x30,0x30,0x30,0x30,0x30,0x30,0x0,0x0,0x0,0x1,};
   }

  /** Constructor with InputStream. */
  public Pascal(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public Pascal(java.io.InputStream stream, String encoding) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new PascalTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 28; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 28; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public Pascal(java.io.Reader stream) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new PascalTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 28; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 28; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public Pascal(PascalTokenManager tm) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 28; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(PascalTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 28; i++) jj_la1[i] = -1;
  }

  static private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  static final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  static final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  static private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  static private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  static private int[] jj_expentry;
  static private int jj_kind = -1;

  /** Generate ParseException. */
  static public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[38];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 28; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 38; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  static final public void enable_tracing() {
  }

  /** Disable tracing. */
  static final public void disable_tracing() {
  }

}
