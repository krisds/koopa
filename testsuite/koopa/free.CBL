******************************************************************
*                                                                *
* Testfile for the Koopa tokenizer.                              *
*                                                                *
* This is a free format version of the test.cbl file. As there   *
* is no identification area we can't do any token counting here. *
* Instead we check if it generates the same tokens as the        *
* original one (disregarding comments and whitespace).           *
*                                                                *
******************************************************************

* Title compiler directive.
 TITLE "Koopa Tokenizer Test".

 IDENTIFICATION DIVISION.

 PROGRAM-ID.
*    TOKENIZER-TEST.
     TOKENIZER-TEST IS INITIAL PROGRAM.

 AUTHOR.
     KRIS DE SCHUTTER.

* My apologies to Bill Watterson for the many silly Calvin and
* Hobbes references in this file. It just helped to keep my sanity
* in check while writing all this stuff.

******************************************************************

 DATA DIVISION.

 WORKING-STORAGE SECTION.

* Testing of picture clauses.
 01 FIELD-00  PICTURE XXXXXX        VALUE "ABCDEF".
 01 FIELD-01  VALUE   IS "AB1C2D"   PIC   AAXXXX.
 01 FIELD-02  PICTURE IS AA9999     VALUE IS "AB1234".
 01 FIELD-03  VALUE   "AB1C2D"      PIC   IS A(2)X(4).
 01 FIELD-04  PICTURE 9999          VALUE IS ALL ZEROES.
 01 FIELD-05  VALUE   IS ZERO       PIC   S99.
 01 FIELD-06  PICTURE IS S99V9      VALUE IS X'0F'.
 01 FIELD-07  PIC     IS PPP999.
 01 FIELD-08  PICTURE S999PPP.
 01 FIELD-09  PIC     BAAAB.
 01 FIELD-10  PICTURE IS 999,999.
 01 FIELD-11  PIC     IS 99B99B99.
 01 FIELD-12  PICTURE 99B99B00.
 01 FIELD-13  PIC     99/99/99.
 01 FIELD-14  PICTURE IS XXBXXX.
 01 FIELD-15  PIC     IS 000X(5).
 01 FIELD-16  PICTURE XX/XX.
 01 FIELD-17  PIC     999.999.
 01 FIELD-18  PICTURE IS +999.99.
 01 FIELD-19  PIC     IS -999.99.
 01 FIELD-20  PICTURE $999.99.
 01 FIELD-21  PIC     $$$$.99.
 01 FIELD-22  PICTURE IS $,$$$.99.
 01 FIELD-23  PIC     IS +,+++.99.
 01 FIELD-24  PICTURE +,+++.++.
 01 FIELD-25  PIC     $,$$$.99.
 01 FIELD-26  PICTURE IS -,---.99.
 01 FIELD-27  PIC     IS $$.$$$.99.
 01 FIELD-28  PICTURE +,+++,999.99.
 01 FIELD-29  PIC     +,+++,+++.++.
 01 FIELD-30  PICTURE IS ZZZZ.ZZ.
 01 FIELD-31  PIC     IS ****.**.
 01 FIELD-32  PICTURE ZZZZ.99.
 01 FIELD-33  PIC     ****.99.
 01 FIELD-34  PICTURE IS ZZZZ.ZZ.
 01 FIELD-35  PIC     IS $**,***.**B.
 01 FIELD-36  PICTURE $BB****,**.99BB.

 01 FIELD-37A PIC S9(6)V9(6).
 01 FIELD-37B PIC S9(6)V9(6).

 66 FIELD-38 RENAMES FIELD-00.
 66 FIELD-39 RENAMES FIELD-01 THROUGH FIELD-02.
 66 FIELD-40 RENAMES FIELD-03 THRU FIELD-04.

 01 BUGGY-00 PICTURE S9(03)V9(06).

 88 COND-00 VALUE IS 0.
 88 COND-01 VALUE 1.
 88 COND-02 VALUES ARE 2.
 88 COND-03 VALUES 3.
 88 COND-04 VALUES ARE 0 THROUGH 10.
 88 COND-05 VALUES ARE 0 THRU 10, 20 THRU 30.
 88 COND-06 VALUES ARE 0, 2, 4, 6.
 88 COND-07 VALUES ARE 1; 3; 5; 7.

 01 PROCEDUREDIVISION  PIC X.

******************************************************************

 PROCEDURE DIVISION.

* Testing string literals.
 DISPLAY 'So long, Pop!'.
 DISPLAY "I'm off to check my tiger trap!".

* Testing numeric literals.
 DISPLAY 1, 23, 456, 7890.      *> These are integer values.
 DISPLAY 1.23, 345.6789, .8.    *> These are decimal values.
* TODO: Test signed numeric literals.

* First paragraph; not in section.
 YUKON-HO.

 MOVE SPACEMAN-SPIFF TO THE-FIFTH-DIMENSION.

 ACCEPT THE-ANSWER-TO-QUESTION-7-FROM-SUSIE-DERKINS.

 ADD 100 TO MONEY-SAVED-WHILE-BUILDING-CHARACTER.

 MOVE "You know how Einstein got bad grades as a kid? Well, mine are even worse!" TO CALVIN-QUOTE.

 MOVE "Sometimes I think the surest sign that intelligent life exists elsewhere in the universe is that none of it has tried to contact us." TO CALVIN-QUOTE.

* First section.
 SCIENTIFIC-PROGRESS SECTION.

 MOVE -100000000.000000 TO TWELVE-AND-SEVEN.

* Paragraph inside a section.
 BOINK.

* Quoted quotes...
 DISPLAY "I want to be introduced as ""Calvin, boy of destiny."" But you have to say it right, pause a little after ""boy,"" and say ""Destiny"" a bit slower and deeper for emphasis. Say it, ""Boy... Of Dessstiny,"" Like that!".

 MOVE 'thoroughly useless information' TO CALVINS-COMMAND.

 MOVE 'Our class voted Calvin the ''Most likely to be seen on the news some day''.' TO SUSIE-QUOTE.

 DISPLAY 'ONE' 'TWO'
         'THREE'.

* Pseudo literals.
 REPLACE ==Calvin== BY ==Spaceman Spiff==.
 COPY SUSIES-HOMEWORK
     REPLACING ==Susie Derkins.== BY ==Calvin, the misunderstood
     genius.==

* Checks that the comment indicator is not recognised inside literals.
 DISPLAY '*> DO A BARREL ROLL <*'.

* Checks that non-separator non-cobol-word characters get split up correctly.
 IF NUMBER=ELEVENTEEN
   DISPLAY "You have to use imaginary numbers.".

* Checks tokenisation of <= and >= .
 IF CALVIN >= HOBBES
    OR CALVIN <= SUSIE
   DISPLAY "...".
