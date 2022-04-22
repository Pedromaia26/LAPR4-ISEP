# Domain model glossary #

This document contains a description of each entity, value object and aggregate.

> ### Entities ###
> | Designation | Description |
> |:---------------|:--------:|
> | Administrator     | This entity represents the employee that manages the system. It is responsible for managing the system users and their respective permissions as well as the general configuration of the system.
> | AGV               | An AGV (automated guided vehicles) is an operating machine that will pick up in the warehouse the products ordered by the customers. It has a digital twin, which is a digital version represented in the system that presents the information about the AGV location. 
> | AGVDock           | Each AGV has, in the warehouse, its AGV dock, that corresponds to its base location. |
> | Aisle             | The way a warehouse is organized. It consists of several rows. |
> | Category          | A category is one of the main characteristics of a product. A product belongs to a single category. |
> | Customer          | The main user. It is the user that orders a specific group of products. |
> | Order             | An order is an entity that represents the way a customer can request a product. It is characterized by status, and it is associated with the products that the customer added to the shopping cart. |
> | Product           | Represents the products in the system. It is stored in the warehouse and is identified with a category. |
> | Question          | A question is presented in a specific section of a questionnaire. It has a type and, in terms of obligatoriness, it can be 'mandatory', 'optional' or 'condition dependent'. |
> | Questionnaire     | A questionnaire corresponds to a group of questions that are made to the customer. |
> | Row               | The way a aisle is organized. It consists of several shelf's. |
> | SalesClerk        | This entity represents the employee that works on the balcony. It is responsible to manage information related to the products catalog, categories, and families as well as registering orders on customers' behalf. |
> | SalesManager      | This entity represents the employee that controls the sales information. It is responsible, in addition to Salesclerk responsibilities, carrying out surveys and viewing some sales reports. |
> | Section           | The way a questionnaire is organized. It can contain one or more questions.  |
> | Shelf             | The way a shelf is organized. It consists of several bins. |
> | ShoppingCart      | The customer has its shopping car. It is the local that the customer adds the wanted products (by line). |
> | ShoppingCart_Line | This entity corresponds to each item in the shopping car. It is associated with a single product and has information about the quantity of each product a customer wants to order. |
> | Status            | Corresponds to the current stage of an order. It is the way that a customer can track his order. |
> | User              | A general representation of all the users registered in the system. |
> | Warehouse         | A warehouse is the local where the products are stored. It has its employees, the warehouse employees, and is operated by AVGs. |
> | WarehouseEmployee | This entity represents the employees that work in a warehouse. It is responsible for assigning tasks to AGVs, managing the warehouse information, checking and controlling its functioning, and packaging and sending customer delivering orders. |


