CREATE TABLE `cook_procedure` (
  `recipe_id` varchar(200) NOT NULL,
  `order_number` varchar(200) NOT NULL,
  `method` varchar(200) NOT NULL,
  `img` varchar(999) NOT NULL,
  PRIMARY KEY (`order_number`,`recipe_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci