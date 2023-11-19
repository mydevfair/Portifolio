Activity 1 (Portfolio Task):
In this practical you are implementing a conference management system, based
on arrays and pointers thus implementing a subset of a typical array list
functionality.
Note: Do not use Java’s ArrayList.
Implement classes Talk, Session, and Conference that provide the following
functionality:
 Class Talk:
 Stores talk id, speaker, title, and startTime (following ISO 8601)
 Creates a human friendly representation of the class (i.e. toString())
 Allows a total ordering of talks (i.e. talks are Comparable based on
startTime)
 Class Session:
 Stores session id, location, a talk list (an array of scheduled talks
with default capacity for 4 talks), and the current size of the talk list
 Allows talks to be scheduled if a talk is not already in the talk list
(while maintaining the talk list in ascending order based on
startTime)
 Allows talks to be cancelled (the talk list must not have gaps that
“break” the sequence of scheduled talks)
 Creates a human friendly representation of the class (i.e. toString(),
improve print outs by ignoring empty elements within the talk list)
 Class Conference:
 Contains a main function driving events
 Creates four sessions
 Schedules and cancels talks for each session so that each session
has eventually between one and four talks
 Prints the final conference schedule
