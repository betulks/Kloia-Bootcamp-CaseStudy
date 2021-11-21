Feature: CaseStudy tests

  Background:
    Given homepage is open
    And I close the pop up

  @regression
  Scenario: verify page title and search result
    And I verify page title
    When I search for "drone"
    Then verify search results are listed

  @regression
  Scenario: verify successful login with enter button
    And I open "Account" dropdown menu
    When I choose "Orders & Purchases" submenu
    Then sign in page should open
    When fill login form for email "vorkikokko@vusra.com"
    When fill login form for password "*-testpassword-*"
    When sign in button clicked
    Then verify successful login

  @regression
  Scenario: sign in with Google and Verify user logged in on the newly opened tab
    And I open "Account" dropdown menu
    When I choose "Orders & Purchases" submenu
    Then sign in page should open
    When sign in with Google
    Then Google sign in page should open
    When sign in with Google for email "my.testuser.kloia"
    When click mail next button
    When sign in with Google for password "*-testpassword-*"
    When click password next button
    Given homepage is open
    Then verify successful login







