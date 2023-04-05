@tag
Feature: Error Validation Test Case
Background:
Given I landed on ECommerce Page

  @ErrorValidation
  Scenario Outline: Negative scenario of purchasing order
    Given I login with username <email> and password <password>
    Then "Incorrect e-mail or password" message is displayed

    Examples: 
      | email  										| password  |
      |cmadhura22j2018@gmail.com	|abcd				|