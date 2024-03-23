#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
Feature: Orange HRM Login and Dashboard Features
  I want to use this feature file to validate Orange HRM Login and Dashboard Features

  Background: Launch the application
  	Given Initialize all pages
    And Launch the application

  @Functional
  Scenario: verify Application Logo
    Then Verify application logo

  @Functional
  Scenario: verify Application Login Page Header
    Then Verify application login page header is displayed as "Login"

  @Regression @Sanity @Smoke
  Scenario Outline: Verify Application Login <Scenario>
    When User enter <Username> and <Password>
    And Click on login button
    Then Login should be successful

    Examples: 
      | Scenario                 | Username | Password |
      | With Valid Credentials   | Admin    | admin123 |
      | With Invalid Credentials | Test     | test123  |

  @Regression
  Scenario Outline: Verify Dashboard Menu
    When User enter <Username> and <Password>
    And Click on login button
    Then Login should be successful
    And Verify dashboard menu items

    Examples: 
      | Username | Password |
      | Admin    | admin123 |

  @Regression @Sanity
  Scenario Outline: Verify Application Logout
    When User enter <Username> and <Password>
    And Click on login button
    Then Login should be successful
    And Verify logout

    Examples: 
      | Username | Password |
      | Admin    | admin123 |
