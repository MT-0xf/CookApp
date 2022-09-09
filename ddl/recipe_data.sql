CREATE TABLE `recipe_data` (
  `recipe_id` varchar(200) NOT NULL,
  `dish_name` varchar(45) NOT NULL,
  PRIMARY KEY (`recipe_id`),
  UNIQUE KEY `recipe_id_UNIQUE` (`recipe_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci