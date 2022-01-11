Feature: Admin Management
  Scenario: Admin user should be able to add a new user
    Given an admin user is logged in
    When navigating to Admin page
    Then new user should be able to be created
    Then admin logout