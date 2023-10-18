---
excalidraw-plugin: parsed
tags:
  - excalidraw
---
#concepts #ER-modeling #ER-Attributes #databases #collegeYear3 

Entity - Relationship model is an concept connecting different entities together over the relationships. 

So what is an #entity ? 
Entity is an independent thing, concept (house, dog, job, course);

Entity may have #atributes. They are properties that belong to an entity. 

I.e.: Entity: *Person*
	Attributes: *Phone number, addresses, age*
	
![[ER model.png]]


### ER-Attribute types:
- Composite Attribute: can be divided further
	- (name -> first name, last name)
- Simple Attribute: Can not be divided further 
	- ( first name )
- Single Value: Have a single value for an entity 
	- ( age )
- Multivalued Attributes: can be a set of values 
	- ( college degree (can have more than 1) )
- Derived Attributes: can be derived from other attributes 
	- (age -> can be derived from date of birth)
- Stored Attributes: from this value we can derive other attributes 
	- ( date of birth -> age )
- Complex Attributes:
	- Multivalued Attributes represented with "{  }"
	- Composite Attribute represented within "(  )"
		- Ex {College Degrees (college, year, degree, field)}
- Null values:
	- null values can be used to represent a value in attribute if value is not:
		- applicable
		- known
- Entity Types:
	- a collection of entities that have the same attributes. 
		- Ex: STUDENT
			- (name), student_id, age
	- Entity Set:
		-  collection of entities of a particular entity type at a point in time; 
			  Ex: Students whos' age is between 19 - 20.
- Key Attributes:
	- unique key that can be used to identify entity
		- ex: ID