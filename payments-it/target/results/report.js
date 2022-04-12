$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/add-customer.feature");
formatter.feature({
  "name": "Add Customer",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@add_customer"
    }
  ]
});
formatter.scenarioOutline({
  "name": "Add new customer details",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "a request to post customer details",
  "keyword": "Given "
});
formatter.step({
  "name": "add customer is called",
  "keyword": "When "
});
formatter.step({
  "name": "\"\u003cstatus_code\u003e\" returned as response status code must match",
  "keyword": "Then "
});
formatter.step({
  "name": "\"\u003cstatus_message\u003e\" returned as status message must match",
  "keyword": "And "
});
formatter.step({
  "name": "customer id returned must match with \"\u003ccustomer_id\u003e\"",
  "keyword": "And "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "customer_id",
        "status_code"
      ]
    },
    {
      "cells": [
        "40",
        "200"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Add new customer details",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@add_customer"
    }
  ]
});
formatter.step({
  "name": "a request to post customer details",
  "keyword": "Given "
});
formatter.match({
  "location": "AddCustomerDef.a_request_to_post_customer_details()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "add customer is called",
  "keyword": "When "
});
formatter.match({
  "location": "AddCustomerDef.add_customer_is_called()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "\"200\" returned as response status code must match",
  "keyword": "Then "
});
formatter.match({
  "location": "AddCustomerDef.returned_as_response_status_code(String)"
});
formatter.result({
  "error_message": "java.lang.NullPointerException\n\tat com.ticketmaster.bdd.AddCustomerDef.returned_as_response_status_code(AddCustomerDef.java:44)\n\tat ✽.\"200\" returned as response status code must match(file:src/test/resources/features/add-customer.feature:8)\n",
  "status": "failed"
});
formatter.step({
  "name": "\"\u003cstatus_message\u003e\" returned as status message must match",
  "keyword": "And "
});
formatter.match({
  "location": "AddCustomerDef.returned_as_status_message(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "customer id returned must match with \"40\"",
  "keyword": "And "
});
formatter.match({
  "location": "AddCustomerDef.customer_id_returned_must_match_with(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "status": "passed"
});
});