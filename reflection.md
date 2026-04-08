Use this file to record your reflection on this assignment.

- Which methods did you decide to `overload`, and why?
- What worked, what didn't, what advice would you give someone taking this course in the future?

-I overloaded methods so that same action can be done in more than one way. For example, in Cafe.java, I overloaded sellCoffee(...) so that coffee could be sold with different amounts of details like its size, whether with sugar, or with sugar and cream. Or not. Same idea applies to House.java and Library.java. In those situations, it is just natural for a user to might want to have more than one way of doing the same task.

- For me, building on top of A7 rather than starting from scratch worked well. Inheritance reused code from Building.java, so it became easier for me to focus only on what was new for each class. It was a bit difficult to decide how to override goToFloor(...) because it is different for each subclass, and I had to make the overloaded methods still relatively simple/ clear.

- An advice to future students: keep the parent class open while working so you can see what has already been inherited and what has to be changed. Overloading is like giving a user options/ multiple ways of doing the same action, which allows more interactivity, and saves us from trying to invent completely different behaviors. 