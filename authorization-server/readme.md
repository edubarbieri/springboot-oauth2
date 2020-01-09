create table oauth_client_details (
    client_id VARCHAR(256) PRIMARY KEY,
    resource_ids VARCHAR(256),
    client_secret VARCHAR(256),
    scope VARCHAR(256),
    authorized_grant_types VARCHAR(256),
    web_server_redirect_uri VARCHAR(256),
    authorities VARCHAR(256),
    access_token_validity INTEGER,
    refresh_token_validity INTEGER,
    additional_information VARCHAR(4096),
    autoapprove VARCHAR(256)
);

INSERT INTO oauth_client_details
    (client_id, client_secret, scope, authorized_grant_types,
    web_server_redirect_uri, authorities, access_token_validity,
    refresh_token_validity, additional_information, autoapprove)
VALUES
    ('webapp', '{bcrypt}$2a$10$vN1RMCw3lX3zdJ1oS/KyM.TEu5F3RbVqQ/84/PpEQeRTI38S5nKHO', 'foo,read,write', 'password,authorization_code,refresh_token', null, null, 36000, 36000, null, 'true');


The most important fields from the oauth_client_details we should focus on are:

client_id – to store the id of newly registered clients
client_secret – to store the password of clients
access_token_validity – which indicates if client is still valid
authorities – to indicate what roles are permitted with particular client
scope – allowed actions, for example writing statuses on Facebook etc.
authorized_grant_types, which provides information how users can login to the particular client (in our example case it's a form login with password)
Please note, that each client has one to many relationship with users, which naturally means that multiple users can utilize a single client.