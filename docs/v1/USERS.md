## Terminology

* `User`: explained further below in the "Resource" section.
* `Entity`: a unique individual, company or organization.

## Resource

The resource represented by the `/users` set of endpoints is the user (or account) itself.

The user represents a set of identification and personal data belonging to an entity. As such, it will contain
identification data for the associated entity, as well as operational data (email, username, password, etc...).

A user is directly tied to an entity - while an entity is not necessarily tied to a user, meaning it can be expected
from an entity to own several users.

To comply with national and international law, all the data contained in a user belongs to the entity it is supposed to
represent, and thus the entity should be able to ask for the fetching or deletion of that data.

## Attributes

An user resource may contain the following attributes:
* `id` (required): A unique identifier for the user resource. Must be non-sequential and unique, and should be randomly
generated.
* `username` (required): A username for the user resource. Must be unique.
* `email` (required): The email associated with the user resource. Must be unique.
* `civility` (optional): The non-legal civility that matches the entity associated with a user the most. Can have the
following values:
** `MR`: Corresponds to a male individual.
** `MS`: Corresponds to a female individual.
** `MO`: Corresponds to an individual identifying as neither male nor female.
** `CI`: Corresponds to a one-person commercial entity (e.g. a freelance).
** `CP`: Corresponds to a corporation or a business. In legal terms, this corresponds to a commercial partnership
(LP and derivatives), a limited liability company (LLC and derivatives) or a corporation (Corp., Inc. and derivatives).
** `CO`: Corresponds to a non-profit organization, foundation or association.
* `firstName` (optional): The first name of the individual, or the first name of the representative for other entities.
* `lastName` (optional): The last name of the individual, or the last name of the representation for other entities.
* `legalName` (optional): The full legal name of the entity, if it is different than the `firstName + lastName`
concatenation.
* `salt` (required): The salt that will be used for hashing the user's password.
* `password` (required): The hash of the user's password, salted with the `salt` attribute.
* `lastLogin` (optional): The date at which the user last logged in.
* `status` (required): The status of the user, being one of the following:
** `STD`: The user is a standard user.
** `ADM`: The user is an administrator. This status means that the user will be able to bypass any user rights or groups
system that might be used throughout the Tiwind Software ecosystem.
** `DSB`: The user is disabled and cannot log in or do any operational action.