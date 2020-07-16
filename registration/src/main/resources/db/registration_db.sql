USE registration_db;

CREATE TABLE `person` (
  `id` bigint(20) NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `last_modified_by` varchar(255) DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `cpf` varchar(255) DEFAULT NULL,
  `date_of_birth` date DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `full_name` varchar(255) DEFAULT NULL,
  `gender` int(11) DEFAULT NULL,
  `nationality` varchar(255) DEFAULT NULL,
  `place_of_birth` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;


INSERT INTO `person` (`id`, `created_by`, `created_date`, `last_modified_by`, `last_modified_date`, `cpf`, `date_of_birth`, `email`, `full_name`, `gender`, `nationality`, `place_of_birth`) VALUES
(2, 'Unauthenticated user', '2020-07-14 22:21:11', 'Unauthenticated user', '2020-07-14 22:21:11', '66375288037', '2000-10-10', 'ronasl4d1o@bol.com.br', 'Jonas', 0, 'Brazilian', 'Rio de Janeiro');

ALTER TABLE `person`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `person`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

