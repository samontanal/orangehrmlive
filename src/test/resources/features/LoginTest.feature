Feature: As a user, I want to create credentials

  @ValidCase @SomeTags
  Scenario Outline: Successful login using valid account
    Given user on login page
    And Submit email using "Admin" and password using "admin123"
    And Success login to home page
    When A new user is created with <userRole>, <employeeName>, <userName> <status>, and <password>
    And session closed
    Then The user with the <userName> y <password> can log in correctly
    Examples:
      | userRole | employeeName | userName  | status  | password     |
      | ESS      | John         | jjguevara | Enabled | Pass123Pass  |
