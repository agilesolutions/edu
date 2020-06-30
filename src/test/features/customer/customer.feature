Feature: Managing customers

   @basis
   Scenario Outline: Retrieve customer age by identifier
        When I search customer age by identifier <id>
        Then the customer age is found
        And its age is '<age>'
        
   Examples:
   
    | id             | age                        |
    | 1              | 28                         |
    | 2              | 21                         |
    | 3 		     | 22                         |
   
   @critical 
   Scenario Outline: Retrieve customer gender by identifier
        When I search customer gender by id <id>
        Then the customer gender is found
        And its gender is <gender>
        
   Examples:
   
    | id             | gender |
    | 1              | M      |
    | 2              | F      |
    | 3 		     | F      |     