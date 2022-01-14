Feature: Smoke test for test run
  @SmokeTest
  Scenario: Test framework should be prepared for running Cucumber and TestNG tests
    Given JUnit and Cucumber dependencies are latest in POM
    When running this test
    Then build should be successfully
    And this test shall not fail

  @SmokeTest
  Scenario: Test framework should be prepared for running Cucumber tests
    Given JUnit and Cucumber dependencies are latest in POM
    Then build should be successfully