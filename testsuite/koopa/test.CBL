      *  1         2         3         4         5         6         7         8
123456*8901234567890123456789012345678901234567890123456789012345678901234567890
KOOPAH******************************************************************:0
KOOPAH*                                                                *:0
KOOPAH* Testfile for the Koopa tokenizer.                              *:0
KOOPAH*                                                                *:0
KOOPAH* The identification area may have a colon followed by a number. *:0
KOOPAH* That number represents the expected number of tokens in the    *:0
KOOPAH* program text area of that line.                                *:0
KOOPAH* If the line gets continued on the next line (by means of a     *:0
KOOPAH* continuation marker), then only the number at the end of the   *:0
KOOPAH* last continuation line is checked, and this count is for all   *:0
KOOPAH* tokens (in the program text) of all lines (original and        *:0
KOOPAH* continued).                                                    *:0
KOOPAH*                                                                *:0
KOOPAH******************************************************************:0
KOOPAH
KOOPAH IDENTIFICATION DIVISION.                                         :5
KOOPAH
KOOPAH PROGRAM-ID.                                                      :3
KOOPAH*    TOKENIZER-TEST.                              *>  4 tokens -> :0
KOOPAH     TOKENIZER-TEST IS INITIAL PROGRAM.           *> 10 tokens -> :10
KOOPAH
KOOPAH AUTHOR.                                                          :3
KOOPAH     KRIS DE SCHUTTER.                                            :8
KOOPAH                                                                  :1
KOOPAH* My apologies to Bill Watterson for the many silly Calvin and    :0
KOOPAH* Hobbes references in this file. It just helped to keep my sanity:0
KOOPAH* in check while writing all this stuff.                          :0
KOOPAH
KOOPAH******************************************************************:0
KOOPAH
KOOPAH DATA DIVISION.                                                   :5
KOOPAH
KOOPAH WORKING-STORAGE SECTION.                                         :5
KOOPAH
KOOPAH* Testing of picture clauses.                                     :0
KOOPAH 01 FIELD-00  PICTURE XXXXXX        VALUE "ABCDEF".               :13
KOOPAH 01 FIELD-01  VALUE   IS "AB1C2D"   PIC   AAXXXX.                 :15
KOOPAH 01 FIELD-02  PICTURE IS AA9999     VALUE IS "AB1234".            :17
KOOPAH 01 FIELD-03  VALUE   "AB1C2D"      PIC   IS A(2)X(4).            :22
KOOPAH 01 FIELD-04  PICTURE 9999          VALUE IS ALL ZEROES.          :17
KOOPAH 01 FIELD-05  VALUE   IS ZERO       PIC   S99.                    :15
KOOPAH 01 FIELD-06  PICTURE IS S99V9      VALUE IS X'0F'.               :17
KOOPAH 01 FIELD-07  PIC     IS PPP999.                                  :11
KOOPAH 01 FIELD-08  PICTURE S999PPP.                                    :9
KOOPAH 01 FIELD-09  PIC     BAAAB.                                      :9
KOOPAH 01 FIELD-10  PICTURE IS 999,999.                                 :11
KOOPAH 01 FIELD-11  PIC     IS 99B99B99.                                :11
KOOPAH 01 FIELD-12  PICTURE 99B99B00.                                   :9
KOOPAH 01 FIELD-13  PIC     99/99/99.                                   :9
KOOPAH 01 FIELD-14  PICTURE IS XXBXXX.                                  :11
KOOPAH 01 FIELD-15  PIC     IS 000X(5).                                 :14
KOOPAH 01 FIELD-16  PICTURE XX/XX.                                      :9
KOOPAH 01 FIELD-17  PIC     999.999.                                    :9
KOOPAH 01 FIELD-18  PICTURE IS +999.99.                                 :11
KOOPAH 01 FIELD-19  PIC     IS -999.99.                                 :11
KOOPAH 01 FIELD-20  PICTURE $999.99.                                    :9
KOOPAH 01 FIELD-21  PIC     $$$$.99.                                    :9
KOOPAH 01 FIELD-22  PICTURE IS $,$$$.99.                                :11
KOOPAH 01 FIELD-23  PIC     IS +,+++.99.                                :11
KOOPAH 01 FIELD-24  PICTURE +,+++.++.                                   :9
KOOPAH 01 FIELD-25  PIC     $,$$$.99.                                   :9
KOOPAH 01 FIELD-26  PICTURE IS -,---.99.                                :11
KOOPAH 01 FIELD-27  PIC     IS $$.$$$.99.                               :11
KOOPAH 01 FIELD-28  PICTURE +,+++,999.99.                               :9
KOOPAH 01 FIELD-29  PIC     +,+++,+++.++.                               :9
KOOPAH 01 FIELD-30  PICTURE IS ZZZZ.ZZ.                                 :11
KOOPAH 01 FIELD-31  PIC     IS ****.**.                                 :11
KOOPAH 01 FIELD-32  PICTURE ZZZZ.99.                                    :9
KOOPAH 01 FIELD-33  PIC     ****.99.                                    :9
KOOPAH 01 FIELD-34  PICTURE IS ZZZZ.ZZ.                                 :11
KOOPAH 01 FIELD-35  PIC     IS $**,***.**B.                             :11
KOOPAH 01 FIELD-36  PICTURE $BB****,**.99BB.                            :9
KOOPAH
KOOPAH* Testing continuation of picture clauses.                        :0
KOOPAH 01 FIELD-37A PIC S9(
KOOPAH-                    6)V9(6).                                     :16
KOOPAH 01 FIELD-37B PIC S9(                                             KOOPAH
KOOPAH-                    6)V9(6).                                     :16
KOOPAH
KOOPAH 66 FIELD-38 RENAMES FIELD-00.                                    :9
KOOPAH 66 FIELD-39 RENAMES FIELD-01 THROUGH FIELD-02.                   :13
KOOPAH 66 FIELD-40 RENAMES FIELD-03 THRU FIELD-04.                      :13
KOOPAH
KOOPAH 88 COND-00 VALUE IS 0.                                           :11
KOOPAH 88 COND-01 VALUE 1.                                              :9
KOOPAH 88 COND-02 VALUES ARE 2.                                         :11
KOOPAH 88 COND-03 VALUES 3.                                             :9
KOOPAH 88 COND-04 VALUES ARE 0 THROUGH 10.                              :15
KOOPAH 88 COND-05 VALUES ARE 0 THRU 10, 20 THRU 30.                     :22
KOOPAH 88 COND-06 VALUES ARE 0, 2, 4, 6.                                :20
KOOPAH 88 COND-07 VALUES ARE 1; 3; 5; 7.                                :20
KOOPAH
KOOPAH 01 PROCEDURE                                                     KOOPAH
KOOPAH-            DIVISION  PIC X.                                     :9
KOOPAH
KOOPAH******************************************************************:0
KOOPAH
KOOPAH PROCEDURE DIVISION.                                              :5
KOOPAH
KOOPAH* Testing string literals.                                        :0
KOOPAH DISPLAY 'So long, Pop!'.                                         :5
KOOPAH DISPLAY "I'm off to check my tiger trap!".                       :5
KOOPAH
KOOPAH* Testing numeric literals.                                       :0
KOOPAH DISPLAY 1, 23, 456, 7890.  *> These are integer values.          :14
KOOPAH DISPLAY 1.23, 345.6789.    *> These are decimal values.          :8
KOOPAH* TODO: Test signed numeric literals.                             :0
KOOPAH
KOOPAH* First paragraph; not in section.                                :0
KOOPAH YUKON-HO.                                                        :3
KOOPAH
KOOPAH* Testing continuation lines.                                     :0
KOOPAH MOVE SPACEMAN-SPIFF TO THE-FIFTH-
KOOPAH-     DIMENSION.                                                  :9
KOOPAH
KOOPAH ACCEPT THE-ANSWER-TO-QUESTION-7
KOOPAH-       -FROM-SUSIE-DERKINS.                                      :5
KOOPAH
KOOPAH ADD 100 TO MONEY-SAVED-
KOOPAH-           WHILE
KOOPAH-           -BUILDING-CHARACTER.                                  :9
KOOPAH
KOOPAH MOVE "You know how Einstein got bad grades as a kid? Well, mine a
KOOPAH-     "re even worse!" TO CALVIN-QUOTE.                           :9
KOOPAH
KOOPAH MOVE "Sometimes I think the surest sign that intelligent life exi
KOOPAH-     "sts elsewhere in the universe is that none of it has tried 
KOOPAH-     "to contact us." TO CALVIN-QUOTE.                           :9
KOOPAH
KOOPAH* First section.                                                  :0
KOOPAH SCIENTIFIC-PROGRESS SECTION.                                     :5
KOOPAH
KOOPAH* If you write code like this (for purposes other than testing a  :0
KOOPAH* parser), you should get banned from computers for life.         :0
KOOPAH MOVE -
KOOPAH-     100
KOOPAH-     000
KOOPAH-     000
KOOPAH-     .
KOOPAH-     000
KOOPAH-     000 TO TWELVE-AND-SEVEN.                                    :9
KOOPAH
KOOPAH* Paragraph inside a section.                                     :0
KOOPAH BOINK.                                                           :3
KOOPAH
KOOPAH* Continuations and quoted quotes...
KOOPAH DISPLAY "I want to be introduced as ""Calvin, boy of destiny."" B
KOOPAH-        "ut you have to say it right, pause a little after ""boy,
KOOPAH-        """ and say ""Destiny"" a bit slower and deeper for empha
KOOPAH-        "sis. Say it, ""Boy... Of Dessstiny,"" Like that!".      :5
KOOPAH
KOOPAH MOVE    'thoroughly
KOOPAH-        ' useless 
KOOPAH-        'information' TO CALVINS-COMMAND.                        :9
KOOPAH
KOOPAH* The quoted quote may also be continued in mid-quoting. Which    :0
KOOPAH* means adding yet another quote...                               :0
KOOPAH MOVE                                'Our class voted Calvin the '
KOOPAH-                   ''Most likely to be seen on the news some day'
KOOPAH-     ''.' TO SUSIE-QUOTE.                                        :9
KOOPAH
KOOPAH* The following contains three literals; not two.                 :0
KOOPAH DISPLAY 'ONE'                                               'TWO'
KOOPAH-        'THREE'.                                                 :9
KOOPAH
KOOPAH* Pseudo literals.                                                :0
KOOPAH REPLACE ==Calvin== BY ==Spaceman Spiff==.                        :9
KOOPAH COPY SUSIES-HOMEWORK                                             :4
KOOPAH      REPLACING ==Susie Derkins.== BY ==Calvin, the misunderstood
KOOPAH      genius.==                                                   :9
KOOPAH
KOOPAH* Checks that the comment indicator is not recognised inside
KOOPAH* literals.
KOOPAH DISPLAY '*> DO A BARREL ROLL <*'.                                :5
