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

### AC-USERS-11: Cannot create user with invalid civility

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

### AC-USERS-20: Cannot create a user with a username that's too long

* When a user is created with a username that is too long
* Then it should fail with a bad request (400) reason.

### AC-USERS-21: Cannot modify user with an invalid civility

* Given an existing user
* When that user is modified with an invalid civility
* Then it should fail with a bad request (400) reason

### AC-USERS-22: Cannot modify a user with a username that's too long

* Given an existing user
* When that user is modified with a username that is too long
* Then it should fail with a bad request (400) reason

### AC-USERS-23: Cannot create a user with an invalid email

* When a user is created with an invalid email (as defined in `RFC-5322`)
* Then it should fail with a bad request (400) reason

### AC-USERS-24: Cannot modify a user with an invalid email

* Given an existing user
* When that user is modified with an invalid email (as defined in `RFC-5322`)
* Then it should fail with a bad request (400) reason

### AC-USERS-25: Cannot create a user with an email that's too long

* When a user is created with an email that is too long
* Then it should fail with a bad request (400) reason

### AC-USERS-26: Cannot modify a user with an email that's too long

* Given an existing user
* When that user is modified with an email that is too long
* Then it should fail with a bad request (400) reason

### AC-USERS-27: Cannot create a user with a first name that's too long

* When a user is created with a first name that is too long
* Then it should fail with a bad request (400) reason

### AC-USERS-28: Cannot modify a user with a first name that's too long

* Given an existing user
* When that user is modified with a first name that is too long
* Then it should fail with a bad request (400) reason

### AC-USERS-29: Cannot create a user with a last name that's too long

* When a user is created with a last name that is too long
* Then it should fail with a bad request (400) reason

### AC-USERS-30: Cannot modify a user with a last name that's too long

* Given an existing user
* When that user is modified with a last name that is too long
* Then it should fail with a bad request (400) reason

### AC-USERS-31: Cannot create a user with a legal name that's too long

* When a user is created with a legal name that is too long
* Then it should fail with a bad request (400) reason

### AC-USERS-32: Cannot modify a user with a legal name that's too long

* Given an existing user
* When that user is modified with a legal name that is too long
* Then it should fail with a bad request (400) reason

### AC-USERS-33: Legal name automatically generated from just first name

* Given an existing user with a first name and no last name
* When that user is retrieved
* Then it should contain a legal name equal to its first name

### AC-USERS-34: Legal name automatically generated from just last name

* Given an existing user with a last name and no first name
* When that user is retrieved
* Then it should contain a legal name equal to its last name

### AC-USERS-35: Legal name with no first name or last name

* Given an existing user with no last name nor first name
* When that user is retrieved
* Then it should contain a legal name equal to its username

### AC-USERS-36: Cannot create a user with an invalid status

* When a user is created with an invalid status
* Then it should fail with a bad request (400) reason

### AC-USERS-37: Cannot modify a user with an invalid status

* Given an existing user
* When that user is modified with an invalid status
* Then it should fail with a bad request (400) reason

### AC-USERS-38: Cannot retrieve a user that does not exist

* When a user that does not exist is retrieved
* Then it should fail with a not found (404) reason

### AC-USERS-39: Cannot modify a user that does not exist

* When a user that does not exist is modified
* Then it should fail with a not found (404) reason

### AC-USERS-40: Cannot delete a user that does not exist

* When a user that does not exist is deleted
* Then it should fail with a not found (404) reason

### AC-USERS-41: Cannot retrieve a user with an invalid identifier

* When a user with an invalid identifier is retrieved
* Then it should fail with a bad request (400) reason

### AC-USERS-42: Cannot modify a user with an invalid identifier

* When a user with an invalid identifier is modified
* Then it should fail with a bad request (400) reason

### AC-USERS-43: Cannot delete a user with an invalid identifier

* When a user with an invalid identifier is deleted
* Then it should fail with a bad request (400) reason