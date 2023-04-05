@tag
Feature: Move to WishList order from Ecommerce Website
Background:
Given I landed on ECommerce Page

  @Regression2
  Scenario Outline: Positive Test of adding to wishlist
    Given I login with username <email> and password <password>
    When I select product by id <id> and colour <colour> and size <size> and moved to wishlist
    Then I signout

    Examples: 
      | email  										| password  | id  |	colour | size |
      |cmadhura22j2018@gmail.com  |MyBata@123 | 5515913|RED|4|
    