CREATE TABLE `appusers` (
  `lastname` varchar(50) NOT NULL,
  `firstname` varchar(50) NOT NULL,
  `mail` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `balance` decimal(15,2) NOT NULL,
  PRIMARY KEY (`mail`),
  UNIQUE KEY `unique_mail` (`mail`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `contact` (
  `user1` varchar(50) NOT NULL,
  `user2` varchar(50) NOT NULL,
  `dateAction` datetime NOT NULL,
  PRIMARY KEY (`user2`,`user1`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `transactions` (
  `idTransaction` int NOT NULL AUTO_INCREMENT,
  `idSender` varchar(50) DEFAULT NULL,
  `idRecipient` varchar(50) DEFAULT NULL,
  `amount` decimal(15,2) NOT NULL,
  `fees` decimal(15,2) DEFAULT NULL,
  `dateTransaction` datetime NOT NULL,
  PRIMARY KEY (`idTransaction`),
  KEY `transactions_ibfk_1` (`idRecipient`),
  KEY `transactions_ibfk_2` (`idSender`),
  CONSTRAINT `transactions_ibfk_1` FOREIGN KEY (`idRecipient`) REFERENCES `appusers` (`mail`),
  CONSTRAINT `transactions_ibfk_2` FOREIGN KEY (`idSender`) REFERENCES `appusers` (`mail`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci