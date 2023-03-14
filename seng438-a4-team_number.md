**SENG 438 - Software Testing, Reliability, and Quality**

**Lab. Report \#4 – Mutation Testing and Web app testing**

| Group \#:      |     |
| -------------- | --- |
| Student Names: |     |
|      Oliver Molina          |     |
|                |     |
|                |     |

# Introduction
We do some things idk 

# Analysis of 10 Mutants of the Range class 
## __Survived__
### Negated double field lower  
```java
public boolean contains(double value)  
{
        return (value >= this.lower && value <= this.upper);
}
```
In this test case a negation of the lower bound still 
resulted in the the same return value since since our test cases did not use large enough lower and upper bounds for such a bug to be noticed i.e Range.lower = 0.  
###  Post Incrementation/Decrementation in line 225 of Range.combine():  
```java
return new Range(l, u)
```  
 Post incrementation of the values l or u is not detected since the operation is happening post construction of the return object, such an error should be irrelevant as the program stands but could cause errors with future iterations.

 ```java

 ```

## __Killed__

# Report all the statistics and the mutation score for each test class



# Analysis drawn on the effectiveness of each of the test classes

# A discussion on the effect of equivalent mutants on mutation score accuracy

# A discussion of what could have been done to improve the mutation score of the test suites

# Why do we need mutation testing? Advantages and disadvantages of mutation testing

# Explain your SELENUIM test case design process

# Explain the use of assertions and checkpoints

# how did you test each functionaity with different test data

# Discuss advantages and disadvantages of Selenium vs. Sikulix

# How the team work/effort was divided and managed


# Difficulties encountered, challenges overcome, and lessons learned

# Comments/feedback on the lab itself
