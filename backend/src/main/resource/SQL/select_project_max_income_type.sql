DELIMITER $$

USE `edms`$$

DROP VIEW IF EXISTS `select_project_max_income_type`$$

CREATE ALGORITHM=UNDEFINED 
DEFINER=`root`@`localhost` 
SQL SECURITY DEFINER 
VIEW `select_project_max_income_type` AS 
SELECT
	`financial_model`.`project_Id` AS `project_Id`,
	`financial_detail`.`title` AS `title`,
	`financial_log`.`num` AS `num`,
	`financial_log`.`time` AS `time`
FROM
	(
		(
			`financial_detail`
			JOIN `financial_model` ON (
				(
					`financial_detail`.`financial_model_id` = `financial_model`.`id`
				)
			)
		)
		JOIN `financial_log`
	)
WHERE
	(
		(
			`financial_detail`.`financial_model_id` = `financial_model`.`id`
		)
		AND (
			`financial_detail`.`type` = 0
		)
		AND (
			`financial_log`.`financial_detail_id` = `financial_detail`.`id`
		)
	) ;
	
DELIMITER ;