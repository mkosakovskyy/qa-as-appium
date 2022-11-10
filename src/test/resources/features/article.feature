@article-feature
Feature: Article scenarios

  Background: The user is in the article
    Given The user access the article

  @first
  @firstarticle
  Scenario: The sticky add is displayed (Article)
    Then The sticky add is displayed in the article

  Scenario: The MPU1 add is displayed (Article)
    Then The first MPU add is displayed

  Scenario: The BTN add is displayed (Article)
    Then The BTN add is displayed

  Scenario: The MPU2 add is displayed (Article)
    Then The second MPU add is displayed
