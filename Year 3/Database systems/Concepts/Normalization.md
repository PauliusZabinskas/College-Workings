#concepts #ER-Normalization #databases #collegeYear3 
- Normalization can be used to:  
	- develop a normalized relational schema given the universal relation  
	- verify correctness of relational schema developed from  conceptual design.  
- Decompose relation such that it satisfies successively restrictive normal forms

### what is data normalization?
*Database normalization or database normalization is the process of structuring a relational database in accordance with a series of so-called normal forms in order to reduce data redundancy and improve data integrity*

Good Read: https://database.guide/what-is-normalization/

- UNF (  #UnnormalizedForm) 
	- A database is in UNF if it has not been normalized at all.

- 1NF ( #FirstNormalForm)
	- A relation (table) is in 1NF if (and only if) the domain of each attribute contains only atomic (indivisible) values, and the value of each attribute contains only a single value from that domain.

- 2NF ( #SecondNormalForm)
	- A relation is in 2NF if it is in 1NF and every non-prime attribute of the relation is dependent on the whole of every candidate key.

- 3NF ( #ThirdNormalForm)
	- A relation is in 3NF if it is in 2NF and every non-prime attribute of the relation is non-transitively dependent on every key of the relation.

- CNF ( #Boyce-CoddNormalForm)
	- BCNF is a subtle enhancement on 3NF. A relation is in Boyce–Codd normal form if and only if for every one of its dependencies X → Y, at least one of the following conditions hold:
		- X → Y is a trivial functional dependency (Y ⊆ X)
		- X is a superkey for schema R