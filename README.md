# Tug-of-War
UVa 10032

A simple dynamic problem with a small twist (requiring the number of people on the
two teams must not differ by more than 1). In order to keep track of the different
numbers of how many people are needed to form a weight, an array of long is used. 
If the i-th bit of weight k is turned on, it suggests that it is possible to form weight k
with i number of people. For example, if people[21]=0001 1110, it means that it is possible 
to form the weight of 21 with 1, 2, 3, or 4 people since bit 1, 2, 3, and 4 are turned on.
