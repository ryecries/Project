# Nama Anggota
- M. Irfan Ardiansyah - 1917051034, 
- Gladie Thoriqudin - 1917051047, 
- Muhammad Weidz Alqurni - 1957051012

# Account Holder System
> Sistem ini dapat melakukan perekaman data yang menyimpan data dari murid (individual holder) dan (guru corporate holder).

Libraries dan Tools project:
- mysql-connector-java-5.1.49.jar
- sqlite-jdbc-3.340.jar
- Scene builder
- Sqlite studio
- MySQL server with xampp
- Netbeans editor
- VS code plugin
     - mermaid diagram
     - GitHub Pull Requests and Issues
## Desain
To view the diagrams below install mermaid-diagram plugin at
### Class Diagram

```mermaid
classDiagram
    AccountHolder <|-- IndividualHolder
    AccountHolder <|-- CorporateHolder

    class AccountHolder{
    <<abstract>>
    #int ID
    #String name
    #String address
    #String email
    }
    class IndividualHolder{
     -String jenjang
    }
    class CorporateHolder{
     -String pangkat
    }
    

```

### ER Diagram

```mermaid
erDiagram
          ACCOUNTHOLDER ||..|| INDIVIDUAL-HOLDER : is
          ACCOUNTHOLDER ||--|| CORPORATE-HOLDER : is
          ACCOUNTHOLDER {
            int id
            string name
            string adress
            string email
          }
          INDIVIDUAL-HOLDER{
            string jenjang
          }
          CORPORATE-HOLDER{
            string pangkat
          }

```
### Design Class Diagram for JavaFX and Database
```mermaid
classDiagram
    AccountHolder <|-- IndividualHolder
    AccountHolder <|-- CorporateHolder
    AccountHolder "1"--o"*" Account : has
    AccountHolder o-- AccountHolderDataModel : Data Modeling
    AccountHolderDataModel <-- AccountHolderController : Data Control
    AccountHolderDataModel --> DBHelper : DB Connection
    AccountHolderController <.. AccountHolderForm : Form Control      

    class AccountHolder{
      <<abstract>>
      #IntegerProperty ID
      #StringProperty name
      #StringProperty address
      #String email
      
    }
    
    class IndividualHolder{
      -StringProperty jenjang
    }
    class CorporateHolder{
      -StringProperty pangkat
    }


    class AccountHolderDataModel{
        Connection conn
        addAccountHolder()
        addAccount()
        getIndividualHolders()
        getCorporateHolders()
    }

    class AccountHolderController{
        initialize()
        handleButtonAddAccount()
        handleButtonAddAccountHolder()
        loadDataIndividualHolder()
        loadDataCorporateHolder()
        loadDataAccount()
        handleClearForm()
    }
    class DBHelper{
        - String USERNAME
        - String PASSWORD
        - String DB
        getConnection()
        getConnection(String driver)
        createTable();
    }
