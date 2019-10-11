Feature: Login Feature

  Scenario: Login to facebook
    Given user is on home page
    Then user created a new account by entering details
    Then user click on Data policy link
    Then I clear the entered data and reentered it through excel

  Scenario Outline: Basic navigation
    Given user is on home page
    When user searches for "<searchText>"
    Then verify that user lands on page "<pageName>"
    And verify that top bar consists below menu items
      | Women    |
      | Dresses  |
      | T-SHIRTS |

    Examples:
      | searchText | pageName |
      | Shirt      | My Store |

  @test
  Scenario Outline: Hover on Element
    Given user is on home page
    When user hovers on "<sectionName>" and selects "<category>"
    And verify that 5 products are displayed
    When user applies item filters "Categories,Size,Color,Availability" for "<tcID>"
#    When user adds item 1 to the card
#    Then I execute select query on DB

    Examples:
      | sectionName | category | tcID  |
      | Women       | Dresses  | tc_01 |
      | Women       | Dresses  | tc_02 |
      | Women       | Dresses  | tc_03 |