> ### Value Objects ###
> | Designation | Description | Entity |
> |:---------------|:--------:|:--------:|
> | Bar_code | Product information encoded into bars and alphanumeric characters, making it much faster and easier to ring up items in the warehouse (max. 23 chars) | Product |
> | Brand | Name of the company responsible for the manufacture of a given product | Product |
> | Extended_description | A more detailed report of the features that distinguishes a product (20 to 100 chars) | Product |
> | Photo | Image representing the product. Might be of any common format (e.g. png, jpeg, svg) | Product |
> | Price_with_tax | Price of the product after the application of taxes (VAT, e.g.) | Product |
> | Price_without_tax | Price of the product before the application of taxes (VAT, e.g.) | Product |
> | Product_code | Unique internal code that allows the identification of a product (max. 23 chars) | Product |
> | Production_code | Code that identifies a product assigned by its brand (max. 23 chars) | Product |
> | Reference | An alphanumeric code (max. 23 chars) set by the brand | Product | 
> | Short_description | Short report of the features that distinguishes a product (max. 30 chars) | Product |
> | Technical_description | A report concerning the technical aspects of the product. Multiple lines of text, preferably with no limit or the biggest possible | Product |
> | FinalMessage | A message to be presented after completing the questionnaire | Questionnaire |
> | IdQuestion | Mandatory numeric value to univocally identify a question inside a questionnaire | Questionnaire |
> | IdQuestionnaire | Mandatory numeric value to univocally identify a questionnaire | Questionnaire | 
> | IdSection | Mandatory numeric value to univocally identify a section inside a questionnaire | Questionnaire |
> | Instruction | Optionally a text with some answering instruction might be provided | Questionnaire |
> | QuestionObligatoriness | A question might be one of "mandatory", "optional" or "condition dependent". If the latter is selected, a condition needs to be set | Questionnaire |
> | QuestionnaireTitle | The title of the questionnaire. It is a mandatory short sentence | Questionnaire |
> | SectionDescription | An optional message highlighting some concern/purpose of the section. Multiplesentences need to be supported | Questionnaire |
> | SectionObligatoriness | A section can be "mandatory", "optional" or "condition dependent". If the latter is selected, a condition needs to be set | Questionnaire |
> | SectionRepeatability | Optional condition stating if the questions of the section are to be answered more than once. At least two kinds of conditions need to be supported: (i) based on numeric answers or (ii) on a set of selected values | Questionnaire |
> | SectionTitle | The title of the section. It is a mandatory short sentence | Questionnaire |
> | Type | Defines the kind of answer and available options (Free-text, single-choice, multiple-choice, and so on) | Questionnaire |
> | WelcomeMessage | An optional message to be presented before any section/question | Questionnaire |
> | Billing_postal_addresses | The address connected to a specific form of payment, which is typically a credit or debit card. Is where the bill for a product is sent so it can be paid by the recipient | User |
> | Birthday | Date of birth of an user | User |
> | Delivering_postal_addresses | The address to which the goods are to be delivered | User |
> | Email | Expression that identifies an user in a computer network, allowing sending and receiving messages | User |
> | Gender | Gender of an user | User |
> | Phone_number | Phone number of a given client | User |
> | VAT_id | Unique number that identifies a taxable person (business) or non-taxable legal entity that is registered for VAT | User |
> | AGVDockIdentifier | Set of characters that allows the identification of an AGV dock | Warehouse |
> | AGVDockLocation | Location of an AGV dock in the warehouse  | Warehouse
> | AGVIdentifier | Set of characters that allows the identification of an AGV | Warehouse |
> | AGVShortDescription | Short report of the features that distinguishes an AGV | Warehouse |
> | AisleIdentifer | Set of characters that allows the identification of an aisle in a given warehouse | Warehouse |
> | AisleLocation | Location of an aisle in the warehouse | Warehouse |
> | Autonomy | Time left until an AGV needs to recharge | Warehouse |
> | MaximumWeight | Maximum weight an AGV can carry at once  | Warehouse |
> | Model | AGV model  | Warehouse |
> | RowIdentifier | Set of characters that allows the identification of a row in a given aisle | Warehouse |
> | RowLocation | Location of a row in its corresponding aisle | Warehouse |
> | ShelfIdentifier | Set of characters that allows the identification of a shelf in a given row | Warehouse |
> | ShelfLocation | Location of a shelf in its corresponding row | Warehouse |
> | Task | Represents the current task being performed by an AGV | Warehouse |
> | VAT | Value Added Tax. A consumption tax assessed on the value added to goods and services. | ------ |

> ### Aggregates ###
> | Designation   | Description | Entities |
---------------|:---------------|:--------|:-------:|
> | Questionnaire | The aggregate Questionnaire contains all entities involving the questionnaire. | Questionnaire - Section - Question |
> | Product       | The aggregate Product contains all entities involving the product. | Product |
> | User          | The aggregate User contains all entities involving the user. | User - Administrator - SalesManager - SalesClerk - WarehouseEmployee - Customer |
> | Warehouse     | The aggregate Warehouse contains all entities involving the warehouse. | Warehouse - AGV - AGVDock - Aisle - Row - Shelf |
> | AGV           | The aggregate AGV contains all entities involving the AGV. | AGV - AGVDock |
> | Category      | The aggregate Category contains all entities involving the category. | Category |
> | Order         | The aggregate Order contains all entities involving the order. | Order - Order_Line - ShoppingCart - ShoppingCart_Line |
> | Status        | The aggregate Status contains all entities involving the status. | Status |