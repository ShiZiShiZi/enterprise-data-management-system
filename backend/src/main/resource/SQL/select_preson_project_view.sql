DELIMITER $$

USE `edms`$$

DROP VIEW IF EXISTS `select_person_project`$$

CREATE ALGORITHM = UNDEFINED DEFINER =`root`@`localhost` SQL SECURITY DEFINER VIEW `select_person_project` AS
SELECT `project`.`title`                 AS `title`,
       `project`.`id`                    AS `id`,
       `projectmember`.`projectpeopleid` AS `projectpeopleid`
FROM (`project`
       JOIN `projectmember`)
WHERE (`project`.`id` = `projectmember`.`projectid`)$$

DELIMITER ;