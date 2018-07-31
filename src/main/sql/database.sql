
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `data_add` datetime(6) DEFAULT NULL,
  `data_mod` datetime(6) DEFAULT NULL,
  `email` varchar(255) COLLATE utf8_polish_ci NOT NULL,
  `idv` bigint(20) DEFAULT NULL,
  `password` varchar(255) COLLATE utf8_polish_ci NOT NULL,
  `username` varchar(255) COLLATE utf8_polish_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY (`email`),
  UNIQUE KEY (`username`)
)

CREATE TABLE `training` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `data_add` datetime(6) DEFAULT NULL,
  `data_mod` datetime(6) DEFAULT NULL,
  `idv` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY (`user_id`),
  FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
)

CREATE TABLE `exercise` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `data_add` datetime(6) DEFAULT NULL,
  `data_mod` datetime(6) DEFAULT NULL,
  `description` varchar(255) COLLATE utf8_polish_ci DEFAULT NULL,
  `idv` bigint(20) DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_polish_ci NOT NULL,
  `recommend` varchar(255) COLLATE utf8_polish_ci DEFAULT NULL,
  `repeats` bigint(20) DEFAULT NULL,
  `series` bigint(20) DEFAULT NULL,
  `weight` bigint(20) DEFAULT NULL,
  `training_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY (`training_id`),
  FOREIGN KEY (`training_id`) REFERENCES `training` (`id`)
)

CREATE TABLE `profil_progress` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `data_add` datetime(6) DEFAULT NULL,
  `data_mod` datetime(6) DEFAULT NULL,
  `idv` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY (`user_id`),
  FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
)

CREATE TABLE `body` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `biceps` bigint(20) DEFAULT NULL,
  `calf` bigint(20) DEFAULT NULL,
  `chest` bigint(20) DEFAULT NULL,
  `data_add` datetime(6) DEFAULT NULL,
  `data_mod` datetime(6) DEFAULT NULL,
  `dateBody` datetime(6) DEFAULT NULL,
  `flag` varchar(255) COLLATE utf8_polish_ci DEFAULT NULL,
  `hight` bigint(20) DEFAULT NULL,
  `idv` bigint(20) DEFAULT NULL,
  `thigh` bigint(20) DEFAULT NULL,
  `waist` bigint(20) DEFAULT NULL,
  `weight` bigint(20) DEFAULT NULL,
  `profilProgress_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY (`profilProgress_id`),
  KEY (`user_id`),
  FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  FOREIGN KEY (`profilProgress_id`) REFERENCES `profil_progress` (`id`)
)




