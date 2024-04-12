## SovietVille

The city of SovietVille is very strange and people there are still living in the 
socialist era, so they don't want to change anything. An ordinary home in 
SovietVille consists of fixed things depending on certain conditions. 

- A **young couple**'s home has 
  - two rooms
  - a TV
  - a fridge
  - one computer per person
  - *Room's electricity* cost is: **20**.
- A **single young person** has 
  - a room
  - a computer
  - *Room’s electricity* cost is: **10**.
- An **old couple** has 
  - three rooms
  - a TV
  - a fridge
  - a stove
  - *Room’s electricity* cost is: **15**.
- A **single old person** has 
  - a room
  - a stove
  - *Room’s electricity* cost is: **15**.

> ### Optional
> - A **young couple with children** has
>   - two rooms
>   - a TV
>   - a fridge
>   - a computer per each adult
>   - toys for each child
>   - *Room's electricity* cost is: **30**.


Each **Device** (computer, TV, fridge or stove) has certain electricity cost (of your choice).
   - For example: fridge costs **1.5**, stove costs **1.2**, TV cost **1** , computer cost **0.7**

Each **room** has fixed electricity cost for lighting.

Each **adult** has either
  - a *salary* if they are young
  - or *pension* if they are old. 

>### For optional
>   - Parents have to pay for each of their child's food any toys.

 - You will receive the whole population of SovietVille from the standard input as 
homes information (in SovietVille there are no homeless people) and each command 
will come on a new line. 
 - Consider each **4** input lines as a whole month, thus each person in SovietVille 
receives either a *salary* or *pension* when a month ends.

###Input commands

   - **status**: You need to print the *total consumption* of electricity and food/toys 
cost in SovietVille.
   - **bills**: You need to take the money 
     - for the electricity
     - spent on food from the home's budget.
   - A home's budget is the sum of all salaries/pensions of
     the people living there. 
   - If they are not able to pay their bills, they are forced to move away from the
          city and will no longer be part of it.
>### For optional
>   - take the money for food and toys after each children


   - **quit**: End the input sequence. Afterwards you need 
to print the whole population count (people and their children).

   - ####Register Home Commands:
     - **YoungCouple(salary1, salary2)** – registers a young couple in SovietVille
     - **YoungSingle(salary)** – registers a single young person
     - **OldCouple(pension1, pension2)** – registers an old couple
     - **OldSingle(pension)** – registers a single old person

>###For optional
> - **YoungCoupleWithChildren(salary1, salary2) Child(foodCost, toy1Cost, toy2Cost,... toyNCost) Child(foodCost, toy1Cost, toy2Cost,... toyNCost)**
> 
> – registers a young couple with their children (and their food/toys costs)

### Examples

  - **Example 1:**
    - YoungCouple(22, 25)
    - YoungCouple(22, 24)
    - YoungCouple(22, 22)
    - bills
      - salaries are paid (because it is the fourth line)
      - bills are paid 
    - quit
      - output: _Total population: ..._

  - **Example 2:**
    - YoungCouple(22, 25)
    - YoungCouple(22, 24)
    - YoungCouple(22, 22)
    - YoungCoupleWithChildren(130, 130) Child(10, 5, 6, 7, 8) Child(10, 5, 5) Child(10, 5) - salaries are paid 
    - status
      - output: _Total consumption: ...._
    - status
      - output: _Total consumption: ...._
    - bills
      - bills are paid 
    - quit
      - output: Total population: ...
