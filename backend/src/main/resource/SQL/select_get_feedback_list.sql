DELIMITER $$

USE `edms`$$

DROP VIEW IF EXISTS `select_get_feedback_list`$$

CREATE ALGORITHM=UNDEFINED 
DEFINER=`root`@`localhost` 
SQL SECURITY DEFINER 
VIEW `select_get_feedback_list` AS 
SELECT
	`project`.`title` AS `project_title`,
	`financial_detail`.`title` AS `title`,
	`financial_detail_feedback`.`request_time` AS `request_time`,
	`financial_detail_feedback`.`state` AS `state`,
	`financial_detail_feedback`.`description` AS `description`,
	`financial_detail`.`project_people_id` AS `project_people_id`
FROM
	(
		(
			(
				`financial_detail_feedback`
				JOIN `financial_detail` ON (
					(
						`financial_detail_feedback`.`financial_detail_id` = `financial_detail`.`id`
					)
				)
			)
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
WHERE
	(
		(
			`financial_detail_feedback`.`financial_detail_id` = `financial_detail`.`id`
		)
		AND (
			`financial_detail`.`financial_model_id` = `financial_model`.`id`
		)
		AND (
			`financial_model`.`project_Id` = `project`.`id`
		)
	) ;

DELIMITER ;