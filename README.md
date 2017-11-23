# java-validator

Functional style java validator.

Sample usage:

```java
Customer customer = new Customer();

Validator validator = Validator.
				when(customer::isAdult).
				and(customer::isAuthenticationEnabled).
				then(customer::getLogin).withName("login").isMandatory().
				and(customer::getPassword).withName("password").isMandatory();

validator.validate();
```