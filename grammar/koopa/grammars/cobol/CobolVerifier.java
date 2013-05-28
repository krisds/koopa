package koopa.grammars.cobol;

import koopa.tokens.Token;
import koopa.verifiers.Verifier;
import koopa.verifiers.VerifyingSink;

public class CobolVerifier extends VerifyingSink {
  protected void initialize() {
    register("water", new Verifier() {
      public void verify(Token t) {
        { final int p0 = 0;
          final int p1 = lastIndexOf("workingStorageSection");
          final int p2 = lastIndexOf("copyStatement");
          final int p3 = lastIndexOf("replaceStatement");
          final int p4 = lastIndexOf("execStatement");

          if (p0 < p1 && p2 < p1 && p3 < p1 && p4 < p1) {
            warn(t, "Water in the working storage section.");
          }
        }

        { final int p0 = 0;
          final int p1 = lastIndexOf("linkageSection");
          final int p2 = lastIndexOf("copyStatement");
          final int p3 = lastIndexOf("replaceStatement");
          final int p4 = lastIndexOf("execStatement");

          if (p0 < p1 && p2 < p1 && p3 < p1 && p4 < p1) {
            warn(t, "Water in the linkage section.");
          }
        }

        { final int p0 = 0;
          final int p1 = lastIndexOf("fileSection");
          final int p2 = lastIndexOf("copyStatement");
          final int p3 = lastIndexOf("replaceStatement");
          final int p4 = lastIndexOf("execStatement");

          if (p0 < p1 && p2 < p1 && p3 < p1 && p4 < p1) {
            warn(t, "Water in the file section.");
          }
        }
      }
    });

    register("ADD", new Verifier() {
      public void verify(Token t) {
        { final int p0 = 0;
          final int p1 = lastIndexOf("addStatement");
          final int p2 = lastIndexOf("water");

          if ((p1 < p0 || p1 > p2) && p0 < p2) {
            warn(t, "ADD in the water.");
          }
        }

        { final int p0 = 0;
          final int p1 = lastIndexOf("addStatement");
          final int p2 = lastIndexOf("statement");

          if (p0 < p1 && p1 < p2) {
            warn(t, "ADD not in add statement.");
          }
        }

        { final int p0 = 0;
          final int p1 = lastIndexOf("statement");
          final int p2 = lastIndexOf("execStatement");
          final int p3 = lastIndexOf("addStatement");

          if (p0 < p1 && p2 < p1 && p3 < p1) {
            warn(t, "ADD not in add statement.");
          }
        }
      }
    });

    register("END-ADD", new Verifier() {
      public void verify(Token t) {
        { final int p0 = 0;
          final int p1 = lastIndexOf("addStatement");
          final int p2 = lastIndexOf("water");

          if ((p1 < p0 || p1 > p2) && p0 < p2) {
            warn(t, "END-ADD in the water.");
          }
        }

        { final int p0 = 0;
          final int p1 = lastIndexOf("addStatement");
          final int p2 = lastIndexOf("statement");

          if (p0 < p1 && p1 < p2) {
            warn(t, "END-ADD not in add statement.");
          }
        }

        { final int p0 = 0;
          final int p1 = lastIndexOf("statement");
          final int p2 = lastIndexOf("execStatement");
          final int p3 = lastIndexOf("addStatement");

          if (p0 < p1 && p2 < p1 && p3 < p1) {
            warn(t, "END-ADD not in add statement.");
          }
        }
      }
    });

    register("COPY", new Verifier() {
      public void verify(Token t) {
        { final int p0 = 0;
          final int p1 = lastIndexOf("copyStatement");
          final int p2 = lastIndexOf("water");

          if ((p1 < p0 || p1 > p2) && p0 < p2) {
            warn(t, "COPY in the water.");
          }
        }

        { final int p0 = 0;
          final int p1 = lastIndexOf("copyStatement");
          final int p2 = lastIndexOf("statement");

          if (p0 < p1 && p1 < p2) {
            warn(t, "COPY not in copy statement.");
          }
        }

        { final int p0 = 0;
          final int p1 = lastIndexOf("statement");
          final int p2 = lastIndexOf("execStatement");
          final int p3 = lastIndexOf("copyStatement");

          if (p0 < p1 && p2 < p1 && p3 < p1) {
            warn(t, "COPY not in copy statement.");
          }
        }
      }
    });

    register("CALL", new Verifier() {
      public void verify(Token t) {
        { final int p0 = 0;
          final int p1 = lastIndexOf("execStatement");
          final int p2 = lastIndexOf("water");

          if ((p1 < p0 || p1 > p2) && p0 < p2) {
            warn(t, "CALL in the water.");
          }
        }

        { final int p0 = 0;
          final int p1 = lastIndexOf("callStatement");
          final int p2 = lastIndexOf("statement");

          if (p0 < p1 && p1 < p2) {
            warn(t, "CALL not in call statement.");
          }
        }

        { final int p0 = 0;
          final int p1 = lastIndexOf("statement");
          final int p2 = lastIndexOf("execStatement");
          final int p3 = lastIndexOf("callStatement");

          if (p0 < p1 && p2 < p1 && p3 < p1) {
            warn(t, "CALL not in call statement.");
          }
        }
      }
    });

    register("CANCEL", new Verifier() {
      public void verify(Token t) {
        { final int p0 = 0;
          final int p1 = lastIndexOf("execStatement");
          final int p2 = lastIndexOf("water");

          if ((p1 < p0 || p1 > p2) && p0 < p2) {
            warn(t, "CANCEL in the water.");
          }
        }

        { final int p0 = 0;
          final int p1 = lastIndexOf("cancelStatement");
          final int p2 = lastIndexOf("statement");

          if (p0 < p1 && p1 < p2) {
            warn(t, "CANCEL not in cancel statement.");
          }
        }

        { final int p0 = 0;
          final int p1 = lastIndexOf("statement");
          final int p2 = lastIndexOf("execStatement");
          final int p3 = lastIndexOf("cancelStatement");

          if (p0 < p1 && p2 < p1 && p3 < p1) {
            warn(t, "CANCEL not in cancel statement.");
          }
        }
      }
    });

    register("CLOSE", new Verifier() {
      public void verify(Token t) {
        { final int p0 = 0;
          final int p1 = lastIndexOf("execStatement");
          final int p2 = lastIndexOf("water");

          if ((p1 < p0 || p1 > p2) && p0 < p2) {
            warn(t, "CLOSE in the water.");
          }
        }

        { final int p0 = 0;
          final int p1 = lastIndexOf("closeStatement");
          final int p2 = lastIndexOf("statement");

          if (p0 < p1 && p1 < p2) {
            warn(t, "CLOSE not in close statement.");
          }
        }

        { final int p0 = 0;
          final int p1 = lastIndexOf("statement");
          final int p2 = lastIndexOf("execStatement");
          final int p3 = lastIndexOf("closeStatement");

          if (p0 < p1 && p2 < p1 && p3 < p1) {
            warn(t, "CLOSE not in close statement.");
          }
        }
      }
    });

    register("DIVIDE", new Verifier() {
      public void verify(Token t) {
        { final int p0 = 0;
          final int p1 = lastIndexOf("divideStatement");
          final int p2 = lastIndexOf("water");

          if ((p1 < p0 || p1 > p2) && p0 < p2) {
            warn(t, "DIVIDE in the water.");
          }
        }

        { final int p0 = 0;
          final int p1 = lastIndexOf("divideStatement");
          final int p2 = lastIndexOf("statement");

          if (p0 < p1 && p1 < p2) {
            warn(t, "DIVIDE not in divide statement.");
          }
        }

        { final int p0 = 0;
          final int p1 = lastIndexOf("statement");
          final int p2 = lastIndexOf("execStatement");
          final int p3 = lastIndexOf("divideStatement");

          if (p0 < p1 && p2 < p1 && p3 < p1) {
            warn(t, "DIVIDE not in divide statement.");
          }
        }
      }
    });

    register("END-DIVIDE", new Verifier() {
      public void verify(Token t) {
        { final int p0 = 0;
          final int p1 = lastIndexOf("divideStatement");
          final int p2 = lastIndexOf("water");

          if ((p1 < p0 || p1 > p2) && p0 < p2) {
            warn(t, "END-DIVIDE in the water.");
          }
        }

        { final int p0 = 0;
          final int p1 = lastIndexOf("divideStatement");
          final int p2 = lastIndexOf("statement");

          if (p0 < p1 && p1 < p2) {
            warn(t, "END-DIVIDE not in divide statement.");
          }
        }

        { final int p0 = 0;
          final int p1 = lastIndexOf("statement");
          final int p2 = lastIndexOf("execStatement");
          final int p3 = lastIndexOf("divideStatement");

          if (p0 < p1 && p2 < p1 && p3 < p1) {
            warn(t, "END-DIVIDE not in divide statement.");
          }
        }
      }
    });

    register("ENTRY", new Verifier() {
      public void verify(Token t) {
        { final int p0 = 0;
          final int p1 = lastIndexOf("execStatement");
          final int p2 = lastIndexOf("water");

          if ((p1 < p0 || p1 > p2) && p0 < p2) {
            warn(t, "ENTRY in the water.");
          }
        }

        { final int p0 = 0;
          final int p1 = lastIndexOf("entryStatement");
          final int p2 = lastIndexOf("statement");

          if (p0 < p1 && p1 < p2) {
            warn(t, "ENTRY not in entry statement.");
          }
        }

        { final int p0 = 0;
          final int p1 = lastIndexOf("statement");
          final int p2 = lastIndexOf("execStatement");
          final int p3 = lastIndexOf("entryStatement");

          if (p0 < p1 && p2 < p1 && p3 < p1) {
            warn(t, "ENTRY not in entry statement.");
          }
        }
      }
    });

    register("EVALUATE", new Verifier() {
      public void verify(Token t) {
        { final int p0 = 0;
          final int p1 = lastIndexOf("execStatement");
          final int p2 = lastIndexOf("water");

          if ((p1 < p0 || p1 > p2) && p0 < p2) {
            warn(t, "EVALUATE in the water.");
          }
        }

        { final int p0 = 0;
          final int p1 = lastIndexOf("evaluateStatement");
          final int p2 = lastIndexOf("statement");

          if (p0 < p1 && p1 < p2) {
            warn(t, "EVALUATE not in evaluate statement.");
          }
        }

        { final int p0 = 0;
          final int p1 = lastIndexOf("statement");
          final int p2 = lastIndexOf("execStatement");
          final int p3 = lastIndexOf("evaluateStatement");

          if (p0 < p1 && p2 < p1 && p3 < p1) {
            warn(t, "EVALUATE not in evaluate statement.");
          }
        }
      }
    });

    register("EXEC", new Verifier() {
      public void verify(Token t) {
        { final int p0 = 0;
          final int p1 = lastIndexOf("execStatement");
          final int p2 = lastIndexOf("water");

          if ((p1 < p0 || p1 > p2) && p0 < p2) {
            warn(t, "EXEC in the water.");
          }
        }

        { final int p0 = 0;
          final int p1 = lastIndexOf("execStatement");
          final int p2 = lastIndexOf("statement");

          if (p0 < p1 && p1 < p2) {
            warn(t, "EXEC not in exec statement.");
          }
        }

        { final int p0 = 0;
          final int p1 = lastIndexOf("statement");
          final int p2 = lastIndexOf("execStatement");
          final int p3 = lastIndexOf("execStatement");

          if (p0 < p1 && p2 < p1 && p3 < p1) {
            warn(t, "EXEC not in exec statement.");
          }
        }
      }
    });

    register("EXIT", new Verifier() {
      public void verify(Token t) {
        { final int p0 = 0;
          final int p1 = lastIndexOf("execStatement");
          final int p2 = lastIndexOf("water");

          if ((p1 < p0 || p1 > p2) && p0 < p2) {
            warn(t, "EXIT in the water.");
          }
        }

        { final int p0 = 0;
          final int p1 = lastIndexOf("exitStatement");
          final int p2 = lastIndexOf("statement");

          if (p0 < p1 && p1 < p2) {
            warn(t, "EXIT not in exit statement.");
          }
        }

        { final int p0 = 0;
          final int p1 = lastIndexOf("statement");
          final int p2 = lastIndexOf("execStatement");
          final int p3 = lastIndexOf("exitStatement");

          if (p0 < p1 && p2 < p1 && p3 < p1) {
            warn(t, "EXIT not in exit statement.");
          }
        }
      }
    });

    register("GOBACK", new Verifier() {
      public void verify(Token t) {
        { final int p0 = 0;
          final int p1 = lastIndexOf("execStatement");
          final int p2 = lastIndexOf("water");

          if ((p1 < p0 || p1 > p2) && p0 < p2) {
            warn(t, "GOBACK in the water.");
          }
        }

        { final int p0 = 0;
          final int p1 = lastIndexOf("gobackStatement");
          final int p2 = lastIndexOf("statement");

          if (p0 < p1 && p1 < p2) {
            warn(t, "GOBACK not in goback statement.");
          }
        }

        { final int p0 = 0;
          final int p1 = lastIndexOf("statement");
          final int p2 = lastIndexOf("execStatement");
          final int p3 = lastIndexOf("gobackStatement");

          if (p0 < p1 && p2 < p1 && p3 < p1) {
            warn(t, "GOBACK not in goback statement.");
          }
        }
      }
    });

    register("GO", new Verifier() {
      public void verify(Token t) {
        { final int p0 = 0;
          final int p1 = lastIndexOf("execStatement");
          final int p2 = lastIndexOf("water");

          if ((p1 < p0 || p1 > p2) && p0 < p2) {
            warn(t, "GO in the water.");
          }
        }

        { final int p0 = 0;
          final int p1 = lastIndexOf("goToStatement");
          final int p2 = lastIndexOf("statement");

          if (p0 < p1 && p1 < p2) {
            warn(t, "GO not in go statement.");
          }
        }

        { final int p0 = 0;
          final int p1 = lastIndexOf("statement");
          final int p2 = lastIndexOf("execStatement");
          final int p3 = lastIndexOf("goToStatement");

          if (p0 < p1 && p2 < p1 && p3 < p1) {
            warn(t, "GO not in go statement.");
          }
        }
      }
    });

    register("IF", new Verifier() {
      public void verify(Token t) {
        { final int p0 = 0;
          final int p1 = lastIndexOf("execStatement");
          final int p2 = lastIndexOf("water");

          if ((p1 < p0 || p1 > p2) && p0 < p2) {
            warn(t, "IF in the water.");
          }
        }

        { final int p0 = 0;
          final int p1 = lastIndexOf("ifStatement");
          final int p2 = lastIndexOf("statement");

          if (p0 < p1 && p1 < p2) {
            warn(t, "IF not in if statement.");
          }
        }

        { final int p0 = 0;
          final int p1 = lastIndexOf("statement");
          final int p2 = lastIndexOf("execStatement");
          final int p3 = lastIndexOf("ifStatement");

          if (p0 < p1 && p2 < p1 && p3 < p1) {
            warn(t, "IF not in if statement.");
          }
        }
      }
    });

    register("MOVE", new Verifier() {
      public void verify(Token t) {
        { final int p0 = 0;
          final int p1 = lastIndexOf("execStatement");
          final int p2 = lastIndexOf("water");

          if ((p1 < p0 || p1 > p2) && p0 < p2) {
            warn(t, "MOVE in the water.");
          }
        }

        { final int p0 = 0;
          final int p1 = lastIndexOf("moveStatement");
          final int p2 = lastIndexOf("statement");

          if (p0 < p1 && p1 < p2) {
            warn(t, "MOVE not in move statement.");
          }
        }

        { final int p0 = 0;
          final int p1 = lastIndexOf("statement");
          final int p2 = lastIndexOf("execStatement");
          final int p3 = lastIndexOf("moveStatement");

          if (p0 < p1 && p2 < p1 && p3 < p1) {
            warn(t, "MOVE not in move statement.");
          }
        }
      }
    });

    register("MULTIPLY", new Verifier() {
      public void verify(Token t) {
        { final int p0 = 0;
          final int p1 = lastIndexOf("multiplyStatement");
          final int p2 = lastIndexOf("water");

          if ((p1 < p0 || p1 > p2) && p0 < p2) {
            warn(t, "MULTIPLY in the water.");
          }
        }

        { final int p0 = 0;
          final int p1 = lastIndexOf("multiplyStatement");
          final int p2 = lastIndexOf("statement");

          if (p0 < p1 && p1 < p2) {
            warn(t, "MULTIPLY not in multiply statement.");
          }
        }

        { final int p0 = 0;
          final int p1 = lastIndexOf("statement");
          final int p2 = lastIndexOf("execStatement");
          final int p3 = lastIndexOf("multiplyStatement");

          if (p0 < p1 && p2 < p1 && p3 < p1) {
            warn(t, "MULTIPLY not in multiply statement.");
          }
        }
      }
    });

    register("END-MULTIPLY", new Verifier() {
      public void verify(Token t) {
        { final int p0 = 0;
          final int p1 = lastIndexOf("multiplyStatement");
          final int p2 = lastIndexOf("water");

          if ((p1 < p0 || p1 > p2) && p0 < p2) {
            warn(t, "END-MULTIPLY in the water.");
          }
        }

        { final int p0 = 0;
          final int p1 = lastIndexOf("multiplyStatement");
          final int p2 = lastIndexOf("statement");

          if (p0 < p1 && p1 < p2) {
            warn(t, "END-MULTIPLY not in multiply statement.");
          }
        }

        { final int p0 = 0;
          final int p1 = lastIndexOf("statement");
          final int p2 = lastIndexOf("execStatement");
          final int p3 = lastIndexOf("multiplyStatement");

          if (p0 < p1 && p2 < p1 && p3 < p1) {
            warn(t, "END-MULTIPLY not in multiply statement.");
          }
        }
      }
    });

    register("OPEN", new Verifier() {
      public void verify(Token t) {
        { final int p0 = 0;
          final int p1 = lastIndexOf("openStatement");
          final int p2 = lastIndexOf("water");

          if ((p1 < p0 || p1 > p2) && p0 < p2) {
            warn(t, "OPEN in the water.");
          }
        }

        { final int p0 = 0;
          final int p1 = lastIndexOf("openStatement");
          final int p2 = lastIndexOf("statement");

          if (p0 < p1 && p1 < p2) {
            warn(t, "OPEN not in open statement.");
          }
        }

        { final int p0 = 0;
          final int p1 = lastIndexOf("statement");
          final int p2 = lastIndexOf("execStatement");
          final int p3 = lastIndexOf("openStatement");

          if (p0 < p1 && p2 < p1 && p3 < p1) {
            warn(t, "OPEN not in open statement.");
          }
        }
      }
    });

    register("PERFORM", new Verifier() {
      public void verify(Token t) {
        { final int p0 = 0;
          final int p1 = lastIndexOf("execStatement");
          final int p2 = lastIndexOf("water");

          if ((p1 < p0 || p1 > p2) && p0 < p2) {
            warn(t, "PERFORM in the water.");
          }
        }

        { final int p0 = 0;
          final int p1 = lastIndexOf("performStatement");
          final int p2 = lastIndexOf("statement");
          final int p3 = lastIndexOf("exitStatement");

          if (p0 < p1 && p1 < p2 && p3 < p2) {
            warn(t, "PERFORM not in perform statement.");
          }
        }

        { final int p0 = 0;
          final int p1 = lastIndexOf("statement");
          final int p2 = lastIndexOf("execStatement");
          final int p3 = lastIndexOf("exitStatement");
          final int p4 = lastIndexOf("performStatement");

          if (p0 < p1 && p2 < p1 && p3 < p1 && p4 < p1) {
            warn(t, "PERFORM not in perform or exit statement.");
          }
        }
      }
    });

    register("READ", new Verifier() {
      public void verify(Token t) {
        { final int p0 = 0;
          final int p1 = lastIndexOf("readStatement");
          final int p2 = lastIndexOf("water");

          if ((p1 < p0 || p1 > p2) && p0 < p2) {
            warn(t, "READ in the water.");
          }
        }

        { final int p0 = 0;
          final int p1 = lastIndexOf("readStatement");
          final int p2 = lastIndexOf("statement");

          if (p0 < p1 && p1 < p2) {
            warn(t, "READ not in read statement.");
          }
        }

        { final int p0 = 0;
          final int p1 = lastIndexOf("statement");
          final int p2 = lastIndexOf("execStatement");
          final int p3 = lastIndexOf("readStatement");

          if (p0 < p1 && p2 < p1 && p3 < p1) {
            warn(t, "READ not in read statement.");
          }
        }
      }
    });

    register("END-READ", new Verifier() {
      public void verify(Token t) {
        { final int p0 = 0;
          final int p1 = lastIndexOf("readStatement");
          final int p2 = lastIndexOf("water");

          if ((p1 < p0 || p1 > p2) && p0 < p2) {
            warn(t, "END-READ in the water.");
          }
        }

        { final int p0 = 0;
          final int p1 = lastIndexOf("readStatement");
          final int p2 = lastIndexOf("statement");

          if (p0 < p1 && p1 < p2) {
            warn(t, "END-READ not in read statement.");
          }
        }

        { final int p0 = 0;
          final int p1 = lastIndexOf("statement");
          final int p2 = lastIndexOf("execStatement");
          final int p3 = lastIndexOf("readStatement");

          if (p0 < p1 && p2 < p1 && p3 < p1) {
            warn(t, "END-READ not in read statement.");
          }
        }
      }
    });

    register("RELEASE", new Verifier() {
      public void verify(Token t) {
        { final int p0 = 0;
          final int p1 = lastIndexOf("execStatement");
          final int p2 = lastIndexOf("releaseStatement");
          final int p3 = lastIndexOf("water");

          if ((p1 < p0 || p1 > p3) && (p2 < p0 || p2 > p3) && p0 < p3) {
            warn(t, "RELEASE in the water.");
          }
        }

        { final int p0 = 0;
          final int p1 = lastIndexOf("releaseStatement");
          final int p2 = lastIndexOf("statement");

          if (p0 < p1 && p1 < p2) {
            warn(t, "RELEASE not in release statement.");
          }
        }

        { final int p0 = 0;
          final int p1 = lastIndexOf("statement");
          final int p2 = lastIndexOf("execStatement");
          final int p3 = lastIndexOf("releaseStatement");

          if (p0 < p1 && p2 < p1 && p3 < p1) {
            warn(t, "RELEASE not in release statement.");
          }
        }
      }
    });

    register("RETURN", new Verifier() {
      public void verify(Token t) {
        { final int p0 = 0;
          final int p1 = lastIndexOf("execStatement");
          final int p2 = lastIndexOf("water");

          if ((p1 < p0 || p1 > p2) && p0 < p2) {
            warn(t, "RETURN in the water.");
          }
        }

        { final int p0 = 0;
          final int p1 = lastIndexOf("returnStatement");
          final int p2 = lastIndexOf("statement");

          if (p0 < p1 && p1 < p2) {
            warn(t, "RETURN not in return statement.");
          }
        }

        { final int p0 = 0;
          final int p1 = lastIndexOf("statement");
          final int p2 = lastIndexOf("execStatement");
          final int p3 = lastIndexOf("returnStatement");

          if (p0 < p1 && p2 < p1 && p3 < p1) {
            warn(t, "RETURN not in return statement.");
          }
        }
      }
    });

    register("SEARCH", new Verifier() {
      public void verify(Token t) {
        { final int p0 = 0;
          final int p1 = lastIndexOf("execStatement");
          final int p2 = lastIndexOf("water");

          if ((p1 < p0 || p1 > p2) && p0 < p2) {
            warn(t, "SEARCH in the water.");
          }
        }

        { final int p0 = 0;
          final int p1 = lastIndexOf("searchStatement");
          final int p2 = lastIndexOf("statement");

          if (p0 < p1 && p1 < p2) {
            warn(t, "SEARCH not in search statement.");
          }
        }

        { final int p0 = 0;
          final int p1 = lastIndexOf("statement");
          final int p2 = lastIndexOf("execStatement");
          final int p3 = lastIndexOf("searchStatement");

          if (p0 < p1 && p2 < p1 && p3 < p1) {
            warn(t, "SEARCH not in search statement.");
          }
        }
      }
    });

    register("STOP", new Verifier() {
      public void verify(Token t) {
        { final int p0 = 0;
          final int p1 = lastIndexOf("execStatement");
          final int p2 = lastIndexOf("water");

          if ((p1 < p0 || p1 > p2) && p0 < p2) {
            warn(t, "STOP in the water.");
          }
        }

        { final int p0 = 0;
          final int p1 = lastIndexOf("stopStatement");
          final int p2 = lastIndexOf("statement");

          if (p0 < p1 && p1 < p2) {
            warn(t, "STOP not in stop statement.");
          }
        }

        { final int p0 = 0;
          final int p1 = lastIndexOf("statement");
          final int p2 = lastIndexOf("execStatement");
          final int p3 = lastIndexOf("stopStatement");

          if (p0 < p1 && p2 < p1 && p3 < p1) {
            warn(t, "STOP not in stop statement.");
          }
        }
      }
    });

    register("STRING", new Verifier() {
      public void verify(Token t) {
        { final int p0 = 0;
          final int p1 = lastIndexOf("stringStatement");
          final int p2 = lastIndexOf("water");

          if ((p1 < p0 || p1 > p2) && p0 < p2) {
            warn(t, "STRING in the water.");
          }
        }

        { final int p0 = 0;
          final int p1 = lastIndexOf("stringStatement");
          final int p2 = lastIndexOf("statement");

          if (p0 < p1 && p1 < p2) {
            warn(t, "STRING not in string statement.");
          }
        }

        { final int p0 = 0;
          final int p1 = lastIndexOf("statement");
          final int p2 = lastIndexOf("execStatement");
          final int p3 = lastIndexOf("stringStatement");

          if (p0 < p1 && p2 < p1 && p3 < p1) {
            warn(t, "STRING not in string statement.");
          }
        }
      }
    });

    register("END-STRING", new Verifier() {
      public void verify(Token t) {
        { final int p0 = 0;
          final int p1 = lastIndexOf("stringStatement");
          final int p2 = lastIndexOf("water");

          if ((p1 < p0 || p1 > p2) && p0 < p2) {
            warn(t, "END-STRING in the water.");
          }
        }

        { final int p0 = 0;
          final int p1 = lastIndexOf("stringStatement");
          final int p2 = lastIndexOf("statement");

          if (p0 < p1 && p1 < p2) {
            warn(t, "END-STRING not in string statement.");
          }
        }

        { final int p0 = 0;
          final int p1 = lastIndexOf("statement");
          final int p2 = lastIndexOf("execStatement");
          final int p3 = lastIndexOf("stringStatement");

          if (p0 < p1 && p2 < p1 && p3 < p1) {
            warn(t, "END-STRING not in string statement.");
          }
        }
      }
    });

    register("SUBTRACT", new Verifier() {
      public void verify(Token t) {
        { final int p0 = 0;
          final int p1 = lastIndexOf("subtractStatement");
          final int p2 = lastIndexOf("water");

          if ((p1 < p0 || p1 > p2) && p0 < p2) {
            warn(t, "SUBTRACT in the water.");
          }
        }

        { final int p0 = 0;
          final int p1 = lastIndexOf("subtractStatement");
          final int p2 = lastIndexOf("statement");

          if (p0 < p1 && p1 < p2) {
            warn(t, "SUBTRACT not in subtract statement.");
          }
        }

        { final int p0 = 0;
          final int p1 = lastIndexOf("statement");
          final int p2 = lastIndexOf("execStatement");
          final int p3 = lastIndexOf("subtractStatement");

          if (p0 < p1 && p2 < p1 && p3 < p1) {
            warn(t, "SUBTRACT not in subtract statement.");
          }
        }
      }
    });

    register("END-SUBTRACT", new Verifier() {
      public void verify(Token t) {
        { final int p0 = 0;
          final int p1 = lastIndexOf("subtractStatement");
          final int p2 = lastIndexOf("water");

          if ((p1 < p0 || p1 > p2) && p0 < p2) {
            warn(t, "END-SUBTRACT in the water.");
          }
        }

        { final int p0 = 0;
          final int p1 = lastIndexOf("subtractStatement");
          final int p2 = lastIndexOf("statement");

          if (p0 < p1 && p1 < p2) {
            warn(t, "END-SUBTRACT not in subtract statement.");
          }
        }

        { final int p0 = 0;
          final int p1 = lastIndexOf("statement");
          final int p2 = lastIndexOf("execStatement");
          final int p3 = lastIndexOf("subtractStatement");

          if (p0 < p1 && p2 < p1 && p3 < p1) {
            warn(t, "END-SUBTRACT not in subtract statement.");
          }
        }
      }
    });

    register("UNSTRING", new Verifier() {
      public void verify(Token t) {
        { final int p0 = 0;
          final int p1 = lastIndexOf("unstringStatement");
          final int p2 = lastIndexOf("water");

          if ((p1 < p0 || p1 > p2) && p0 < p2) {
            warn(t, "UNSTRING in the water.");
          }
        }

        { final int p0 = 0;
          final int p1 = lastIndexOf("unstringStatement");
          final int p2 = lastIndexOf("statement");

          if (p0 < p1 && p1 < p2) {
            warn(t, "UNSTRING not in unstring statement.");
          }
        }

        { final int p0 = 0;
          final int p1 = lastIndexOf("statement");
          final int p2 = lastIndexOf("execStatement");
          final int p3 = lastIndexOf("unstringStatement");

          if (p0 < p1 && p2 < p1 && p3 < p1) {
            warn(t, "UNSTRING not in unstring statement.");
          }
        }
      }
    });

    register("END-UNSTRING", new Verifier() {
      public void verify(Token t) {
        { final int p0 = 0;
          final int p1 = lastIndexOf("unstringStatement");
          final int p2 = lastIndexOf("water");

          if ((p1 < p0 || p1 > p2) && p0 < p2) {
            warn(t, "END-UNSTRING in the water.");
          }
        }

        { final int p0 = 0;
          final int p1 = lastIndexOf("unstringStatement");
          final int p2 = lastIndexOf("statement");

          if (p0 < p1 && p1 < p2) {
            warn(t, "END-UNSTRING not in unstring statement.");
          }
        }

        { final int p0 = 0;
          final int p1 = lastIndexOf("statement");
          final int p2 = lastIndexOf("execStatement");
          final int p3 = lastIndexOf("unstringStatement");

          if (p0 < p1 && p2 < p1 && p3 < p1) {
            warn(t, "END-UNSTRING not in unstring statement.");
          }
        }
      }
    });

    register("WRITE", new Verifier() {
      public void verify(Token t) {
        { final int p0 = 0;
          final int p1 = lastIndexOf("writeStatement");
          final int p2 = lastIndexOf("water");

          if ((p1 < p0 || p1 > p2) && p0 < p2) {
            warn(t, "WRITE in the water.");
          }
        }

        { final int p0 = 0;
          final int p1 = lastIndexOf("writeStatement");
          final int p2 = lastIndexOf("statement");

          if (p0 < p1 && p1 < p2) {
            warn(t, "WRITE not in write statement.");
          }
        }

        { final int p0 = 0;
          final int p1 = lastIndexOf("statement");
          final int p2 = lastIndexOf("execStatement");
          final int p3 = lastIndexOf("writeStatement");

          if (p0 < p1 && p2 < p1 && p3 < p1) {
            warn(t, "WRITE not in write statement.");
          }
        }
      }
    });

    register("END-WRITE", new Verifier() {
      public void verify(Token t) {
        { final int p0 = 0;
          final int p1 = lastIndexOf("writeStatement");
          final int p2 = lastIndexOf("water");

          if ((p1 < p0 || p1 > p2) && p0 < p2) {
            warn(t, "END-WRITE in the water.");
          }
        }

        { final int p0 = 0;
          final int p1 = lastIndexOf("writeStatement");
          final int p2 = lastIndexOf("statement");

          if (p0 < p1 && p1 < p2) {
            warn(t, "END-WRITE not in write statement.");
          }
        }

        { final int p0 = 0;
          final int p1 = lastIndexOf("statement");
          final int p2 = lastIndexOf("execStatement");
          final int p3 = lastIndexOf("writeStatement");

          if (p0 < p1 && p2 < p1 && p3 < p1) {
            warn(t, "END-WRITE not in write statement.");
          }
        }
      }
    });

    register("COMPUTE", new Verifier() {
      public void verify(Token t) {
        { final int p0 = 0;
          final int p1 = lastIndexOf("execStatement");
          final int p2 = lastIndexOf("computeStatement");
          final int p3 = lastIndexOf("water");

          if ((p1 < p0 || p1 > p3) && (p2 < p0 || p2 > p3) && p0 < p3) {
            warn(t, "COMPUTE in the water.");
          }
        }

        { final int p0 = 0;
          final int p1 = lastIndexOf("computeStatement");
          final int p2 = lastIndexOf("statement");

          if (p0 < p1 && p1 < p2) {
            warn(t, "COMPUTE not in compute statement.");
          }
        }

        { final int p0 = 0;
          final int p1 = lastIndexOf("statement");
          final int p2 = lastIndexOf("execStatement");
          final int p3 = lastIndexOf("computeStatement");

          if (p0 < p1 && p2 < p1 && p3 < p1) {
            warn(t, "COMPUTE not in compute statement.");
          }
        }
      }
    });

    register("END-COMPUTE", new Verifier() {
      public void verify(Token t) {
        { final int p0 = 0;
          final int p1 = lastIndexOf("execStatement");
          final int p2 = lastIndexOf("computeStatement");
          final int p3 = lastIndexOf("water");

          if ((p1 < p0 || p1 > p3) && (p2 < p0 || p2 > p3) && p0 < p3) {
            warn(t, "END-COMPUTE in the water.");
          }
        }

        { final int p0 = 0;
          final int p1 = lastIndexOf("computeStatement");
          final int p2 = lastIndexOf("statement");

          if (p0 < p1 && p1 < p2) {
            warn(t, "END-COMPUTE not in compute statement.");
          }
        }

        { final int p0 = 0;
          final int p1 = lastIndexOf("statement");
          final int p2 = lastIndexOf("execStatement");
          final int p3 = lastIndexOf("computeStatement");

          if (p0 < p1 && p2 < p1 && p3 < p1) {
            warn(t, "END-COMPUTE not in compute statement.");
          }
        }
      }
    });

    register("START", new Verifier() {
      public void verify(Token t) {
        { final int p0 = 0;
          final int p1 = lastIndexOf("execStatement");
          final int p2 = lastIndexOf("startStatement");
          final int p3 = lastIndexOf("water");

          if ((p1 < p0 || p1 > p3) && (p2 < p0 || p2 > p3) && p0 < p3) {
            warn(t, "START in the water.");
          }
        }

        { final int p0 = 0;
          final int p1 = lastIndexOf("startStatement");
          final int p2 = lastIndexOf("statement");

          if (p0 < p1 && p1 < p2) {
            warn(t, "START not in start statement.");
          }
        }

        { final int p0 = 0;
          final int p1 = lastIndexOf("statement");
          final int p2 = lastIndexOf("execStatement");
          final int p3 = lastIndexOf("startStatement");

          if (p0 < p1 && p2 < p1 && p3 < p1) {
            warn(t, "START not in start statement.");
          }
        }
      }
    });

    register("END-START", new Verifier() {
      public void verify(Token t) {
        { final int p0 = 0;
          final int p1 = lastIndexOf("execStatement");
          final int p2 = lastIndexOf("startStatement");
          final int p3 = lastIndexOf("water");

          if ((p1 < p0 || p1 > p3) && (p2 < p0 || p2 > p3) && p0 < p3) {
            warn(t, "END-START in the water.");
          }
        }

        { final int p0 = 0;
          final int p1 = lastIndexOf("startStatement");
          final int p2 = lastIndexOf("statement");

          if (p0 < p1 && p1 < p2) {
            warn(t, "END-START not in start statement.");
          }
        }

        { final int p0 = 0;
          final int p1 = lastIndexOf("statement");
          final int p2 = lastIndexOf("execStatement");
          final int p3 = lastIndexOf("startStatement");

          if (p0 < p1 && p2 < p1 && p3 < p1) {
            warn(t, "END-START not in start statement.");
          }
        }
      }
    });

    register("DELETE", new Verifier() {
      public void verify(Token t) {
        { final int p0 = 0;
          final int p1 = lastIndexOf("execStatement");
          final int p2 = lastIndexOf("deleteStatement");
          final int p3 = lastIndexOf("water");

          if ((p1 < p0 || p1 > p3) && (p2 < p0 || p2 > p3) && p0 < p3) {
            warn(t, "DELETE in the water.");
          }
        }

        { final int p0 = 0;
          final int p1 = lastIndexOf("deleteStatement");
          final int p2 = lastIndexOf("statement");

          if (p0 < p1 && p1 < p2) {
            warn(t, "DELETE not in delete statement.");
          }
        }

        { final int p0 = 0;
          final int p1 = lastIndexOf("statement");
          final int p2 = lastIndexOf("execStatement");
          final int p3 = lastIndexOf("deleteStatement");

          if (p0 < p1 && p2 < p1 && p3 < p1) {
            warn(t, "DELETE not in delete statement.");
          }
        }
      }
    });

    register("END-DELETE", new Verifier() {
      public void verify(Token t) {
        { final int p0 = 0;
          final int p1 = lastIndexOf("execStatement");
          final int p2 = lastIndexOf("deleteStatement");
          final int p3 = lastIndexOf("water");

          if ((p1 < p0 || p1 > p3) && (p2 < p0 || p2 > p3) && p0 < p3) {
            warn(t, "END-DELETE in the water.");
          }
        }

        { final int p0 = 0;
          final int p1 = lastIndexOf("deleteStatement");
          final int p2 = lastIndexOf("statement");

          if (p0 < p1 && p1 < p2) {
            warn(t, "END-DELETE not in delete statement.");
          }
        }

        { final int p0 = 0;
          final int p1 = lastIndexOf("statement");
          final int p2 = lastIndexOf("execStatement");
          final int p3 = lastIndexOf("deleteStatement");

          if (p0 < p1 && p2 < p1 && p3 < p1) {
            warn(t, "END-DELETE not in delete statement.");
          }
        }
      }
    });

    register("REWRITE", new Verifier() {
      public void verify(Token t) {
        { final int p0 = 0;
          final int p1 = lastIndexOf("execStatement");
          final int p2 = lastIndexOf("execStatement");
          final int p3 = lastIndexOf("rewriteStatement");
          final int p4 = lastIndexOf("water");

          if ((p1 < p0 || p1 > p4) && (p2 < p0 || p2 > p4) && (p3 < p0 || p3 > p4) && p0 < p4) {
            warn(t, "REWRITE in the water.");
          }
        }

        { final int p0 = 0;
          final int p1 = lastIndexOf("rewriteStatement");
          final int p2 = lastIndexOf("statement");

          if (p0 < p1 && p1 < p2) {
            warn(t, "REWRITE not in rewrite statement.");
          }
        }

        { final int p0 = 0;
          final int p1 = lastIndexOf("statement");
          final int p2 = lastIndexOf("execStatement");
          final int p3 = lastIndexOf("rewriteStatement");

          if (p0 < p1 && p2 < p1 && p3 < p1) {
            warn(t, "REWRITE not in rewrite statement.");
          }
        }
      }
    });

    register("END-REWRITE", new Verifier() {
      public void verify(Token t) {
        { final int p0 = 0;
          final int p1 = lastIndexOf("execStatement");
          final int p2 = lastIndexOf("rewriteStatement");
          final int p3 = lastIndexOf("water");

          if ((p1 < p0 || p1 > p3) && (p2 < p0 || p2 > p3) && p0 < p3) {
            warn(t, "END-REWRITE in the water.");
          }
        }

        { final int p0 = 0;
          final int p1 = lastIndexOf("rewriteStatement");
          final int p2 = lastIndexOf("statement");

          if (p0 < p1 && p1 < p2) {
            warn(t, "END-REWRITE not in rewrite statement.");
          }
        }

        { final int p0 = 0;
          final int p1 = lastIndexOf("statement");
          final int p2 = lastIndexOf("execStatement");
          final int p3 = lastIndexOf("rewriteStatement");

          if (p0 < p1 && p2 < p1 && p3 < p1) {
            warn(t, "END-REWRITE not in rewrite statement.");
          }
        }
      }
    });
  }
}