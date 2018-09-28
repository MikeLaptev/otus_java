### Used design patterns

#### Atm

Contains implementation of the Momento pattern.
This pattern is used for easier restoring Atm state in case of 
an exceptional situation that occurs during an operation.

#### Currencies

Currencies are implemented using the Chain Responsibilities pattern.
It is easier to add/remove a new/old banknote type as well as process 
all the operations within the chain.