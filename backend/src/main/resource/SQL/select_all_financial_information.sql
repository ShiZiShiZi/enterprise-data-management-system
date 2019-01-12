 SELECT
financial_log.id AS log_id,
financial_log.num AS log_num,
financial_log.tax_rate,
financial_log.type AS log_type,
financial_log.time AS log_time,
financial_log.project_people_id AS financial_people_id,
financial_detail.id AS detail_id,
financial_detail.title,
financial_detail.num AS detail_num,
financial_detail.time AS detail_time,
financial_detail.type AS detail_type,
financial_detail.project_people_id,
financial_model.id AS model_id,
financial_model.`name`,
financial_model.num AS model_num,
financial_model.type AS model_type,
financial_model.project_Id,
financial_model.active
FROM
financial_log ,
financial_detail
INNER JOIN financial_model ON financial_detail.financial_model_id = financial_model.id
WHERE
financial_log.financial_detail_id = financial_detail.id AND
financial_detail.financial_model_id = financial_model.id
