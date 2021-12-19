"# firstjunidemo" 
 
1 - Provide code which can be used by a front-end to populate the two views above: the first table/list of
transactions, and the second flow-detailed sub-table/sub-list when a row gets expanded

- TransactionController

2 - Briefly discuss which entities/data models you are using (use a database diagram)

 - /images/database_diagram.png

3 - Provide a contract of how to use your functions, i.e. an "API documentation"

 - /images/swagger_home.png
 - transaction_account_id.png
 - transaction_id.png

4 - Discuss or implement pagination or filtering in your code (one of them is enough)

 - TransactionRepository class, Pageable parameter is responsible for the pagination

5 - Discuss how you think the association between the transactions are done, by the already existing
process

 - The association between the transactions are done similar to the database_diagram.png. 
 - Account has a list of Transactions, which has a list of sub-Transactions (Self referencing association).
 - Every sub-Transaction has an attribute called parentTransaction which links it to its Parent Transaction
 - Transactions/sub-Transaction have an association with account_id which determines where the Transactions are coming from.
 - This way, sub-Transaction can belong to other Accounts, not just the ones from the Transaction parent.
 - i.e: Revolut's sub-Transactions might be related to Paypal's transactions.