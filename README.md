As per the requirements, task have been implemented in spring boot maven project with SQL server as database.

# Data Base Information
* username and password are mentioned in application.properties file
* databse name : PayMaster
* table name : transaction_info

# End Points 
End points of each task are declared in TransactionController.java file

* Returns the sum of the amounts of all transactions
  http://localhost:8080/smallworldfs/sumOfTrn

* Returns the sum of the amounts of all transactions sent by the specified client
  http://localhost:8080/smallworldfs/sumOfTrn/Grace Burgess
  
* Returns the highest transaction amount
  http://localhost:8080/smallworldfs/highestTrnAmount
  
* Counts the number of unique clients that sent or received a transaction
http://localhost:8080/smallworldfs/uniqueClient

* Returns whether a client (sender or beneficiary) has at least one transaction with a compliance issue that has not been solved
http://localhost:8080/smallworldfs/openIssue/Billy Kimber

* Returns all transactions indexed by beneficiary name
http://localhost:8080/smallworldfs/beneTrn

* Returns the identifiers of all open compliance issues
http://localhost:8080/smallworldfs/unsolvedIssueIds

* Returns a list of all solved issue messages
http://localhost:8080/smallworldfs/solvedIssueMsg

* Returns the 3 transactions with highest amount sorted by amount descending
http://localhost:8080/smallworldfs/top3Trn

* Returns the sender with the most total sent amount
http://localhost:8080/smallworldfs/topSender




