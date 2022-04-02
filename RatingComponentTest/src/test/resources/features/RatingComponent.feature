Feature: Rating Component
  As a user
  I want to be able to choose a rating
  From the list of available ratings
  So that I can rate the service

  Scenario Outline: Submit a number rating
    Given I am on the rating page
    When I select "<selectedRating>" as my rating
    Then I should see the rating <validRating> in the next section
    Examples:
    | selectedRating| validRating|
    | one           | 1          |
    | two           | 2          |
    | three         | 3          |
    | four          | 4          |
    | five          | 5          |