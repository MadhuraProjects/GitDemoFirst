#@tag
#Feature: Purchase order from Ecommerce Website
#
#// this test runs before each and every test case
#Background:
#Given I landed on ECommerce Page
#
  #@Regression
  #Scenario Outline: Positive Test of buying shoes
    #Given I login with username <email> and password <password>
    #When I select product by id <id> and colour <colour> and size <size> and added to cart
    #Then I checkout 
#
    #Examples: 
      #| email  										| password  | id  |	colour | size |
      #|cmadhura22j2018@gmail.com  |MyBata@123 | 7615045|ROSEGOLD|5|
      #
