$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/java/features/NavigateResults.feature");
formatter.feature({
  "name": "Search and navigate through results pages",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Search and navigate through results pages",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@003"
    }
  ]
});
formatter.step({
  "name": "User is a non registered customer and navigate to ebay site",
  "keyword": "Given "
});
formatter.match({
  "location": "NavigateResults.user_is_a_non_registered_customer_and_navigate_to_ebay_site()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User search for an item",
  "keyword": "When "
});
formatter.match({
  "location": "NavigateResults.user_search_for_an_item()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User get a list of matching results display",
  "keyword": "Then "
});
formatter.match({
  "location": "NavigateResults.user_get_a_list_of_matching_results_display()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the results show more than one page",
  "keyword": "And "
});
formatter.match({
  "location": "NavigateResults.the_results_show_more_than_one_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user can navigate through the pages to continue looking at the items",
  "keyword": "Then "
});
formatter.match({
  "location": "NavigateResults.the_user_can_navigate_through_the_pages_to_continue_looking_at_the_items()"
});
formatter.result({
  "status": "passed"
});
});