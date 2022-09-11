CREATE TABLE `ingredient_master` (
  `ingredient_id` varchar(200) NOT NULL,
  `ingredient_name` varchar(45) NOT NULL,
  PRIMARY KEY (`ingredient_id`),
  UNIQUE KEY `ingredient_id_UNIQUE` (`ingredient_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci