CREATE TABLE `ingredient` (
  `recipe_id` varchar(200) NOT NULL,
  `ingredient_id` varchar(200) NOT NULL,
  `amount` varchar(45) NOT NULL,
  PRIMARY KEY (`recipe_id`,`ingredient_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci