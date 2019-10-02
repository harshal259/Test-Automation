Feature: Login Feature

  Scenario: Login to facebook

    Given user is on home page
    Then user created a new account by entering details
    Then user click on Data policy link
    Then I clear the entered data and reentered it through excel

  @test
  Scenario Outline: Automation practice

    Given user is on home page
    When user searches for "<searchText>"
    Then verify that user lands on page "<pageName>"
    And verify that top bar consists below menu items
      | Women   |
      | Dresses |
      | T-shirt |
#    Then I execute select query on DB

    Examples:
      | searchText | pageName |
      | Shirt      | My Store |
