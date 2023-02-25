Feature: Google search functionality
  Agile story: As a user, when I am on the Google search page
  I should be able to search whatever I want and see relevant information
  Background: For the scenarios in the feature file, user is expected to be on Google search page
    Given user is on Google search page

  Scenario: Search page title verification

    Then user should see title is Google

  Scenario: Search functionality result title verification

    When user types apple and clicks enter
    Then user sees apple in the google title


  Scenario: Search functionality result title verification

    When user types "apple" and clicks enter
    Then user sees "apple" in the google title
@Capital
  Scenario: Data Driven Testing Format preparation

    When user types "capital of Turkey" and clicks enter
    Then User should see "Ankara" in the result

  Scenario: Data Driven Testing Format preparation

    When user types "capital of Spanish" and clicks enter
    Then User should see "Madrid" in the result

  Scenario Outline: Search functionality in a Data Driven Testing Format

    When user types "capital of <country>" and clicks enter
    Then User should see "<capital>" in the result
    Examples:
      |country|capital|
      |Turkey |Ankara |
      |USA    |Washington, DC|
      |Ukraine|Kiev         |
      |Germany |Berlin       |
      |UK     |Londra      |
      |Latvia |Riga         |
      |Greece |Atina       |

