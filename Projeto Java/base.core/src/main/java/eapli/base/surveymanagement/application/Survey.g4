grammar Survey;

prog: survey ;

survey: id end title end wMessage? end? section+ end wMessage end # surveys
;

id: alphanumeric+
| alphanumeric+ HIFFEN alphanumeric+;

alphanumeric:INT
| WORD
;


title: phrase
;

obli:MANDATORY
|OPTIONAL
|CONDITION_DEPENDENT
;

wMessage: (phrase signal)+
;


section: otherId end title end wMessage? end? obli end rep? end? content+ ;

otherId: INT;



rep: INT;

content: otherId end question end wMessage? end? type end obli end phrase? end?;

question: phrase INTE;

phrase: ( WORD | INT ) (COMMA? SPACE (WORD | INT ))*
;

signal: COMMA
|ELLIP
| DOT
| INTE
| EXCL;

type:FREE_TEXT
| NUMERIC
|SINGLE_CHOICE
|SINGLE_CHOICE_INPUT
|MULTIPLE_CHOICE
|MULTIPLE_CHOICE_INPUT
|SORTING_OPTIONS
|SCALING_OPTIONS
;

end: FIM
| NEWLINE
| FIM NEWLINE
| DOT
;


NEWLINE:[\r\n]+;
MANDATORY: 'mandatory';
OPTIONAL: 'optional';
CONDITION_DEPENDENT: 'condition dependent';
FREE_TEXT:'Free-text';
NUMERIC:'Numeric';
SINGLE_CHOICE:'Single-Choice';
SINGLE_CHOICE_INPUT:'Songle-Choice with input value';
MULTIPLE_CHOICE:'Multiple-Choice';
MULTIPLE_CHOICE_INPUT:'Multiple-Choice with input value';
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
