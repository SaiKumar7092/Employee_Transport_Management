drop table employee;


CREATE TABLE `employee` (
  `id` varchar(10) NOT NULL,
  `fullName` varchar(30) DEFAULT NULL,
  `designation` varchar(15) DEFAULT NULL,
  `joiningDate` date DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  `phone` varchar(15) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
);


drop table cab;

CREATE TABLE `cab` (
  `cabId` varchar(10) NOT NULL,
  `registrationNumber` varchar(30) DEFAULT NULL,
  `driverId` varchar(15) NOT NULL,
  `cabStatus` varchar(20) DEFAULT NULL,
  `comments` varchar(20) DEFAULT NULL,
  `vacancy` int(11) DEFAULT '4',
  PRIMARY KEY (`cabId`),
  KEY `driverId` (`driverId`),
  CONSTRAINT `cab_ibfk_1` FOREIGN KEY (`driverId`) REFERENCES `employee` (`id`)
);



drop table booking;

CREATE TABLE `booking` (
  `requestId` int(11) NOT NULL AUTO_INCREMENT,
  `requestStatus` varchar(30) DEFAULT NULL,
  `comments` varchar(50) DEFAULT NULL,
  `bookingId` varchar(30) DEFAULT NULL,
  `sourceLocation` varchar(30) DEFAULT NULL,
  `dateTimeOfJourney` datetime DEFAULT NULL,
  `employeeId` varchar(20) DEFAULT NULL,
  `cabId` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`requestId`)
);

alter table booking auto_increment=10001;

commit;