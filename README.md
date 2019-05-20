# Bowling score keeper

Bowling score keeper calculator developed for Software Dependability course following the test driven development metodology.

## Usage
The project consist in two classes: Game and Frame. Frame can be of three types: normal, bonus strike and bonus spare. 
The class Game accept an arraylist of Frames; the arraylist must have a size of 10 with the exception if the 10° throw is a strike or a spare. In this case, a bonus throw is added to the arraylist. The bonus throw can be a bonus strike or a bonus spare frame depending on the 10nth throw. If the bonus frame lack of specialization, is marked as a normal frame or if the size of the arraylist is wrong an exeption is throw.The score is calculate following the classic bowling scheme
