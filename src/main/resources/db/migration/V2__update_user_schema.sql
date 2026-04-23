-- Adding the missing columns from BaseAuditEntity
ALTER TABLE users
    ADD COLUMN is_deleted BOOLEAN NOT NULL DEFAULT FALSE,
ADD COLUMN is_blocked BOOLEAN NOT NULL DEFAULT FALSE;