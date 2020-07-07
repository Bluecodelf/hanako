### AC-USERS-1: A user can be created

* Given a created user with all allowed data
* When the newly created user is fetched
* Then the newly created user is retrieved
* And it contains all the sent data

### AC-USERS-2: A user can be partially modified

* Given an existing user
* When a partial modification request is sent
* Then the modified user can be retrieved
* And the modified data must change to the new values

### AC-USERS-3: A user can be completely modified

* Given an existing user
* When a total modification request is sent
* Then the modified user can be retrieved
* And all data must change to the new values

### AC-USERS-4: All users are returned

* Given an existing user
* And another existing user
* When all users are fetched
* Then both users should be present

### AC-USERS-5: User identifiers should be generated

* Given a created user with all required data
* When the newly created user is fetched
* Then the newly created user is retrieved
* And it contains a generated identifier

### AC-USERS-6: Cannot create user with identifier

* When a user is created with an identifier
* Then it should fail with a forbidden (403) reason

### AC-USERS-7: Cannot modify user identifier

* Given an existing user
* When I try to modify the user's identifier
* Then it should fail with a forbidden (403) reason

### AC-USERS-8: Unique user username

* Given an existing user
* When a user is created with the other user's identifier
* Then it should fail with a conflict (409) reason

### AC-USERS-9: Unique user email

* Given an existing user
* When a user is created with the other user's email
* Then it should fail with a conflict (409) reason

### AC-USERS-10: Unique user email during modification

* Given an existing user
* When another user is modified with the other user's email
* Then it should fail with a conflict (409) reason

### AC-USERS-11: User with invalid civility

* When a user is created with an invalid civility
* Then it should fail with a bad request (400) reason

### AC-USERS-14: Legal name automatically generated

* Given an existing user with a first and last name, but no legal name
* When the user is retrieved
* Then it should have a legal name composed from the first and last name

### AC-USERS-15: Legal name overriding first and last name

* Given an existing user with a first, last and legal name
* When the user is retrieved
* Then the legal name should be consistent with the stored value

### AC-USERS-16: Cannot retrieve salt

* Given an existing user
* When the user is retrieved
* Then the user should not contain a `salt` attribute

### AC-USERS-17: Cannot retrieve password

* Given an existing user
* When the user is retrieved
* Then the user should not contain a `password` attribute

### AC-USERS-18: User is deleted

* Given an existing user
* When that user is deleted
* And the user is retrieved
* Then the user should not exist anymore

### AC-USERS-19: Users should be paginated

* Given two existing users
* When a first page of one user is retrieved
* And a second page of one user is retrieved
* Then the first page response should contain only one user
* And the second page response should contain the other user