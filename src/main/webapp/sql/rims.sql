
CREATE DATABASE IF NOT EXISTS `rims`;
USE `rims`;

CREATE TABLE IF NOT EXISTS `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
	(17),
	(17),
	(17),
	(17),
	(17),
	(17);

CREATE TABLE IF NOT EXISTS `item` (
  `itemId` bigint(20) NOT NULL AUTO_INCREMENT,
  `itemBrand` varchar(255) DEFAULT NULL,
  `itemCode` int(11) NOT NULL,
  `itemDescription` varchar(255) DEFAULT NULL,
  `itemExpirationDate` date DEFAULT NULL,
  PRIMARY KEY (`itemId`),
  UNIQUE KEY `UK_dd53ejouqdcnldmb18h0nap2w` (`itemCode`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS `user` (
  `userId` bigint(20) NOT NULL AUTO_INCREMENT,
  `userDepartment` varchar(255) DEFAULT NULL,
  `userEmail` varchar(255) NOT NULL,
  `userFirstName` varchar(255) DEFAULT NULL,
  `userLastName` varchar(255) DEFAULT NULL,
  `userPassword` varchar(255) DEFAULT NULL,
  `userTitle` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`userId`),
  UNIQUE KEY `UK_p4yevdj0vncgm8qtapdj1lyq3` (`userEmail`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS `userprivilege` (
  `userPrivilegeId` bigint(20) NOT NULL,
  `userRole` varchar(255) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`userPrivilegeId`),
  KEY `FKtq5tlelt80y1v476oye60so93` (`userId`),
  CONSTRAINT `FKtq5tlelt80y1v476oye60so93` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;