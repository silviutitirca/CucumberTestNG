Feature: Admin Management
  @Test2
  Scenario: Admin user should be able to add a new admin user
    Given an admin user is logged in
    When navigating to Admin page
    Then new user should be able to be created
    Then admin logout

  @Test3
  Scenario: Admin user should be able to add and delete a new employee
    Given an admin user is logged in
    When navigation to PIM page
    Then new employee should be able to be created
    Then search for new employee created
    Then delete the newly created user
    Then admin logout