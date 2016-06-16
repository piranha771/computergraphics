grammar ShapeGrammar;

shape_grammar
    :
        decoration*
        start_entry
        decoration*
        shape_rule+
    ;

decoration
    :
        include_statement
        | attr
        | resource
    ;

include_statement
    :
        'include' PATH END
    ;

attr
    :
        'attr' ATTR_TYPE IDENTIFIER ('(' NUMBER ',' NUMBER ')')? END
    ;

resource
    :
        RESOURCE_TYPE IDENTIFIER PATH END
    ;

start_entry
    :
        'start' IDENTIFIER END
    ;

shape_rule
    :
        IDENTIFIER ARROW (func (',' func)*) END
    ;

func
    :
        IDENTIFIER '(' (parameter (',' parameter)*)* ')'
    ;

parameter
    :
        expr
        | func
    ;

expr
    :
        addition_exp
    ;

addition_exp
    :
        multiply_exp ( '+' multiply_exp | '-' multiply_exp)*
    ;

multiply_exp
    :
         atom_exp
         ( '*' atom_exp
         | '/' atom_exp
         )*
    ;

atom_exp
    :
        NUMBER
        | object_identifier
        | '(' addition_exp ')'
    ;

object_identifier
    :
        IDENTIFIER ('.' IDENTIFIER)*
    ;

/** TOKEN **/
ARROW
    :
        '->'
    ;

END
    :
        ';'
    ;

NUMBER
    :
        INT
        |FLOAT
    ;

INT
    :
        [0-9]+
    ;

FLOAT
    :
        INT+ ('.' INT+)
    ;

WS
    :
        [ \t\r\n]+ -> skip // skip spaces, tabs, newlines
    ;


PATH
    :
        '\"' ('a'..'z'|'A'..'Z'|'0'..'9'|'_'|'-'|'.'|'/'|'\\')+ '\"'
    ;
ATTR_TYPE
    :
        'int'
        |'float'
        |'bool'
    ;
RESOURCE_TYPE
    :
        'model'
    ;


IDENTIFIER
    :
        [a-z]+
        |([a-z][a-z_0-9]+)
    ;