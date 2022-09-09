CREATE TABLE `cook_procedure` (
  `recipe_id` int NOT NULL,
  `order` int NOT NULL AUTO_INCREMENT,
  `method` varchar(200) NOT NULL,
  `img` varchar(999) NOT NULL,
  PRIMARY KEY (`order`,`recipe_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci