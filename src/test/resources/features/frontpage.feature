@frontpage-feature
Feature: Front page scenarios

  Background: The user is in the front page
    Given The user access the front page

  @first
  @inter
  Scenario: The inter add is displayed (Front page)
    Then The inter add is displayed

  Scenario: The sticky add is displayed (Front page)
    Then The sticky add is displayed

  Scenario: The MPU1 add is displayed (Front page)
    Then The first MPU add is displayed
