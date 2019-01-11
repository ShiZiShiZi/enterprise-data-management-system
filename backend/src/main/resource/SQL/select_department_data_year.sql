DELIMITER $$

USE `edms`$$

DROP VIEW IF EXISTS `select_department_data_year`$$

CREATE ALGORITHM=UNDEFINED 
DEFINER=`root`@`localhost` 
SQL SECURITY DEFINER 
VIEW `select_department_data_year` AS 
SELECT
	`financial_log`.`num` AS `num`,
	`financial_log`.`time` AS `time`,
	`project`.`department_id` AS `department_id`,
	`financial_log`.`type` AS `type`
FROM
	(
		`financial_log`
		JOIN (
			(
				`financial_detail`
				JOIN `financial_model` ON (
					(
						`financial_detail`.`financial_model_id` = `financial_model`.`id`
					)
				)
			)
			JOIN `project` ON (
				(
					`financial_model`.`project_Id` = `project`.`id`
				)
			)
		)
	)
WHERE
	(
		(
			`financial_log`.`financial_detail_id` = `financial_detail`.`id`
		)
		AND (
			`financial_detail`.`financial_model_id` = `financial_model`.`id`
		)
		AND (
			`financial_model`.`project_Id` = `project`.`id`
		)
	) ;

DELIMITER ;