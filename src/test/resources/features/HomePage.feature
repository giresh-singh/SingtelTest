Feature: Test the ToDoMVC user URL for DT Testing

  @Test
  Scenario Outline: Verify adding a todo to the list.
    Given user opens homepage.
    When add the Item: "<items>" in To Do list.
    #Then check the added '<items>' is correct
    Examples:
      | items                                                |
      | eqeqwewewrewrewfrere454tgghjweejiwru32476389roi3jkhb |


