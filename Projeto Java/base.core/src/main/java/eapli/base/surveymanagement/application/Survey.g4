grammar Survey;

prog: survey ;

survey: id end title end wMessage? end? section+ wMessage end # surveys
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

content: otherId end question end wMessage? end? type end;

question: phrase INTE;

phrase: ( WORD | INT ) (COMMA? SPACE (WORD | INT ))*
;

signal: COMMA
|ELLIP
| DOT
| INTE
| EXCL;

type:FREE_TEXT end obli end FT_TEXT
| NUMERIC end obli end NUM_TEXT
|SINGLE_CHOICE end obli end SC_TEXT
|SINGLE_CHOICE_INPUT end obli end SCI_TEXT
|MULTIPLE_CHOICE end obli end MC_TEXT
|MULTIPLE_CHOICE_INPUT end obli end MCI_TEXT
|SORTING_OPTIONS end obli end SO_TEXT
|SCALING_OPTIONS end obli end SCO_TEXT
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
SINGLE_CHOICE_INPUT:'Single-Choice with input value';
SINGLE_CHOICE:'Single-Choice';
MULTIPLE_CHOICE_INPUT:'Multiple-Choice with input value';
MULTIPLE_CHOICE:'Multiple-Choice';
SORTING_OPTIONS:'Sorting Options';
SCALING_OPTIONS:'Scaling Options';
FT_TEXT:'it means the person answers the question by typing some text.';
NUM_TEXT:'it means the person answers the question by typing a numeric value.';
SC_TEXT:'it means the person answers the question by selection one (and just one) of the provided options.';
SCI_TEXT:'very similar to the single choice but the last option, if selected, implies that the person must type a numeric value or a free text.';
MC_TEXT:'very similar to the single choice, but instead of selection just one, the answering person might select more than one.';
MCI_TEXT:'very similar to the multiple choice, but the last option, if selected, implies that the person must type a numeric value or a free text.';
SO_TEXT:'given two or more option the person answers the question by sorting the options as desired and in accordance with the instructions provided.';
SCO_TEXT:'it means the person answers the question by selecting a value of a given scale (e.g.: unimportant, neutral, important) to each of the specified options.';
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