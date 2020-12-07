Feature: Login Feature

#  Scenario: Login to facebook
#    Given user is on home page
#    Then user created a new account by entering details
#    Then user click on Data policy link
#    Then I clear the entered data and reentered it through excel

  @test
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

  Scenario Outline: Hover on Element & Read Data From Excel Map
    Given user is on home page
    When user hovers on "<sectionName>" and selects "<category>"
    And verify that 5 products are displayed
    When user applies item filters for "<tcID>" as per excel sheet "<sheetName>"
#    When user adds item 1 to the card
#    Then I execute select query on DB

    Examples:
      | sectionName | category | tcID  | sheetName   |
      | Women       | Dresses  | tc_01 | Item Filter |
#      | Women       | Dresses  | tc_02 | Item Filter |
#      | Women       | Dresses  | tc_03 | Item Filter |

  Scenario Outline: Fillo Excel Data Read
    Then I read data for "<CustType>"

    Examples:
      | CustType |
      | CITY     |

    Scenario: Take screenshot
      Given user is on home page
      And I take a screenshot
