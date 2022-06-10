grammar Answer;

prog: (otherId end answer)+ ;

answer: type # answers
;

alphanumeric:INT
| WORD
;

otherId: INT;

phrase: ( WORD | INT ) (COMMA? SPACE (WORD | INT ))*
;

signal: COMMA
|ELLIP
| DOT
| INTE
| EXCL;

option: alphanumeric NEWLINE;

text: (phrase signal)+;

type: FREE_TEXT end text NEWLINE
|NUMERIC end INT NEWLINE
|SINGLE_CHOICE end option
|SINGLE_CHOICE_INPUT end (option|(phrase NEWLINE))
|MULTIPLE_CHOICE end (option)+
|MULTIPLE_CHOICE_INPUT end (option)+ (phrase NEWLINE)?
|SORTING_OPTIONS end (option)+
|SCALING_OPTIONS end (option)+
;

end: FIM
| NEWLINE
| FIM NEWLINE
| DOT
;


NEWLINE:[\r\n]+;
FREE_TEXT:'Free-text';
NUMERIC:'Numeric';
SINGLE_CHOICE_INPUT:'Single-Choice with input value';
SINGLE_CHOICE:'Single-Choice';
MULTIPLE_CHOICE_INPUT:'Multiple-Choice with input value';
MULTIPLE_CHOICE:'Multiple-Choice';
SORTING_OPTIONS:'Sorting Options';
SCALING_OPTIONS:'Scaling Options';
INT:[0-9]+;
WORD:[a-zA-Z]+;
SPACE:' ';
COMMA:',';
DOT:'.';
EXCL:'!';
INTE:'?';
ELLIP:'...';
HIFFEN: '-';
FIM : ';';
RIGHT_PARENTHESES: ')';