CREATE TABLE `oauth_access_token` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`authentication` LONGBLOB NULL,
	`authentication_id` VARCHAR(255) NULL DEFAULT NULL,
	`client_id` VARCHAR(255) NULL DEFAULT NULL,
	`refresh_token` VARCHAR(255) NULL DEFAULT NULL,
	`token` LONGBLOB NULL,
	`token_id` VARCHAR(255) NULL DEFAULT NULL,
	`user_name` VARCHAR(255) NULL DEFAULT NULL,
	PRIMARY KEY (`id`)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
AUTO_INCREMENT=4
;

CREATE TABLE `oauth_approvals` (
	`userId` VARCHAR(256) NULL DEFAULT NULL,
	`clientId` VARCHAR(256) NULL DEFAULT NULL,
	`scope` VARCHAR(256) NULL DEFAULT NULL,
	`status` VARCHAR(10) NULL DEFAULT NULL,
	`expiresAt` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	`lastModifiedAt` TIMESTAMP NOT NULL DEFAULT '0000-00-00 00:00:00'
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
;

CREATE TABLE `oauth_client_details` (
	`client_id` VARCHAR(256) NOT NULL,
	`resource_ids` VARCHAR(256) NULL DEFAULT NULL,
	`client_secret` VARCHAR(256) NULL DEFAULT NULL,
	`scope` VARCHAR(256) NULL DEFAULT NULL,
	`authorized_grant_types` VARCHAR(256) NULL DEFAULT NULL,
	`web_server_redirect_uri` VARCHAR(256) NULL DEFAULT NULL,
	`authorities` VARCHAR(256) NULL DEFAULT NULL,
	`access_token_validity` INT(11) NULL DEFAULT NULL,
	`refresh_token_validity` INT(11) NULL DEFAULT NULL,
	`additional_information` VARCHAR(4096) NULL DEFAULT NULL,
	`autoapprove` VARCHAR(256) NULL DEFAULT NULL,
	PRIMARY KEY (`client_id`)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
;

CREATE TABLE `oauth_refresh_token` (
	`token_id` VARCHAR(256) NULL DEFAULT NULL,
	`token` LONGBLOB NULL,
	`authentication` LONGBLOB NULL
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
;

