Feature:  Navigate to catalogue

Scenario: Navigate to catalogue
    Given I am on the Onliner main page
    When I navigate to "Каталог"
    And I select category "Электроника"
    And I select subcategory "Телевидение"
    And I select product "Телевизоры"
    And I set to "цена" range filter values "<priceFrom>" "<priceTo>"
    And I set to "диагональ" range filter values "<diagonalFrom>" "<diagonalTo>"
    And I set "<resolution>" filter
    And I set "<manufacturer>" filter
    Then I check search results contains needed filters values "<manufacturer>" "<resolution>" "<priceFrom>" "<priceTo>" "<diagonalFrom>" "<diagonalTo>"

Examples:
    | manufacturer        | resolution          | priceFrom | priceTo | diagonalFrom | diagonalTo |
    | Samsung             | 1920x1080 (Full HD) | 0         | 1000    | 40           | 50         |