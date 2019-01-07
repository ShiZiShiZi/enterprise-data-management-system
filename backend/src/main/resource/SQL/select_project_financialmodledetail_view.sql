DELIMITER $$

USE `edms`$$

DROP VIEW IF EXISTS `select_project_financialmodeldetail`$$

CREATE ALGORITHM = UNDEFINED DEFINER =`root`@`localhost` SQL SECURITY DEFINER VIEW `select_project_financialmodeldetail` AS
SELECT `project`.`id`                AS `projectid`,
       `financialmodeldetail`.`id`   AS `fincialmodeldetailid`,
       `financialmodeldetail`.`name` AS `name`,
       `financialmodeldetail`.`num`  AS `num`,
       `financialmodeldetail`.`type` AS `type`
FROM ((`financialmodeldetail`
  JOIN `financialmodel`)
       JOIN `project`)
WHERE ((`project`.`id` = `financialmodel`.`projectid`)
  AND (`financialmodel`.`id` = `financialmodeldetail`.`financialmodelid`)
  AND (`financialmodeldetail`.`active` = 1))$$

DELIMITER ;